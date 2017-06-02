package com.softserve.edu.test.resourses;

import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class UserLogin {
    private static  UserLogin userLogin;
    
    private WebDriver driver;
    
    private UserLogin(WebDriver driver) {
        this.driver = driver;
    }
    
    
    public static UserLogin getUserLogin(WebDriver driver)
    {
        if ((userLogin) == null)
            userLogin = new UserLogin(driver);
        return userLogin;
    }
    
    
    public void login()  {
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.get("http://java.training.local:8080/registrator/login");
       
        driver.findElement(By.id("login")).click();
        driver.findElement(By.id("login")).clear();
        driver.findElement(By.id("login")).sendKeys("admin");
        
        driver.findElement(By.id("password")).click();
        driver.findElement(By.id("password")).clear();
        driver.findElement(By.id("password")).sendKeys("admin");
        driver.findElement(By.cssSelector(".btn.btn-primary")).submit();
    }
    
    public void quit() {
        driver.findElement(By.cssSelector(".btn.btn-primary.btn-sm.dropdown-toggle")).click();
        driver.findElement(By.xpath("//a[contains(@href,'/logout')]")).click();
    }
}
