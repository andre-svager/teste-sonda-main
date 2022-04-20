package br.com.elo7.sonda.candidato.domain.repository;

import java.util.Optional;

import br.com.elo7.sonda.candidato.domain.model.Probe;

public interface ProbesRepository {

	void save(Probe probe);

	Optional<Probe> findById(int id);

	Integer nextSequence(Integer id);

}
