package com.softserve.edu.registrator.data.communities;

public final class CommunityRepository {
	private CommunityRepository() { }
	
	public static ICommunity getCommunityValidData(){
		return new Community("Kyiv", "470:09:30:461:05471");
	}

	public static ICommunity getCommunityValidEditedData(){
		return new Community("Kyiv2", "120:00:94:860:35001");
	}
	
	public static ICommunity getCommunityValidEditedNumber(){
		return new Community("Kyiv", "120:00:94:860:35001");
	}
	
	public static Community getCommunityValidName(){
		return new Community("Mykolaiv", "");
	}
	
	public static ICommunity getCommunityEmptyData(){
		return new Community("", "");
	}
	
	
	public static ICommunity getCommunityEmptyName(){
		return new Community("", "124:00:94:960:35001");
	}
	
	public static ICommunity getCommunityIncorectNumber(){
		return new Community("Kyiv", "376");
	}
	
	public static ICommunity getCommunityUsedName(){
		return new Community("Lviv", "262:07:60:025:68001");
	}
	
	
	public static ICommunity getCommunityIncorectName(){
		return new Community("!$?#{]", "262:07:60:025:68001");
	}
	
	public static ICommunity getCommunityUsedNumber(){
		return new Community("Odessa", "120:00:94:860:35001");
	}
	
	public static String getErrorMessageNameCommunity(){
		return "Please fill out this field.";
	}
}
