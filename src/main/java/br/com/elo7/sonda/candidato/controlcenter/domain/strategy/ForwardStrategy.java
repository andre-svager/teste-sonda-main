package br.com.elo7.sonda.candidato.controlcenter.domain.strategy;

import br.com.elo7.sonda.candidato.controlcenter.domain.Coordinate;
import br.com.elo7.sonda.candidato.controlcenter.domain.Planet;
import com.elo7.marte.domain.Explorer;
import com.elo7.marte.domain.vo.Coordinate;

public class ForwardStrategy implements MovementStrategy {
	
	private Planet planet;
	
	public ForwardStrategy(Planet planet) {
		this.planet = planet;
	}

	@Override
	public void move() {
		Coordinate coordinates = planet.getState().move(planet.getCoordinates());
		planet.setCoordinates(coordinates);
	}
	
}
