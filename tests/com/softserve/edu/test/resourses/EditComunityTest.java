package com.softserve.edu.test.resourses;

import java.io.File;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class EditComunityTest {
    
    private static WebDriver driver;
    private static UserLogin userLogin;
    private static String folderName;
    
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
        folderName = FileHelper.createDerectory("EditComunity");
    }
    
    @Test
    public void editComutyNotApply() {
        String nameComunity = "Uzhgorod";
        editComunityFormOpen(nameComunity);
        File screenShot = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
        driver.findElement(By.cssSelector("input[name = 'name']")).sendKeys("1");
        driver.findElement(By.cssSelector("input[name = 'registrationNumber']")).clear();
        
        driver.findElement(By.xpath("//a[contains(@href,'/show-all-communities')]")).click();
        
        if(driver.findElements(By.xpath("//td/a[text() = '"+nameComunity+"']")).isEmpty()) {
            FileHelper.saveBugAttachments(folderName+"/editComutyNotApply", screenShot, driver); 
            Assert.fail();
        }
    }
    
    @Test
    public void editComutyChangeName() {
        String oldNameComunity = "Uzhgorod";
        String newNameComunity = "Uzhgorod2";
        editComunityFormOpen(oldNameComunity);
        File screenShot = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
        
        driver.findElement(By.cssSelector("input[name = 'name']")).clear();
        
        driver.findElement(By.cssSelector("input[name = 'name']")).sendKeys(newNameComunity);
        driver.findElement(By.cssSelector("input[type='submit']")).click();
        if(driver.findElements(By.xpath("//td/a[text() = '"+newNameComunity+"']")).isEmpty()) {
            FileHelper.saveBugAttachments(folderName+"/editComutyChangeName", screenShot, driver); 
            Assert.fail();
        }
        returnToPreviousState(oldNameComunity, newNameComunity);
    }
    
    @Test
    public void editComutyChangeAll() {
        String oldNameComunity = "Uzhgorod";
        String newNameComunity = "Uzhgorod2";
        String newNamberComunity = "999:00:00:999:99999";
        editComunityFormOpen(oldNameComunity);
        
        driver.findElement(By.cssSelector("input[name = 'name']")).clear();
        driver.findElement(By.cssSelector("input[name = 'name']")).sendKeys(newNameComunity);
        driver.findElement(By.cssSelector("input[name = 'registrationNumber']")).clear();
        driver.findElement(By.cssSelector("input[name = 'registrationNumber']"))
                .sendKeys(newNamberComunity);
        
        File screenShot = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
        driver.findElement(By.cssSelector("input[type='submit']")).click();
        if(driver.findElements(By.xpath("//td/a[text() = '"+newNameComunity+"']")).isEmpty() ||
                driver.findElements(By.xpath("//td[text() = '"+newNamberComunity+"']")).isEmpty()) {
            FileHelper.saveBugAttachments(folderName+"/editComutyChangeAll", screenShot, driver); 
            Assert.fail();
        }
        returnToPreviousState(oldNameComunity, newNameComunity);
    }
    
    @Test
    public void editComutyNotChangeAnything() {
        String nameComunity = "Uzhgorod";
        editComunityFormOpen(nameComunity);
        File screenShot = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
        driver.findElement(By.cssSelector("input[type='submit']")).click();
        if(driver.findElements(By.xpath("//td/a[text() = '"+nameComunity+"']")).isEmpty()) {
            FileHelper.saveBugAttachments(folderName+"/editComutyNotChangeAnything", screenShot, driver); 
            Assert.fail();
        }
    }
    
    @Test
    public void editComutyChangeNumber() {
        String nameComunity = "Uzhgorod";
        editComunityFormOpen(nameComunity);
        String newNumber = "111:11:11:111:11111";
        driver.findElement(By.cssSelector("input[name = 'registrationNumber']")).clear();
        driver.findElement(By.cssSelector("input[name = 'registrationNumber']"))
                .sendKeys(newNumber);
        File screenShot = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
        driver.findElement(By.cssSelector("input[type='submit']")).click();
        if(driver.findElements(By.xpath("//td[text() = '"+newNumber+"']")).isEmpty()) {
            FileHelper.saveBugAttachments(folderName+"/editComutyChangeNumber", screenShot, driver); 
            Assert.fail();
        }
    }
    
    private void editComunityFormOpen(String nameComunity) {
        driver.findElement(By.xpath("//a[contains(@href,'/show-all-communities')]")).click();
        driver.findElement(By.xpath("//a[text() = '"+
                nameComunity+"']/../..//a[contains(@href,'editCommunity')]"))
                .click();
    }
    
    private void returnToPreviousState(String oldName, String newName) {
        if(!driver.findElements(By.xpath("//td/a[text() = '"+newName+"']")).isEmpty()) {
            editComunityFormOpen(newName);
            driver.findElement(By.cssSelector("input[name = 'name']")).clear();
            driver.findElement(By.cssSelector("input[name = 'name']")).sendKeys(oldName);
            driver.findElement(By.cssSelector("input[type='submit']")).click();
        }
    }
    
    @AfterClass
    public static void after(){
        userLogin.quit();
        driver.quit();
    }
}