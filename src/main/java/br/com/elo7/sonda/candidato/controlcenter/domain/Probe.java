package br.com.elo7.sonda.candidato.controlcenter.domain;

import br.com.elo7.sonda.candidato.controlcenter.application.out.persistence.ProbesRepository;
import br.com.elo7.sonda.candidato.controlcenter.domain.factory.DirectionFactory;
import br.com.elo7.sonda.candidato.controlcenter.domain.state.DirectionState;
import br.com.elo7.sonda.candidato.controlcenter.domain.strategy.ForwardStrategy;
import br.com.elo7.sonda.candidato.controlcenter.domain.strategy.MovementStrategy;
import br.com.elo7.sonda.candidato.controlcenter.domain.strategy.RotateStrategy;
import java.util.Objects;

public class Probe {
	private Integer id;
	private Planet planet;
	private Coordinate coordinate;
	private DirectionState direction;


	private Probe(Integer id){ this.id = id; }

	private Probe(){}

	public Probe( Planet planet,
				  Coordinate coordinate,
				  String state) throws ProbeOutOfRangeException, DirectionException {

		this.coordinate = coordinate;
		this.direction = DirectionFactory.direction(state);

		if( isInvalidCoordinates( planet.getPlanetCoordinates().x().value(),
								  planet.getPlanetCoordinates().y().value())){
			throw new ProbeOutOfRangeException();
		}
		this.planet = planet;
		this.id = generateSequence();
	}

	private Integer generateSequence() {
		return hashCode();
	}

	public Probe move(String commands) throws DirectionException, CommandException {
		for(char command : commands.toCharArray()){
			MovementStrategy strategy = strategy(String.valueOf(command));
			strategy.move();
		}
		return this;
	}

	private MovementStrategy strategy(String command) throws CommandException {
		return switch (Command.toCommand(command.trim())){
			case LEFT, RIGHT -> new RotateStrategy(this, command);
			case MOVE -> new ForwardStrategy(this, command);
		};
	}

	private boolean isInvalidCoordinates(int x, int y) {
		return  isOutOfPlanetLongitude(x)
				|| isOutOfPlanetLatitude(y)
				|| isLongitudeAboveZero()
				|| isLatitudeAboveZero();
	}

	public Probe
		save(ProbesRepository repository){ return repository.save(this);}

	public DirectionState
			changeDirection(DirectionState state){return this.direction = state;}

	private boolean isLatitudeAboveZero() { return this.coordinate.y().value() < 0; }

	private boolean isLongitudeAboveZero() { return this.coordinate.x().value() < 0; }

	private boolean isOutOfPlanetLongitude(int xAxis) { return coordinate.x().value() > xAxis ;}

	private boolean isOutOfPlanetLatitude(int yAxis) { return coordinate.y().value() > yAxis; }

	public Coordinate getProbeCoordinates(){return this.coordinate;}

	public String getLatestDirection(){ return this.direction.type();}

	public Planet getPlanet(){ return this.planet; }

	public Integer getProbeIdentifier(){return this.id;}

	public DirectionState getDirection() { return direction;}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		Probe probe = (Probe) o;
		return planet.getId().equals(probe.planet.getId()) && coordinate.equals(probe.coordinate);
	}

	@Override
	public int hashCode() {
		return Objects.hash(planet.getId(),
							coordinate.x().value(),
							coordinate.y().value());
	}

}
