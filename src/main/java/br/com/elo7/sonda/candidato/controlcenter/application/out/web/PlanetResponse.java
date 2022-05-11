package br.com.elo7.sonda.candidato.controlcenter.application.out.web;

import br.com.elo7.sonda.candidato.controlcenter.domain.Planet;
import com.fasterxml.jackson.annotation.JsonProperty;

public class PlanetResponse {

    @JsonProperty
    private String identifier;

    public PlanetResponse(Planet planet) {
        this.identifier = planet.getPlanetIdentifier();
    }
}
