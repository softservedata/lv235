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
			Assert.assertTrue(driver
					.findElements(
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
					By.xpath("//label[contains(text(), 'Адреса сервера')]"))
					.size() > 0);
			Assert.assertTrue(driver
					.findElements(
							By.xpath("//label[contains(text(), 'Ім') and contains(text(), 'я користувача')]"))
					.size() > 0);
			Assert.assertTrue(driver.findElements(
					By.xpath("//label[contains(text(), 'Порт TCP')]")).size() > 0);
			Assert.assertTrue(driver.findElements(
					By.xpath("//label[contains(text(), 'Протокол')]")).size() > 0);
			Assert.assertTrue(driver.findElements(
					By.xpath("//label[contains(text(), 'Пароль')]")).size() > 0);
			Assert.assertTrue(driver
					.findElements(
							By.xpath("//label[contains(text(), 'Захищене з') and contains(text(), 'єднання TLS')]"))
					.size() > 0);
			Assert.assertTrue(driver.findElements(
					By.xpath("//button[contains(text(), 'Перевірити')]"))
					.size() > 0);
			Assert.assertTrue(driver.findElements(
					By.xpath("//input[@value = 'Підтвердити зміни']")).size() > 0);
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
			Assert.assertTrue(driver
					.findElements(
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
					By.xpath("//label[contains(text(), 'Адрес сервера')]"))
					.size() > 0);
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
					By.xpath("//input[@value = 'Подтвердить изменения']"))
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
