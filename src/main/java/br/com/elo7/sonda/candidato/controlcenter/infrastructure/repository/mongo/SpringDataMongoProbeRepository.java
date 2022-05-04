package br.com.elo7.sonda.candidato.controlcenter.infrastructure.repository.mongo;

import br.com.elo7.sonda.candidato.controlcenter.domain.Probe;
import org.springframework.stereotype.Repository;
import org.springframework.data.mongodb.repository.MongoRepository;

@Repository
public interface SpringDataMongoProbeRepository extends MongoRepository<Probe, Integer> {
    //Optional<Probe> findByCoordinates(int x, int y);
}
