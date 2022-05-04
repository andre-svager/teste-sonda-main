package br.com.elo7.sonda.candidato.controlcenter.domain.exceptions;

public class ProbeCollisionException extends RuntimeException{
    @Override
    public String getMessage() {
        return "There is a Probe in same Position. Move it !!";
    }
}
