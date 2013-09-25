package core;

import java.util.ArrayList;

import org.newdawn.slick.Color;

public class Faction {
	
	private String factionName;
	private String race;
	private int credits;
	private Color color;
	private ArrayList<Fleet> fleetList;
	
	public Faction(String factionName, String race, int credits, Color color) {
		this.factionName = factionName;
		this.race = race;
		this.credits = credits;
		this.setColor(color);
	}

	public String getFactionName() {
		return factionName;
	}

	public void setFactionName(String factionName) {
		this.factionName = factionName;
	}

	public String getRace() {
		return race;
	}

	public void setRace(String race) {
		this.race = race;
	}

	public int getCredits() {
		return credits;
	}
	
	public String getCreditsString() {
		return credits + "";
	}

	public void setCredits(int credits) {
		this.credits = credits;
	}

	public Color getColor() {
		return color;
	}

	public void setColor(Color color) {
		this.color = color;
	}
	
	public ArrayList<Fleet> getFleetList() {
		return this.fleetList;
	}
	
	public void setFleetList(ArrayList<Fleet> fleetList) {
		this.fleetList = fleetList;
	}
	
	public void addFleetToArray(Fleet fleet) {
		this.fleetList.add(fleet);
	}
}
