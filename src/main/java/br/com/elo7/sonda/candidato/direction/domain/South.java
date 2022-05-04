package br.com.elo7.sonda.candidato.direction.domain;

import br.com.elo7.sonda.candidato.controlcenter.domain.Coordinate;
import br.com.elo7.sonda.candidato.controlcenter.domain.exceptions.CoordinateException;

public class South implements DirectionState {

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
		return new East();
	}

	@Override
	public DirectionState right() {
		return new West();
	}
	
}

