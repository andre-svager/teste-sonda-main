package br.com.elo7.sonda.candidato.controlcenter.infrastructure.repository.mongo;

import br.com.elo7.sonda.candidato.controlcenter.application.out.persistence.PlanetsRepository;
import br.com.elo7.sonda.candidato.controlcenter.domain.Coordinate;
import br.com.elo7.sonda.candidato.controlcenter.domain.Planet;
import org.springframework.context.annotation.Primary;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
@Primary
public class MongoDBPlanetRepository implements PlanetsRepository {

    private final SpringDataMongoPlanetRepository planetRepository;

    public MongoDBPlanetRepository(SpringDataMongoPlanetRepository planetRepository) {
        this.planetRepository = planetRepository;
    }


    public Planet save(Planet planet) {
        planetRepository.save(planet);
        return planet;
    }

    @Override
    public Planet save(Coordinate coordinates) {
        return null;
    }

    @Override
    public Optional<Planet> findById(Integer id) {
        return Optional.empty();
    }

    @Override
    public List<Planet> findAll(Sort sort) {
        return planetRepository.findAll(sort);
    }
}
