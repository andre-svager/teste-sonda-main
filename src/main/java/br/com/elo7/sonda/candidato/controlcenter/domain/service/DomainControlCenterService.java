package br.com.elo7.sonda.candidato.controlcenter.domain.service;

import br.com.elo7.sonda.candidato.controlcenter.application.out.persistence.PlanetsRepository;
import br.com.elo7.sonda.candidato.controlcenter.application.out.persistence.ProbesRepository;
import br.com.elo7.sonda.candidato.controlcenter.domain.Coordinate;
import br.com.elo7.sonda.candidato.controlcenter.domain.Planet;
import br.com.elo7.sonda.candidato.controlcenter.domain.Probe;
import br.com.elo7.sonda.candidato.controlcenter.domain.PlanetNotFoundException;
import org.springframework.data.domain.Sort;

import java.util.List;
import java.util.stream.Collectors;

public class DomainControlCenterService implements ControlCenterService {

    private final ProbesRepository probeRepository;
    private final PlanetsRepository planetRepository;

    public DomainControlCenterService(ProbesRepository probeRepository, PlanetsRepository planetsRepository) {
        this.probeRepository = probeRepository;
        this.planetRepository = planetsRepository;
    }
    @Override
    public Planet generateAPlanet(Coordinate toCoordinates) {
        return planetRepository.save(toCoordinates);
    }

    @Override
    public List<Probe> landProbes(Planet planet, List<Probe> probes) {
        planet.isOutOfPlanetLatitude(10);
        planet.isOutOfPlanetLongitude(10);
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
