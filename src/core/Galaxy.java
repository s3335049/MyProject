package core;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

import org.newdawn.slick.Color;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.geom.Vector2f;
import org.newdawn.slick.state.BasicGameState;
import org.newdawn.slick.state.StateBasedGame;

import states.GameWindow;

public class Galaxy extends BasicGameState {
	
	private int numberOfRaces;
	private ArrayList<Planet> planetList;
	private ArrayList<PlanetarySystem> planetarySystemsList;
	private int numberOfPlanetarySystems;
	private String[] planetNames = new String[10000];
	private Image pImage;
	
	public Galaxy(String galaxyName, int numberOfRaces, int numberOfPlanetarySystems) {
		this.numberOfPlanetarySystems = numberOfPlanetarySystems;
		this.numberOfRaces = numberOfRaces;
	}
	
	public ArrayList<Planet> getAllPlanets() {
		return this.planetList;
	}
	
	public void generatePlanetarySystems(GameContainer gc, StateBasedGame sbg) {
		for(int i = 0; i < this.numberOfPlanetarySystems; i++) {
			//int random = MiscLib.newRandom(16);
			this.planetarySystemsList.add(new PlanetarySystem("System", 10, 0, 0));
			for(int j = 0; j < 9; j++) {
				planetarySystemsList.get(i).addPlanet(new Planet(planetNames[MiscLib.newRandom(planetNames.length) - 1], new Faction("Domain", "Dominion", 0, Color.gray), null));
				planetarySystemsList.get(i).getPlanet(j).setPlanetLocation(new Vector2f(planetarySystemsList.get(i).getVectorX() + (j * 75), planetarySystemsList.get(i).getVectorY() + (j * 75)));
				planetarySystemsList.get(i).getPlanet(j).setParentSystem(planetarySystemsList.get(i));
				planetarySystemsList.get(i).getPlanet(j).setRealX((int) (planetarySystemsList.get(i).getPlanet(j).getParentSystem().getVectorX() + (j * 75)));
				planetarySystemsList.get(i).getPlanet(j).setRealY((int) (planetarySystemsList.get(i).getPlanet(j).getParentSystem().getVectorY() + (j * 75)));
				try {
					planetarySystemsList.get(i).getPlanet(j).init(gc, sbg);
				} catch (SlickException e) {
					e.printStackTrace();
				}
			}
		}
	}
	
	public void readPlanetNamesFromFile() {
        try {
            FileInputStream fStream = new FileInputStream("resources/planetNames");
            BufferedReader in = new BufferedReader(new InputStreamReader(fStream));
            while (in.ready()) {
                planetNames = (in.readLine().split(","));
            }
            in.close();
        } catch (IOException e) {
            System.out.println("File input error");
        }
        for(int i = 0; i < planetNames.length; i++) {
        	//System.out.print(planetNames[i] + " ");
        }
        //System.out.print(planetNames.length);
	}
	
	public static void save() {
		
	}

	public void init(GameContainer gc, StateBasedGame sbg)
			throws SlickException {
		planetarySystemsList = new ArrayList<PlanetarySystem>();
		pImage = new Image("resources/metallic.png");
		readPlanetNamesFromFile();
		generatePlanetarySystems(gc, sbg);

	}

	public void render(GameContainer gc, StateBasedGame sbg, Graphics g)
			throws SlickException {
		if(planetarySystemsList != null) {
			for(PlanetarySystem p: planetarySystemsList) {
				p.render(gc, sbg, g);
			}
		}
	}

	public void update(GameContainer gc, StateBasedGame sbg, int delta)
			throws SlickException {
		
	}

	public int getID() {
		return 0;
	}
}
