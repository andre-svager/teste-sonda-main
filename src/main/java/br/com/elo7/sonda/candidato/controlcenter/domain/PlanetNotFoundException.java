package br.com.elo7.sonda.candidato.controlcenter.domain;

public class PlanetNotFoundException extends RuntimeException{

    @Override
    public String getMessage() {
        return "Planet Not found !!";
    }
}