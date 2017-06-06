package com.softserve.edu.registrator.test;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.apache.log4j.Logger;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeDriverService;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;

/**
 * Class created to test the functionality of "Ways Of User Registration".
 */
// TODO change all xPath !!!!!DONE!!!!!
// TODO change all cssSelectors !!!!!DONE!!!!!
// TODO add smoke tests !!!!!DONE!!!!!
// TODO take screenshot when failure
// TODO add JAVADOCs
public class WaysOfUserRegistration {
	/**
	 * ChromeDriverService instance.
	 */
	private static ChromeDriverService service;
	/**
	 * WebDriver instance.
	 */
	private static WebDriver driver;
	/**
	 * Constant for time pattern.
	 */
	private static final String TIME_TEMPLATE = "yyyy-MM-dd_HH-mm-ss";
	/**
	 * Constant for Logger.
	 */
	private static final Logger LOG = Logger.getLogger(WaysOfUserRegistration.class);
	/**
	 * Constant refers to administrator login credential.
	 */
	private static final String ADMIN_LOGIN = "admin";
	/**
	 * Constant refers to administrator password credential.
	 */
	private static final String ADMIN_PASSWORD = "admin";
	/**
	 * Constant refers to commissioner login credential.
	 */
	private static final String COMMISSIONER_LOGIN = "NazarComis";
	/**
	 * Constant refers to commissioner password credential.
	 */
	private static final String COMMISSIONER_PASSWORD = "qwerty";
	/**
	 * SmokeTest instance.
	 */
	private static SmokeTest smokeTest = new SmokeTest();

	/**
	 * Methods creates ChromeDriverService, ChromeOptions, DesiredCapabilities,
	 * ChromeDriver.
	 */
	@BeforeClass
	public static void createService() throws IOException {
		smokeTest.smokeTest();
		service = new ChromeDriverService.Builder().usingDriverExecutable(new File("resources/chromedriver.exe"))
				.usingAnyFreePort().build();
		service.start();
		LOG.debug("+++Service Start");
		System.setProperty("webdriver.chrome.driver", "resources/chromedriver.exe");
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--start-maximized");
		options.addArguments("--disable-web-security");
		options.addArguments("--no-proxy-server");
		options.addArguments("disable-infobars");
		Map<String, Object> preferences = new HashMap<String, Object>();
		preferences.put("credentials_enable_service", false);
		preferences.put("profile.password_manager_enabled", false);
		options.setExperimentalOption("prefs", preferences);
		DesiredCapabilities capabilities = DesiredCapabilities.chrome();
		capabilities.setCapability(ChromeOptions.CAPABILITY, options);
		driver = new ChromeDriver(capabilities);
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		driver.get("http://java.training.local:8080/registrator/login");
	}

	/**
	 * Method takes screenshot.
	 */
	@SuppressWarnings("unused")
	private void takeScreenShot(final WebDriver driver) throws IOException {
		String currentTime = new SimpleDateFormat(TIME_TEMPLATE).format(new Date());
		File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(scrFile, new File("screenshots/" + currentTime + "_screenshot.png"));
	}

	/**
	 * Method does sing in actions as administrator.
	 */
	@Before
	public void logAsAdmin() throws InterruptedException {
		driver.findElement(By.id("login")).sendKeys(ADMIN_LOGIN);
		driver.findElement(By.id("password")).sendKeys(ADMIN_PASSWORD);
		driver.findElement(By.cssSelector((".btn.btn-primary"))).click();
	}

	/**
	 * Method does sing in actions as commissioner.
	 */
	private void logAsCommissioner() throws InterruptedException {
		driver.findElement(By.id("login")).sendKeys(COMMISSIONER_LOGIN);
		driver.findElement(By.id("password")).sendKeys(COMMISSIONER_PASSWORD);
		driver.findElement(By.cssSelector((".btn.btn-primary"))).click();
	}

	/**
	 * Method checks the functionality of "Both Registration Methods Are
	 * Available".
	 */
	@Test
	public void bothRegistrationMethodsAreAvailableTest() throws InterruptedException {
		driver.findElement(By.xpath("//a[@href='/registrator/administrator/settings']")).click();
		driver.findElement(By.xpath("//*[@type = 'radio' and @value = 'MIXED']")).click();
		driver.findElement(By.id("confirmRegistrationMethod")).click();
		logOff();
		Assert.assertTrue(driver.findElements(By.cssSelector((".btn.btn-success"))).size() > 0);
		logAsCommissioner();
		Assert.assertTrue(driver.findElements(By.xpath("//a[@href='/registrator/manualregistration']")).size() > 0);
	}

	/**
	 * Method checks the functionality of "Only Commissioner CanRegister New
	 * User".
	 */
	@Test
	public void onlyCommissionerCanRegisterNewUserTest() throws InterruptedException {
		driver.findElement(By.xpath("//a[@href='/registrator/administrator/settings']")).click();
		driver.findElement(By.xpath("//*[@type = 'radio' and @value = 'MANUAL']")).click();
		driver.findElement(By.id("confirmRegistrationMethod")).click();
		logOff();
		Assert.assertFalse(driver.findElements(By.cssSelector((".btn.btn-success"))).size() > 0);
		logAsCommissioner();
		Assert.assertTrue(driver.findElements(By.xpath("//a[@href='/registrator/manualregistration']")).size() > 0);
	}

	/**
	 * Method checks the functionality of "Only Personal Registration".
	 */
	@Test
	public void onlyPersonalRegistrationTest() throws InterruptedException {
		driver.findElement(By.xpath("//a[@href='/registrator/administrator/settings']")).click();
		driver.findElement(By.xpath("//*[@type = 'radio' and @value = 'PERSONAL']")).click();
		driver.findElement(By.id("confirmRegistrationMethod")).click();
		logOff();
		Assert.assertTrue(driver.findElements(By.cssSelector((".btn.btn-success"))).size() > 0);
		logAsCommissioner();
		Assert.assertFalse(driver.findElements(By.xpath("//a[@href='/registrator/manualregistration']")).size() > 0);
	}

	/**
	 * Method does sign off actions.
	 */
	@After
	public void logOff() throws InterruptedException {
		driver.findElement(By.cssSelector(".btn.btn-primary.btn-sm.dropdown-toggle")).click();
		driver.findElement(By.xpath("//a[@href='/registrator/logout']")).click();
	}

	/**
	 * Method quits the driver and stops ChromeDriverService
	 */
	@AfterClass
	public static void stopServiceAndQuit() {
		driver.quit();
		if (service != null) {
			service.stop();
			LOG.debug("\n+++RemoteWebDriver Stop");
		}
	}
}
