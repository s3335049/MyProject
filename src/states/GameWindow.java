package states;

import org.newdawn.slick.AppGameContainer;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.*;

public class GameWindow extends StateBasedGame{
	public static final int MENUSTATE = 0;
    public static final int GAMESTATE = 1;
    public static final int MENUSETTINGS = 2;
    //public static final int GAMEMENUSTATE = 2;
	
	public GameWindow(String gamename) {
		super(gamename);
		this.addState(new MenuState(MENUSTATE));
		this.addState(new GameState(GAMESTATE));
		this.addState(new GameState(MENUSETTINGS));
		//this.addState(new GameMenuState(GAMEMENUSTATE));
	}
	
	public void initStatesList(GameContainer gc) throws SlickException {
		this.getState(MENUSTATE).init(gc, this);
		this.getState(GAMESTATE).init(gc, this);
		this.getState(MENUSETTINGS).init(gc, this);
		//this.getState(GAMEMENUSTATE).init(gc, this);
		this.enterState(MENUSTATE);
		gc.setShowFPS(false);
	}
	
	public static void main(String[] args) {
		AppGameContainer appgc;
        try
        {
            appgc = new AppGameContainer(new GameWindow("War Space"));
            appgc.setDisplayMode(1600, 900, false);
            appgc.start();
        } catch (Exception e)
        {
           e.printStackTrace();
           System.exit(0);
        }
	}
}
