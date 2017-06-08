package com.softserve.edu.registrator.test;

import java.util.concurrent.TimeUnit;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

/**
 * Class created as a smoke test to sign in and sign off the system.
 * */
public class SmokeTest {
	/**
	 * WebDriver instance.
	 * */
	private static WebDriver driver;
	/**
	 * Constant refers to administrator's login credential.
	 * */
	private static final String ADMIN_LOGIN = "admin";
	/**
	 * Constant refers to administrator's password credential.
	 * */
	private static final String ADMIN_PASSWORD = "admin";

	/**
	 * Method does sign in and sign off actions to the system.
	 * */
	@Test
	public void smokeTest() {
		System.setProperty("webdriver.chrome.driver",
				"resources/chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		driver.get("http://java.training.local:8080/registrator/login");
		Assert.assertTrue(driver.findElements(
				By.cssSelector((".btn.btn-primary"))).size() > 0);
		driver.findElement(By.id("login")).sendKeys(ADMIN_LOGIN);
		driver.findElement(By.id("password")).sendKeys(ADMIN_PASSWORD);
		driver.findElement(By.cssSelector((".btn.btn-primary"))).click();
		Assert.assertTrue(driver.findElements(By.id(("navigationbar"))).size() > 0);
		driver.findElement(
				By.xpath("//button[@class = 'btn btn-primary btn-sm dropdown-toggle']"))
				.click();
		driver.findElement(By.xpath("//a[@href='/registrator/logout']"))
				.click();
		Assert.assertTrue(driver.findElements(
				By.cssSelector((".btn.btn-primary"))).size() > 0);
		driver.quit();
	}
}
