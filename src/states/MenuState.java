package states;

import java.util.ArrayList;
import java.util.Iterator;

import org.lwjgl.input.Mouse;
import org.newdawn.slick.Color;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.Input;
import org.newdawn.slick.MouseListener;
import org.newdawn.slick.Music;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.Sound;
import org.newdawn.slick.gui.ComponentListener;
import org.newdawn.slick.gui.MouseOverArea;
import org.newdawn.slick.state.BasicGameState;
import org.newdawn.slick.state.StateBasedGame;
import org.newdawn.slick.state.transition.FadeInTransition;
import org.newdawn.slick.state.transition.FadeOutTransition;

import core.Planet;
import core.PlanetarySystem;

public class MenuState extends BasicGameState implements MouseListener {
	
	int stateID = 0;
	
	boolean debug = false;
	Image background = null;
	Image playIMG = null;
	Image settingsIMG = null;
	
	private double j = 0;
	private int tickCount = 0;
	private String tick = "Tick: 0";
	
	private Sound menuSound;
	
	private MouseOverArea playButton;
	private MouseOverArea settingsButton;
	private MouseOverArea exitButton;

	String mouse = "No input yet";
	ComponentListener areaListener;
	
	MenuState(int stateID) {

	}
	
	public void init(GameContainer gc, StateBasedGame sbg)
			throws SlickException {
		
	background = new Image("resources/newBG.png");
	playIMG = new Image("resources/startButton.png");
	settingsIMG = new Image("resources/settingsButton.png");
	
	menuSound = new Sound("resources/button-15.wav");
	//mainMusic.loop();
	
	playButton = new MouseOverArea(gc, playIMG, 70, 200);
	playButton.setMouseOverColor(new Color(1, 1, 1, 0.4f));
	
	settingsButton = new MouseOverArea(gc, settingsIMG, 70, 250);
	settingsButton.setMouseOverColor(new Color(1, 1, 1, 0.4f));	
}

	public void render(GameContainer gc, StateBasedGame sbg, Graphics g)
			throws SlickException {
		//background.draw(0,0);
		playButton.render(gc, g);
		settingsButton.render(gc, g);
		
		/*if(debug == true) {
			g.drawString(mouse, 150, 10);
			g.drawString(tick, 150, 25);
		}
		else {
			
		}*/
	}

	public void update(GameContainer gc, StateBasedGame sbg, int delta)
			throws SlickException {
		
		/*j = j + 0.01;
		if(j >= 600) {
			tickCount++;
			tick = "Tick: " + tickCount;
			System.out.print(tickCount);
			j = 0;
		}
		*/
		Input input = gc.getInput();
		/*int posX = Mouse.getX();
		int posY = Mouse.getY();	

		if(debug == false && input.isKeyPressed(Input.KEY_F3)) {
			debug = true;
		}
		
		if(debug == true && input.isKeyPressed(Input.KEY_F3)) {
			debug = false;
		}
		*/
		if(playButton.isMouseOver() == true && input.isMouseButtonDown(0) == true) {
			sbg.enterState(1, new FadeOutTransition(Color.black), new FadeInTransition(Color.black));
		}
		//mouse = "Mouse coords:" + posX + " , " + posY;
	}

	public int getID() {
		return this.stateID;
	}
	
	public int getTickCount() {
		return tickCount;
	}
}
