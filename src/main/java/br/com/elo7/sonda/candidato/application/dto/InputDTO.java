package br.com.elo7.sonda.candidato.application.dto;

import br.com.elo7.sonda.candidato.domain.model.Planet;
import br.com.elo7.sonda.candidato.domain.model.Probe;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;
import java.util.stream.Collectors;

public class InputDTO {
	@JsonProperty
	private int width;
	@JsonProperty
	private int height;
	@JsonProperty
	private String planetName;
	@JsonProperty
	private List<ProbeDTO> probes;

	public Planet concertPlanet(InputDTO input) {
		return new Planet(this.height, this.width, this.planetName);
	}

	public List<Probe> convertProbes(Planet planet) {
		return this.probes.stream()
						.map(probeDto -> {
								return probeDto.convertProbe(planet);
											}).collect(Collectors.toList());
	}
}