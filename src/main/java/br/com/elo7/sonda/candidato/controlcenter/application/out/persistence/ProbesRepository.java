package br.com.elo7.sonda.candidato.controlcenter.application.out.persistence;

import br.com.elo7.sonda.candidato.controlcenter.domain.Probe;

import java.util.List;
import java.util.Optional;

public interface ProbesRepository {

	Probe save(Probe probe);

	Optional<Probe> findById(int id);

	Integer nextSequence(Integer id);

    List<Probe> findAllProbesPlanet(Integer planetId);
}
