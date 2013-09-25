package core;

import java.util.ArrayList;

public class Technology {
	
	private String technologyName;
	private ArrayList<Technology> technologyReq = new ArrayList<Technology>();
	private int RPReq;
	
	public Technology(String techName, ArrayList<Technology> technologyReq, int RPReq) {
		this.setTechnologyName(techName);
		this.setTechnologyReq(technologyReq);
		this.setRPReq(RPReq);
	}

	public String getTechnologyName() {
		return technologyName;
	}

	public void setTechnologyName(String technologyName) {
		this.technologyName = technologyName;
	}

	public ArrayList<Technology> getTechnologyReq() {
		return technologyReq;
	}

	public void setTechnologyReq(ArrayList<Technology> technologyReq) {
		this.technologyReq = technologyReq;
	}

	public int getRPReq() {
		return RPReq;
	}

	public void setRPReq(int rPReq) {
		RPReq = rPReq;
	}
}
