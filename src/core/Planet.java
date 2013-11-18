package core;

import gui.ShipIndicator;

import java.util.ArrayList;

import org.lwjgl.input.Mouse;
import org.newdawn.slick.Color;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.geom.Vector2f;
import org.newdawn.slick.state.BasicGameState;
import org.newdawn.slick.state.StateBasedGame;

import states.GameState;
import gui.PlanetScreen;

public class Planet extends BasicGameState {
	private PlanetScreen planetScreen;
	private boolean isPlanetScreenActive = false;
	
	private String planetName;
	private String systemName;
	private String starOrbiting;
	private Faction planetOwner;
	private PlanetType planetType;
	private int planetSize;
	private int numberOfMoons;
	private int population;
	private ArrayList<Structure> planetStructures = new ArrayList<Structure>();
	
	private int realX, realY;

	private PlanetarySystem parentSystem;

	private boolean hasShips = false;
	private Vector2f planetLocation;
	String test = "";
	
	private Image ship;
	private ShipIndicator shipIndicator;
	
	private Image planetImage;


	public Planet(String planetName, Faction planetOwner, PlanetType planetType) {
		this.planetName = planetName;
		this.planetOwner = planetOwner;
		this.planetType = planetType;
	}
	
	public String getPlanetName() {
		return this.planetName;
	}
	
	public Faction getPlanetOwner() {
		return this.planetOwner;
	}
	
	public void setPlanetOwner(Faction planetOwner) {
		this.planetOwner = planetOwner;
	}
	
	public int getPlanetSize() {
		return planetSize;
	}	
	
	public void setPlanetSize(int PlanetSize) {
		planetSize = PlanetSize;
	}
	
	public int getNumberOfMoons() {
		return numberOfMoons;
	}
	
	public void setNumberOfMoons(int number) {
		numberOfMoons = number;
	}
	
	public String getSystemName() {
		return systemName;
	}
	
	public void setSystemName(String name) {
		systemName = name;
	}
	
	public PlanetType getPlanetType() {
		return planetType;
	}
	
	public void setPlanetImage(Image image) throws SlickException {
		planetImage = image;
	}
	
	public Image getPlanetImage() {
		return planetImage;
	}
	
	public void buildStructure(Structure structure) {
		planetStructures.add(structure);
	}
	
	public void setStructures(ArrayList<Structure> structures) {
		planetStructures.clear();
		this.planetStructures = structures;
		
	}
	
	public String getStarOrbiting() {
		return starOrbiting;
	}

	public void setStarOrbiting(String starOrbiting) {
		this.starOrbiting = starOrbiting;
	}

	public boolean hasShips() {
		return hasShips;
	}

	public void setHasShips(boolean hasShips) {
		this.hasShips = hasShips;
	}

	public ShipIndicator getShipIndicator() {
		return shipIndicator;
	}

	public void setShipIndicator(ShipIndicator shipIndicator) {
		this.shipIndicator = shipIndicator;
	}

	public Vector2f getPlanetLocation() {
		return planetLocation;
	}

	public void setPlanetLocation(Vector2f planetLocation) {
		this.planetLocation = planetLocation;
	}

	public PlanetarySystem getParentSystem() {
		return parentSystem;
	}

	public void setParentSystem(PlanetarySystem parentSystem) {
		this.parentSystem = parentSystem;
	}
	
	public void setRealX(int x) {
		this.realX = x;
	}
	
	public void setRealY(int y) {
		this.realY = y;
	}

	public String toString() {
		return this.planetName + " " + this.planetOwner + " " + this.planetType;
		
	}
	
	public boolean isPlanetScreenActive() {
		return isPlanetScreenActive ;
	}

	public void init(GameContainer gc, StateBasedGame sbg)
			throws SlickException {
		ship = new Image("resources/ship.png");
		planetImage = new Image("resources/metallic.png");
		planetImage.getGraphics().setClip(realX, realX, 50, 50);
	}

	public void update(GameContainer gc, StateBasedGame sbg, int delta)
			throws SlickException {
		if(planetImage.getGraphics().getClip().contains(Mouse.getX() - GameState.getScreenX(), Math.abs(Mouse.getY() - 900) - GameState.getScreenY()) && gc.getGraphics().getPixel(Mouse.getX(), Math.abs(Mouse.getY() - 900)).getAlpha() > 0) {
			planetImage.setAlpha(0.4f);
		}
		else {
			planetImage.setAlpha(1.0f);
		}
		if(planetImage.getGraphics().getClip().contains(Mouse.getX() - GameState.getScreenX(), Math.abs(Mouse.getY() - 900) - GameState.getScreenY()) && gc.getGraphics().getPixel(Mouse.getX(), Math.abs(Mouse.getY() - 900)).getAlpha() > 0 && Mouse.isButtonDown(0) && isPlanetScreenActive == false) {
			System.out.print("LOL");
			isPlanetScreenActive = true;
			planetScreen = new PlanetScreen(800, 300);
		}
		if(isPlanetScreenActive == true) {
			planetScreen.update(gc, sbg, delta);
		}

	}

	public int getID() {
		return 0;
	}

	public void render(GameContainer gc, StateBasedGame sbg, Graphics g)
			throws SlickException {
		if(this.isPlanetScreenActive == true) {
			planetScreen.setPlanetName(this.planetName);
			planetScreen.render(gc, sbg, g);
		}
		if(hasShips == true) {
			//this.shipIndicator.setX(this.getMouseOverArea().getX() + 35 + this.shipIndicator.moveOffsetX());
			//this.shipIndicator.setY(this.getMouseOverArea().getY() - 15 + this.shipIndicator.moveOffsetY());
			shipIndicator.render(gc, g);
		}
		this.planetImage.draw(realX + GameState.getScreenX(), realY + GameState.getScreenY());
		g.drawString(this.getPlanetName(), this.realX + 5 + GameState.getScreenX(), this.realY + 50 + GameState.getScreenY());
	}
}
