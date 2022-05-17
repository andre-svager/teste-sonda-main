package br.com.elo7.sonda.candidato.controlcenter.domain.factory;

import br.com.elo7.sonda.candidato.controlcenter.domain.Direction;
import br.com.elo7.sonda.candidato.controlcenter.domain.DirectionException;
import br.com.elo7.sonda.candidato.controlcenter.domain.state.*;

public class DirectionFactory {
	public static DirectionState direction(Direction direction) throws DirectionException {
		return switch (direction) {
			case NORTH -> new NorthState();
			case SOUTH -> new SouthState();
			case EAST -> new EastState();
			case WEST -> new WestState();
		};
	}
}
