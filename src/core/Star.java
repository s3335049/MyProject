package core;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.geom.Vector2f;
import org.newdawn.slick.gui.MouseOverArea;
import org.newdawn.slick.state.BasicGameState;
import org.newdawn.slick.state.StateBasedGame;

public class Star extends BasicGameState {
	
	private String starName;
	private MouseOverArea mouseOverArea;
	private Vector2f realX;
	private Vector2f realY;
	private Image starImage;
	
	public Star(String starName, Vector2f x, Vector2f y) {
		this.setStarName(starName);
		this.realX = x;
		this.realY = y;
	}
	
	public String getStarName() {
		return starName;
	}

	public void setStarName(String starName) {
		this.starName = starName;
	}

	public void setMouseOverArea(MouseOverArea mouseOverArea) {
		this.mouseOverArea = mouseOverArea;
	}
	
	public void setMouseOverArea(MouseOverArea mouseOverArea, Vector2f x, Vector2f y) {
		this.mouseOverArea = mouseOverArea;
		this.realX = x;
		this.realY = y;
	}
	
	public MouseOverArea getMouseOverArea() {
		return this.mouseOverArea;
	}
	
	public void init(GameContainer gc, StateBasedGame sbg)
			throws SlickException {
		
	}

	public void render(GameContainer gc, StateBasedGame sbg, Graphics g)
			throws SlickException {
		
	}

	public void update(GameContainer gc, StateBasedGame sbg, int delta)
			throws SlickException {
		
	}

	public int getID() {
		return 0;
	}

}
