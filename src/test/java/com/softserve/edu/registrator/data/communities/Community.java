package com.softserve.edu.registrator.data.communities;

public class Community {
	
	private String nameCommunity;
	private String registrationNumber;
	
	public Community(String nameCommunity) {
		this.nameCommunity = nameCommunity;
		this.registrationNumber = "";
	}
	
	public Community(String nameCommunity, String registrationNumber) {
		this.nameCommunity = nameCommunity;
		this.registrationNumber = registrationNumber;
	}
	
	public String getNameCommunity() {
		return nameCommunity;
	}
	
	public String getRegistrationNumber() {
		return registrationNumber;
	}
	
	public void setNameCommunity(String nameCommunity) {
		this.nameCommunity = nameCommunity;
	}
	
	public void setRegistrationNumber(String registrationNumber) {
		this.registrationNumber = registrationNumber;
	}
	
	@Override
	public boolean equals(Object obj) {
		return (this.nameCommunity.equals(((Community)obj).nameCommunity)
				&& this.registrationNumber.equals(((Community)obj).registrationNumber));
	}
}
