package com.softserve.edu.test.resourses;


import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
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
        options.addArguments("--lang=en-US");
        Map<String, Object> prefs = new HashMap<String, Object>();
        prefs.put("credentials_enable_service", false);
        prefs.put("profile.password_manager_enabled", false);
        options.setExperimentalOption("prefs", prefs);
        driver = new ChromeDriver(options);
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        userLogin = UserLogin.getUserLogin(driver);
        userLogin.login();
    }
    
    @AfterClass
    public static void after(){
        userLogin.quit();
        driver.quit();
    }
    
    @Test
    public void test() {
        DeletingComunity.getDeletingComunity(driver).deleteComunityOK("123");
    }
    
}
