package com.softserve.edu.registrator.data.users;

interface IFirstname {
	ILastname setFirstname(String firstname);
}

interface ILastname {
	IEmail setLastname(String lastname);
}

interface IEmail {
	IBuildPerson setEmail(String email);
}

interface IBuildPerson {
	IPersonExt build();
}

public class Person implements IFirstname, ILastname, IEmail, IBuildPerson, IPersonExt {

	private String firstname;
	private String lastname;
	private String middlename;
	private String email;
	private String phonenumber;
	private String login;

	private Person() {
		this.middlename = new String();
		this.phonenumber = new String();
		this.login=new String();
	}

	// static factory - - - - - - - - - -

	public static IFirstname get() {
		return new Person();
	}

	// set - - - - - - - - - -

	public ILastname setFirstname(String firstname) {
		this.firstname = firstname;
		return this;
	}

	public IEmail setLastname(String lastname) {
		this.lastname = lastname;
		return this;
	}

	public IBuildPerson setEmail(String email) {
		this.email = email;
		return this;
	}

	public Person build() {
		return this;
	}

	public IPersonExt setMiddlename(String middlename) {
		this.middlename = middlename;
		return this;
	}

	public IPersonExt setPhonenumber(String phonenumber) {
		this.phonenumber = phonenumber;
		return this;
	}

	// get - - - - - - - - - -

	public String getFirstname() {
		return firstname;
	}

	public String getLastname() {
		return lastname;
	}

	public String getMiddlename() {
		return middlename;
	}

	public String getEmail() {
		return email;
	}

	public String getPhonenumber() {
		return phonenumber;
	}
	public String getLogin(){return login;}

}
