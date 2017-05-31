package com.softserve.edu.registrator.test;

import java.io.File;
import java.util.concurrent.TimeUnit;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeDriverService;

public class Task1 {
	// public static ChromeDriverService service;

	// @BeforeClass
	// public void createService() throws Exception {
	// service = new ChromeDriverService.Builder()
	// .usingDriverExecutable(new File("./resources/chromedriver.exe"))
	// .usingAnyFreePort().build();
	// // .usingPort(8888).build();
	// service.start();
	// System.out.println("\t+++Service Start");
	// }

	@Test
	public static void test() throws InterruptedException {
		 System.setProperty("webdriver.chrome.driver",
		 "resources\\chromedriver.exe");
		 WebDriver d = new ChromeDriver();
		 d.get("http://www.google.com");
		 WebElement e = d.findElement(By.name("q"));
		 e.sendKeys("Ірина Кріцак");
		 e.submit();
		 Thread.sleep(5000);
		 System.out.println(d.getCurrentUrl());
		 System.out.println(d.getTitle());
		 d.quit();
	}

	// @AfterClass
	// public void StopService() {
	// if (service != null) {
	// service.stop();
	// System.out.println("\t+++RemoteWebDriver Stop");
	// }
	// }
}
