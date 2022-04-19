package br.com.elo7.sonda.candidato.infrastructure.repository.mongo;

import br.com.elo7.sonda.candidato.domain.model.Probe;
import org.springframework.stereotype.Repository;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Optional;

@Repository
public interface SpringDataMongoProbeRepository extends MongoRepository<Probe, Integer> {
    //Optional<Probe> findByCoordinates(int x, int y);
}
