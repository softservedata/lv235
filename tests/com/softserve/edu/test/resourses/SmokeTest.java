package com.softserve.edu.test.resourses;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class SmokeTest {
    
    private WebDriver driver;
    private UserLogin userLogin;
    
    @Before
    public void beforeTest(){
        initsializeWebDriver();
        userLogin.login();
    }  
    
    @Test
    public void test() {
        driver.findElement(By.xpath("//a[contains(@href,'/show-all-communities')]")).click();
        driver.findElement(By.cssSelector("a[href= 'addCommunity']")).click();
        SleepThread.sleep(1);
        driver.findElement(By.name("name")).sendKeys("Uzhgorod");
        driver.findElement(By.name("registrationNumber")).sendKeys("123:45:67:891:01112");
        SleepThread.sleep(1);
        driver.findElement(By.cssSelector("input[type = 'submit']")).click();
        SleepThread.sleep(1);
        Assert.assertTrue(driver.findElements(By.cssSelector("input[type = 'submit']")).isEmpty()); 
    }
    
    @After
    public void afterTest(){
        userLogin.quit();
        driver.quit();
    }
    
    public void initsializeWebDriver(){
        System.setProperty("webdriver.chrome.driver", "./lib/chromedriver.exe");
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--start-maximized");
        Map<String, Object> prefs = new HashMap<String, Object>();
        prefs.put("credentials_enable_service", false);
        prefs.put("profile.password_manager_enabled", false);
        options.setExperimentalOption("prefs", prefs);
        driver = new ChromeDriver(options);
        driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
        userLogin = UserLogin.getUserLogin(driver);
    }
}