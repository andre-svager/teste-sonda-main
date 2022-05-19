package br.com.elo7.sonda.candidato.controlcenter.infrastructure.repository.mongo;

import br.com.elo7.sonda.candidato.controlcenter.application.out.persistence.ProbesRepository;
import br.com.elo7.sonda.candidato.controlcenter.domain.Planet;
import br.com.elo7.sonda.candidato.controlcenter.domain.Probe;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
@Primary
public class MongoDBProbeRepository implements ProbesRepository {

    private final SpringDataMongoProbeRepository probeRepo;

    public MongoDBProbeRepository(SpringDataMongoProbeRepository probeRepo) {
        this.probeRepo = probeRepo;
    }

    @Override
    public Probe save(Probe probe) {
        probeRepo.save(probe);
        return probe;
    }

    @Override
    public Optional<Probe> findById(int id) {
        return probeRepo.findById(id);
    }

    @Override
    public Integer nextSequence(Integer id) {
            return ++id;
    }

    @Override
    public List<Probe> findAllProbesPlanet(Integer planetId) {
        return probeRepo.findAllProbeByPlanetId(planetId);
    }
}