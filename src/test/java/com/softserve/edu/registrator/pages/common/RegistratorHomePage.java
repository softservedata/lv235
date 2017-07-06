package com.softserve.edu.registrator.pages.common;

import org.openqa.selenium.WebElement;

import com.softserve.edu.registrator.pages.resource.AddResourcePage;
import com.softserve.edu.registrator.pages.resource.SearchResourcesPage;
import com.softserve.edu.registrator.pages.subclass.SubclassPage;
import com.softserve.edu.registrator.tools.search.Search;

public class RegistratorHomePage extends ACommonComponent {

	// Fields

	private WebElement home;
	private WebElement searchResources;
	private WebElement subclassObjects;
	private WebElement addNewResource;

	// Constructor

	public RegistratorHomePage() {
		super();
		this.home = Search.cssSelector("a.glyphicon.glyphicon-home");
		this.searchResources = Search.xpath("//a[contains(@href,'/searchOnMap')]");
		this.subclassObjects = Search.xpath("//a[contains(@href,'/show-res-types')]");
		this.addNewResource = Search.xpath("//a[contains(@href,'/new')]");
	}

	// get

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

	// set

	public void clickHome() {
		getHome().click();
	}

	public SearchResourcesPage clickSearchResources() {
		getSearchResources().click();
		return new SearchResourcesPage();
	}

	public SubclassPage clickSubclassObjects() {
		getSubclassObjects().click();
		return new SubclassPage();
	}

	public AddResourcePage clickAddNewResource() {
		getAddNewResource().click();
		return new AddResourcePage();

	}

	// Functions

	public LoginPage logout() {
		clickLogout();
		return new LoginPage();
	}

}
