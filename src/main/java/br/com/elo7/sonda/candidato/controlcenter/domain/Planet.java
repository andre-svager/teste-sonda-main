package br.com.elo7.sonda.candidato.controlcenter.domain;

import java.util.Objects;

public class Planet {
	private Integer id;
	private int width;
	private int height;
	private String name;

	public Planet(int height, int width, String name) {
		this.height = height;
		this.width = width;
		this.name = name;
	}

	public Planet(){}

	public Integer getId() {
		return id;
	}

	//Sorry for that !! TODO Implement Sequence in MongoDb
	public Integer nextSequence(){
		return hashCode();
	}

	public void setPlanetId(Integer id){
		this.id = id;
	}

	//Need in: probe.verifyIfProbeInsideOfPlanet
	public int getHeight() {
		return this.height;
	}
	public int getWidth() { return this.width; }
	public String getName() { return this.name; }

	@Override
	public int hashCode() {
		return Objects.hash(id, width, height, name);
	}

	@Override
	public boolean equals(Object obj) {
		if (obj instanceof Planet) {
			return ((Planet) obj).id == this.id;
		}
		return false;
	}
}
