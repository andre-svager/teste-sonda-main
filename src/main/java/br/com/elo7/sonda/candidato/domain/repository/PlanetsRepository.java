package br.com.elo7.sonda.candidato.domain.repository;

import java.util.Optional;

import br.com.elo7.sonda.candidato.domain.model.Planet;

public interface PlanetsRepository {

	void save(Planet planet);

	Optional<Planet> findById(int id);

}
