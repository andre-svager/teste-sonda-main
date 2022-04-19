package br.com.elo7.sonda.candidato.domain.model;

import br.com.elo7.sonda.candidato.domain.ProbeOutOfRangeException;

public class Probe {
	private int id;
	private int x;
	private int y;
	private char direction;
	private Planet planet;
	private String commands;

	public Probe( int x, int y, char direction) {
		this.x = x;
		this.y = y;
		this.direction = direction;
	}

	public Probe(Planet planet, int x, int y, char direction, String commands) {
		this.x = x;
		this.y = y;
		this.direction = direction;
		this.planet = planet;
		this.commands = commands;
	}

	public Probe( Planet planet, int x, int y, char direction) {
		this.x = x;
		this.y = y;
		this.direction = direction;
		this.planet = planet;
	}

	//TODO Refactor to remove this dependency from InMemoryDatabase
	public int getId() { return id; }

	public void setId(int id) {	this.id = id; }

	public char getDirection(){ return this.direction; }

	public int getX() { return this.x; }

	public int getY() {	return this.y; }

	public Planet getPlanet(){
		return this.planet;
	}

	public void moveProbeYAxis() {
		switch (this.direction) {
			case Direction.N: this.y++; break;
			case Direction.S: this.y--; break;
		}
	}

	public void moveProbeXAxis() {
		switch (this.direction) {
			case Direction.E: this.x++; break;
			case Direction.W: this.x--; break;
		}
	}

	public void turnProbeRight() {
		switch (this.direction) {
			case Direction.N: this.direction = Direction.E; break;
			case Direction.E: this.direction = Direction.S; break;
			case Direction.S: this.direction = Direction.W; break;
			case Direction.W: this.direction = Direction.N; break;
		}
	}

	public void turnProbeLeft() {
		switch (this.direction) {
			case Direction.N: this.direction = Direction.W; break;
			case Direction.W: this.direction = Direction.S; break;
			case Direction.S: this.direction = Direction.E; break;
			case Direction.E: this.direction = Direction.N; break;
		}
	}

	public void applyCommandToProbe(char command) {
		switch (command) {
			case Command.R: this.turnProbeRight(); break;
			case Command.L: this.turnProbeLeft();  break;
			case Command.M: this.moveProbeXAxis();
							this.moveProbeYAxis(); break;
		}
	}

	public Probe moveProbeWithAllCommands() throws RuntimeException {
		for (char command : this.commands.toCharArray()) {
			this.applyCommandToProbe(command);
		}
		verifyIfProbeInsideOfPlanet();
		return this;
	}

	public void verifyIfProbeInsideOfPlanet() throws ProbeOutOfRangeException {
		if(this.y >= this.planet.getHeight() || this.x >= this.planet.getWidth() ) {
			throw new ProbeOutOfRangeException();
		}
	}
}
