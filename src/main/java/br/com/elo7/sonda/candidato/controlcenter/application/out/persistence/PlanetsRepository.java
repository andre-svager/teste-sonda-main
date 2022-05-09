package br.com.elo7.sonda.candidato.controlcenter.application.out.persistence;

import br.com.elo7.sonda.candidato.controlcenter.domain.Planet;
import org.springframework.data.domain.Sort;

import java.util.List;
import java.util.Optional;

public interface PlanetsRepository {

	void save(Planet planet);

	Optional<Planet> findById(int id);

	Planet findByName(String name);

	List<Planet> findAll(Sort sort);
}
