package com.softserve.edu.volodya;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class SubclassPage {

	/**
	 * Web driver for browser.
	 */
	WebDriver driver;

	/**
	 * Constructor for class.
	 * @param driver web driver for browser.
	 */
	public SubclassPage(WebDriver driver) {
		this.driver = driver;
	}


	public WebElement getAddSubclassButton() {
		return driver.findElement(By.xpath("//*[@id='body']/p/a"));
	}

	public WebElement getSubclassName() {
		return driver.findElement(By.name("typeName"));
	}
}
