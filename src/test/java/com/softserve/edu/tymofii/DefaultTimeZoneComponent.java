package com.softserve.edu.tymofii;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class DefaultTimeZoneComponent {

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
