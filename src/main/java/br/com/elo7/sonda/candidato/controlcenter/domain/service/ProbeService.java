package br.com.elo7.sonda.candidato.controlcenter.domain.service;

import java.util.List;

import br.com.elo7.sonda.candidato.controlcenter.application.out.web.PlanetResponse;
import br.com.elo7.sonda.candidato.controlcenter.domain.Coordinate;
import br.com.elo7.sonda.candidato.controlcenter.domain.Planet;
import br.com.elo7.sonda.candidato.controlcenter.domain.Probe;


public interface ProbeService {

	public List<Probe> landProbes(Planet planet, List<Probe> probes);

	public Planet getPlanet(String name);

    public Planet load(Coordinate toCoordinates);
}
