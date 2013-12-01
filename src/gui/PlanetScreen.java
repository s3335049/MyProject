package gui;

import org.lwjgl.input.Mouse;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.BasicGameState;
import org.newdawn.slick.state.StateBasedGame;

import core.Planet;

public class PlanetScreen extends BasicGameState{
	
	private Planet planet;
	private int screenX, screenY;
	private Image screenImage;
	private Image exit;
	private Image planetImage;
	private Button exitButton, buildShip, buildings;
	private String planetName, owner;
	private int population;
	
	public PlanetScreen(int screenX, int screenY) throws SlickException {
		this.screenX = screenX;
		this.screenY = screenY;
		this.initScreenImages();
	}


	public void init(GameContainer gc, StateBasedGame sbg)
			throws SlickException {
		
	}


	public void render(GameContainer gc, StateBasedGame sbg, Graphics g)
			throws SlickException {
		screenImage.draw(screenX, screenY);
		exit.draw(screenX + 605, screenY + 15);
		planetImage.draw(screenX + 20, screenY + 20);
		g.drawString(planetName, screenX + 20, screenY + 65);
	}


	public void update(GameContainer gc, StateBasedGame sbg, int delta)
			throws SlickException {
		if(exit.getGraphics().getClip().contains(Mouse.getX(), Math.abs(Mouse.getY() - 900))) {
			exit.setAlpha(0.4f);
		}
		else {
			if(exit.getAlpha() == 0.4f) {
				exit.setAlpha(1.0f);
			}
		}
	}

	public void initScreenImages() throws SlickException {
		screenImage = new Image("resources/planetScreen.png", false, 2); //640 x 480
		planetImage = new Image("resources/metallic.png"); //50 x 50
		exit = new Image("resources/exitButtonX20px-20px.png");
		exit.getGraphics().setClip(screenX + 605, screenY + 15, 20, 20);
	}
	
	public void setPlanetName(String planetName) {
		this.planetName = planetName;
	}
	
	public void setPopulation(int population) {
		this.population = population;
	}
	
	public void setOwner(String owner) {
		this.owner = owner;
	}
	
	public void setPlanetType() {
		
	}
	public int getID() {
		return 0;
	}
}
