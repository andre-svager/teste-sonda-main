package br.com.elo7.sonda.candidato.controlcenter.domain.exceptions;

public class ProbeOutOfRangeException extends RuntimeException {
    @Override
    public String getMessage() {
        return "Probe Out Of Planet Limit !!";
    }
}
