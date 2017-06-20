package com.softserve.edu.volodya;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.softserve.edu.registrator.pages.ACommonComponent;
import com.softserve.edu.registrator.pages.LoginPage;

public class RegistratorHomePage extends ACommonComponent {

	// Fields

	private WebElement home;
	private WebElement searchResources;
	private WebElement subclassObjects;
	private WebElement addNewResource;

	// Constructor

	public RegistratorHomePage(WebDriver driver) {
		super(driver);
		// TODO delete hardcoded elements
		 this.home = driver.findElement(By.cssSelector("a.glyphicon.glyphicon-home"));
		 this.searchResources = driver.findElement(By.cssSelector("#navigationbar > ul > li:nth-child(2) > a"));
		 this.subclassObjects = driver.findElement(By.xpath("//*[@id='navigationbar']/ul/li[3]/a"));
		 this.addNewResource = driver.findElement(By.cssSelector("#navigationbar > ul > li:nth-child(5) > a"));
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

	public void clickSearchResources() {
		getSearchResources().click();
	}

	public void clickSubclassObjects() {
		getSubclassObjects().click();
	}

	public void clickAddNewResource() {
		getAddNewResource().click();
	}


	// Funk

	public LoginPage logout() {
        clickLogout();
        // Return a new page object representing the destination.
        return new LoginPage(driver);
    }




}
