package com.softserve.edu.registrator.pages.common;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.softserve.edu.registrator.pages.resource.AddResourcePage;
import com.softserve.edu.registrator.pages.resource.SearchResourcesPage;
import com.softserve.edu.registrator.pages.subclass.SubclassPage;

public class RegistratorHomePage extends ACommonComponent {

	// Fields

	private WebElement home;
	private WebElement searchResources;
	private WebElement subclassObjects;
	private WebElement addNewResource;

	// Constructor

	public RegistratorHomePage(WebDriver driver) {
		super(driver);
		 this.home = driver.findElement(By.cssSelector("a.glyphicon.glyphicon-home"));
		 this.searchResources = driver.findElement(By.xpath("//a[contains(@href,'/searchOnMap')]"));
		 this.subclassObjects = driver.findElement(By.xpath("//a[contains(@href,'/show-res-types')]"));
		 this.addNewResource = driver.findElement(By.xpath("//a[contains(@href,'/new')]"));
	}

	//get

	public WebElement getHome() {
		return this.home;
	}

	public WebElement getSearchResources() {
		return this.searchResources;
	}

	public WebElement getSubclassObjects() {
		return this.subclassObjects;
	}

	public WebElement getAddNewResource() {
		return this.addNewResource;
	}

	//set

	public void clickHome() {
        getHome().click();
    }

	public SearchResourcesPage clickSearchResources() {
		getSearchResources().click();
		return new SearchResourcesPage(driver);
	}

	public SubclassPage clickSubclassObjects() {
		getSubclassObjects().click();
		return new SubclassPage(driver);
	}

	public AddResourcePage clickAddNewResource() {
		getAddNewResource().click();
		return new AddResourcePage(driver);
		
	}


	// Functions

	public LoginPage logout() {
        clickLogout();
        return new LoginPage(driver);
    }




}
