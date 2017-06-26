package com.softserve.edu.volodya;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.softserve.edu.registrator.pages.ACommonComponent;

public class AddSubclassPage extends ACommonComponent {

	private static final String SUBCLASS_NAME_NAME = "typeName";
	private static final String ADD_PARAMETERS_ID = "clickmeshow";
	private static final String DESCRIPTION_PARAMETER_NAME = "parameters[0].description";
	private static final String UNIT_PARAMETER_NAME = "parameters[0].unitName";
	private static final String DISCRETE_PARAMETER_CSS = "#input1 #myparam2 [value='discreteParameters']";
	private static final String LINEAR_PARAMETER_CSS = "#input2 #myparam2 [value='linearParameters']";
	private static final String ADD_BUTTON_ID = "btnAdd";
	private static final String SAVE_BUTTON_ID = "valid";

	//
	// Constructor
	//
	public AddSubclassPage(WebDriver driver) {
		super(driver);
	}
	
	//
	// Get
	//
	public WebElement getSubclassName() {
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
	
	public WebElement getSaveButton() {
		return driver.findElement(By.id(SAVE_BUTTON_ID));
	}
	
	//
	// Click
	//
	public void clickSubclassName() {
		getSubclassName().click();
	}
	
	public void clickAddParametersButton() {
		getAddParameters().click();
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
 	
	public void clickAddButton() {
		getAddButton().click();
	}
	
	
	public void clickSaveButton() {
		getSaveButton().click();
	}
	
	//
	// InputData
	//
	public void FillSubclassName(ISubclass subclassName) {
		clickSubclassName();
		getSubclassName().sendKeys(subclassName.getNameSubclass());
	}
	
	public void FillDescriptionParameter(ISubclass descriptionName) {
		clickDescriptionParameter();
		getDescriptionParameter().sendKeys(descriptionName.getParameterDescription());
	}
	public void FillUnitParameter(ISubclass unitName) {
		clickUnitParameter();
		getUnitParameter().sendKeys(unitName.getParameterUnit());
	}
	
	// 
	// Functions
	//
	public String FindSubclassName(ISubclass subclassName) {
		return driver.findElement(By.xpath(".//*[@id='datatable']//td[contains(.,'"+ subclassName.getNameSubclass() +"')]")).getText();
	}
	
	
	//
	//
	//
	//
	//
	//
	
	private static final String DESCRIPTION_PARAMETER_NAME2 = "parameters[1].description";
	private static final String UNIT_PARAMETER_NAME2 = "parameters[1].unitName";
	public WebElement getDescriptionParameter2() {
		return driver.findElement(By.name(DESCRIPTION_PARAMETER_NAME2));
	}
	
	public WebElement getUnitParameter2() {
		return driver.findElement(By.name(UNIT_PARAMETER_NAME2));
	}
	
	public void FillDescriptionParameter2(String descriptionName) {
		getDescriptionParameter2().click();
		getDescriptionParameter2().sendKeys(descriptionName);
	}
	public void FillUnitParameter2(String unitName) {
		getUnitParameter2().click();
		getUnitParameter2().sendKeys(unitName);
	}
	
}
