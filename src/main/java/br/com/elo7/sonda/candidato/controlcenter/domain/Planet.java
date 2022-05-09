package br.com.elo7.sonda.candidato.controlcenter.domain;

import br.com.elo7.sonda.candidato.controlcenter.domain.state.DirectionState;

public class Planet {

	private int id;
	private Coordinate extension;
	private DirectionState direction;


	protected Planet() {}

	public Planet(Coordinate coordinates, DirectionState direction) throws DirectionException {
		this.extension = coordinates;
		this.direction = direction;
	}

	public DirectionState changeDirection(DirectionState state){
		return this.direction = state;
	}

	public DirectionState getDirection(){
		return this.direction;
	}
}
