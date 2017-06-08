package com.softserve.edu.automatedTests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoginPage {
	
	/**
	 * Web driver for browser.
	 */
	WebDriver driver;

	/**
	 * Constructor for class.
	 * @param driver web driver for browser.
	 */
	public LoginPage(WebDriver driver) {
		this.driver = driver;
	}
	
	/**
	 * Login field on login page.
	 * @return login field.
	 */
	public WebElement getLoginField() {
		return this.driver.findElement(By.id("login"));
	}

	/**
	 * Password field on login page.
	 * @return password field.
	 */
	public WebElement getLoginPassword() {
		return this.driver.findElement(By.id("password"));
	}

	/**
	 * Login button on login field.
	 * @return login button.
	 */
	public WebElement getLoginButton() {
		return this.driver.findElement(By.cssSelector(".btn.btn-primary"));
	}

	//ErrorMsg

}
