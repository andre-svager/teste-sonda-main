package br.com.elo7.sonda.candidato.infrastructure.repository.mongo;

import br.com.elo7.sonda.candidato.domain.model.Probe;
import br.com.elo7.sonda.candidato.domain.repository.ProbesRepository;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
@Primary
public class MongoDBProbeRepository implements ProbesRepository {

    private final SpringDataMongoProbeRepository probeRepo;

    public MongoDBProbeRepository(SpringDataMongoProbeRepository probeRepo) {
        this.probeRepo = probeRepo;
    }

    @Override
    public void save(Probe probe) {
        probeRepo.save(probe);
    }

    @Override
    public Optional<Probe> findById(int id) {
        return probeRepo.findById(id);
    }

    @Override
    public Integer nextSequence(Integer id) {
            return ++id;
    }
}

    /*@Override
    public Optional<Probe> findByCoordinates(int x, int y) {
        return probeRepo.findByCoordinates(x,y);
    }*/
