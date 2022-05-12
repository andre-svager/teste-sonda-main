package br.com.elo7.sonda.candidato.controlcenter.infrastructure.repository.inmemory;

import br.com.elo7.sonda.candidato.controlcenter.application.out.persistence.PlanetsRepository;
import br.com.elo7.sonda.candidato.controlcenter.application.out.persistence.ProbesRepository;
import br.com.elo7.sonda.candidato.controlcenter.domain.Coordinate;
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
		public Planet save(Planet planet) {
			probesPerPlanet.put(planet, Lists.newArrayList());
			return planet;
		}
		@Override
		public Optional<Planet> findById(Integer id) {
			return probesPerPlanet.keySet()
								  .stream()
								  .filter(planet -> planet.getPlanetIdentifier() == id)
								  .findFirst();
		}

		@Override
		public List<Planet> findAll(Sort sort) {
			return probesPerPlanet.keySet().stream().collect(Collectors.toList());
		}
	}
	
	@Repository	
	public class ProbeDAO implements ProbesRepository {
		@Override
		public Probe save(Probe probe) {
			List<Probe> probes = probesPerPlanet.get( probe.getPlanetIdentifier() );
			//probe.setProbeId(nextSequence(probe.getId()));
			probes.add(probe);
            return probe;
        }

		@Override
		public Optional<Probe> findById(int id) {
			return probesPerPlanet.entrySet().stream().flatMap(
						entry -> entry.getValue()
										.stream()
										.filter(probe -> probe.getProbeIdentifier() == id)
					).findFirst();
		}

		@Override
		public Integer nextSequence(Integer id) {
			return null;
		}

	}
}
