package br.com.elo7.sonda.candidato.controlcenter.domain;

import br.com.elo7.sonda.candidato.controlcenter.domain.factory.DirectionFactory;
import br.com.elo7.sonda.candidato.controlcenter.domain.state.DirectionState;
import java.util.UUID;

public class Probe {
	private UUID id;
	private Coordinate coordinate;
	private DirectionState direction;

	public Probe(Coordinate coordinates, String state) throws DirectionException {
		this.coordinate = coordinates;
		this.direction = DirectionFactory.direction(state);
	}

	public DirectionState changeDirection(DirectionState state){
		return this.direction = state;
	}

	public DirectionState getDirection(){
		return this.direction;
	}
}
