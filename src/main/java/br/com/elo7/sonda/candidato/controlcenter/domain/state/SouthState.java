package br.com.elo7.sonda.candidato.controlcenter.domain.state;

import br.com.elo7.sonda.candidato.controlcenter.domain.Coordinate;
import br.com.elo7.sonda.candidato.controlcenter.domain.CoordinateException;
import br.com.elo7.sonda.candidato.controlcenter.domain.Direction;

public class SouthState implements DirectionState {

	@Override
	public Coordinate move(Coordinate coordinates) throws CoordinateException {
		return new Coordinate(coordinates.x().value(), coordinates.y().decrease());
	}
	
	@Override
	public String type() {
		return Direction.SOUTH.getValue();
	}

	@Override
	public DirectionState left() {
		return new EastState();
	}

	@Override
	public DirectionState right() {
		return new WestState();
	}
	
}

