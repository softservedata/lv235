package com.softserve.edu.registrator.pages.settings;

import java.util.HashMap;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.softserve.edu.registrator.pages.AdminHomePage;

public class SettingsPage extends AdminHomePage {
	public static enum SettingsPageL10n {
		CONFIRM_CHANGES_BUTTON("Підтвердити зміни", "Подтвердить изменения",
				"Confirm changes");

		private HashMap<ChangeLanguageFields, String> field;

		private SettingsPageL10n(String... localization) {
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
