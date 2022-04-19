package br.com.elo7.sonda.candidato.infrastructure.repository.mongo;

import br.com.elo7.sonda.candidato.domain.model.Planet;
import br.com.elo7.sonda.candidato.domain.repository.PlanetsRepository;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

import java.util.Optional;

//@Component
//@Primary
public class MongoDBPlanetRepository implements PlanetsRepository {

    private final SpringDataMongoPlanetRepository planetRepository;

    public MongoDBPlanetRepository(SpringDataMongoPlanetRepository planetRepository) {
        this.planetRepository = planetRepository;
    }

    @Override
    public void save(Planet planet) {
        planetRepository.save(planet);
    }

    @Override
    public Optional<Planet> findById(int id) {
        return Optional.empty();
    }
}
