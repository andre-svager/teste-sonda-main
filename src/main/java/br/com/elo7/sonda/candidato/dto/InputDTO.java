package br.com.elo7.sonda.candidato.dto;

import br.com.elo7.sonda.candidato.domain.model.Planet;

import java.util.List;

public class InputDTO {
	private int width; 
	private int height;
	private List<ProbeDTO> probes;

	public int getWidth() {
		return width;
	}
	public void setWidth(int width) {
		this.width = width;
	}
	public int getHeight() {
		return height;
	}
	public void setHeight(int height) {
		this.height = height;
	}
	public List<ProbeDTO> getProbes() {
		return probes;
	}
	public void setProbes(List<ProbeDTO> probes) {
		this.probes = probes;
	}

	public Planet concertPlanet(InputDTO input) {
		return new Planet(input.getHeight(), input.getWidth());
	}
}
