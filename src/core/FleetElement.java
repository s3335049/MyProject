package core;

public class FleetElement {

	private Ship ship;
	private int numberOfShips;
	
	public FleetElement(Ship ship, int numberOfShips) {
		this.ship = ship;
		this.numberOfShips = numberOfShips;
	}
	
	public void setNumberOfShips(int numberOfShips) {
		this.numberOfShips = numberOfShips;
	}
	
	public void addNumberOfShips(int numberOfShips) {
		this.numberOfShips += numberOfShips;
	}
	
	public void minusNumberOfShips(int numberOfShips) {
		this.numberOfShips -= numberOfShips;
	}
	
	public int getNumberOfShips() {
		return this.numberOfShips;
	}
}
