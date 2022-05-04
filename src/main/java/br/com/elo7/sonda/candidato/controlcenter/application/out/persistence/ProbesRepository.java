package br.com.elo7.sonda.candidato.controlcenter.application.out.persistence;

import java.util.Optional;

import br.com.elo7.sonda.candidato.controlcenter.domain.Probe;

public interface ProbesRepository {

	void save(Probe probe);

	Optional<Probe> findById(int id);

	Integer nextSequence(Integer id);

}
