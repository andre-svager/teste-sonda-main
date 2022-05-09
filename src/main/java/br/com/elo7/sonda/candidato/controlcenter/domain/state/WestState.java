package br.com.elo7.sonda.candidato.controlcenter.domain.state;

import br.com.elo7.sonda.candidato.controlcenter.domain.Coordinate;
import br.com.elo7.sonda.candidato.controlcenter.domain.CoordinateException;
import br.com.elo7.sonda.candidato.controlcenter.domain.Direction;

public class WestState implements DirectionState {

	@Override
	public Coordinate move(Coordinate coordinates) throws CoordinateException {
		return new Coordinate(coordinates.x().decrease(), coordinates.y().value());
	}
	
	@Override
	public String type() {
		return Direction.WEST.getValue();
	}

	@Override
	public DirectionState left() {
		return new SouthState();
	}

	@Override
	public DirectionState right() {
		return new NorthState();
	}
	
}
