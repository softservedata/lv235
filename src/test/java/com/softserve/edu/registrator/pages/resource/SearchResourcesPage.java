package com.softserve.edu.registrator.pages.resource;

import org.openqa.selenium.WebElement;

import com.softserve.edu.registrator.data.subclass.ISubclass;
import com.softserve.edu.registrator.pages.common.RegistratorHomePage;
import com.softserve.edu.registrator.tools.search.Search;

public class SearchResourcesPage extends RegistratorHomePage {

	/*
	 * Constructor
	 */
	public SearchResourcesPage() {
		super();
	}
	
	private static final String SEARCH_BY_PARAMETER_BUTTON_ID = "searchByParameterButton";
	private static final String RESOURCE_TYPE_SELECT_ID = "resourcesTypeSelect";
	private static final String DISCRETE_PARAMETER_INPUT_CSS = "#discreteParameters > div > span.col-md-6 > input";
	private static final String LINEAR_PARAMETER_INPUT_CSS = "#linearParameters > div > span > input";
	
	
	public WebElement getSearchByParameterButton() {
		return Search.id(SEARCH_BY_PARAMETER_BUTTON_ID);
	}
	
	public WebElement getResourceTypeSelect() {
		return Search.id(RESOURCE_TYPE_SELECT_ID);
	}
	
	public WebElement getDiscreteParameterInput() {
		return Search.cssSelector(DISCRETE_PARAMETER_INPUT_CSS);
	}
	
	public WebElement getLinearParameterInput() {
		return Search.cssSelector(LINEAR_PARAMETER_INPUT_CSS);
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
		Search.xpath("//*[@id='resourcesTypeSelect']/option[contains(.,'"+ subclassName.getNameSubclass() +"')]").click();
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
