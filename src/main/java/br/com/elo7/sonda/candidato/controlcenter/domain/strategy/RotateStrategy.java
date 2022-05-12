package br.com.elo7.sonda.candidato.controlcenter.domain.strategy;

import br.com.elo7.sonda.candidato.controlcenter.domain.Command;
import br.com.elo7.sonda.candidato.controlcenter.domain.DirectionException;
import br.com.elo7.sonda.candidato.controlcenter.domain.Probe;
import br.com.elo7.sonda.candidato.controlcenter.domain.Probe;

public class RotateStrategy implements MovementStrategy {
	
	private Probe probe;
	private String command;
	
	public RotateStrategy(Probe probe, String command) {
		super();
		this.probe = probe;
		this.command = command;
	}
	
	@Override
	public void move() throws DirectionException {
		switch (Command.valueOf(command)){
			case RIGHT -> probe.changeDirection(probe.getDirection().right());
		    case LEFT ->  probe.changeDirection(probe.getDirection().left());
		}
	}
}
