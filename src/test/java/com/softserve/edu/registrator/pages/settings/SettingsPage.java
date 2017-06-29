package com.softserve.edu.registrator.pages.settings;

import java.util.HashMap;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.softserve.edu.registrator.pages.AdminHomePage;

public class SettingsPage extends AdminHomePage {
	public static enum SettingsPageL10n {
		CONFIRM_CHANGES_BUTTON("Підтвердити зміни", "Подтвердить изменения",
				"Confirm changes"), ALERT("Налаштування успішно збережені!",
				"Настройки успешно сохранены!",
				"Settings was successfully saved!");

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

	private static final String ALERT_CSS_SELECTOR = ".alert";

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

	public void clickConfirmChangesButton() {
		getConfirmChangesButton().click();
	}

	public WebElement getConfirmChangesButton() {
		return confirmChangesButton;
	}

	public String getConfirmChangesButtonText() {
		return getConfirmChangesButton().getAttribute(VALUE_ATTRIBUTE).trim();
	}

	// TODO white own exception
	public WebElement getAlert() {
		return isAlertPresent() ? driver.findElement(By
				.cssSelector(ALERT_CSS_SELECTOR)) : null;
	}

	public String getAlertText() {
		return getAlert().getText().trim();
	}

	public boolean isAlertPresent() {
		return !driver.findElements(By.cssSelector(ALERT_CSS_SELECTOR))
				.isEmpty();
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
