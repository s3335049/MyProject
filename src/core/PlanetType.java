package core;

import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;

public enum PlanetType {
	METALLIC(3, 1, 1),
	OCEANIC(2, 2, 0);
	
	private int metals;
	private int gas;
	private int crystals;
	
	private PlanetType(int metals, int gas, int crystals) {
		this.setMetals(metals);
		this.setGas(gas);
		this.setCrystals(crystals);
	}

	public int getMetals() {
		return metals;
	}

	public void setMetals(int metals) {
		this.metals = metals;
	}

	public int getGas() {
		return gas;
	}

	public void setGas(int gas) {
		this.gas = gas;
	}

	public int getCrystals() {
		return crystals;
	}

	public void setCrystals(int crystals) {
		this.crystals = crystals;
	}
}