package br.com.elo7.sonda.candidato.infrastructure.repository.mongo;

import br.com.elo7.sonda.candidato.domain.model.Planet;
import br.com.elo7.sonda.candidato.domain.model.Probe;
import org.springframework.stereotype.Repository;
import org.springframework.data.mongodb.repository.MongoRepository;

@Repository
public interface SpringDataMongoPlanetRepository extends MongoRepository<Planet, Integer> {

}
