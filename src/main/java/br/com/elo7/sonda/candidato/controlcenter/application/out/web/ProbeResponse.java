package br.com.elo7.sonda.candidato.controlcenter.application.out.web;

import br.com.elo7.sonda.candidato.controlcenter.application.in.web.ProbeRequest;
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
	private String direction;

	public ProbeResponse(int x, int y, String direction) {
		this.x = x;
		this.y = y;
		this.direction = direction;
	}

	public static List<ProbeResponse> convertTo(List<Probe> probes) {
		return probes.stream()
					 .map(p -> new ProbeResponse( p.getProbeCoordinates().x().value(),
												 p.getProbeCoordinates().y().value(),
												 p.getLatestDirection())).collect(Collectors.toList());
	}
}
