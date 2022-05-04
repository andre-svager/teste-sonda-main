package br.com.elo7.sonda.candidato.direction.domain;

import br.com.elo7.sonda.candidato.controlcenter.domain.Coordinate;
import br.com.elo7.sonda.candidato.controlcenter.domain.exceptions.CoordinateException;


public class East implements DirectionState {

	@Override
	public Coordinate move(Coordinate coordinates) throws CoordinateException {
		return new Coordinate(coordinates.x().increase(), coordinates.x().value());
	}
	
	@Override
	public String type() {
		return Direction.EAST.getValue();
	}

	@Override
	public DirectionState left() {
		return new North();
	}

	@Override
	public DirectionState right() {
		return new South();
	}
	
}
