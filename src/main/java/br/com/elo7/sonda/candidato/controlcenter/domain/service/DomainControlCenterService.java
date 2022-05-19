package br.com.elo7.sonda.candidato.controlcenter.domain.service;

import br.com.elo7.sonda.candidato.controlcenter.application.out.persistence.PlanetsRepository;
import br.com.elo7.sonda.candidato.controlcenter.application.out.persistence.ProbesRepository;
import br.com.elo7.sonda.candidato.controlcenter.domain.*;
import br.com.elo7.sonda.candidato.controlcenter.domain.factory.DirectionFactory;
import org.springframework.data.domain.Sort;

import java.util.List;
import java.util.Optional;

import static br.com.elo7.sonda.candidato.controlcenter.domain.MessageType.PLANET_NOT_FOUND;

public class DomainControlCenterService implements ControlCenterService {

    private final ProbesRepository probeRepository;
    private final PlanetsRepository planetRepository;

    public DomainControlCenterService( ProbesRepository probeRepository,
                                       PlanetsRepository planetsRepository) {
        this.probeRepository = probeRepository;
        this.planetRepository = planetsRepository;
    }

    @Override
    public Planet generateAPlanet(int x, int y) {
        return new Planet(x, y).save(planetRepository);
    }

    @Override
    public Probe registerAProbeInAPlanet(Integer planetId, int x, int y,
                                         char direction, String commands)
                                                    throws DirectionException, PlanetException, CommandException{
                return Optional.ofNullable(findPlanet(planetId)
                                                 .generateAProbe(x, y, direction)
                                                 .move(commands)
                                                 .save(probeRepository))
                               .orElseThrow(() -> new PlanetException(PLANET_NOT_FOUND));
    }

    public List<Probe> findAllProbesInAPlanet(Integer planetId) {
        return probeRepository.findAllProbesPlanet(planetId);
    }



    @Override
    public Planet findPlanet(int id) {
        return new Planet(id, planetRepository);
    }

    public List<Probe> landProbes(Planet planet, List<Probe> probes) {
        List<Probe> convertedProbes = null;//moveProbes(probes);
        convertedProbes.forEach(probe -> { // probe.setProbeId(probeRepository.nextSequence(probe.getId()));
                                            probeRepository.save(probe);});
        return convertedProbes;
    }

    public List<Planet> getAllPlanets() {
        return planetRepository.findAll(Sort.by(Sort.Direction.ASC, "id"));
    }

    @Override
    public Probe movementAProbe(int id, String commands) throws CommandException, DirectionException {
        Probe probe = probeRepository.findById(id).
                              orElseThrow(() -> new ProbeOutOfRangeException());
        return probe.move(commands).save(probeRepository);
    }
}
