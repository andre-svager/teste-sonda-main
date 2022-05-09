package br.com.elo7.sonda.candidato.controlcenter.domain.strategy;

import br.com.elo7.sonda.candidato.controlcenter.domain.Command;
import br.com.elo7.sonda.candidato.controlcenter.domain.DirectionException;
import br.com.elo7.sonda.candidato.controlcenter.domain.Planet;

public class RotateStrategy implements MovementStrategy {
	
	private Planet planet;
	private String command;
	
	public RotateStrategy(Planet planet, String command) {
		super();
		this.planet = planet;
		this.command = command;
	}
	
	@Override
	public void move() throws DirectionException {
		switch (Command.valueOf(command)){
			case RIGHT -> planet.changeDirection(planet.getDirection().right());
			case LEFT ->planet.changeDirection(planet.getDirection().left());
			default -> throw new DirectionException("Invalid command");
		}
	}

}
