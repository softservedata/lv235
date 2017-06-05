package com.softserve.edu.registrator.test;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeDriverService;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;

public class WaysOfUserRegistration {
	private static ChromeDriverService service;
	private static WebDriver driver;
	private static final Logger LOG = Logger
			.getLogger(WaysOfUserRegistration.class);
	private static final String ADMIN_LOGIN = "admin";
	private static final String ADMIN_PASSWORD = "admin";
	private static final String COMMISSIONER_LOGIN = "NazarComis";
	private static final String COMMISSIONER_PASSWORD = "qwerty";

	@BeforeClass
	public static void createService() throws IOException {
		service = new ChromeDriverService.Builder()
				.usingDriverExecutable(new File("resources/chromedriver.exe"))
				.usingAnyFreePort().build();
		service.start();
		LOG.debug("+++Service Start");
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
		driver.findElement(
				By.xpath("//*[@id='header']/div[2]/div[1]/div/button[2]"))
				.click();
		driver.findElement(
				By.xpath("//*[@id='header']/div[2]/div[1]/div/ul/li[4]/a"))
				.click();
	}

	private void logAsAdmin() {
		driver.findElement(By.name("login")).sendKeys(ADMIN_LOGIN);
		driver.findElement(By.name("password")).sendKeys(ADMIN_PASSWORD);
		driver.findElement(By.xpath("//*[@id='loginForm']/div[5]/button"))
				.click();
	}

	private void logAsCommissioner() {
		driver.findElement(By.name("login")).sendKeys(COMMISSIONER_LOGIN);
		driver.findElement(By.name("password")).sendKeys(COMMISSIONER_PASSWORD);
		driver.findElement(By.xpath("//*[@id='loginForm']/div[5]/button"))
				.click();
	}

	@Test
	public void bothRegistrationMethodsAreAvailableTest() {
		logAsAdmin();
		driver.findElement(
				By.cssSelector("#navigationbar > ul > li:nth-child(3) > a"))
				.click();
		driver.findElement(
				By.cssSelector("#ñhangeReg > div:nth-child(1) > div.panel-body.panel30 > div:nth-child(4) > label"))
				.click();
		driver.findElement(By.id("confirmRegistrationMethod")).click();
		logOff();
		Assert.assertTrue(driver.findElements(
				By.cssSelector("#loginForm > div:nth-child(5) > a")).size() > 0);
		logAsCommissioner();
		Assert.assertTrue(driver.findElements(
				By.cssSelector("#navigationbar > ul > li:nth-child(3) > a"))
				.size() > 0);
		logOff();
	}

	@Test
	public void onlyCommissionerCanRegisterNewCoownerTest()
			throws InterruptedException {
		logAsAdmin();
		driver.findElement(
				By.cssSelector("#navigationbar > ul > li:nth-child(3) > a"))
				.click();
		driver.findElement(
				By.cssSelector("#ñhangeReg > div:nth-child(1) > div.panel-body.panel30 > div:nth-child(3) > label"))
				.click();
		driver.findElement(By.id("confirmRegistrationMethod")).click();
		logOff();
		Assert.assertFalse(driver.findElements(
				By.cssSelector("#loginForm > div:nth-child(5) > a")).size() > 0);
		logAsCommissioner();
		Assert.assertTrue(driver.findElements(
				By.cssSelector("#navigationbar > ul > li:nth-child(3) > a"))
				.size() > 0);
		logOff();
	}

	@Test
	public void onlyPersonalRegistrationTest() {
		logAsAdmin();
		driver.findElement(
				By.cssSelector("#navigationbar > ul > li:nth-child(3) > a"))
				.click();
		driver.findElement(
				By.cssSelector("#ñhangeReg > div:nth-child(1) > div.panel-body.panel30 > div:nth-child(2) > label"))
				.click();
		driver.findElement(By.id("confirmRegistrationMethod")).click();
		logOff();
		Assert.assertTrue(driver.findElements(
				By.cssSelector("#loginForm > div:nth-child(5) > a")).size() > 0);
		logAsCommissioner();
		Assert.assertFalse(driver.findElements(
				By.cssSelector("#navigationbar > ul > li:nth-child(3) > a"))
				.size() > 0);
		logOff();
	}

	@AfterClass
	public static void stopService() {
		driver.quit();
		if (service != null) {
			service.stop();
			LOG.debug("+++RemoteWebDriver Stop");
		}
	}
}
