package br.com.elo7.sonda.candidato.direction.domain;

import br.com.elo7.sonda.candidato.controlcenter.domain.Coordinate;
import br.com.elo7.sonda.candidato.controlcenter.domain.exceptions.CoordinateException;

public interface DirectionState {
	String type();
    Coordinate move(Coordinate coordinates) throws CoordinateException;
    DirectionState left();
    DirectionState right();
}

