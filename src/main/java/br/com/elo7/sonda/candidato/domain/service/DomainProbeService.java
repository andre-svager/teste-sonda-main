package br.com.elo7.sonda.candidato.domain.service;

import br.com.elo7.sonda.candidato.domain.PlanetNotFoundException;
import br.com.elo7.sonda.candidato.domain.model.Planet;
import br.com.elo7.sonda.candidato.domain.model.Probe;
import br.com.elo7.sonda.candidato.domain.repository.PlanetsRepository;
import br.com.elo7.sonda.candidato.domain.repository.ProbesRepository;
import org.springframework.data.domain.Sort;

import java.util.List;
import java.util.stream.Collectors;

public class DomainProbeService implements ProbeService{

    private final ProbesRepository probeRepository;
    private final PlanetsRepository planetRepository;

    public DomainProbeService(ProbesRepository probeRepository, PlanetsRepository planetsRepository) {
        this.probeRepository = probeRepository;
        this.planetRepository = planetsRepository;
    }

    @Override
    public List<Probe> landProbes(Planet planet, List<Probe> probes) {
        planet.setPlanetId(planet.nextSequence());
        planetRepository.save(planet);

        List<Probe> convertedProbes = moveProbes(probes);
        convertedProbes.forEach(probe -> {  probe.setProbeId(probeRepository.nextSequence(probe.getId()));
                                            probeRepository.save(probe);});
        return convertedProbes;
    }

    @Override
    public Planet getPlanet(String name) {
        return planetRepository
                .findByName(name);
    }

    public Planet getPlanet(Integer id) {
        return planetRepository.findById(id).orElseThrow(PlanetNotFoundException::new);
    }

    public List<Planet> getAllPlanets() {
        return planetRepository.findAll(Sort.by(Sort.Direction.ASC, "name"));
    }

    private List<Probe> moveProbes(List<Probe> probes){
        return probes.stream().map(probe -> probe.moveProbeWithAllCommands()).collect(Collectors.toList());
    }

    public void verifyIfThereIsAProbeInSamePosition(int x, int y){
        //probeRepository.findAll().filter( p -> { throw new ProbeCollisionException(); });
    }

}
