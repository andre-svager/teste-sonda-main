package br.com.elo7.sonda.candidato.controlcenter.domain.strategy;


import br.com.elo7.sonda.candidato.controlcenter.domain.DirectionException;

public interface MovementStrategy {
	
	public void move() throws DirectionException;

}
