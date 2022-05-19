package br.com.elo7.sonda.candidato.controlcenter.domain.service;

import br.com.elo7.sonda.candidato.controlcenter.domain.*;

import java.util.List;


public interface ControlCenterService {

	Probe registerAProbeInAPlanet(Integer planetId, int x, int y, char direction, String commands) throws DirectionException, CommandException;

    Planet generateAPlanet(int x, int y);

	List<Probe> findAllProbesInAPlanet(Integer planetId);

	Planet findPlanet(int id);

	public List<Planet> getAllPlanets();

    Probe movementAProbe(int id, String commands) throws CommandException, DirectionException;
}
