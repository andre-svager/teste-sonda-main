package br.com.elo7.sonda.candidato.domain.service;

import java.util.List;
import br.com.elo7.sonda.candidato.domain.model.Planet;
import br.com.elo7.sonda.candidato.domain.model.Probe;


public interface ProbeService {

	public List<Probe> landProbes(Planet planet, List<Probe> probes);

	public Planet getPlanet(String name);

}
