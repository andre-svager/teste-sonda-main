package br.com.elo7.sonda.candidato.direction.domain;

import br.com.elo7.sonda.candidato.controlcenter.domain.Coordinate;
import br.com.elo7.sonda.candidato.controlcenter.domain.exceptions.CoordinateException;

public class West implements DirectionState {

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
		return new South();
	}

	@Override
	public DirectionState right() {
		return new North();
	}
	
}
