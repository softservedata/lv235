package com.softserve.edu.registrator.test;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeDriverService;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;

public class Task1 {
	private static ChromeDriverService service;
	private static WebDriver driver;
	private static WebElement element;
	private static final Logger LOG = Logger.getLogger(Task1.class);

	@BeforeClass
	public static void createService() throws IOException {
		service = new ChromeDriverService.Builder()
				.usingDriverExecutable(new File("resources/chromedriver.exe"))
				.usingAnyFreePort().build();
		// .usingPort(8888).build();
		service.start();
		LOG.debug("+++Service Start");
	}

	@Before
	public void initDriver() {
		System.setProperty("webdriver.chrome.driver",
				"resources/chromedriver.exe");
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--start-maximized");
		options.addArguments("--disable-web-security");
		options.addArguments("--no-proxy-server");
		Map<String, Object> prefs = new HashMap<String, Object>();
		prefs.put("credentials_enable_service", false);
		prefs.put("profile.password_manager_enabled", false);
		options.setExperimentalOption("prefs", prefs);
		DesiredCapabilities capabilities = DesiredCapabilities.chrome();
		capabilities.setCapability(ChromeOptions.CAPABILITY, options);
		driver = new ChromeDriver(capabilities);
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		driver.get("http://java.training.local:8080/registrator/login");
	}

	private void logOff() {
		element = driver.findElement(By
				.xpath("//*[@id='header']/div[2]/div[1]/div/button[2]"));
		element.click();
		element = driver.findElement(By
				.xpath("//*[@id='header']/div[2]/div[1]/div/ul/li[4]/a"));
		element.click();
	}

	private void logAsAdmin() {
		element = driver.findElement(By.name("login"));
		element.sendKeys("tomtom");
		element = driver.findElement(By.name("password"));
		element.sendKeys("qwerty");
		element.submit();
	}

	private void logAsCommissioner() {
		element = driver.findElement(By.name("login"));
		element.sendKeys("tomutomu");
		element = driver.findElement(By.name("password"));
		element.sendKeys("qwerty");
		element.submit();
	}

	private boolean isRegisterButtonPresent() throws NoSuchElementException {
		return driver.findElement(
				By.cssSelector("#loginForm > div:nth-child(5) > a"))
				.isDisplayed();
	}

	private boolean isRegisterNewUserEnableForCommissioner() {
		return driver.findElement(
				By.cssSelector("#navigationbar > ul > li:nth-child(3) > a"))
				.isDisplayed();
	}

	@Test
	public void bothRegistrationMethodsAreAvailableTest() {
		logAsAdmin();
		element = driver.findElement(By
				.cssSelector("#navigationbar > ul > li:nth-child(3) > a"));
		element.click();
		element = driver
				.findElement(By
						.cssSelector("#ñhangeReg > div:nth-child(1) > div.panel-body.panel30 > div:nth-child(4) > label"));
		element.click();
		element = driver.findElement(By.id("confirmRegistrationMethod"));
		element.click();
		logOff();
		Assert.assertTrue(isRegisterButtonPresent());
		logAsCommissioner();
		Assert.assertTrue(isRegisterNewUserEnableForCommissioner());
	}

	@Test
	public void onlyCommissionerCanRegisterNewCoownerTest()
			throws InterruptedException {
		logAsAdmin();
		element = driver.findElement(By
				.cssSelector("#navigationbar > ul > li:nth-child(3) > a"));
		Thread.sleep(2000);
		element.click();
		element = driver
				.findElement(By
						.cssSelector("#ñhangeReg > div:nth-child(1) > div.panel-body.panel30 > div:nth-child(3) > label"));
		Thread.sleep(2000);
		element.click();
		element = driver.findElement(By.id("confirmRegistrationMethod"));
		Thread.sleep(2000);
		element.click();
		logOff();
		Thread.sleep(2000);
		Assert.assertFalse(isRegisterButtonPresent());
		Thread.sleep(2000);
		logAsCommissioner();
		Assert.assertTrue(isRegisterNewUserEnableForCommissioner());
		Thread.sleep(2000);
	}

	@Test
	public void onlyPersonalRegistrationTest() {
		logAsAdmin();
		element = driver.findElement(By
				.cssSelector("#navigationbar > ul > li:nth-child(3) > a"));
		element.click();
		element = driver
				.findElement(By
						.cssSelector("#ñhangeReg > div:nth-child(1) > div.panel-body.panel30 > div:nth-child(2) > label"));
		element.click();
		element = driver.findElement(By.id("confirmRegistrationMethod"));
		element.click();
		logOff();
		Assert.assertTrue(isRegisterButtonPresent());
		logAsCommissioner();
		Assert.assertFalse(isRegisterNewUserEnableForCommissioner());
	}

	@After
	public void stopDriver() {
		driver.quit();
	}

	@AfterClass
	public static void stopService() {
		if (service != null) {
			service.stop();
			LOG.debug("+++RemoteWebDriver Stop");
		}
	}
}
