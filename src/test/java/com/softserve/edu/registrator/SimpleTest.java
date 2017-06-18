package com.softserve.edu.registrator;

import java.util.concurrent.TimeUnit;

import com.softserve.edu.registrator.pages.ActiveCoownersPage;
import com.softserve.edu.registrator.pages.AdminHomePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class SimpleTest {

    @Test
    public void adminLogin() throws Exception {
        //
        // Precondition
        //
        System.setProperty("webdriver.chrome.driver",
                "./lib/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        //driver.get("http://regres.herokuapp.com/login");
        driver.get("http://java.training.local:8080/registrator/login");
        Thread.sleep(1000);
        //
        // Test Steps
        //
        //WebElement login = driver.findElement(By.id("login"));
        //login.click();
        //login.clear();
        //login.sendKeys("ha-ha-ha");
        //Thread.sleep(2000);
        //
        //driver.navigate().refresh();
        //
        //login.click();
        //login.clear();
        //login.sendKeys("work");
        //
        driver.findElement(By.id("login")).click();
        driver.findElement(By.id("login")).clear();
        driver.findElement(By.id("login")).sendKeys("admin");
        Thread.sleep(1000);
        //
        driver.findElement(By.id("password")).click();
        driver.findElement(By.id("password")).clear();
        driver.findElement(By.id("password")).sendKeys("admin");
        Thread.sleep(1000);
        //
        driver.findElement(By.cssSelector(".btn.btn-primary")).click();
        Thread.sleep(4000);
        //
        // Check
        //
        // Local Variable - BAD SOLUTION
        WebElement loginName = driver.findElement(By
                .cssSelector(".btn.btn-primary.btn-sm:not(.dropdown-toggle)"));
        Assert.assertEquals(loginName.getText(), "admin");
        //
        // Return to previous state
        //
        driver.findElement(By
                .cssSelector(".btn.btn-primary.btn-sm.dropdown-toggle")).click();
        Thread.sleep(1000);
        //
        driver.findElement(By.xpath("//a[contains(@href,'/logout')]")).click();
        Thread.sleep(1000);
        //
        // Check
        //
        // Assert.assertEquals("work", loginName.getText()); // ERROR!!!
        Assert.assertTrue(driver.findElement(By.cssSelector("img")).getAttribute("src").contains("/ukraine_logo2.gif"));
        Thread.sleep(4000);

        ActiveCoownersPage user=new ActiveCoownersPage(driver);
        user.setFirstNameField("ihor");
        //
        driver.quit();
    }

}
