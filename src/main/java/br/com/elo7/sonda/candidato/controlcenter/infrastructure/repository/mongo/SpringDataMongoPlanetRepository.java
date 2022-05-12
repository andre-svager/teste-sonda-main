package br.com.elo7.sonda.candidato.controlcenter.infrastructure.repository.mongo;

import br.com.elo7.sonda.candidato.controlcenter.domain.Planet;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SpringDataMongoPlanetRepository extends MongoRepository<Planet, Integer> {

}
