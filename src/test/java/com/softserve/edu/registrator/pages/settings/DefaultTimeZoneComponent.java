package com.softserve.edu.registrator.pages.settings;

import java.util.HashMap;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.softserve.edu.registrator.pages.ATopComponent.ChangeLanguageFields;

public class DefaultTimeZoneComponent {
	public static enum DefaultTimeZoneComponentL10n {
		COMPONENT_LABEL("Часовий пояс для розрахунку поточного часу",
				"Часовой пояс для расчета текущего времени",
				"Default time zone"), INNER_LABEL(
				"Введіть місто або часовий пояс",
				"Введите город или часовой пояс", "Enter city or time zone");

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
				.cssSelector("form div:nth-child(2) div.panel-heading h3"));
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
		return componentLabel.getText().trim();
	}

	public WebElement getInnerLabel() {
		return innerLabel;
	}

	public String getInnerLabelText() {
		return innerLabel.getText().trim();
	}

	public WebElement getCityOrTimeZoneInputField() {
		return cityOrTimeZoneInputField;
	}

}
