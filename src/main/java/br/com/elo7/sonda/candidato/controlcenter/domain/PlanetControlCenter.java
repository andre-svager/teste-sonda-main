package br.com.elo7.sonda.candidato.controlcenter.domain;

import br.com.elo7.sonda.candidato.controlcenter.domain.state.DirectionState;

import java.util.List;

public class PlanetControlCenter {

	private int id;
	private Coordinate extension;
	private DirectionState direction;

	private Planet planet;

	private List<Probe> probes;

	private Probe currentProbe;

	protected PlanetControlCenter() {}

	public PlanetControlCenter(Coordinate coordinates, DirectionState direction) throws DirectionException {
		this.extension = coordinates;
		this.direction = direction;
	}
}
