package br.com.elo7.sonda.candidato.controlcenter.application.in.web;

import br.com.elo7.sonda.candidato.controlcenter.domain.Coordinate;
import br.com.elo7.sonda.candidato.controlcenter.domain.exceptions.CoordinateException;
import com.fasterxml.jackson.annotation.JsonProperty;

public class PlanetRequest {
    @JsonProperty
    private int id;
    @JsonProperty
    private int x;
    @JsonProperty
    private int y;

    public Coordinate toCoordinates() throws CoordinateException {
        return new Coordinate(x, y);
    }
}
