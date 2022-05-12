package br.com.elo7.sonda.candidato.controlcenter.domain.service;

import br.com.elo7.sonda.candidato.controlcenter.domain.*;

import java.util.List;


public interface ControlCenterService {

    public Planet generateAPlanet(Coordinate toCoordinates);

	List<Probe> registerAProbeInAPlanet(Integer planetId, int x, int y, char direction, String commands) throws DirectionException, CommandException;

	Planet findPlanet(int id);
}
