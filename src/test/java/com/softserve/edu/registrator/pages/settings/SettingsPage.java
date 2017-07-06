package com.softserve.edu.registrator.pages.settings;

import org.openqa.selenium.WebElement;

import com.softserve.edu.registrator.pages.common.AdminHomePage;
import com.softserve.edu.registrator.tools.search.Search;

public class SettingsPage extends AdminHomePage {

	private WebElement confirmChangesButton;
	private UserRegistrationOptionsComponent userRegistrationOptionsComponent;
	private DefaultTimeZoneComponent defaultTimeZoneComponent;
	private EmailConfigurationComponent emailConfigurationComponent;

	public SettingsPage() {
		super();
		this.userRegistrationOptionsComponent = new UserRegistrationOptionsComponent();
		this.defaultTimeZoneComponent = new DefaultTimeZoneComponent();
		this.emailConfigurationComponent = new EmailConfigurationComponent();
		this.confirmChangesButton = Search.id("confirmRegistrationMethod");
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
