package br.com.elo7.sonda.candidato.infrastructure.repository.inmemory;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import br.com.elo7.sonda.candidato.domain.repository.PlanetsRepository;
import br.com.elo7.sonda.candidato.domain.repository.ProbesRepository;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import com.google.common.collect.Lists;
import br.com.elo7.sonda.candidato.domain.model.Planet;
import br.com.elo7.sonda.candidato.domain.model.Probe;

@Component
class InMemoryDatabase {
	private static Map<Planet, List<Probe>> probesPerPlanet = new HashMap<>();
	
	@Repository
	public class PlanetDAO implements PlanetsRepository {
		public void save(Planet planet) {
			planet.setId(generatePlanetId());
			probesPerPlanet.put(planet, Lists.newArrayList());
		}

		private int generatePlanetId() {
			return probesPerPlanet.size()+1;
		}

		public Optional<Planet> findById(int id) {
			return probesPerPlanet.keySet()
					.stream()
					.filter(planet -> planet.getId() == id)
					.findFirst();
		}
	}
	
	@Repository	
	public class ProbeDAO implements ProbesRepository {
		@Override
		public void save(Probe probe) {
			List<Probe> probes = probesPerPlanet.get(probe.getPlanet());
			probe.setId(generateProbeId(probe, probes.size()));
			probes.add(probe);
		}

		private int generateProbeId(Probe probe, int size) {
			return 7*(size+1)+11*probe.getPlanet().getId();
		}

		@Override
		public Optional<Probe> findById(int id) {
			return probesPerPlanet.entrySet().stream().flatMap(
						entry -> entry.getValue()
										.stream()
										.filter(probe -> probe.getId() == id)
					).findFirst();
		}

		@Override
		public Optional<Probe> findByCoordinates(int x, int y) {
			return Optional.empty();
		}
	}
}
