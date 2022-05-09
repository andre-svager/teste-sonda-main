package br.com.elo7.sonda.candidato.controlcenter.domain;

import br.com.elo7.sonda.candidato.controlcenter.domain.factory.DirectionFactory;
import br.com.elo7.sonda.candidato.controlcenter.domain.state.DirectionState;

public class Probe {
	private int id;
	private Coordinate coordinate;
	private DirectionState state;

	public Probe(Coordinate coordinates, String state) throws DirectionException {
		this.coordinate = coordinates;
		this.state = DirectionFactory.direction(state);
	}

	private boolean invalidCoordinates(int x, int y) {
		return this.coordinate.x().isBiggerThan(x)
				|| coordinate.y().isBiggerThan(y)
				|| coordinate.y().isLessThan(LatVO.ZERO)
				|| coordinate.y().isLessThan(LngVO.ZERO);
	}
}
