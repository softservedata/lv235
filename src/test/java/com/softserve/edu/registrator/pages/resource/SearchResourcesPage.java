package com.softserve.edu.registrator.pages.resource;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.softserve.edu.registrator.data.subclass.ISubclass;
import com.softserve.edu.registrator.pages.common.RegistratorHomePage;

public class SearchResourcesPage extends RegistratorHomePage {

	/*
	 * Constructor
	 */
	public SearchResourcesPage(WebDriver driver) {
		super(driver);
	}
	
	private static final String SEARCH_BY_PARAMETER_BUTTON_ID = "searchByParameterButton";
	private static final String RESOURCE_TYPE_SELECT_ID = "resourcesTypeSelect";
	private static final String DISCRETE_PARAMETER_INPUT_CSS = "#discreteParameters > div > span.col-md-6 > input";
	private static final String LINEAR_PARAMETER_INPUT_CSS = "#linearParameters > div > span > input";
	
	
	public WebElement getSearchByParameterButton() {
		return driver.findElement(By.id(SEARCH_BY_PARAMETER_BUTTON_ID));
	}
	
	public WebElement getResourceTypeSelect() {
		return driver.findElement(By.id(RESOURCE_TYPE_SELECT_ID));
	}
	
	public WebElement getDiscreteParameterInput() {
		return driver.findElement(By.cssSelector(DISCRETE_PARAMETER_INPUT_CSS));
	}
	
	public WebElement getLinearParameterInput() {
		return driver.findElement(By.cssSelector(LINEAR_PARAMETER_INPUT_CSS));
	}
	
	public void clickSearchByParameterButton() {
		getSearchByParameterButton().click();
	}
	
	public void clickResourceTypeSelect() {
		getResourceTypeSelect().click();
	}
	
	public void clickDiscreteParameterInput() {
		getDiscreteParameterInput().click();
	}
	
	public void clickLinearParameterInput() {
		getLinearParameterInput().click();
	}
	
	public void clickResourceByName(ISubclass subclassName) {
		driver.findElement(By.xpath("//*[@id='resourcesTypeSelect']/option[contains(.,'"+ subclassName.getNameSubclass() +"')]")).click();
	}
	
	public void fillDiscreteParameter(String value) {
		clickDiscreteParameterInput();
		getDiscreteParameterInput().sendKeys(value);
	}
	
	public void fillLinearParameter(String value) {
		clickLinearParameterInput();
		getLinearParameterInput().sendKeys(value);
	}
	
	
}
