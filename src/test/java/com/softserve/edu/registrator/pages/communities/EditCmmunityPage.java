package com.softserve.edu.registrator.pages.communities;

import java.util.HashMap;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.softserve.edu.registrator.data.communities.ICommunity;
import com.softserve.edu.registrator.pages.common.AdminHomePage;

public class EditCmmunityPage extends AdminHomePage {

	public static enum AddCommunityPageL10n {
		EDIT_COMMUNITY_LABEL("Редагування територіальної громади",
				"Изменить общину", "Edit territorial community"), COMMUNITY_NAME_LABEL(
				"Найменування громади:", "Найменование общины:",
				"Community name:"), COMMUNITY_NAME_INPUT("Введіть", "Введите",
				"Enter"), REGISTER_NUMBER_LABEL("Реєстраційний номер:",
				"Регистрационный номер:", "Registration number:"), SAVE_BUTTON(
				"Зберегти", "Сохранить", "Save");

		private HashMap<ChangeLanguageFields, String> field;

		private AddCommunityPageL10n(String... localization) {
			this.field = new HashMap<ChangeLanguageFields, String>();
			int i = 0;
			for (ChangeLanguageFields language : ChangeLanguageFields.values()) {
				this.field.put(language, localization[i]);
				i++;
			}
		}

		public String getLocalization(ChangeLanguageFields language) {
			return this.field.get(language).trim();
		}
	}

	public static final String VALUE_ATTRIBUTE = "value";
	public static final String VALIDATION_MESSAGE_ATTRIBUTE = "alidationMessage";
	public static final String VALUE_PLACEHOLDER = "value placeholder";

	private AddEditCommunityForm addEditCommunityForm;
	private WebElement saveButton;

	public EditCmmunityPage(WebDriver driver) {
		super(driver);
		initPage();
	}
	
	private void initPage() {
			addEditCommunityForm = new AddEditCommunityForm(driver);
			saveButton = driver.findElement(By
					.cssSelector("input[type = 'submit']"));
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

	public String getCommunityNameInputPlaceholderText() {
		return getCommunityNameAttributeText(VALUE_PLACEHOLDER);
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

	public WebElement getNameCommunityErrorLabel() {
		return driver.findElement(By.id("name.errors"));
	}

	public WebElement getRegistrationNumberErrorLabel() {
		return driver.findElement(By.id("registrationNumber.errors"));
	}

	// Functional Getters

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
		return getCommunityNameAttributeText(VALUE_ATTRIBUTE);
	}

	private String getCommunityNameErrorAttributeText(String attribute) {
		return driver.switchTo().activeElement().getAttribute(attribute);
	}

	public String getCommunityNameInputErrorText() {
		return getCommunityNameErrorAttributeText(VALIDATION_MESSAGE_ATTRIBUTE);
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

	public String getNameCommunityErrorLabelText() {
		return getNameCommunityErrorLabel().getText();
	}

	public String getRegistrationNumberErrorLabelText() {
		return getRegistrationNumberErrorLabel().getText();
	}

	public int getCountofRegNumberErrorLabels() {
		return driver.findElements(By.cssSelector("#body span")).size();
	}

	// Setters
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

	// Functional setters
	public void setCommunityData(ICommunity community) {
		setCommunityNameInput(community.getNameCommunity());
		setRegistrationNumberInput(community.getRegistrationNumber());
	}

	public AdminHomePage seccesfulEditedCommunity(ICommunity community) { // TODO
		setCommunityData(community);
		clickSaveButton();
		if(!driver.findElements(By.tagName("table")).isEmpty()){
			return new CommunityPage(driver);
		} else {
			return new EditCmmunityPage(driver);
		}
	}

	public AddCommunityPage changeLanguage(ChangeLanguageFields language) {
		setChangeLanguage(language);
		return new AddCommunityPage(driver);
	}
	
	public AdminHomePage save() {
		clickSaveButton();
		if(!driver.findElements(By.tagName("table")).isEmpty()){
			return new CommunityPage(driver);
		} else {
			return new EditCmmunityPage(driver);
		}
	}
}
