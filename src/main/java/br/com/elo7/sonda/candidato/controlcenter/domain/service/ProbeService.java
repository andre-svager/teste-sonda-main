package br.com.elo7.sonda.candidato.controlcenter.domain.service;

import br.com.elo7.sonda.candidato.controlcenter.domain.Coordinate;
import br.com.elo7.sonda.candidato.controlcenter.domain.Planet;
import br.com.elo7.sonda.candidato.controlcenter.domain.Probe;

import java.util.List;


public interface ProbeService {

	public List<Probe> landProbes(Planet planet, List<Probe> probes);

	public Planet getPlanet(String name);

    public Planet load(Coordinate toCoordinates);
}
