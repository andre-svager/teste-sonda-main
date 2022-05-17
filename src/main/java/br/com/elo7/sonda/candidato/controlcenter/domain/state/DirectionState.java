package br.com.elo7.sonda.candidato.controlcenter.domain.state;

import br.com.elo7.sonda.candidato.controlcenter.domain.Coordinate;
import br.com.elo7.sonda.candidato.controlcenter.domain.CoordinateException;
import br.com.elo7.sonda.candidato.controlcenter.domain.Direction;

public interface DirectionState {
	Direction type();
    Coordinate move(Coordinate coordinates) throws CoordinateException;
    DirectionState left();
    DirectionState right();
}

