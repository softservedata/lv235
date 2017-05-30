package com.softserve.edu.automatedTests;

import java.util.concurrent.TimeUnit;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class AutomatedTests {

	/**
	 * Thread.sleep() Use only for DEMO! This test will CREATE a new subclass.
	 */
	@Test
	public void testCreate() throws Exception {
		// init
		System.setProperty("webdriver.chrome.driver", "./lib/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		driver.get("http://java.training.local:8080/registrator");
		Thread.sleep(1000);
		// login
		driver.findElement(By.id("login")).click();
		driver.findElement(By.id("login")).clear();
		driver.findElement(By.id("login")).sendKeys("regist");
		Thread.sleep(1000);
		driver.findElement(By.id("password")).click();
		driver.findElement(By.id("password")).clear();
		driver.findElement(By.id("password")).sendKeys("111111");
		Thread.sleep(1000);
		driver.findElement(By.cssSelector(".btn.btn-primary")).click();
		Thread.sleep(1000);
		// Subclass
		driver.findElement(By.linkText("Підкласи об'єктів")).click();
		Thread.sleep(1000);
		driver.findElement(By.linkText("Додати новий підклас")).click();
		Thread.sleep(1000);
		driver.findElement(By.name("typeName")).click();
		driver.findElement(By.name("typeName")).sendKeys("Wifi");
		Thread.sleep(1000);
		driver.findElement(By.id("clickmeshow")).click();
		Thread.sleep(1000);
		driver.findElement(By.name("parameters[0].description")).click();
		driver.findElement(By.name("parameters[0].description")).sendKeys("Frequency");
		Thread.sleep(1000);
		driver.findElement(By.name("parameters[0].unitName")).click();
		driver.findElement(By.name("parameters[0].unitName")).sendKeys("GGz");
		Thread.sleep(1000);
		driver.findElement(By.name("parameters[0].parametersType")).click();
		driver.findElement(By.cssSelector("*[value='discreteParameters']")).click();
		driver.findElement(By.id("btnAdd")).click();
		Thread.sleep(1000);
		driver.findElement(By.name("parameters[1].description")).click();
		driver.findElement(By.name("parameters[1].description")).sendKeys("Channel");
		Thread.sleep(1000);
		driver.findElement(By.name("parameters[1].unitName")).click();
		driver.findElement(By.name("parameters[1].unitName")).sendKeys("ch");
		Thread.sleep(1000);
		driver.findElement(By.name("parameters[1].parametersType")).click();
		WebElement dropdown2 = driver.findElement(By.cssSelector("#input2 #myparam2"));
		dropdown2.findElement(By.cssSelector("*[value='linearParameters']")).click();
		driver.findElement(By.id("valid")).click();
		Thread.sleep(1000);
		Assert.assertNotNull(driver.findElement(By.xpath(".//*[@id='datatable']//td[contains(.,'Wifi')]")).getText());
		Thread.sleep(1000);
		// exit
		driver.findElement(By.cssSelector(".btn.btn-primary.btn-sm.dropdown-toggle")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("//a[contains(@href,'/logout')]")).click();
		Thread.sleep(1000);
		Assert.assertTrue(driver.findElement(By.cssSelector("img")).getAttribute("src").contains("/ukraine_logo2.gif"));
		Thread.sleep(1000);
		driver.quit();
	}

	/**
	 * Thread.sleep() Use only for DEMO!
	 * This test will CREATE a new subclass.
	 */
	@Test
	public void testDelete() throws Exception {
		//init
		System.setProperty("webdriver.chrome.driver", "./lib/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		driver.get("http://java.training.local:8080/registrator");
		Thread.sleep(1000);
		// login
		driver.findElement(By.id("login")).click();
		driver.findElement(By.id("login")).clear();
		driver.findElement(By.id("login")).sendKeys("regist");
		Thread.sleep(1000);
		driver.findElement(By.id("password")).click();
		driver.findElement(By.id("password")).clear();
		driver.findElement(By.id("password")).sendKeys("111111");
		Thread.sleep(1000);
		driver.findElement(By.cssSelector(".btn.btn-primary")).click();
		Thread.sleep(1000);
		//Delete
		driver.findElement(By.linkText("Підкласи об'єктів")).click();
		Thread.sleep(1000);
		Assert.assertNotNull(driver.findElement(By.xpath(".//*[@id='datatable']//td[contains(.,'Wifi')]")).getText());
		driver.findElement(By.xpath(".//*[@id='datatable']//td[contains(.,'Wifi')]/../td[6]/div/a")).click();
		Thread.sleep(1000);
		driver.findElement(By.cssSelector(".bootbox.modal.fade.bootbox-confirm.in")).findElement(By.cssSelector(".btn.btn-primary")).click();
		Thread.sleep(1000);
		//Assert.assertNull(driver.findElement(By.xpath(".//*[@id='datatable']//td[contains(.,'Wifi')]")).getText());
		// exit
		driver.findElement(By.cssSelector(".btn.btn-primary.btn-sm.dropdown-toggle")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("//a[contains(@href,'/logout')]")).click();
		Thread.sleep(1000);
		Assert.assertTrue(driver.findElement(By.cssSelector("img")).getAttribute("src").contains("/ukraine_logo2.gif"));
		Thread.sleep(1000);
		driver.quit();
	}
}
