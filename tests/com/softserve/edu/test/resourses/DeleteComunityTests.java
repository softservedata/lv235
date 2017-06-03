package com.softserve.edu.test.resourses;


import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class DeleteComunityTests {
    
    private static WebDriver driver;
    private static UserLogin userLogin;
    
    @BeforeClass
    public static void before(){
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
        userLogin.login();
    }
    
    @Test
    public void deleteComunityOK() {
        String nameComunity = "Uzhgorod";
        DeletingComunity.getDeletingComunity(driver).deleteComunityOK(nameComunity);
        SleepThread.sleep(2);  
        Assert.assertTrue(driver.findElements(By.xpath("//a[text() = '"+ nameComunity
                +"']/../..//a[contains(@href,'deleteCommunity/')]")).isEmpty());
    }
    
    @Test
    public void deleteComunityCancel() {
        String nameComunity = "Lviv";
        DeletingComunity.getDeletingComunity(driver).deleteComunityCancel("Lviv");
        SleepThread.sleep(2);  
        Assert.assertTrue(!driver.findElements(By.xpath("//a[text() = '"+ nameComunity
                +"']/../..//a[contains(@href,'deleteCommunity/')]")).isEmpty());        
    }
    
    @AfterClass
    public static void after(){
        userLogin.quit();
        driver.quit();
    }
}
