package br.com.elo7.sonda.candidato.controlcenter.domain;

import java.util.UUID;

public class Planet {

	private UUID id;
	private Coordinate extension;

	public Planet(Coordinate coordinates) {
		this.extension = coordinates;
		this.id = generateSequence();
	}
	private UUID generateSequence() {
		return UUID.randomUUID();
	}
	public String getPlanetIdentifier() {
		return "planet<$id>";
	}
	public boolean isOutOfPlanetLongitude(int xAxis) { return xAxis > extension.x().value();}
	public boolean isOutOfPlanetLatitude(int yAxis) {
		return yAxis > extension.y().value();
	}
}

