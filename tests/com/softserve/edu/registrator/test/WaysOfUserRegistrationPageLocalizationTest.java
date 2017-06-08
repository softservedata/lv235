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
						By.xpath("//h3[contains(text(), 'Децентралізований майновий реєстр')]"))
				.size() > 0);
		Assert.assertTrue(driver
				.findElements(
						By.xpath("//h3[contains(text(), 'природних ресурсів України')]"))
				.size() > 0);
		Assert.assertTrue(driver.findElements(
				By.xpath("//a[contains(text(), 'Співвласники')]")).size() > 0);
		Assert.assertTrue(driver.findElements(
				By.xpath("//a[contains(text(), 'Налаштування')]")).size() > 0);
		Assert.assertTrue(driver.findElements(
				By.xpath("//a[contains(text(), 'Громади')]")).size() > 0);
		Assert.assertTrue(driver
				.findElements(
						By.xpath("//a[contains(text(), 'Зареєструвати співвласника')]"))
				.size() > 0);
		Assert.assertTrue(driver
				.findElements(
						By.xpath("//a[contains(text(), 'Розблокувати всіх співвласників')]"))
				.size() > 0);
		Assert.assertTrue(driver
				.findElements(
						By.xpath("//h3[contains(text(), 'Спосіб реєстрації нових співвласників')]"))
				.size() > 0);
		Assert.assertTrue(driver.findElements(
				By.xpath("//p[contains(text(), 'Виберіть одну з опцій')]"))
				.size() > 0);
		Assert.assertTrue(driver.findElements(
				By.xpath("//label[contains(text(), 'Особиста реєстрація')]"))
				.size() > 0);
		Assert.assertTrue(driver
				.findElements(
						By.xpath("//label[contains(text(), 'Реєстрація нового співвласника здійснюється виключно уповноваженим')]"))
				.size() > 0);
		Assert.assertTrue(driver
				.findElements(
						By.xpath("//label[contains(text(), 'Обидва способи реєстрації доступні')]"))
				.size() > 0);
		Assert.assertTrue(driver
				.findElements(
						By.xpath("//h3[contains(text(), 'Часовий пояс для розрахунку поточного часу')]"))
				.size() > 0);
		Assert.assertTrue(driver
				.findElements(
						By.xpath("//p[contains(text(), 'Введіть місто або часовий пояс')]"))
				.size() > 0);
		Assert.assertTrue(driver
				.findElements(
						By.xpath("//h3[contains(text(), 'Налаштування надсилання електронної пошти')]"))
				.size() > 0);
		Assert.assertTrue(driver.findElements(
				By.xpath("//label[contains(text(), 'Адреса сервера')]")).size() > 0);
		Assert.assertTrue(driver.findElements(
				By.xpath("//label[contains(text(), \"Ім'я користувача\")]"))
				.size() > 0);
		Assert.assertTrue(driver.findElements(
				By.xpath("//label[contains(text(), 'Порт TCP')]")).size() > 0);
		Assert.assertTrue(driver.findElements(
				By.xpath("//label[contains(text(), 'Протокол')]")).size() > 0);
		Assert.assertTrue(driver.findElements(
				By.xpath("//label[contains(text(), 'Пароль')]")).size() > 0);
		Assert.assertTrue(driver
				.findElements(
						By.xpath("//label[contains(text(), \"Захищене з'єднання TLS\")]"))
				.size() > 0);
		Assert.assertTrue(driver.findElements(
				By.xpath("//button[contains(text(), 'Перевірити')]")).size() > 0);
		Assert.assertTrue(driver.findElements(
				By.xpath("//input[@value = 'Підтвердити зміни']")).size() > 0);
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
						By.xpath("//h3[contains(text(), 'Децентрализированный имущественный реестр')]"))
				.size() > 0);
		Assert.assertTrue(driver
				.findElements(
						By.xpath("//h3[contains(text(), 'природных ресурсов Украины')]"))
				.size() > 0);
		Assert.assertTrue(driver.findElements(
				By.xpath("//a[contains(text(), 'Совладельцы')]")).size() > 0);
		Assert.assertTrue(driver.findElements(
				By.xpath("//a[contains(text(), 'Настройки')]")).size() > 0);
		Assert.assertTrue(driver.findElements(
				By.xpath("//a[contains(text(), 'Общины')]")).size() > 0);
		Assert.assertTrue(driver
				.findElements(
						By.xpath("//a[contains(text(), 'Зарегистрировать пользователя')]"))
				.size() > 0);
		Assert.assertTrue(driver
				.findElements(
						By.xpath("//a[contains(text(), 'Разблокивать всех совладельцев')]"))
				.size() > 0);
		Assert.assertTrue(driver
				.findElements(
						By.xpath("//h3[contains(text(), 'Способ регистрации новых пользователей')]"))
				.size() > 0);
		Assert.assertTrue(driver.findElements(
				By.xpath("//p[contains(text(), 'Выберите одну из опций')]"))
				.size() > 0);
		Assert.assertTrue(driver
				.findElements(
						By.xpath("//label[contains(text(), 'Персональная регистрация')]"))
				.size() > 0);
		Assert.assertTrue(driver
				.findElements(
						By.xpath("//label[contains(text(), 'Регистрация нового совладельца осуществляется исключительно уполномоченым')]"))
				.size() > 0);
		Assert.assertTrue(driver
				.findElements(
						By.xpath("//label[contains(text(), 'Доступны два способа регистрации')]"))
				.size() > 0);

		Assert.assertTrue(driver
				.findElements(
						By.xpath("//h3[contains(text(), 'Часовой пояс для расчета текущего времени')]"))
				.size() > 0);
		Assert.assertTrue(driver
				.findElements(
						By.xpath("//p[contains(text(), 'Введите город или часовой пояс')]"))
				.size() > 0);
		Assert.assertTrue(driver
				.findElements(
						By.xpath("//h3[contains(text(), 'Настройки отправки электронной почты')]"))
				.size() > 0);
		Assert.assertTrue(driver.findElements(
				By.xpath("//label[contains(text(), 'Адрес сервера')]")).size() > 0);
		Assert.assertTrue(driver.findElements(
				By.xpath("//label[contains(text(), 'Имя пользователя')]"))
				.size() > 0);
		Assert.assertTrue(driver.findElements(
				By.xpath("//label[contains(text(), 'Порт TCP')]")).size() > 0);
		Assert.assertTrue(driver.findElements(
				By.xpath("//label[contains(text(), 'Протокол')]")).size() > 0);
		Assert.assertTrue(driver.findElements(
				By.xpath("//label[contains(text(), 'Пароль')]")).size() > 0);
		Assert.assertTrue(driver
				.findElements(
						By.xpath("//label[contains(text(), 'Защищенное соединение TLS')]"))
				.size() > 0);
		Assert.assertTrue(driver.findElements(
				By.xpath("//button[contains(text(), 'Проверить')]")).size() > 0);
		Assert.assertTrue(driver.findElements(
				By.xpath("//input[@value = 'Подтвердить изменения']")).size() > 0);
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
