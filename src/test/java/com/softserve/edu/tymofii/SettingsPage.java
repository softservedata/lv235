package com.softserve.edu.tymofii;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.softserve.edu.registrator.pages.AdminHomePage;

public class SettingsPage extends AdminHomePage {
	private WebElement confirmChangesButton;
	private UserRegistrationOptionsComponent userRegistrationOptionsComponent;

	public SettingsPage(WebDriver driver) {
		super(driver);
		this.userRegistrationOptionsComponent = new UserRegistrationOptionsComponent(
				driver);
		this.confirmChangesButton = driver.findElement(By
				.cssSelector((".btn.btn-primary")));
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
}
