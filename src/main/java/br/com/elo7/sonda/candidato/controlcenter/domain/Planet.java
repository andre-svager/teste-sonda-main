package br.com.elo7.sonda.candidato.controlcenter.domain;

import br.com.elo7.sonda.candidato.controlcenter.application.out.persistence.PlanetsRepository;

import java.util.Objects;
import java.util.Optional;

import static br.com.elo7.sonda.candidato.controlcenter.domain.MessageType.*;

public class Planet {

	private Integer id;
	private Coordinate extension;

	public Planet(int x, int y) {
		this.extension = new Coordinate(x,y);
		this.id = generateSequence();
	}

	public Planet(Integer id) {
		this.id = id;
	}

	private Planet(){}

	public Planet(int x, int y, Integer identifier, PlanetsRepository repository) {
		this.extension = new Coordinate(x,y);
		Optional.ofNullable( repository.findById(identifier).map(a -> checkIfPlanetHasSameCoordinates(a)).get() )
				.orElse(new Planet(x, y, generateSequence(), repository));
	}

	public Planet(Integer identifier, PlanetsRepository repository) {
		Optional.ofNullable( repository.findById(identifier).map(a -> loadRecoveredPlanet(a)).get() )
				.orElseThrow(() -> new PlanetException(PLANET_NOT_FOUND));
	}

	public Probe generateAProbe( Integer x, Integer y,
								 char direction) throws DirectionException, ProbeOutOfRangeException {

		return new Probe(this, new Coordinate(x,y),String.valueOf(direction));
	}

	private Planet loadRecoveredPlanet(Planet planet) {
		this.extension = planet.getPlanetCoordinates();
		this.id = planet.getId();
		return planet;
	}

	private Planet checkIfPlanetHasSameCoordinates(Planet planet) {
		if( this.extension
				.equals(planet.getPlanetCoordinates())) throw new PlanetException(PLANET_DUPLICATED);
		return planet;
	}

	public Planet
			save(PlanetsRepository repository){ return repository.save(this);}

	private Integer generateSequence() {
		return this.id = hashCode();
	}

	public Integer getId() { return id; }

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
		return Objects.hash(extension.x().value(), extension.y().value());
	}
}