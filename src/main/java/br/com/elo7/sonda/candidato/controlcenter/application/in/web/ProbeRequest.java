package br.com.elo7.sonda.candidato.controlcenter.application.in.web;

import br.com.elo7.sonda.candidato.controlcenter.domain.*;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;
import java.util.stream.Collectors;

public class ProbeRequest {
	@JsonProperty
	private int x;
	@JsonProperty
	private int y;
	@JsonProperty
	private Direction direction;
	@JsonProperty
	private List<Command> commands;
	@JsonProperty(required = true)
	private Integer planetId;

	public ProbeRequest(){}

	public ProbeRequest(int x, int y, Direction direction) {
		this.x = x;
		this.y = y;
		this.direction = direction;
	}

	public int getX() { return x;}

	public int getY() { return y;}

	public Direction getDirection() { return direction;}

	public List<Command> getCommands() {return commands;}

	public Integer getPlanetId() {return planetId;}

	/**
	 * @return
	 * @throws DirectionException
	 * This is not a better locale to create a Probe. So I sent attributes in a method body
	 * Or maybe in a future create a Map to do it.
	 */
/**public Probe convertTo(String planetId, int x, int y, char direction, String commands) throws DirectionException {
		return new Probe( new Coordinate(x, y), String.valueOf(this.direction), this.commands);
	}*/
	public List<Command> getProbeCommands(){
		return this.commands;
	}

	public static List<ProbeRequest> convertTo(List<Probe> probes) {
		return probes.stream()
					 .map(p -> new ProbeRequest( p.getProbeCoordinates().x().value(),
												 p.getProbeCoordinates().y().value(),
												 Direction.valueOf(p.getLatestDirection()))).collect(Collectors.toList());
	}

    public Planet concertPlanet() {
		return new Planet( new Coordinate(x,y));
    }
}
