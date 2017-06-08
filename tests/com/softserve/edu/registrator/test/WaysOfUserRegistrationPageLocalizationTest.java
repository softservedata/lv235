package com.softserve.edu.registrator.test;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Rule;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeDriverService;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;

/**
 * Class created to test localization on "Ways Of User Registration" page.
 */
public class WaysOfUserRegistrationPageLocalizationTest {
	/**
	 * ChromeDriverService instance.
	 */
	private static ChromeDriverService service;
	/**
	 * WebDriver instance.
	 */
	private static WebDriver driver;
	/**
	 * Constant for Logger.
	 */
	private static final Logger LOG = Logger
			.getLogger(WaysOfUserRegistrationPageLocalizationTest.class);
	/**
	 * Constant refers to administrator login credential.
	 */
	private static final String ADMIN_LOGIN = "admin";
	/**
	 * Constant refers to administrator password credential.
	 */
	private static final String ADMIN_PASSWORD = "admin";
	/**
	 * Constant for Thread.sleep().
	 */
	private static final int PAUSE_MILLS = 1200;

	/**
	 * Rule to take screenshot when test fails.
	 * */
	@Rule
	public ScreenShotOnFailure failure = new ScreenShotOnFailure(driver);

	/**
	 * Methods creates ChromeDriverService, ChromeOptions, DesiredCapabilities,
	 * ChromeDriver.
	 */
	@BeforeClass
	public static void createService() throws IOException, InterruptedException {
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
		options.addArguments("disable-infobars");
		Map<String, Object> preferences = new HashMap<String, Object>();
		preferences.put("credentials_enable_service", false);
		preferences.put("profile.password_manager_enabled", false);
		options.setExperimentalOption("preferences", preferences);
		DesiredCapabilities capabilities = DesiredCapabilities.chrome();
		capabilities.setCapability(ChromeOptions.CAPABILITY, options);
		driver = new ChromeDriver(capabilities);
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		driver.get("http://java.training.local:8080/registrator/login");
	}

	/**
	 * Method does sing in actions as administrator.
	 */
	@Before
	public void logAsAdmin() throws InterruptedException {
		driver.findElement(By.id("login")).clear();
		driver.findElement(By.id("login")).sendKeys(ADMIN_LOGIN);
		Thread.sleep(PAUSE_MILLS);
		driver.findElement(By.id("password")).clear();
		driver.findElement(By.id("password")).sendKeys(ADMIN_PASSWORD);
		Thread.sleep(PAUSE_MILLS);
		driver.findElement(By.cssSelector((".btn.btn-primary"))).click();
	}

	/**
	 * Method checks Ukrainian localization.
	 * 
	 * @throws IOException
	 */
	@Test
	public void ukrainianLocalizationTest() throws InterruptedException {
		Thread.sleep(PAUSE_MILLS);
		driver.findElement(By.id("changeLanguage")).click();
		Thread.sleep(PAUSE_MILLS);
		driver.findElement(
				By.cssSelector("#changeLanguage > option[value='uk']")).click();
		Thread.sleep(PAUSE_MILLS);
		driver.findElement(
				By.xpath("//a[@href='/registrator/administrator/settings']"))
				.click();
		Thread.sleep(PAUSE_MILLS);
		Assert.assertTrue(driver
				.findElements(
						By.xpath("//h3[contains(text(), '���������������� �������� �����')]"))
				.size() > 0);
		Assert.assertTrue(driver
				.findElements(
						By.xpath("//h3[contains(text(), '��������� ������� ������')]"))
				.size() > 0);
		Assert.assertTrue(driver.findElements(
				By.xpath("//a[contains(text(), '�����������')]")).size() > 0);
		Assert.assertTrue(driver.findElements(
				By.xpath("//a[contains(text(), '������������')]")).size() > 0);
		Assert.assertTrue(driver.findElements(
				By.xpath("//a[contains(text(), '�������')]")).size() > 0);
		Assert.assertTrue(driver
				.findElements(
						By.xpath("//a[contains(text(), '������������ �����������')]"))
				.size() > 0);
		Assert.assertTrue(driver
				.findElements(
						By.xpath("//a[contains(text(), '������������ ��� �����������')]"))
				.size() > 0);
		Assert.assertTrue(driver
				.findElements(
						By.xpath("//h3[contains(text(), '����� ��������� ����� �����������')]"))
				.size() > 0);
		Assert.assertTrue(driver.findElements(
				By.xpath("//p[contains(text(), '������� ���� � �����')]"))
				.size() > 0);
		Assert.assertTrue(driver.findElements(
				By.xpath("//label[contains(text(), '�������� ���������')]"))
				.size() > 0);
		Assert.assertTrue(driver
				.findElements(
						By.xpath("//label[contains(text(), '��������� ������ ����������� ����������� �������� �������������')]"))
				.size() > 0);
		Assert.assertTrue(driver
				.findElements(
						By.xpath("//label[contains(text(), '������ ������� ��������� �������')]"))
				.size() > 0);
		Assert.assertTrue(driver
				.findElements(
						By.xpath("//h3[contains(text(), '������� ���� ��� ���������� ��������� ����')]"))
				.size() > 0);
		Assert.assertTrue(driver
				.findElements(
						By.xpath("//p[contains(text(), '������ ���� ��� ������� ����')]"))
				.size() > 0);
		Assert.assertTrue(driver
				.findElements(
						By.xpath("//h3[contains(text(), '������������ ���������� ���������� �����')]"))
				.size() > 0);
		Assert.assertTrue(driver.findElements(
				By.xpath("//label[contains(text(), '������ �������')]")).size() > 0);
		Assert.assertTrue(driver.findElements(
				By.xpath("//label[contains(text(), \"��'� �����������\")]"))
				.size() > 0);
		Assert.assertTrue(driver.findElements(
				By.xpath("//label[contains(text(), '���� TCP')]")).size() > 0);
		Assert.assertTrue(driver.findElements(
				By.xpath("//label[contains(text(), '��������')]")).size() > 0);
		Assert.assertTrue(driver.findElements(
				By.xpath("//label[contains(text(), '������')]")).size() > 0);
		Assert.assertTrue(driver
				.findElements(
						By.xpath("//label[contains(text(), \"�������� �'������� TLS\")]"))
				.size() > 0);
		Assert.assertTrue(driver.findElements(
				By.xpath("//button[contains(text(), '���������')]")).size() > 0);
		Assert.assertTrue(driver.findElements(
				By.xpath("//input[@value = 'ϳ��������� ����']")).size() > 0);
	}

	/**
	 * Method checks Russian localization.
	 */
	@Test
	public void russianLocalizationTest() throws InterruptedException {
		Thread.sleep(PAUSE_MILLS);
		driver.findElement(By.id("changeLanguage")).click();
		Thread.sleep(PAUSE_MILLS);
		driver.findElement(
				By.cssSelector("#changeLanguage > option[value='ru']")).click();
		Thread.sleep(PAUSE_MILLS);
		driver.findElement(
				By.xpath("//a[@href='/registrator/administrator/settings']"))
				.click();
		Thread.sleep(PAUSE_MILLS);
		Assert.assertTrue(driver
				.findElements(
						By.xpath("//h3[contains(text(), '�������������������� ������������� ������')]"))
				.size() > 0);
		Assert.assertTrue(driver
				.findElements(
						By.xpath("//h3[contains(text(), '��������� �������� �������')]"))
				.size() > 0);
		Assert.assertTrue(driver.findElements(
				By.xpath("//a[contains(text(), '�����������')]")).size() > 0);
		Assert.assertTrue(driver.findElements(
				By.xpath("//a[contains(text(), '���������')]")).size() > 0);
		Assert.assertTrue(driver.findElements(
				By.xpath("//a[contains(text(), '������')]")).size() > 0);
		Assert.assertTrue(driver
				.findElements(
						By.xpath("//a[contains(text(), '���������������� ������������')]"))
				.size() > 0);
		Assert.assertTrue(driver
				.findElements(
						By.xpath("//a[contains(text(), '������������ ���� ������������')]"))
				.size() > 0);
		Assert.assertTrue(driver
				.findElements(
						By.xpath("//h3[contains(text(), '������ ����������� ����� �������������')]"))
				.size() > 0);
		Assert.assertTrue(driver.findElements(
				By.xpath("//p[contains(text(), '�������� ���� �� �����')]"))
				.size() > 0);
		Assert.assertTrue(driver
				.findElements(
						By.xpath("//label[contains(text(), '������������ �����������')]"))
				.size() > 0);
		Assert.assertTrue(driver
				.findElements(
						By.xpath("//label[contains(text(), '����������� ������ ����������� �������������� ������������� �������������')]"))
				.size() > 0);
		Assert.assertTrue(driver
				.findElements(
						By.xpath("//label[contains(text(), '�������� ��� ������� �����������')]"))
				.size() > 0);

		Assert.assertTrue(driver
				.findElements(
						By.xpath("//h3[contains(text(), '������� ���� ��� ������� �������� �������')]"))
				.size() > 0);
		Assert.assertTrue(driver
				.findElements(
						By.xpath("//p[contains(text(), '������� ����� ��� ������� ����')]"))
				.size() > 0);
		Assert.assertTrue(driver
				.findElements(
						By.xpath("//h3[contains(text(), '��������� �������� ����������� �����')]"))
				.size() > 0);
		Assert.assertTrue(driver.findElements(
				By.xpath("//label[contains(text(), '����� �������')]")).size() > 0);
		Assert.assertTrue(driver.findElements(
				By.xpath("//label[contains(text(), '��� ������������')]"))
				.size() > 0);
		Assert.assertTrue(driver.findElements(
				By.xpath("//label[contains(text(), '���� TCP')]")).size() > 0);
		Assert.assertTrue(driver.findElements(
				By.xpath("//label[contains(text(), '��������')]")).size() > 0);
		Assert.assertTrue(driver.findElements(
				By.xpath("//label[contains(text(), '������')]")).size() > 0);
		Assert.assertTrue(driver
				.findElements(
						By.xpath("//label[contains(text(), '���������� ���������� TLS')]"))
				.size() > 0);
		Assert.assertTrue(driver.findElements(
				By.xpath("//button[contains(text(), '���������')]")).size() > 0);
		Assert.assertTrue(driver.findElements(
				By.xpath("//input[@value = '����������� ���������']")).size() > 0);
	}

	/**
	 * Method checks English localization.
	 */
	@Test
	public void englishLocalizationTest() throws InterruptedException {
		Thread.sleep(PAUSE_MILLS);
		driver.findElement(By.id("changeLanguage")).click();
		Thread.sleep(PAUSE_MILLS);
		driver.findElement(
				By.cssSelector("#changeLanguage > option[value='en']")).click();
		Thread.sleep(PAUSE_MILLS);
		driver.findElement(
				By.xpath("//a[@href='/registrator/administrator/settings']"))
				.click();
		Thread.sleep(PAUSE_MILLS);
		Assert.assertTrue(driver
				.findElements(
						By.xpath("//h3[contains(text(), 'Decentralized registry of')]"))
				.size() > 0);
		Assert.assertTrue(driver
				.findElements(
						By.xpath("//h3[contains(text(), 'Ukrainian natural resources')]"))
				.size() > 0);
		Assert.assertTrue(driver.findElements(
				By.xpath("//a[contains(text(), 'Coowners')]")).size() > 0);
		Assert.assertTrue(driver.findElements(
				By.xpath("//a[contains(text(), 'Settings')]")).size() > 0);
		Assert.assertTrue(driver.findElements(
				By.xpath("//a[contains(text(), 'Communities')]")).size() > 0);
		Assert.assertTrue(driver.findElements(
				By.xpath("//a[contains(text(), 'Register new user')]")).size() > 0);
		Assert.assertTrue(driver.findElements(
				By.xpath("//a[contains(text(), 'Unblock all coowners')]"))
				.size() > 0);
		Assert.assertTrue(driver
				.findElements(
						By.xpath("//h3[contains(text(), 'Method of registering new users')]"))
				.size() > 0);
		Assert.assertTrue(driver.findElements(
				By.xpath("//p[contains(text(), 'Select one of the options')]"))
				.size() > 0);
		Assert.assertTrue(driver.findElements(
				By.xpath("//label[contains(text(), 'Personal registration')]"))
				.size() > 0);
		Assert.assertTrue(driver
				.findElements(
						By.xpath("//label[contains(text(), 'Only commissioner can register new co-owner')]"))
				.size() > 0);
		Assert.assertTrue(driver
				.findElements(
						By.xpath("//label[contains(text(), 'Both registration method are available')]"))
				.size() > 0);
		Assert.assertTrue(driver.findElements(
				By.xpath("//h3[contains(text(), 'Default time zone')]")).size() > 0);
		Assert.assertTrue(driver.findElements(
				By.xpath("//p[contains(text(), 'Enter city or time zone')]"))
				.size() > 0);
		Assert.assertTrue(driver.findElements(
				By.xpath("//h3[contains(text(), 'System email account')]"))
				.size() > 0);
		Assert.assertTrue(driver.findElements(
				By.xpath("//label[contains(text(), 'Email server address')]"))
				.size() > 0);
		Assert.assertTrue(driver.findElements(
				By.xpath("//label[contains(text(), 'User name')]")).size() > 0);
		Assert.assertTrue(driver.findElements(
				By.xpath("//label[contains(text(), 'TCP port')]")).size() > 0);
		Assert.assertTrue(driver.findElements(
				By.xpath("//label[contains(text(), 'Protocol')]")).size() > 0);
		Assert.assertTrue(driver.findElements(
				By.xpath("//label[contains(text(), 'Password')]")).size() > 0);
		Assert.assertTrue(driver.findElements(
				By.xpath("//label[contains(text(), 'TLS secure connection')]"))
				.size() > 0);
		Assert.assertTrue(driver.findElements(
				By.xpath("//button[contains(text(), 'Check')]")).size() > 0);
		Assert.assertTrue(driver.findElements(
				By.xpath("//input[@value = 'Confirm changes']")).size() > 0);
	}

	/**
	 * Method does sign off actions.
	 */
	@After
	public void logOff() throws InterruptedException {
		driver.findElement(
				By.cssSelector(".btn.btn-primary.btn-sm.dropdown-toggle"))
				.click();
		Thread.sleep(PAUSE_MILLS);
		driver.findElement(By.xpath("//a[@href='/registrator/logout']"))
				.click();
	}

	/**
	 * Method quits the driver and stops ChromeDriverService.
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
