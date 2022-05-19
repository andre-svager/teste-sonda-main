package br.com.elo7.sonda.candidato.controlcenter.infrastructure.repository.mongo;

import br.com.elo7.sonda.candidato.controlcenter.domain.Planet;
import br.com.elo7.sonda.candidato.controlcenter.domain.Probe;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SpringDataMongoProbeRepository extends MongoRepository<Probe, Integer> {

    @Query("{ 'planetId: ?0 }")
    public List<Probe> findAllProbeByPlanetId(Integer planetId);
}
