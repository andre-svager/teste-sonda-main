package br.com.elo7.sonda.candidato.controlcenter.domain.state;

import br.com.elo7.sonda.candidato.controlcenter.domain.Coordinate;
import br.com.elo7.sonda.candidato.controlcenter.domain.CoordinateException;
import br.com.elo7.sonda.candidato.controlcenter.domain.Direction;


public class EastState implements DirectionState {

	@Override
	public Coordinate move(Coordinate coordinates) throws CoordinateException {
		return new Coordinate(coordinates.x().increase(), coordinates.y().value());
	}
	
	@Override
	public String type() {
		return Direction.EAST.getValue();
	}

	@Override
	public DirectionState left() {
		return new NorthState();
	}

	@Override
	public DirectionState right() {
		return new SouthState();
	}
	
}
