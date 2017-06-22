package com.softserve.edu.tymofii;

import java.util.HashMap;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.softserve.edu.registrator.pages.ATopComponent.ChangeLanguageFields;

public class DefaultTimeZoneComponent {
	public static enum DefaultTimeZoneComponentL10n {
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

		private DefaultTimeZoneComponentL10n(String... localization) {
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
	private WebElement innerLabel;
	private WebElement cityOrTimeZoneInputField;

	public DefaultTimeZoneComponent(WebDriver driver) {
		this.componentLabel = driver.findElement(By
				.cssSelector("form div:nth-child(1) div.panel-heading h3"));
		this.innerLabel = driver.findElement(By
				.cssSelector("form div:nth-child(2) div.panel-body.panel30 p"));
		this.cityOrTimeZoneInputField = driver.findElement(By
				.cssSelector("#time_id"));
	}

	public void typeInCityOrTimeZoneInputField(String text) {
		getCityOrTimeZoneInputField().sendKeys(text);
	}

	public WebElement getComponentLabel() {
		return componentLabel;
	}

	public String getComponentLabelText() {
		return componentLabel.getText();
	}

	public WebElement getInnerLabel() {
		return innerLabel;
	}

	public String getInnerLabelTest() {
		return innerLabel.getText();
	}

	public WebElement getCityOrTimeZoneInputField() {
		return cityOrTimeZoneInputField;
	}

}
