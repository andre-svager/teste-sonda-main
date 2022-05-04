package br.com.elo7.sonda.candidato.controlcenter.infrastructure.repository.mongo;

import br.com.elo7.sonda.candidato.controlcenter.domain.Planet;
import org.springframework.stereotype.Repository;
import org.springframework.data.mongodb.repository.MongoRepository;

@Repository
public interface SpringDataMongoPlanetRepository extends MongoRepository<Planet, Integer> {

    Planet findByName(String name);

}
