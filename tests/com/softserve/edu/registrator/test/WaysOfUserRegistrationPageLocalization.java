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

/**
 * Class for localization test on "User Registration" page
 * */
public class WaysOfUserRegistrationPageLocalization {
	private static ChromeDriverService service;
	private static WebDriver driver;
	private static final Logger LOG = Logger
			.getLogger(WaysOfUserRegistration.class);
	private static final String ADMIN_LOGIN = "admin";
	private static final String ADMIN_PASSWORD = "admin";

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

	private void logAsAdmin() {
		driver.findElement(By.name("login")).sendKeys(ADMIN_LOGIN);
		driver.findElement(By.name("password")).sendKeys(ADMIN_PASSWORD);
		driver.findElement(By.xpath("//*[@id='loginForm']/div[5]/button"))
				.click();
	}

	private void logOff() {
		driver.findElement(
				By.xpath("//*[@id='header']/div[2]/div[1]/div/button[2]/span"))
				.click();
		driver.findElement(
				By.xpath("//*[@id='header']/div[2]/div[1]/div/ul/li[4]/a"))
				.click();
	}

	@Test
	public void ukrainianLocalizationTest() {
		logAsAdmin();
		driver.findElement(By.id("changeLanguage")).click();
		driver.findElement(
				By.cssSelector("#changeLanguage > option:nth-child(1)"))
				.click();
		driver.findElement(
				By.cssSelector("#navigationbar > ul > li:nth-child(3) > a"))
				.click();
		try {
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
			Assert.assertTrue(driver
					.findElements(
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
					By.xpath("//label[contains(text(), '������ �������')]"))
					.size() > 0);
			Assert.assertTrue(driver
					.findElements(
							By.xpath("//label[contains(text(), '��') and contains(text(), '� �����������')]"))
					.size() > 0);
			Assert.assertTrue(driver.findElements(
					By.xpath("//label[contains(text(), '���� TCP')]")).size() > 0);
			Assert.assertTrue(driver.findElements(
					By.xpath("//label[contains(text(), '��������')]")).size() > 0);
			Assert.assertTrue(driver.findElements(
					By.xpath("//label[contains(text(), '������')]")).size() > 0);
			Assert.assertTrue(driver
					.findElements(
							By.xpath("//label[contains(text(), '�������� �') and contains(text(), '������� TLS')]"))
					.size() > 0);
			Assert.assertTrue(driver.findElements(
					By.xpath("//button[contains(text(), '���������')]"))
					.size() > 0);
			Assert.assertTrue(driver.findElements(
					By.xpath("//input[@value = 'ϳ��������� ����']")).size() > 0);
		} finally {
			logOff();
		}
	}

	@Test
	public void russianLocalizationTest() {
		logAsAdmin();
		driver.findElement(By.id("changeLanguage")).click();
		driver.findElement(
				By.cssSelector("#changeLanguage > option:nth-child(2)"))
				.click();
		driver.findElement(
				By.cssSelector("#navigationbar > ul > li:nth-child(3) > a"))
				.click();
		try {
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
			Assert.assertTrue(driver
					.findElements(
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
					By.xpath("//label[contains(text(), '����� �������')]"))
					.size() > 0);
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
					By.xpath("//input[@value = '����������� ���������']"))
					.size() > 0);
		} finally {
			logOff();
		}
	}

	@Test
	public void englishLocalizationTest() {
		logAsAdmin();
		driver.findElement(By.id("changeLanguage")).click();
		driver.findElement(
				By.cssSelector("#changeLanguage > option:nth-child(3)"))
				.click();
		driver.findElement(
				By.cssSelector("#navigationbar > ul > li:nth-child(3) > a"))
				.click();
		try {
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
					By.xpath("//a[contains(text(), 'Register new user')]"))
					.size() > 0);
			Assert.assertTrue(driver.findElements(
					By.xpath("//a[contains(text(), 'Unblock all coowners')]"))
					.size() > 0);
			Assert.assertTrue(driver
					.findElements(
							By.xpath("//h3[contains(text(), 'Method of registering new users')]"))
					.size() > 0);
			Assert.assertTrue(driver
					.findElements(
							By.xpath("//p[contains(text(), 'Select one of the options')]"))
					.size() > 0);
			Assert.assertTrue(driver
					.findElements(
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
					By.xpath("//h3[contains(text(), 'Default time zone')]"))
					.size() > 0);
			Assert.assertTrue(driver
					.findElements(
							By.xpath("//p[contains(text(), 'Enter city or time zone')]"))
					.size() > 0);
			Assert.assertTrue(driver.findElements(
					By.xpath("//h3[contains(text(), 'System email account')]"))
					.size() > 0);
			Assert.assertTrue(driver
					.findElements(
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
			Assert.assertTrue(driver
					.findElements(
							By.xpath("//label[contains(text(), 'TLS secure connection')]"))
					.size() > 0);
			Assert.assertTrue(driver.findElements(
					By.xpath("//button[contains(text(), 'Check')]")).size() > 0);
			Assert.assertTrue(driver.findElements(
					By.xpath("//input[@value = 'Confirm changes']")).size() > 0);
		} finally {
			logOff();
		}
	}

	@AfterClass
	public static void stopService() {
		driver.quit();
		if (service != null) {
			service.stop();
			LOG.debug("\n+++RemoteWebDriver Stop");
		}
	}
}
