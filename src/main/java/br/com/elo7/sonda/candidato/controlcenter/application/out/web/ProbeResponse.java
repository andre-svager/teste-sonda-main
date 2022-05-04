package br.com.elo7.sonda.candidato.controlcenter.application.out.web;

import br.com.elo7.sonda.candidato.controlcenter.domain.Probe;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;
import java.util.stream.Collectors;

public class ProbeResponse {
	@JsonProperty
	private int x;
	@JsonProperty
	private int y;
	@JsonProperty
	private char direction;

	public ProbeResponse(int x, int y, char direction) {
		this.x = x;
		this.y = y;
		this.direction = direction;
	}

	public static List<ProbeResponse> convertToDTO(List<Probe> probes) {
		return probes.stream()
					 .map(p -> new ProbeResponse( p.getX(),
											 p.getY(),
											 p.getDirection())).collect(Collectors.toList());
	}
}
