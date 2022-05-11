package br.com.elo7.sonda.candidato.controlcenter.application.out.web;

import br.com.elo7.sonda.candidato.controlcenter.domain.Planet;
import com.fasterxml.jackson.annotation.JsonProperty;

public class PlanetResponse {

    @JsonProperty
    private Integer identifier;

    public PlanetResponse(Planet planet) {
        this.identifier = planet.getPlanetIdentifier();
    }

    public static PlanetResponse convertTo(Planet planet) {
        return new PlanetResponse(planet);
    }
}
