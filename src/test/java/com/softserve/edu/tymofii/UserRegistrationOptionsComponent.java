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
		// this.componentLabel = driver
		// .findElement(By
		//				.xpath("//h3[contains(text(), 'Method of registering new users')]"));
		// this.optionLabel = driver.findElement(By
		//		.xpath("//p[contains(text(),'Select one of the options')]"));
		this.personalRegistration = driver.findElement(By
				.xpath("//*[@type = 'radio' and @value = 'PERSONAL']"));
		this.manualRegistration = driver.findElement(By
				.xpath("//*[@type = 'radio' and @value = 'MANUAL']"));
		this.mixedRegistration = driver.findElement(By
				.xpath("//*[@type = 'radio' and @value = 'MIXED']"));
	}

	public void setPersonalRegistration() {
		personalRegistration.click();
	}

	public void setManualRegistration() {
		getManualRegistration().click();
	}

	public void setMixedRegistration() {
		mixedRegistration.click();
	}

	public WebElement getComponentLabel() {
		return componentLabel;
	}

	public WebElement getOptionLabel() {
		return optionLabel;
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
