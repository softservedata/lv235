package com.softserve.edu.registrator.data.subclass;

public class Subclass implements ISubclass {

	private String nameSubclass;
	private String parameterDescription;
	private String parameterUnit;

	/*
	 * Constructor
	 */
	public Subclass(String nameSubclass, String parameterDescription, String parameterUnit) {
		this.nameSubclass = nameSubclass;
		this.parameterDescription = parameterDescription;
		this.parameterUnit = parameterUnit;
	}
	
	// Getters
	
	public String getNameSubclass() {
		return nameSubclass;
	}

	public String getParameterDescription() {
		return parameterDescription;
	}

	public String getParameterUnit() {
		return parameterUnit;
	}

	// Setters
	
	public void setNameSubclass(String nameSubclass) {
		this.nameSubclass = nameSubclass;
	}
	
	public void setParameterDescription(String parameterDescription) {
		this.parameterDescription = parameterDescription;
	}
	
	public void setParameterUnit(String parameterUnit) {
		this.parameterUnit = parameterUnit;
	}

}
