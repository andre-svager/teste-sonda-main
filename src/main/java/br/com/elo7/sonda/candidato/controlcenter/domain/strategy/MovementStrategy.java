package br.com.elo7.sonda.candidato.controlcenter.domain.strategy;


import br.com.elo7.sonda.candidato.controlcenter.domain.DirectionException;
import br.com.elo7.sonda.candidato.controlcenter.domain.Probe;

public interface MovementStrategy {
	
	public void move() throws DirectionException;

}
