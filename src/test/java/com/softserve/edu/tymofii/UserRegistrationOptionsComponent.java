package com.softserve.edu.tymofii;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class UserRegistrationOptionsComponent {

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
				.xpath("//*[@type = 'radio' and @value = 'PERSONAL']"));
		this.manualRegistration = driver.findElement(By
				.xpath("//*[@type = 'radio' and @value = 'MANUAL']"));
		this.mixedRegistration = driver.findElement(By
				.xpath("//*[@type = 'radio' and @value = 'MIXED']"));
	}

	public void personalRegistrationClick() {
		personalRegistration.click();
	}

	public void manualRegistrationClick() {
		getManualRegistration().click();
	}

	public void mixedRegistrationClick() {
		mixedRegistration.click();
	}

	public WebElement getComponentLabel() {
		return componentLabel;
	}

	public String getComponentLabelText() {
		return componentLabel.getText();
	}

	public WebElement getOptionLabel() {
		return optionLabel;
	}

	public String getOptionLabelText() {
		return optionLabel.getText();
	}

	public WebElement getPersonalRegistration() {
		return personalRegistration;
	}

	public WebElement getManualRegistration() {
		return manualRegistration;
	}

	public WebElement getMixedRegistration() {
		return mixedRegistration;
	}

}
