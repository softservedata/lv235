package com.softserve.edu.registrator.pages.communities;

import org.openqa.selenium.WebElement;

import com.softserve.edu.registrator.tools.search.Search;

public class AddEditCommunityForm {

	private WebElement nameFormLable;
	private WebElement communityNameLable;
	private WebElement communityNameInput;
	private WebElement registrationNumberLable;
	private WebElement registrationNumberInput;

	public AddEditCommunityForm() {
		nameFormLable = Search.cssSelector("h2");
		communityNameLable = Search.xpath("//input[@name = 'name']/../../label");
		communityNameInput = Search.name("name");
		registrationNumberLable = Search.xpath("//input[@name = 'registrationNumber']/../../label");
		registrationNumberInput = Search.name("registrationNumber");
	}

	public WebElement getNameFormLable() {
		return nameFormLable;
	}

	public WebElement getCommunityNameLable() {
		return communityNameLable;
	}

	public WebElement getCommunityNameInput() {
		return communityNameInput;
	}

	public WebElement getRegistrationNumberLable() {
		return registrationNumberLable;
	}

	public WebElement getRegistrationNumberInput() {
		return registrationNumberInput;
	}
}
