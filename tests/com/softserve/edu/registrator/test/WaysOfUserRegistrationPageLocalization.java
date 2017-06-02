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

public class WaysOfUserRegistrationPageLocalization {
	private static ChromeDriverService service;
	private static WebDriver driver;
	private static final Logger LOG = Logger.getLogger(WaysOfUserRegistration.class);
	private static final String ADMIN_LOGIN = "admin";
	private static final String ADMIN_PASSWORD = "admin";

	@BeforeClass
	public static void createService() throws IOException {
		service = new ChromeDriverService.Builder().usingDriverExecutable(new File("resources/chromedriver.exe"))
				.usingAnyFreePort().build();
		// .usingPort(8888).build();
		service.start();
		LOG.debug("+++Service Start");
		System.setProperty("webdriver.chrome.driver", "resources/chromedriver.exe");
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

	private void logAsAdmin() {
		driver.findElement(By.name("login")).sendKeys(ADMIN_LOGIN);
		driver.findElement(By.name("password")).sendKeys(ADMIN_PASSWORD);
		driver.findElement(By.xpath("//*[@id='loginForm']/div[5]/button")).click();
	}

	private void logOff() {
		driver.findElement(By.xpath("//*[@id='header']/div[2]/div[1]/div/button[2]")).click();
		driver.findElement(By.xpath("//*[@id='header']/div[2]/div[1]/div/ul/li[4]/a")).click();
	}

	@Test
	public void EnglishLocalizationTest() throws InterruptedException {
		logAsAdmin();
		driver.findElement(By.cssSelector("#navigationbar > ul > li:nth-child(3) > a")).click();
		driver.findElement(By.id("changeLanguage")).click();
		driver.findElement(By.cssSelector("#changeLanguage > option:nth-child(3)")).click();
		Assert.assertTrue(
				driver.findElements(By.xpath("//h3[contains(text(), 'Decentralized registry of')]")).size() > 0);
		Assert.assertTrue(
				driver.findElements(By.xpath("//h3[contains(text(), 'Ukrainian natural resources')]")).size() > 0);
		Assert.assertTrue(driver.findElements(By.xpath("//a[contains(text(), 'Coowners')]")).size() > 0);
		Assert.assertTrue(driver.findElements(By.xpath("//a[contains(text(), 'Settings')]")).size() > 0);
		Assert.assertTrue(driver.findElements(By.xpath("//a[contains(text(), 'Communities')]")).size() > 0);
		Assert.assertTrue(driver.findElements(By.xpath("//a[contains(text(), 'Register new user')]")).size() > 0);
		Assert.assertTrue(driver.findElements(By.xpath("//a[contains(text(), 'Unblock all coowners')]")).size() > 0);
		Assert.assertTrue(
				driver.findElements(By.xpath("//h3[contains(text(), 'Method of registering new users')]")).size() > 0);
		Assert.assertTrue(
				driver.findElements(By.xpath("//label[contains(text(), 'Personal registration')]")).size() > 0);
		Assert.assertTrue(driver
				.findElements(By.xpath("//label[contains(text(), 'Only commissioner can register new co-owner')]"))
				.size() > 0);
		Assert.assertTrue(
				driver.findElements(By.xpath("//label[contains(text(), 'Both registration method are available')]"))
						.size() > 0);
		Assert.assertTrue(driver.findElements(By.xpath("//h3[contains(text(), 'Default time zone')]")).size() > 0);

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
