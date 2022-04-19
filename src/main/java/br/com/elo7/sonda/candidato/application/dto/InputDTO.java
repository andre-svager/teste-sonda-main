package br.com.elo7.sonda.candidato.application.dto;

import br.com.elo7.sonda.candidato.domain.ProbeOutOfRangeException;
import br.com.elo7.sonda.candidato.domain.model.Planet;
import br.com.elo7.sonda.candidato.domain.model.Probe;

import java.util.List;
import java.util.stream.Collectors;

public class InputDTO {
	private int width; 
	private int height;
	private List<ProbeDTO> probes;

	public Planet concertPlanet(InputDTO input) {
		return new Planet(this.height, this.width);
	}

	/**
	 * To keep layers segregated, we should convert all application Layers objects to Domain Objects
	 * @param planet
	 * @return Probes
	 */
	public List<Probe> convertProbes(Planet planet) {
		return this.probes.stream()
						.map(probeDto -> {
								return probeDto.convertProbe(planet);
											}).collect(Collectors.toList());
	}

}
