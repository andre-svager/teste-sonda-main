package br.com.elo7.sonda.candidato.domain;

public class ProbeOutOfRangeException extends RuntimeException {
    @Override
    public String getMessage() {
        return "Probe Out Of Planet Limit !!";
    }
}
