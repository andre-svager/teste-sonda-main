package br.com.elo7.sonda.candidato.controlcenter.domain;

import br.com.elo7.sonda.candidato.controlcenter.domain.exceptions.CoordinateException;

/** X and Y axis should be segregated ?? */
public class Coordinate {
    private Axis x;
    private Axis y;

    public Coordinate(Integer x, Integer y) throws CoordinateException {
        this.x = new Axis(x);
        this.y = new Axis(y);
    }

    public Axis x() { return x;}

    public Axis y() { return y; }
}
