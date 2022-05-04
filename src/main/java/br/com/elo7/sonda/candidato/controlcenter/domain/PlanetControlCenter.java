package br.com.elo7.sonda.candidato.controlcenter.domain;

import java.util.List;

public class PlanetControlCenter {
    private Integer id;
    private String planetDescription;
    private Planet planet;
    private List<Probe> probes;

    public PlanetControlCenter(String planetDescription, Planet planet, List<Probe> probes) {
        this.planetDescription = planetDescription;
        this.planet = planet;
        this.probes = probes;
    }
}
