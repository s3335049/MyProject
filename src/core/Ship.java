package core;

import java.util.ArrayList;

public class Ship {

	private String shipName;
	private Faction shipOwner;
	private ArrayList<WeaponSystem> weaponSystem;
	private ArrayList<Module> module;
	private int shields;
	private int hull;
	private String location;
	private boolean inTransit = false;
	
	public Ship(String shipName, ArrayList<WeaponSystem> weaponSystem, int shields, int hull, ArrayList<Module> module) {
		this.shipName = shipName;
		this.weaponSystem = weaponSystem;
		this.module = module;
		this.shields = shields;
		this.hull = hull;
	}

	public String getShipName() {
		return shipName;
	}

	public void setShipName(String shipName) {
		this.shipName = shipName;
	}

	public ArrayList<WeaponSystem> getWeaponSystem() {
		return weaponSystem;
	}

	public void setWeaponSystem(ArrayList<WeaponSystem> weaponSystem) {
		this.weaponSystem = weaponSystem;
	}

	public ArrayList<Module> getModule() {
		return module;
	}

	public void setModule(ArrayList<Module> module) {
		this.module = module;
	}

	public int getShields() {
		return shields;
	}

	public void setShields(int shields) {
		this.shields = shields;
	}

	public int getHull() {
		return hull;
	}

	public void setHull(int hull) {
		this.hull = hull;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(Planet planet) {
		planet.setHasShips(true);
	}

	public boolean isInTransit() {
		return inTransit;
	}

	public void setInTransit(boolean inTransit) {
		this.inTransit = inTransit;
	}
	
	public void SettlePlanet(boolean isPlanetOwned, boolean outpostModule, Planet planet) {
		if(isPlanetOwned == false && outpostModule == true) {
			planet.setPlanetOwner(shipOwner);
			//planet.getMouseOverArea().setNormalColor(planet.getPlanetOwner().getColor());
		}
	}
}
