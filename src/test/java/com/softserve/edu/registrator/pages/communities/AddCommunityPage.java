package com.softserve.edu.registrator.pages.communities;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.softserve.edu.registrator.data.communities.Community;
import com.softserve.edu.registrator.pages.AdminHomePage;

public class AddCommunityPage extends AdminHomePage {

	public static final String VALUE_ATTRIBUTE = "value"; 
	public static final String VALIDATION_MESSAGE_ATTRIBUTE = "alidationMessage";
	
	private AddEditCommunityForm addEditCommunityForm;
	private WebElement saveButton;
	private WebElement clearFormButton;
	
	public AddCommunityPage(WebDriver driver) {
		super(driver);
		
		addEditCommunityForm = new AddEditCommunityForm(driver);
		saveButton= driver.findElement(By.cssSelector("input[type = 'submit']"));
		clearFormButton= driver.findElement(By.cssSelector("button[type='reset']"));
	}

	public WebElement getNameFormLable() {
		return addEditCommunityForm.getNameFormLable();
	}

	public WebElement getCommunityNameLable() {
		return addEditCommunityForm.getCommunityNameLable();
	}

	public WebElement getCommunityNameInput() {
		return addEditCommunityForm.getCommunityNameInput();
	}

	public WebElement getRegistrationNumberLable() {
		return addEditCommunityForm.getRegistrationNumberLable();
	}

	public WebElement getRegistrationNumberInput() {
		return addEditCommunityForm.getRegistrationNumberInput();
	}

	public AddEditCommunityForm getAddEditCommunityForm() {
		return this.addEditCommunityForm;
	}

	public WebElement getSaveButton() {
		return saveButton;
	}

	public WebElement getClearFormButton() {
		return clearFormButton;
	}
	
	public WebElement getNameCommunityErrorLabel() {
		return driver.findElement(By.id("name.errors"));
	}

	public WebElement getRegistrationNumberErrorLabel() {
		return driver.findElement(By.id("registrationNumber.errors"));
	}
	

	//Functional getters
	public String getNameFormLableText() {
		return getNameFormLable().getText();
	}

	public String getCommunityNameLableText() {
		return getCommunityNameLable().getText();
	}

	private String getCommunityNameAttributeText(String attribute) {
		return getCommunityNameInput().getAttribute(attribute);
	}
	
	public String getCommunityNameInputText() {
		return  getCommunityNameAttributeText(VALUE_ATTRIBUTE);
	}
	
	private String getCommunityNameErrorAttributeText(String attribute) {
		return driver.switchTo().activeElement().getAttribute(attribute);
	}
	
	public String getCommunityNameInputErrorText() {
		return  getCommunityNameErrorAttributeText(VALIDATION_MESSAGE_ATTRIBUTE);
	}

	public String getRegistrationNumberLableText() {
		return getRegistrationNumberLable().getText();
	}

	private String getRegistrationNumberAttributeText(String attribute) {
		return getRegistrationNumberInput().getAttribute(attribute);
	}
	
	public String getRegistrationNumberInputText() {
		return getRegistrationNumberAttributeText(VALUE_ATTRIBUTE);
	}

    private String getSaveButtonAttributeText(String attribute) {
        return getSaveButton().getAttribute(attribute);
    }
    
	public String getSaveButtonText() {
		return getSaveButtonAttributeText(VALUE_ATTRIBUTE);
	}

	public String getClearFormButtonText() {
		return getClearFormButton().getText();
	}
	
	public String getNameCommunityErrorLabelText() {
		return getNameCommunityErrorLabel().getText();
	}

	public String getRegistrationNumberErrorLabelText() {
		return getRegistrationNumberErrorLabel().getText();
	}
	
	public int getCountofRegNumberErrorLabels() {
		return driver.findElements(By.cssSelector("#body span")).size();
	}
	
	// set Data
	
	public void setCommunityNameInputClear() {
		getCommunityNameInput().clear();
	}
	
	public void setRegistrationNumberInputClear() {
		getRegistrationNumberInput().clear();
	}
	
	
	public void setCommunityNameInput(String nameCommunity) {
		setCommunityNameInputClear();
		getCommunityNameInput().sendKeys(nameCommunity);
	}
	
	public void setRegistrationNumberInput(String registerNumber) {
		setRegistrationNumberInputClear();
		getRegistrationNumberInput().sendKeys(registerNumber);
	}
	
	public void clickCommunityNameInput() {
		getCommunityNameInput().click();
	}
	
	public void clickRegistrationNumberInput() {
		getRegistrationNumberInput().click();
	}
	
	public void clickSaveButton() {
		getSaveButton().click();
	}
	
	public void clickClearFormButton() {
		getClearFormButton().click();
	}
	
	//Functional setters
	public void setCommunityData(Community community) {
		setCommunityNameInput(community.getNameCommunity());
		setRegistrationNumberInput(community.getRegistrationNumber());
	}
	
	public CommunityPage seccesfulAddedCommunity(Community community) { //TODO
		setCommunityData(community);
		clickSaveButton();
		return new CommunityPage(driver);
	}
	
    public AddCommunityPage changeLanguage(ChangeLanguageFields language) {
    	setChangeLanguage(language);
        return new AddCommunityPage(driver);
    }
}
