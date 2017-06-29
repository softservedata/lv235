package com.softserve.edu.registrator.pages.settings;

import java.util.HashMap;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.softserve.edu.registrator.pages.ATopComponent.ChangeLanguageFields;

public class UserRegistrationOptionsComponent {

	public static enum UserRegistrationOptionsComponentL10n {
		COMPONENT_LABEL("Спосіб реєстрації нових співвласників",
				"Способ регистрации новых пользователей",
				"Method of registering new users"), OPTION_LABEL(
				"Виберіть одну з опцій", "Выберите одну из опций",
				"Select one of the options"), PERSONAL_REGISTRATION(
				"Особиста реєстрація", "Персональная регистрация",
				"Personal registration"), MANUAL_REGISTRATION(
				"Реєстрація нового співвласника здійснюється виключно уповноваженим",
				"Регистрация нового совладельца осуществляется исключительно уполномоченым",
				"Only commissioner can register new co-owner"), MIXED_REGISTRATION(
				"Обидва способи реєстрації доступні",
				"Доступны два способа регистрации",
				"Both registration method are available");

		private HashMap<ChangeLanguageFields, String> field;

		private UserRegistrationOptionsComponentL10n(String... localization) {
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

	private WebElement componentLabel;
	private WebElement optionLabel;
	private WebElement personalRegistration;
	private WebElement manualRegistration;
	private WebElement mixedRegistration;

	public UserRegistrationOptionsComponent(WebDriver driver) {
		this.componentLabel = driver.findElement(By
				.cssSelector("form div:nth-child(1) div.panel-heading h3"));
		this.optionLabel = driver.findElement(By
				.cssSelector("form div:nth-child(1) div.panel-body.panel30 p"));
		this.personalRegistration = driver.findElement(By
				.xpath("//input[@type = 'radio' and @value = 'PERSONAL']/.."));
		this.manualRegistration = driver.findElement(By
				.xpath("//input[@type = 'radio' and @value = 'MANUAL']/.."));
		this.mixedRegistration = driver.findElement(By
				.xpath("//input[@type = 'radio' and @value = 'MIXED']/.."));
	}

	public void clickPersonalRegistration() {
		personalRegistration.click();
	}

	public void clickManualRegistration() {
		getManualRegistration().click();
	}

	public void clickMixedRegistration() {
		mixedRegistration.click();
	}

	public WebElement getComponentLabel() {
		return componentLabel;
	}

	public String getComponentLabelText() {
		return getComponentLabel().getText().trim();
	}

	public WebElement getOptionLabel() {
		return optionLabel;
	}

	public String getOptionLabelText() {
		return optionLabel.getText().trim();
	}

	public WebElement getPersonalRegistration() {
		return personalRegistration;
	}

	public String getPersonalRegistrationText() {
		return getPersonalRegistration().getText().trim();
	}

	public WebElement getManualRegistration() {
		return manualRegistration;
	}

	public String getManualRegistrationText() {
		return getManualRegistration().getText().trim();
	}

	public WebElement getMixedRegistration() {
		return mixedRegistration;
	}

	public String getMixedRegistrationText() {
		return getMixedRegistration().getText().trim();
	}

}
