package br.com.elo7.sonda.candidato.controlcenter.infrastructure.repository.inmemory;

import br.com.elo7.sonda.candidato.controlcenter.application.out.persistence.PlanetsRepository;
import br.com.elo7.sonda.candidato.controlcenter.application.out.persistence.ProbesRepository;
import br.com.elo7.sonda.candidato.controlcenter.domain.Planet;
import br.com.elo7.sonda.candidato.controlcenter.domain.Probe;
import com.google.common.collect.Lists;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

@Component
//@Primary
class InMemoryDatabase {
	private static Map<Planet, List<Probe>> probesPerPlanet = new HashMap<>();
	
	@Repository
	public class PlanetDAO implements PlanetsRepository {
		public void save(Planet planet) {
			planet.setPlanetId(planet.nextSequence());
			probesPerPlanet.put(planet, Lists.newArrayList());
		}

		public Optional<Planet> findById(int id) {
			return probesPerPlanet.keySet()
					.stream()
					.filter(planet -> planet.getId() == id)
					.findFirst();
		}

		@Override
		public Planet findByName(String name) {
			return probesPerPlanet.keySet()
								  .stream()
								  .filter(planet -> name.equals(planet.getName()))
								  .findFirst().get();
		}

		@Override
		public List<Planet> findAll(Sort sort) {
			return probesPerPlanet.keySet().stream().collect(Collectors.toList());
		}
	}
	
	@Repository	
	public class ProbeDAO implements ProbesRepository {
		@Override
		public void save(Probe probe) {
			List<Probe> probes = probesPerPlanet.get(probe.getPlanet());
			probe.setProbeId(nextSequence(probe.getId()));
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
		public Integer nextSequence(Integer id) {
			return id ++;
		}

	}
}
