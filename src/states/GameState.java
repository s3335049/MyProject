package states;
import java.awt.Font;
import gui.DebugMode;
import org.lwjgl.input.Mouse;
import org.newdawn.slick.Color;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.Input;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.TrueTypeFont;
import org.newdawn.slick.gui.TextField;
import org.newdawn.slick.state.BasicGameState;
import org.newdawn.slick.state.StateBasedGame;
import core.Galaxy;

public class GameState extends BasicGameState{
	public final int SCREEN_MAX_X = 1600;
	public final int SCREEN_MAX_Y = 900;
	private int yBias, yBias2;
	private static String[] planetNames;
	private TextField textField;
	private int stateID = 1;
	private static int screenX;
	private static int screenY;
	DebugMode debugMode;
	private boolean enabled = true;
	private Image creditsGUI;
	private Galaxy galaxy;
	private Image planet, planet2;
	private Color color;
	private TrueTypeFont font;
	private boolean antiAlias = true;
	GameState(int stateID) {
		this.stateID = stateID;
	}

	public void init(GameContainer gc, StateBasedGame sbg)
			throws SlickException {
		Font awtFont = new Font("Times New Roman", Font.BOLD, 24);
		font = new TrueTypeFont(awtFont, antiAlias);
		planet = new Image("resources/metallic.png");
		planet2 = new Image("resources/metallic.png");
		creditsGUI = new Image("resources/credits-gui.png");
		debugMode = new DebugMode();
		galaxy = new Galaxy("Milky Way", 1, 1);
		galaxy.init(gc, sbg);
		planet.getGraphics().setClip(700, 700, 50, 50);
		yBias = 1400 - SCREEN_MAX_Y + 50;
		yBias2 = 1080 - SCREEN_MAX_Y + 50;
		planet2.getGraphics().setClip(1100, 540, 50, 50);
	}

	public void render(GameContainer gc, StateBasedGame sbg, Graphics g)
			throws SlickException {
		font.drawString(700, 700, "TESTING NIGGER", Color.green);
		planet.draw(700 + screenX, 700 + screenY);
		planet2.draw(1100 + screenX, 540 + screenY);
		if(planet.getGraphics().getClip().contains(Mouse.getX() - screenX, Math.abs(Mouse.getY() - SCREEN_MAX_Y) - screenY) && gc.getGraphics().getPixel(Mouse.getX(), Mouse.getY() + yBias).getAlpha() > 0) {
			planet.setAlpha(0.4f);
		}
		else {
			planet.setAlpha(1.0f);
		}
		if(planet2.getGraphics().getClip().contains(Mouse.getX() - screenX, Math.abs(Mouse.getY() - SCREEN_MAX_Y) - screenY) && gc.getGraphics().getPixel(Mouse.getX(), Mouse.getY() + yBias2).getAlpha() > 0) {
			planet2.setAlpha(0.4f);
		}
		else {
			planet2.setAlpha(1.0f);
		}
		debugMode.render(gc, sbg, g);
		creditsGUI.draw(1200, 5);
		galaxy.render(gc, sbg, g);
		color = gc.getGraphics().getPixel(Mouse.getX(), Math.abs(Mouse.getY() - SCREEN_MAX_Y));
		g.drawString(color + "", 300, 300);
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
		galaxy.update(gc, sbg, delta);
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
