package br.com.elo7.sonda.candidato.controlcenter.domain;

public class Axis {
    private Integer value;

    public static Integer ZERO = 0;

    public Axis(Integer value) throws CoordinateException {
        if(! isPositive(value) ){  throw new CoordinateException("axis: "+ value); }
        this.value = value;
    }

    public Axis() { this.value = 0; }

    public int increase() { return ++ this.value;}

    public Integer value() { return value; }

    public int decrease() {return --this.value;}

    public boolean isBiggerThan(Integer value) { return this.value > value; }

    public boolean isLessThan(Integer x) { return this.value < value; }

    public boolean isPositive(Integer value) { return value != null && value >= 0; }
}
