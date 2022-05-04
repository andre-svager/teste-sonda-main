package br.com.elo7.sonda.candidato.controlcenter.application.in.web;

import br.com.elo7.sonda.candidato.controlcenter.domain.Planet;
import br.com.elo7.sonda.candidato.controlcenter.domain.Probe;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;
import java.util.stream.Collectors;

public class ProbeDTO {
	@JsonProperty
	private int x;
	@JsonProperty
	private int y;
	@JsonProperty
	private char direction;
	@JsonProperty
	private String commands;

	public ProbeDTO(){}

	public ProbeDTO(int x, int y, char direction) {
		this.x = x;
		this.y = y;
		this.direction = direction;
	}

	public Probe convertProbe(Planet planet) {
		return new Probe(planet, this.x, this.y, this.direction, this.commands);
	}

	public String getProbeCommands(){
		return this.commands;
	}

	public static List<ProbeDTO> convertToDTO(List<Probe> probes) {
		return probes.stream()
					 .map(p -> new ProbeDTO( p.getX(),
											 p.getY(),
											 p.getDirection())).collect(Collectors.toList());
	}
}
