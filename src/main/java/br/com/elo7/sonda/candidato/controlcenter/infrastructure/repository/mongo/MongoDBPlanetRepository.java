package br.com.elo7.sonda.candidato.controlcenter.infrastructure.repository.mongo;

import br.com.elo7.sonda.candidato.controlcenter.domain.Planet;
import br.com.elo7.sonda.candidato.controlcenter.application.out.persistence.PlanetsRepository;
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

    @Override
    public void save(Planet planet) {
        planetRepository.save(planet);
    }

    @Override
    public Optional<Planet> findById(int id) {
        return Optional.empty();
    }

    @Override
    public Planet findByName(String name) {
        return planetRepository.findByName(name);
    }

    @Override
    public List<Planet> findAll(Sort sort) {
        return planetRepository.findAll(sort);
    }
}
