package br.com.elo7.sonda.candidato.controlcenter.application.out.web;

import br.com.elo7.sonda.candidato.controlcenter.domain.Planet;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;
import java.util.stream.Collectors;

public class PlanetResponse {

    @JsonProperty
    private Integer identifier;

    public PlanetResponse(Planet planet) {
        this.identifier = planet.getId();
    }

    public static PlanetResponse convertTo(Planet planet) {
        return new PlanetResponse(planet);
    }

    public static List<PlanetResponse> convertTo(List<Planet> planets) {
        return planets.stream()
                     .map(p -> convertTo(p)).collect(Collectors.toList());
    }
}
