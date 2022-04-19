package br.com.elo7.sonda.candidato.domain.service;

import br.com.elo7.sonda.candidato.domain.ProbeCollisionException;
import br.com.elo7.sonda.candidato.domain.model.Planet;
import br.com.elo7.sonda.candidato.domain.model.Probe;
import br.com.elo7.sonda.candidato.domain.repository.PlanetsRepository;
import br.com.elo7.sonda.candidato.domain.repository.ProbesRepository;
import java.util.List;
import java.util.stream.Collectors;

public class DomainProbeService implements ProbeService{

    private final ProbesRepository probeRepository;
    private PlanetsRepository planetRepository;

    public DomainProbeService(ProbesRepository probeRepository) {
        this.probeRepository = probeRepository;
    }

    @Override
    public List<Probe> landProbes(Planet planet, List<Probe> probes) {
        planetRepository.save(planet);

        List<Probe> convertedProbes = moveProbes(probes);
        convertedProbes.forEach(probe -> probeRepository.save(probe));
        return convertedProbes;
    }

    @Override
    public Planet getPlanet(Integer id) {
        return new Planet(10,10);
                /**planetRepository
                .findById(id)
                .orElseThrow(PlanetNotFoundException::new);**/
    }

    private List<Probe> moveProbes(List<Probe> probes){
        return probes.stream().map(probe -> probe.moveProbeWithAllCommands()).collect(Collectors.toList());
    }

    public void verifyIfThereIsAProbeInSamePosition(int x, int y){
        //probeRepository.findByCoordinates(x,y).ifPresent( p -> { throw new ProbeCollisionException(); });
    }

}
