package br.com.elo7.sonda.candidato.controlcenter.domain.exceptions;

public class DirectionException extends Throwable {
    public DirectionException() {
    }

    public DirectionException(String acronym) {
        super("WRONG_DIRECTION".concat(acronym));
    }
}
