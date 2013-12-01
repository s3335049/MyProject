package gui;

import org.newdawn.slick.Color;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.Sound;
import org.newdawn.slick.geom.Rectangle;
import org.newdawn.slick.geom.Shape;
import org.newdawn.slick.gui.GUIContext;
import org.newdawn.slick.gui.MouseOverArea;
import org.newdawn.slick.state.BasicGameState;
import org.newdawn.slick.state.StateBasedGame;

public class Button extends BasicGameState {
	private Image buttonImage;
	private int posX, posY;
	
	public Button(int posX, int posY) {
		this.posX = posX;
		this.posY = posY;
	}

	public void init(GameContainer gc, StateBasedGame sbg)
			throws SlickException {
		buttonImage = new Image("resources/exitButtonX20px-20px.png");
		buttonImage.getGraphics().setClip(posX, posY, 20, 20);
	}


	public void render(GameContainer gc, StateBasedGame sbg, Graphics g)
			throws SlickException {
		buttonImage.draw(posX, posY);
	}


	public void update(GameContainer gc, StateBasedGame sbg, int delta)
			throws SlickException {
		
	}
	public Rectangle getClip() throws SlickException {
		return buttonImage.getGraphics().getClip();
	}

	public int getID() {
		return 0;
	}

}
