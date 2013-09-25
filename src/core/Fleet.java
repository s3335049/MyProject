package core;

import java.util.ArrayList;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.BasicGameState;
import org.newdawn.slick.state.StateBasedGame;

import view.ShipIndicator;

public class Fleet extends BasicGameState {

	private String fleetName;
	private ArrayList<FleetElement> shipList;
	private Planet location;
	private Planet destination = null;
	private ShipIndicator shipIndicator;
	private Image shipImage;
	
	public Fleet(String fleetName, ArrayList<FleetElement> shipList, Planet location) {
		this.fleetName = fleetName;
		this.shipList = shipList;
	}
	
	public Planet getDestination() {
		return this.destination;
	}
	
	public void setDestination(Planet destination) {
		this.destination = destination;
	}
	
	public Planet getLocation() {
		return this.location;
	}
	
	public void setLocation(Planet location) {
		this.location = location;
	}
	
	public ShipIndicator getShipIndicator() {
		return this.shipIndicator;
	}
	
	public void init(GameContainer gc, StateBasedGame sbg)
			throws SlickException {
		shipImage = new Image("resources/ship.png");
		shipIndicator = new ShipIndicator(gc, shipImage, location.getMouseOverArea().getX(), location.getMouseOverArea().getY());
	}

	public void render(GameContainer gc, StateBasedGame sbg, Graphics g)
			throws SlickException {
		shipIndicator.render(gc, g);
	}

	public void update(GameContainer gc, StateBasedGame sbg, int delta)
			throws SlickException {
		
	}

	public int getID() {
		return 0;
	}
}
