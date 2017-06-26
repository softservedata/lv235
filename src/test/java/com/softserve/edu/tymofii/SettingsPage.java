package com.softserve.edu.tymofii;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.softserve.edu.registrator.pages.AdminHomePage;

public class SettingsPage extends AdminHomePage {

	private WebElement confirmChangesButton;
	private UserRegistrationOptionsComponent userRegistrationOptionsComponent;
	private DefaultTimeZoneComponent defaultTimeZoneComponent;
	private EmailConfigurationComponent emailConfigurationComponent;

	public SettingsPage(WebDriver driver) {
		super(driver);
		this.userRegistrationOptionsComponent = new UserRegistrationOptionsComponent(
				driver);
		this.defaultTimeZoneComponent = new DefaultTimeZoneComponent(driver);
		this.emailConfigurationComponent = new EmailConfigurationComponent(
				driver);
		this.confirmChangesButton = driver.findElement(By
				.id(("confirmRegistrationMethod")));
	}

	public void confirmChangesButtonClick() {
		getConfirmChangesButton().click();
	}

	public WebElement getConfirmChangesButton() {
		return confirmChangesButton;
	}

	public UserRegistrationOptionsComponent getUserRegistrationOptionsComponent() {
		return userRegistrationOptionsComponent;
	}

	public DefaultTimeZoneComponent getDefaultTimeZoneComponent() {
		return defaultTimeZoneComponent;
	}

	public EmailConfigurationComponent getEmailConfigurationComponent() {
		return emailConfigurationComponent;
	}
}
