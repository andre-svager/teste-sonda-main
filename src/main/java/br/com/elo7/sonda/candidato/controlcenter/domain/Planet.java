package br.com.elo7.sonda.candidato.controlcenter.domain;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

public class Planet {

	private Integer id;
	private Coordinate extension;
	private List<Probe> probes;

	public Planet(Coordinate coordinates) {
		this.extension = coordinates;
		this.id = generateSequence();
	}

	public Planet(Coordinate coordinates, Integer identifier) {
		this.extension = coordinates;
		Optional.ofNullable(identifier).orElse(generateSequence());
	}

	private Integer generateSequence() {
		return this.id = hashCode();
	}

	public Integer getPlanetIdentifier() { return id; }

	public Coordinate getPlanetCoordinates(){
		return extension;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		Planet planet = (Planet) o;
		return id.equals(planet.id) && extension.equals(planet.extension);
	}

	@Override
	public int hashCode() {
		return Objects.hash(id, extension);
	}
}

