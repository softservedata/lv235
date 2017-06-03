package com.softserve.edu.test.resourses;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class DeletingComunity {
    
    private static DeletingComunity instanse;
    
    private WebDriver driver;

    private DeletingComunity(WebDriver driver) {
        this.driver = driver;
    }
    
    public static DeletingComunity getDeletingComunity(WebDriver driver)  {
        if ((instanse) == null)
            instanse = new DeletingComunity(driver);
        return instanse;
    }
    
    public void deleteComunityOK(String text) {
        driver.findElement(By.xpath("//a[contains(@href,'/show-all-communities')]")).click();
        SleepThread.sleep(1);
        
        if(!driver.findElements(By.xpath("//a[text() = '"+ text
                +"']/../..//a[contains(@href,'deleteCommunity/')]")).isEmpty()) {
            
            driver.findElement(By.xpath("//a[text() = '"+ text
                    +"']/../..//a[contains(@href,'deleteCommunity/')]")).click();
        
            WebDriverWait wait = new WebDriverWait(driver, 5);
            wait.until(ExpectedConditions.visibilityOf(driver
                 .findElement(By.cssSelector("button[class='btn btn-primary']"))));
        
            driver.findElement(By.xpath("//button[@class='btn btn-primary']")).click();
        }
    }
    
    public void deleteComunityCancel(String text) {
        driver.findElement(By.xpath("//a[contains(@href,'/show-all-communities')]")).click();
        SleepThread.sleep(1);
        
        if(!driver.findElements(By.xpath("//a[text() = '"+ text
                +"']/../..//a[contains(@href,'deleteCommunity/')]")).isEmpty()) {
            
            driver.findElement(By.xpath("//a[text() = '"+ text
                    +"']/../..//a[contains(@href,'deleteCommunity/')]")).click();
        
            WebDriverWait wait = new WebDriverWait(driver, 5);
            wait.until(ExpectedConditions.visibilityOf(driver
                 .findElement(By.cssSelector("button[class='btn btn-primary']"))));
        
            driver.findElement(By.xpath("//button[@class='btn btn-default']")).click();
            SleepThread.sleep(1);
        }
    }
}
