package com.softserve.edu.tymofii;

import java.util.concurrent.TimeUnit;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class UserRegistrationOptionsTest {

	@Test
	public void adminLogin2() throws Exception {
		System.setProperty("webdriver.chrome.driver",
				"F:/SoftServe/javaWorkspace/app2/lv235/src/test/resources/lib/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		driver.get("http://java.training.local:8080/registrator/login");
		driver.findElement(By.id("login")).click();
		driver.findElement(By.id("login")).clear();
		driver.findElement(By.id("login")).sendKeys("admin");
		driver.findElement(By.id("password")).click();
		driver.findElement(By.id("password")).clear();
		driver.findElement(By.id("password")).sendKeys("admin");
		driver.findElement(By.cssSelector(".btn.btn-primary")).click();
		driver.findElement(
				By.xpath("//a[@href='/registrator/administrator/settings']"))
				.click();
		SettingsPage s = new SettingsPage(driver);
		s.getUserRegistrationOptionsComponent().manualRegistrationClick();
		s.confirmChangesButtonClick();
		Thread.sleep(1000);
		Assert.assertTrue(driver.findElements(
				By.cssSelector("alert.alert-success.span")).size() > 0);
		driver.quit();
	}
}
