package core;

import java.util.ArrayList;

public class Structure {
	
	private String structureName;
	private int spaceRequirement;
	private static ArrayList<Structure> structureRequirement = new ArrayList<Structure>();
	private static ArrayList<Technology> technologyRequirement = new ArrayList<Technology>();
	
	public Structure(String structureName, int spaceReq) {
		this.setStructureName(structureName);
		this.setSpaceRequirement(spaceReq);
	}
	
	public String getStructureName() {
		return structureName;
	}

	public void setStructureName(String structureName) {
		this.structureName = structureName;
	}

	public int getSpaceRequirement() {
		return spaceRequirement;
	}

	public void setSpaceRequirement(int spaceRequirement) {
		this.spaceRequirement = spaceRequirement;
	}

	public static void setStructureReq(ArrayList<Structure> structureReq) {
		structureRequirement.clear();
		structureRequirement = structureReq;
	}
	
	public static void addStructureReq(Structure structure) {
		structureRequirement.add(structure);
	}
	
	public static void setTechnologyReq(ArrayList<Technology> techReq) {
		technologyRequirement.clear();
		technologyRequirement = techReq;
	}
	
	public static void addTechReq(Technology technology) {
		technologyRequirement.add(technology);
	}
}
