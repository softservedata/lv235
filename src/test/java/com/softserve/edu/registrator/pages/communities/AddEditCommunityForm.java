package com.softserve.edu.registrator.pages.communities;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class AddEditCommunityForm {

	private WebElement nameFormLable;
	private WebElement communityNameLable;
	private WebElement communityNameInput;
	private WebElement registrationNumberLable;
	private WebElement registrationNumberInput;
	
	public AddEditCommunityForm(WebDriver driver){
		nameFormLable = driver.findElement(By.cssSelector("h2"));
		communityNameLable= driver.findElement(By.xpath("//input[@name = 'name']/../../label"));
		communityNameInput= driver.findElement(By.name("name"));
		registrationNumberLable= driver.findElement(By.xpath("//input[@name = 'registrationNumber']/../../label"));
		registrationNumberInput= driver.findElement(By.name("registrationNumber"));
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
