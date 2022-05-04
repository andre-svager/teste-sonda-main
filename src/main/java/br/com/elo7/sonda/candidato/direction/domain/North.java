package br.com.elo7.sonda.candidato.direction.domain;

import br.com.elo7.sonda.candidato.controlcenter.domain.Coordinate;
import br.com.elo7.sonda.candidato.controlcenter.domain.exceptions.CoordinateException;

public class North implements DirectionState {

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
		return new West();
	}

	@Override
	public DirectionState right() {
		return new East();
	}
	
}
