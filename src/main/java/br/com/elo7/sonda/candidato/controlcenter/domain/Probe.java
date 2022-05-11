package br.com.elo7.sonda.candidato.controlcenter.domain;

import br.com.elo7.sonda.candidato.controlcenter.domain.factory.DirectionFactory;
import br.com.elo7.sonda.candidato.controlcenter.domain.state.DirectionState;
import br.com.elo7.sonda.candidato.controlcenter.domain.strategy.ForwardStrategy;
import br.com.elo7.sonda.candidato.controlcenter.domain.strategy.MovementStrategy;
import br.com.elo7.sonda.candidato.controlcenter.domain.strategy.RotateStrategy;

public class Probe {
	private Integer id;
	private Integer planetId;
	private Coordinate coordinate;
	private DirectionState direction;

	public Probe(Planet planet, Coordinate coordinates, String state) throws CoordinateException, DirectionException {
		this.coordinate = coordinates;
		this.direction = DirectionFactory.direction(state);
		this.planetId = planet.getPlanetIdentifier();

		if( isInvalidCoordinates( planet.getPlanetCoordinates().x().value(),
								  planet.getPlanetCoordinates().x().value())){
			throw new CoordinateException();
		}
	}

	public Probe move(String command) throws DirectionException {
		MovementStrategy strategy = strategy(command);
		strategy.move();
		return this;
	}

	private MovementStrategy strategy(String command) {
		return switch (Command.valueOf(command)){
			case LEFT -> new RotateStrategy(this, "");
			case MOVE -> new ForwardStrategy(new Planet(new Coordinate(1,1)));
			case RIGHT -> new RotateStrategy(this, "");
		};
	}


	public DirectionState changeDirection(DirectionState state){
		return this.direction = state;
	}

	private boolean isInvalidCoordinates(int x, int y) {
		return  isOutOfPlanetLongitude(x)
				|| isOutOfPlanetLatitude(y)
				|| isLongitudeAboveZero()
				|| isLatitudeAboveZero();
	}

	private boolean isLatitudeAboveZero() { return this.coordinate.y().value() < 0; }

	private boolean isLongitudeAboveZero() { return this.coordinate.x().value() < 0; }

	public boolean isOutOfPlanetLongitude(int xAxis) { return coordinate.x().value() > xAxis ;}

	public boolean isOutOfPlanetLatitude(int yAxis) { return coordinate.y().value() > yAxis; }

	public Coordinate getProbeCoordinates(){
		return this.coordinate;
	}

	public String getLatestDirection(){
		return this.direction.type();
	}

	public Integer getPlanetIdentifier(){ return this.planetId; }

	public Integer getProbeIdentifier(){return this.id;}
}
