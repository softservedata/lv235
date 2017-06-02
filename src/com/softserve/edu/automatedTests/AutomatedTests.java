package com.softserve.edu.automatedTests;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import com.beust.jcommander.internal.Console;

public class AutomatedTests {

	private final int DELAY_FOR_DEMO = 0;
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
		Thread.sleep(DELAY_FOR_DEMO);
		// login
		driver.findElement(By.id("login")).click();
		driver.findElement(By.id("login")).clear();
		driver.findElement(By.id("login")).sendKeys("regist");
		Thread.sleep(DELAY_FOR_DEMO);
		driver.findElement(By.id("password")).click();
		driver.findElement(By.id("password")).clear();
		driver.findElement(By.id("password")).sendKeys("111111");
		Thread.sleep(DELAY_FOR_DEMO);
		driver.findElement(By.cssSelector(".btn.btn-primary")).click();
		Thread.sleep(DELAY_FOR_DEMO);
		// Subclass
		driver.findElement(By.xpath("//*[@id='navigationbar']/ul/li[3]/a")).click(); // Subclass of objects
		Thread.sleep(DELAY_FOR_DEMO);
		driver.findElement(By.xpath("//*[@id='body']/p/a")).click(); // Add new subclass
		Thread.sleep(DELAY_FOR_DEMO);
		driver.findElement(By.name("typeName")).click();
		driver.findElement(By.name("typeName")).sendKeys("Wifi");
		Thread.sleep(DELAY_FOR_DEMO);
		driver.findElement(By.id("clickmeshow")).click();
		Thread.sleep(DELAY_FOR_DEMO);
		driver.findElement(By.name("parameters[0].description")).click();
		driver.findElement(By.name("parameters[0].description")).sendKeys("Frequency");
		Thread.sleep(DELAY_FOR_DEMO);
		driver.findElement(By.name("parameters[0].unitName")).click();
		driver.findElement(By.name("parameters[0].unitName")).sendKeys("GGz");
		Thread.sleep(DELAY_FOR_DEMO);
		driver.findElement(By.name("parameters[0].parametersType")).click();
		driver.findElement(By.cssSelector("*[value='discreteParameters']")).click();
		driver.findElement(By.id("btnAdd")).click();
		Thread.sleep(DELAY_FOR_DEMO);
		driver.findElement(By.name("parameters[1].description")).click();
		driver.findElement(By.name("parameters[1].description")).sendKeys("Channel");
		Thread.sleep(DELAY_FOR_DEMO);
		driver.findElement(By.name("parameters[1].unitName")).click();
		driver.findElement(By.name("parameters[1].unitName")).sendKeys("ch");
		Thread.sleep(DELAY_FOR_DEMO);
		driver.findElement(By.name("parameters[1].parametersType")).click();
		WebElement dropdown2 = driver.findElement(By.cssSelector("#input2 #myparam2"));
		dropdown2.findElement(By.cssSelector("*[value='linearParameters']")).click();
		driver.findElement(By.id("valid")).click();
		Thread.sleep(DELAY_FOR_DEMO);
		Assert.assertNotNull(driver.findElement(By.xpath(".//*[@id='datatable']//td[contains(.,'Wifi')]")).getText());
		Thread.sleep(DELAY_FOR_DEMO);
		// exit
		driver.findElement(By.cssSelector(".btn.btn-primary.btn-sm.dropdown-toggle")).click();
		Thread.sleep(DELAY_FOR_DEMO);
		driver.findElement(By.xpath("//a[contains(@href,'/logout')]")).click();
		Thread.sleep(DELAY_FOR_DEMO);
		Assert.assertTrue(driver.findElement(By.cssSelector("img")).getAttribute("src").contains("/ukraine_logo2.gif"));
		Thread.sleep(DELAY_FOR_DEMO);
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
		Thread.sleep(DELAY_FOR_DEMO);
		// login
		driver.findElement(By.id("login")).click();
		driver.findElement(By.id("login")).clear();
		driver.findElement(By.id("login")).sendKeys("regist");
		Thread.sleep(DELAY_FOR_DEMO);
		driver.findElement(By.id("password")).click();
		driver.findElement(By.id("password")).clear();
		driver.findElement(By.id("password")).sendKeys("111111");
		Thread.sleep(DELAY_FOR_DEMO);
		driver.findElement(By.cssSelector(".btn.btn-primary")).click();
		Thread.sleep(DELAY_FOR_DEMO);
		//Delete
		driver.findElement(By.xpath("//*[@id='navigationbar']/ul/li[3]/a")).click(); // Subclass of objects
		Thread.sleep(DELAY_FOR_DEMO);
		Assert.assertNotNull(driver.findElement(By.xpath(".//*[@id='datatable']//td[contains(.,'Wifi')]")).getText());
		driver.findElement(By.xpath(".//*[@id='datatable']//td[contains(.,'Wifi')]/../td[6]/div/a")).click();
		Thread.sleep(DELAY_FOR_DEMO);
		driver.findElement(By.cssSelector(".bootbox.modal.fade.bootbox-confirm.in")).findElement(By.cssSelector(".btn.btn-primary")).click();
		Thread.sleep(DELAY_FOR_DEMO);
		//Test if not null
		List<WebElement> list = driver.findElements(By.xpath("//*[@id='datatable']//td[contains(.,'Wifi')]"));
		for (WebElement li : list) {
			System.out.println(li.toString());
		}
		// exit
		driver.findElement(By.cssSelector(".btn.btn-primary.btn-sm.dropdown-toggle")).click();
		Thread.sleep(DELAY_FOR_DEMO);
		driver.findElement(By.xpath("//a[contains(@href,'/logout')]")).click();
		Thread.sleep(DELAY_FOR_DEMO);
		Assert.assertTrue(driver.findElement(By.cssSelector("img")).getAttribute("src").contains("/ukraine_logo2.gif"));
		Thread.sleep(DELAY_FOR_DEMO);
		driver.quit();
	}
}
