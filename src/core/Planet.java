package core;

import gui.ShipIndicator;

import java.util.ArrayList;

import org.newdawn.slick.Color;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.geom.Vector2f;
import org.newdawn.slick.gui.MouseOverArea;
import org.newdawn.slick.state.BasicGameState;
import org.newdawn.slick.state.StateBasedGame;

import states.GameState;

public class Planet extends BasicGameState{
	
	private String planetName;
	private String systemName;
	private String starOrbiting;
	private Faction planetOwner;
	private int planetSize;
	private int numberOfMoons;
	private int realX, realY;
	private PlanetType planetType;
	private PlanetarySystem parentSystem;
	private ArrayList<Structure> planetStructures = new ArrayList<Structure>();
	private MouseOverArea area;
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

	public void setMouseOverArea(GameContainer gc, Image planetImage, int x, int y) {
		area = new MouseOverArea(gc, planetImage, x, y);
		this.realX = x;
		this.realY = y;
		area.setMouseOverColor(new Color(1,1,1,0.8f));
	}
	
	public MouseOverArea getMouseOverArea() {
		return area;
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

	public void init(GameContainer gc, StateBasedGame sbg)
			throws SlickException {
		ship = new Image("resources/ship.png");
		planetImage = new Image("resources/metallic.png");
		this.setMouseOverArea(gc, planetImage, realX, realY);
		shipIndicator = new ShipIndicator(gc, ship, this.getMouseOverArea().getX() + 35 + GameState.getScreenX(), this.getMouseOverArea().getY() - 30 + GameState.getScreenY());
	}

	public void update(GameContainer gc, StateBasedGame sbg, int delta)
			throws SlickException {
		
	}

	public int getID() {
		return 0;
	}

	public void render(GameContainer gc, StateBasedGame sbg, Graphics g)
			throws SlickException {
		if(hasShips == true) {
			this.shipIndicator.setX(this.getMouseOverArea().getX() + 35 + this.shipIndicator.moveOffsetX());
			this.shipIndicator.setY(this.getMouseOverArea().getY() - 15 + this.shipIndicator.moveOffsetY());
			shipIndicator.render(gc, g);
		}
		this.getMouseOverArea().render(gc, g);
		this.getMouseOverArea().setX(realX + GameState.getScreenX());
		this.getMouseOverArea().setY(realY + GameState.getScreenY());
		g.drawString(this.getPlanetName(), this.getMouseOverArea().getX() + 5, this.getMouseOverArea().getY() + 50);
	}
}
