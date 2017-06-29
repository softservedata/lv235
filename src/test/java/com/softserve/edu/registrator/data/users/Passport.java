package com.softserve.edu.registrator.data.users;

public class Passport implements IPassport {

	private String seria;
	private String number;
	private String published;

	private Passport() {
		this.seria = new String();
		this.number = new String();
		this.published = new String();
	}
	
	// static factory - - - - - - - - - -

	public static Passport get() {
		return new Passport();
	}

	// set - - - - - - - - - -

	public Passport setSeria(String seria) {
		this.seria = seria;
		return this;
	}

	public Passport setNumber(String number) {
		this.number = number;
		return this;
	}

	public Passport setPublished(String published) {
		this.published = published;
		return this;
	}

	// get - - - - - - - - - -

	public String getSeria() {
		return seria;
	}

	public String getNumber() {
		return number;
	}

	public String getPublished() {
		return published;
	}

}
