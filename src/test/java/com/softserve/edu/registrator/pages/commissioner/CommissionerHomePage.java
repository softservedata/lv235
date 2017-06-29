package com.softserve.edu.registrator.pages.commissioner;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.softserve.edu.registrator.pages.ACommonComponent;
import com.softserve.edu.registrator.pages.AdminHomePage.CoownersOptions;

public class CommissionerHomePage extends ACommonComponent {

	private CoownersOptions coownersOptions;

	public CommissionerHomePage(WebDriver driver) {
		super(driver);
	}

	public CoownersOptions getCoownersOptions() {
		return coownersOptions;
	}

	public WebElement getRegisterNewUser() {
		return driver.findElement(By
				.xpath("//a[@href = '/registrator/manualregistration']"));
	}

	public boolean isRegisterNewUserPresent() {
		return !driver.findElements(
				By.xpath("//a[@href = '/registrator/manualregistration']"))
				.isEmpty();
	}

}
