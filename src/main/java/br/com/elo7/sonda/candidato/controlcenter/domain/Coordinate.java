package br.com.elo7.sonda.candidato.controlcenter.domain;

import java.util.Objects;

public class Coordinate {
    private Axis x;
    private Axis y;

    //Utilized to SpringData
    private Coordinate(){}

    public Coordinate(Integer x, Integer y) throws CoordinateException {
        this.x = new Axis(x);
        this.y = new Axis(y);
    }

    public Axis x() { return x;}

    public Axis y() { return y; }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Coordinate that = (Coordinate) o;
        return x.equals(that.x) && y.equals(that.y);
    }

    @Override
    public int hashCode() {
        return Objects.hash(x, y);
    }
}
