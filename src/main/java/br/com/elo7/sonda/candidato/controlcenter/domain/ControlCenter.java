package br.com.elo7.sonda.candidato.controlcenter.domain;

import java.util.ArrayList;
import java.util.List;


public class ControlCenter {
    private Integer id;
    private Planet planet;
    private List<Probe> probes;

    public ControlCenter(Planet planet, List<Probe> probes) {
        this.planet = planet;
        probes = new ArrayList<Probe>();
        this.probes = probes;
    }
}