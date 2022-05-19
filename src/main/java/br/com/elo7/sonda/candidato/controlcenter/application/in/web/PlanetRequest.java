package br.com.elo7.sonda.candidato.controlcenter.application.in.web;

import br.com.elo7.sonda.candidato.controlcenter.domain.Coordinate;
import br.com.elo7.sonda.candidato.controlcenter.domain.CoordinateException;
import com.fasterxml.jackson.annotation.JsonProperty;

public class PlanetRequest {
    @JsonProperty
    private int x;
    @JsonProperty
    private int y;

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }
}
