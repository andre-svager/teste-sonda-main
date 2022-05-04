package br.com.elo7.sonda.candidato.direction.domain;

import br.com.elo7.sonda.candidato.controlcenter.domain.exceptions.DirectionException;

import java.util.stream.Stream;

public enum Direction {
	NORTH("N"), SOUTH("S"), WEST("W"), EAST("E");

	private String acronym;

	private Direction(String acronym) {
		this.acronym = acronym;
	}

	public String getValue(){ return this.acronym; }

	public static Direction toDirection(String acronym) throws DirectionException {
		return Stream.of(values())
					 .filter(d -> d.acronym.equals(acronym))
					 .findFirst().orElseThrow(() -> new DirectionException(acronym));
	}
}
