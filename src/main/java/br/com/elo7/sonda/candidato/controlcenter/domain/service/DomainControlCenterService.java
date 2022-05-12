package br.com.elo7.sonda.candidato.controlcenter.domain.service;

import br.com.elo7.sonda.candidato.controlcenter.application.out.persistence.PlanetsRepository;
import br.com.elo7.sonda.candidato.controlcenter.application.out.persistence.ProbesRepository;
import br.com.elo7.sonda.candidato.controlcenter.domain.*;
import org.springframework.data.domain.Sort;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;
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
        return new Planet(toCoordinates).save(planetRepository);
    }

    @Override
    public List<Probe> registerAProbeInAPlanet( Integer planetId, int x, int y,
                                                char direction, String commands)
                                                    throws DirectionException,PlanetNotFoundException, CommandException{
        Optional.ofNullable( findPlanet(planetId)
                                .generateAProbe( x, y, direction)
                                .move(commands)
                                .save(probeRepository) )
                .orElseThrow(PlanetNotFoundException::new);

        return findAllProbesInAPlanet(planetId);
    }

    private List<Probe> findAllProbesInAPlanet(Integer planetId) {
        return probeRepository.findAllProbesPlanet(planetId);
    }

    @Override
    public Planet findPlanet(int id) {
        return null;
    }

    public List<Probe> landProbes(Planet planet, List<Probe> probes) {
        List<Probe> convertedProbes = null;//moveProbes(probes);
        convertedProbes.forEach(probe -> { // probe.setProbeId(probeRepository.nextSequence(probe.getId()));
                                            probeRepository.save(probe);});
        return convertedProbes;
    }

    public Planet getPlanet(Integer id) {
        return planetRepository.findById(id).orElseThrow(PlanetNotFoundException::new);
    }

    public List<Planet> getAllPlanets() {
        return planetRepository.findAll(Sort.by(Sort.Direction.ASC, "name"));
    }

    public void verifyIfThereIsAProbeInSamePosition(int x, int y){
        //probeRepository.findAll().filter( p -> { throw new ProbeCollisionException(); });
    }

}
