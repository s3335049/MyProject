package states;

import gui.DebugMode;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.Input;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.BasicGameState;
import org.newdawn.slick.state.StateBasedGame;

import core.Galaxy;

public class GameState extends BasicGameState{
	
	private static String[] planetNames;
	
	private int stateID = 1;
	private static int screenX;
	private static int screenY;
	DebugMode debugMode;
	private boolean enabled = true;
	private Image creditsGUI;
	private Galaxy galaxy;
	
	GameState(int stateID) {
		this.stateID = stateID;
	}
	
	public void init(GameContainer gc, StateBasedGame sbg)
			throws SlickException {
		creditsGUI = new Image("resources/credits-gui.png");
		debugMode = new DebugMode();
		galaxy = new Galaxy("Milky Way", 1, 1);
		galaxy.init(gc, sbg);
	}

	public void render(GameContainer gc, StateBasedGame sbg, Graphics g)
			throws SlickException {
		debugMode.render(gc, sbg, g);
		creditsGUI.draw(1200, 5);
		galaxy.render(gc, sbg, g);
	}

	public void update(GameContainer gc, StateBasedGame sbg, int delta)
			throws SlickException {
		Input input = gc.getInput();
		
		if(input.isKeyDown(Input.KEY_W)) {
			screenY++;
		}
		
		if(input.isKeyDown(Input.KEY_S)) {
			screenY--;
		}
		
		if(input.isKeyDown(Input.KEY_D)) {
			screenX--;
		}
		
		if(input.isKeyDown(Input.KEY_A)) {
			screenX++;
		}
		
		if(debugMode.getDebug() == false && input.isKeyPressed(Input.KEY_F3)) {
			debugMode.setDebug(true);
		}
		
		if(debugMode.getDebug() == true && input.isKeyPressed(Input.KEY_F3)) {
			debugMode.setDebug(false);
			gc.setShowFPS(false);
		}
		
		debugMode.update(gc, sbg, delta, this.enabled);
	}

	public int getID() {
		return this.stateID;
	}
	
	public static int getScreenX() {
		return screenX;
	}
	
	public static int getScreenY() {
		return screenY;
	}
	
	public void setDebug(boolean debug) {
		enabled = debug;
	}
	
	public static String[] getPlanetNames() {
		return planetNames;
	}
}
