package br.com.elo7.sonda.candidato.controlcenter.application.in.web;

import br.com.elo7.sonda.candidato.controlcenter.domain.Planet;
import br.com.elo7.sonda.candidato.controlcenter.domain.Probe;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;
import java.util.stream.Collectors;

public class ProbeRequest {
	@JsonProperty
	private int x;
	@JsonProperty
	private int y;
	@JsonProperty
	private char direction;
	@JsonProperty
	private String commands;
	@JsonProperty(required = true)
	private Integer planetId;

	public ProbeRequest(){}

	public ProbeRequest(int x, int y, char direction) {
		this.x = x;
		this.y = y;
		this.direction = direction;
	}

	public int getX() { return x;}

	public int getY() { return y;}

	public char getDirection() { return direction;}

	public String getCommands() {return commands;}

	public Integer getPlanetId() {return planetId;}

	public static List<ProbeRequest> convertTo(List<Probe> probes) {
		return probes.stream()
					 .map(p -> new ProbeRequest( p.getProbeCoordinates().x().value(),
												 p.getProbeCoordinates().y().value(),
												 p.getLatestDirection().charAt(0))).collect(Collectors.toList());
	}

    public Planet concertPlanet() {
		return new Planet(x, y);
    }
}
