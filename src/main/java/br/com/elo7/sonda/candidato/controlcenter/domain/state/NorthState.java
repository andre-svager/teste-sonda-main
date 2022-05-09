package br.com.elo7.sonda.candidato.controlcenter.domain.state;

import br.com.elo7.sonda.candidato.controlcenter.domain.Coordinate;
import br.com.elo7.sonda.candidato.controlcenter.domain.CoordinateException;
import br.com.elo7.sonda.candidato.controlcenter.domain.Direction;

public class NorthState implements DirectionState {

	@Override
	public Coordinate move(Coordinate coordinates) throws CoordinateException {
		return new Coordinate(coordinates.x().value(), coordinates.y().increase());
	}
	
	@Override
	public String type() {
		return Direction.NORTH.getValue();
	}

	@Override
	public DirectionState left() {
		return new WestState();
	}

	@Override
	public DirectionState right() {
		return new EastState();
	}
	
}
