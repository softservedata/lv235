package com.softserve.edu.volodya;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

<<<<<<< HEAD
public class SubclassPage {

	/**
	 * Web driver for browser.
	 */
	WebDriver driver;

	/**
	 * Constructor for class.
	 * @param driver web driver for browser.
	 */
	public SubclassPage(WebDriver driver) {
		this.driver = driver;
	}


=======
import com.softserve.edu.registrator.pages.ACommonComponent;

public class SubclassPage extends ACommonComponent {

	private static int ParameterCounter = -1;
	
	private static final String SUBCLASS_NAME_NAME = "typeName";
	private static final String ADD_PARAMETERS_ID = "clickmeshow";
	private static final String DESCRIPTION_PARAMETER_NAME = "parameters[" + ParameterCounter + "].description";
	private static final String UNIT_PARAMETER_NAME = "parameters[" + ParameterCounter + "].unitName";
	private static final String DISCRETE_PARAMETER_CSS = "#input"+ ParameterCounter+1 +" #myparam2 [value='discreteParameters']";
	private static final String LINEAR_PARAMETER_CSS = "#input" + ParameterCounter+1 +" #myparam2 [value='linearParameters']";
	private static final String ADD_BUTTON_ID = "btnAdd";

	
	
	//
	// Constructor
	//
	public SubclassPage(WebDriver driver) {
		super(driver);
	}
	
	//
	// Get
	//
>>>>>>> 98de4368300538b047f570aa9d10bd9417bd2e73
	public WebElement getAddSubclassButton() {
		return driver.findElement(By.xpath("//*[@id='body']/p/a"));
	}

	public WebElement getSubclassName() {
<<<<<<< HEAD
		return driver.findElement(By.name("typeName"));
	}
=======
		return driver.findElement(By.name(SUBCLASS_NAME_NAME));
	}
	
	public WebElement getAddParameters() {
		return driver.findElement(By.id(ADD_PARAMETERS_ID));
	}
	
	public WebElement getDescriptionParameter() {
		return driver.findElement(By.name(DESCRIPTION_PARAMETER_NAME));
	}
	
	public WebElement getUnitParameter() {
		return driver.findElement(By.name(UNIT_PARAMETER_NAME));
	}
	
	public WebElement getAddButton() {
		return driver.findElement(By.id(ADD_BUTTON_ID));
	}
	
	public WebElement getDiscreteParameter() {
		return driver.findElement(By.cssSelector(DISCRETE_PARAMETER_CSS));
	}
	
	public WebElement getLinearParameter() {
		return driver.findElement(By.cssSelector(LINEAR_PARAMETER_CSS));
	}
	
	//
	// Click
	//
	public void clickSubclassName() {
		getSubclassName().click();
	}
	
	public void clickAddParametersButton() {
		getAddParameters().click();
		ParameterCounter++;
	}
	
	public void clickDescriptionParameter() {
		getDescriptionParameter().click();
	}
	
	public void clickUnitParameter() {
		getUnitParameter().click();
	}
	
	public void clickDiscreteParameter() {
		getDiscreteParameter().click();
	}
	
	public void clickLinearParameter() {
		getLinearParameter().click();
	}
 	
	//
	// InputData
	//
	public void FillSubclassName(String subclassName) {
		getSubclassName().sendKeys(subclassName);
	}
	
	public void FillDescriptionParameter(String descriptionName) {
		getDescriptionParameter().sendKeys(descriptionName);
	}
	public void FillUnitParameter(String unitName) {
		getUnitParameter().sendKeys(unitName);
	}
	
	// 
	// Functions
	//
	
	public String FindSubclassName(String subclassName) {
		return driver.findElement(By.xpath(".//*[@id='datatable']//td[contains(.,'"+ subclassName +"')]")).getText();
	}
	
>>>>>>> 98de4368300538b047f570aa9d10bd9417bd2e73
}
