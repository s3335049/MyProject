package core;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;

import org.newdawn.slick.Color;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.geom.Vector2f;
import org.newdawn.slick.state.BasicGameState;
import org.newdawn.slick.state.StateBasedGame;

import states.GameState;

public class PlanetarySystem extends BasicGameState {
	private ArrayList<Planet> planets = new ArrayList<Planet>();
	private String systemName;
	private int numberOfPlanets;
	private Vector2f systemLocation;
	private float vectorX, vectorY;
	private ArrayList<Planet> psList = null;
	private Star systemStar;
	
	public PlanetarySystem(String systemName, int numberOfPlanets, float x, float y) {
		this.systemName = systemName;
		this.numberOfPlanets = numberOfPlanets;
		this.vectorX = x;
		this.vectorY = y;
	}
	
	public void addPlanet(Planet planet) {
		planets.add(planet);
	}
	
	public String getSystemName() {
		return systemName;
	}
	
	public void setPlanets(ArrayList<Planet> planetList) {
		planets = planetList;
	}
	
	public Planet getPlanet(int index) {
		return this.planets.get(index);
	}
	
	public ArrayList<Planet> getPlanets() {
		return this.planets;
	}
	
	public int getNumberOfPlanets() {
		return numberOfPlanets;
	}
	
	public Vector2f getSystemLocation() {
		return systemLocation;
	}

	public void setSystemLocation(Vector2f systemLocation) {
		this.systemLocation = systemLocation;
	}

	public float getVectorX() {
		return vectorX;
	}

	public void setVectorX(float vectorX) {
		this.vectorX = vectorX;
	}

	public float getVectorY() {
		return vectorY;
	}

	public void setVectorY(float vectorY) {
		this.vectorY = vectorY;
	}

	public void generatePlanets() {
		planets.clear();
		for(int i = 0; i < numberOfPlanets; i++) {
			planets.add(new Planet(GameState.getPlanetNames()[i], new Faction("Dominion", "Uninhabited", 0, Color.black), null));
		}
	}

	public void init(GameContainer gc, StateBasedGame sbg)
			throws SlickException {
		
	}

	public void render(GameContainer gc, StateBasedGame sbg, Graphics g)
			throws SlickException {
		if(planets != null) {
			for(Planet p: planets) {
				p.render(gc, sbg, g);
			}
		}
	}

	public void update(GameContainer gc, StateBasedGame sbg, int delta)
			throws SlickException {
		
	}

	public int getID() {
		return 0;
	}
	
	public String toString() {
		if(planets != null) {
			for(Planet p: planets) {
				return p.getPlanetName();
			}
		}
		return "No planets";
	}
}
