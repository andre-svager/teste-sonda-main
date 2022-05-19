package br.com.elo7.sonda.candidato.controlcenter.domain;

public class PlanetException extends RuntimeException{

    private MessageType type;

    @Override
    public String getMessage() {
        return type.name();
    }

    public PlanetException(MessageType messageType){
        this.type = messageType;
    }
}
