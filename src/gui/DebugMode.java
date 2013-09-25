package gui;

import org.lwjgl.input.Mouse;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Input;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.BasicGameState;
import org.newdawn.slick.state.StateBasedGame;

import states.GameState;

public class DebugMode extends BasicGameState{

	private int tickCount;
	private String tick;
	private double j = 0;

	private boolean debug;
	private String mouse;
	
	public void init(GameContainer gc, StateBasedGame sbg)
			throws SlickException {
		
	}

	public void render(GameContainer gc, StateBasedGame sbg, Graphics g)
			throws SlickException {
		
		if(debug == true) {
			g.drawString(mouse, 150, 10);
			g.drawString(tick, 150, 25);
			gc.setShowFPS(true);
		}
	}

	public void update(GameContainer gc, StateBasedGame sbg, int d, boolean enabled)
			throws SlickException {
		tick = "Tick: " + tickCount;
		j = j + 0.01;
		if(j >= 600) {
			tickCount++;
			System.out.print(tickCount);
			j = 0;
		}
		int posX = Mouse.getX();
		int posY = Mouse.getY();	
		
		mouse = "Mouse coords:" + posX + " , " + posY + " " + GameState.getScreenX() + " " + GameState.getScreenY();
	}

	public int getID() {
		return 0;
	}

	public void update(GameContainer arg0, StateBasedGame arg1, int arg2)
			throws SlickException {
		
	}
	
	public void setDebug(boolean debug) {
		this.debug = debug;
	}
	
	public boolean getDebug() {
		return this.debug;
	}
	
	public int getScreenX() {
		return states.GameState.getScreenX();
	}
	
	public int getScreenY() {
		return states.GameState.getScreenY();
	}

}
