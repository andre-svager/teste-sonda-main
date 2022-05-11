package br.com.elo7.sonda.candidato.controlcenter.domain;

public class CoordinateException extends RuntimeException {

    public CoordinateException(String s) {
        super(s);
    }

    public CoordinateException() {
        super("Coordinate Out Of Range");
    }
}
