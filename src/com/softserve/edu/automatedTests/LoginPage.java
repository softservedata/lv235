package com.softserve.edu.automatedTests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoginPage {

	WebDriver driver;

	public LoginPage(WebDriver driver) {
		this.driver = driver;
	}

	public WebElement getLoginField() {
		return this.driver.findElement(By.id("login"));
	}

	public WebElement getLoginPassword() {
		return this.driver.findElement(By.id("password"));
	}

	public WebElement getLoginButton() {
		return this.driver.findElement(By.cssSelector(".btn.btn-primary"));
	}

	//ErrorMsg





}
