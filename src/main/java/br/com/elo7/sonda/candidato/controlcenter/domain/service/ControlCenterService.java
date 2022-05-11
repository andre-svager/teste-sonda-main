package br.com.elo7.sonda.candidato.controlcenter.domain.service;

import br.com.elo7.sonda.candidato.controlcenter.domain.Coordinate;
import br.com.elo7.sonda.candidato.controlcenter.domain.Planet;
import br.com.elo7.sonda.candidato.controlcenter.domain.Probe;

import java.util.List;


public interface ControlCenterService {

    public Planet generateAPlanet(Coordinate toCoordinates);

	List<Probe> registerAProbeInAPlanet(Integer planetId, int x, int y, char direction, String commands);

	Planet findPlanet(int id);
}
