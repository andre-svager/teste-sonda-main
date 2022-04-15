package br.com.elo7.sonda.candidato.domain.model;

public class Probe {
	private int id;
	private int x;
	private int y;
	private char direction;
	private Planet planet;

	public Probe( Planet planet, int x, int y, char direction) {
		this.x = x;
		this.y = y;
		this.direction = direction;
		this.planet = planet;
	}

	public Probe(){}

	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getX() {
		return x;
	}
	public void setX(int x) {
		this.x = x;
	}
	public int getY() {
		return y;
	}
	public void setY(int y) {
		this.y = y;
	}
	public char getDirection() {
		return direction;
	}
	public void setDirection(char direction) {
		this.direction = direction;
	}
	public Planet getPlanet() {
		return planet;
	}
	public void setPlanet(Planet planet) {
		this.planet = planet;
	}

	public void moveProbeForward(Probe probe) {
		int newX = probe.getX();
		int newY = probe.getY();
		switch (probe.getDirection()) {
			case Direction.N:
				newY++;
				break;
			case Direction.W:
				newX--;
				break;
			case Direction.S:
				newY--;
				break;
			case Direction.E:
				newX++;
				break;
		}
		probe.setX(newX);
		probe.setY(newY);
	}

	public void turnProbeLeft(Probe probe) {
		char newDirection = Direction.N;
		switch (probe.getDirection()) {
			case Direction.N:
				newDirection = Direction.W;
				break;
			case Direction.W:
				newDirection = Direction.S;
				break;
			case Direction.S:
				newDirection = Direction.E;
				break;
			case Direction.E:
				newDirection = Direction.N;
				break;
		}
		probe.setDirection(newDirection);
	}

	public void turnProbeRight(Probe probe) {
		char newDirection = Direction.N;
		switch (probe.getDirection()) {
			case Direction.N:
				newDirection = Direction.E;
				break;
			case Direction.E:
				newDirection = Direction.S;
				break;
			case Direction.S:
				newDirection = Direction.W;
				break;
			case Direction.W:
				newDirection = Direction.N;
				break;
		}
		System.out.println(newDirection);
		probe.setDirection(newDirection);
	}

}
