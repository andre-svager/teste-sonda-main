package br.com.elo7.sonda.candidato.direction.domain;

import br.com.elo7.sonda.candidato.controlcenter.domain.exceptions.DirectionException;

public class DirectionFactory {
	public static DirectionState direction(String direction) throws DirectionException {
		return switch (Direction.toDirection(direction)) {
			case NORTH -> new North();
			case SOUTH -> new South();
			case EAST -> new East();
			case WEST -> new West();
		};
	}
}
