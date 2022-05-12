package br.com.elo7.sonda.candidato.controlcenter.domain.strategy;

import br.com.elo7.sonda.candidato.controlcenter.domain.*;
public class ForwardStrategy implements MovementStrategy {
	
	private Probe probe;
	private String commands;
	
	public ForwardStrategy(Probe probe, String commands) {
		this.probe = probe;
		this.commands = commands;
	}

	@Override
	public void move() throws DirectionException, CommandException {
		switch (Command.toCommand(commands)){
			case MOVE -> this.probe = new Probe( probe.getPlanet(),
										    	 probe.getDirection().move(probe.getProbeCoordinates()),
												 probe.getLatestDirection() );
		}
	}
	
}
