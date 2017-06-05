package com.softserve.edu.automatedTests;

import java.util.concurrent.TimeUnit;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class AutoFirst {

    @Test
    public void testAdminMainPage() throws InterruptedException {
        
        //Test data (url, login, password)
        String url = "http://java.training.local:8080/registrator";
        // String url = "http://regres.herokuapp.com/login";
        final String login = "admin";
        final String password = "admin";
        boolean isRunDemoMode = false;

        System.setProperty("webdriver.chrome.driver",
                "C:/Program Files/Java/Selenium_3.40/chromedriver_2.29.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.get(url);
        
        // Sign in
        driver.findElement(By.id("login")).sendKeys(login);
        driver.findElement(By.id("password")).sendKeys(password);
        if (isRunDemoMode) Thread.sleep(3000);
        driver.findElement(By.xpath("//button[@type='submit']")).click();
        if (isRunDemoMode) Thread.sleep(4000);
        // Sign in confirm
        Assert.assertEquals(login,
                driver.findElement(By.cssSelector("button.btn.btn-primary.btn-sm:not(.dropdown-toggle)")).getText());

        // Checking default language
        Assert.assertTrue(
                driver.findElement(By.xpath("//select[@id='changeLanguage']//option[@value='uk']")).isSelected());
        
        // Change language
        driver.findElement(By.id("changeLanguage")).click();
        if (isRunDemoMode) Thread.sleep(5000);
        driver.findElement(By.id("changeLanguage")).findElement(By.xpath(".//option[@value='en']")).click();

        // Confirm change language
        Assert.assertTrue(
                driver.findElement(By.xpath("//select[@id='changeLanguage']//option[@value='en']")).isSelected());
        if (isRunDemoMode) Thread.sleep(5000);

        // Checking header
        Assert.assertEquals("Decentralized registry of",
                driver.findElement(By.xpath("//h3[contains(.,'Decentralized')]")).getText());
        Assert.assertEquals("Ukrainian natural resources", 
                driver.findElement(By.xpath("//h3[contains(.,'Ukrainian')]")).getText());

        // Checking footer
        Assert.assertEquals("�2017 Softserve IT Academy",
                driver.findElement(By.xpath("//div[@id='footer']//span")).getText());
        
        // Checking navigate menu
        Assert.assertEquals("Coowners", 
                driver.findElement(By.cssSelector("a.dropdown-toggle")).getText());
        Assert.assertEquals("Settings", 
                driver.findElement(By.xpath("//a[contains(@href, '/settings')]")).getText());
        Assert.assertEquals("Communities", 
                driver.findElement(By.xpath("//a[contains(@href, '/show-all-communities')]")).getText());
        Assert.assertEquals("Register new user", 
                driver.findElement(By.xpath("//a[contains(@href, '/manualregistration')]")).getText());
        Assert.assertEquals("Unblock all coowners", 
                driver.findElement(By.id("unlockUsers")).getText());

        // Checking sub-menu "Coowners"
        driver.findElement(By.cssSelector("a.dropdown-toggle")).click();
        if (isRunDemoMode) Thread.sleep(3000);
        Assert.assertEquals("Active", 
                driver.findElement(By.xpath("//a[contains(@href, 'get-all-users')]")).getText());
        Assert.assertEquals("Inactive", 
                driver.findElement(By.xpath("//a[contains(@href, 'inactive')]")).getText());
        Assert.assertEquals("Non-confirmed", 
                driver.findElement(By.xpath("//a[contains(@href, 'notcomfirmed')]")).getText());
        Assert.assertEquals("Blocked", 
                driver.findElement(By.xpath("//a[contains(@href, 'block')]")).getText());

        // Checking dropdown "Log out" menu
        driver.findElement(By.cssSelector("button.btn.btn-primary.btn-sm.dropdown-toggle")).click();

        Assert.assertEquals("Change my password", 
                driver.findElement(By.cssSelector(".change-password")).getText());
        Assert.assertEquals("Reset my password", 
                driver.findElement(By.cssSelector(".reset-my-password")).getText());
        Assert.assertEquals("Sign out", 
                driver.findElement(By.xpath("//a[contains(@href, '/logout')]")).getText());
        if (isRunDemoMode) Thread.sleep(4000);

        // Log out
        driver.findElement(By.xpath("//a[contains(@href, '/logout')]")).click();

        // Confirm log out
        Assert.assertFalse(driver.findElements(By.xpath("//img[contains(@src, '/ukraine_logo2.gif')]")).isEmpty());

        if (isRunDemoMode) Thread.sleep(5000);
        driver.quit();
    }
    
    @Test
    public void testAdminCommunitiesTab() throws Exception {
        //Test data (url, login, password)
        String url = "http://java.training.local:8080/registrator";
        // String url = "http://regres.herokuapp.com/login";
        final String login = "admin";
        final String password = "admin";
        boolean isRunDemoMode = false;

        System.setProperty("webdriver.chrome.driver",
                "C:/Program Files/Java/Selenium_3.40/chromedriver_2.29.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.get(url);

        // Confirm opening main page
        Assert.assertFalse(driver.findElements(By.xpath("//img[contains(@src, '/ukraine_logo2.gif')]")).isEmpty());

        // Sign in
        driver.findElement(By.id("login")).sendKeys(login);
        driver.findElement(By.id("password")).sendKeys(password);
        if (isRunDemoMode) Thread.sleep(3000);
        driver.findElement(By.xpath("//button[@type='submit']")).click();
        if (isRunDemoMode) Thread.sleep(3000);
        
        // Sign in confirm
        Assert.assertEquals(login,
                driver.findElement(By.cssSelector("button.btn.btn-primary.btn-sm:not(.dropdown-toggle)")).getText());

        // Checking default language
        Assert.assertTrue(
                driver.findElement(By.xpath("//select[@id='changeLanguage']//option[@value='uk']")).isSelected());
        
        // Change language
        driver.findElement(By.id("changeLanguage")).findElement(By.xpath("//option[@value='en']")).click();
        if (isRunDemoMode) Thread.sleep(4000);
        
        // Confirm change language
        Assert.assertTrue(
                driver.findElement(By.xpath("//select[@id='changeLanguage']//option[@value='en']")).isSelected());
        
        //Go to "Communities" tab
        driver.findElement(By.xpath("//a[contains(@href, '/show-all-communities')]")).click();
        if (isRunDemoMode) Thread.sleep(5000);

        //Confirm open "Communities" tab 
        Assert.assertNotNull(driver.findElement(By.xpath("//div[@id='body']//h4")));

        // Checking header// �����
        Assert.assertEquals("Decentralized registry of",
                driver.findElement(By.xpath("//div[@class='col-md-7 col-xs-12']/h3[contains(.,'Decentralized')]")).getText());
        Assert.assertEquals("Ukrainian natural resources", 
                driver.findElement(By.xpath("//div[@class='col-md-7 col-xs-12']/h3[contains(.,'Ukrainian')]")).getText());

        // Checking footer
        Assert.assertEquals("�2017 Softserve IT Academy",
                driver.findElement(By.xpath("//div[@id='footer']//span")).getText());

        // Checking label of tab
        Assert.assertEquals("Communities",
                driver.findElement(By.xpath("//div[@id='body']//h4")).getText());
        
        // Table header// ��������!!
        Assert.assertEquals("Territorial community",
                driver.findElement(By.xpath("//th[contains(., 'Territorial community')]")).getText());
        Assert.assertEquals("Registration number",
                driver.findElement(By.xpath("//th[contains(., 'Registration number')]")).getText());
        Assert.assertEquals("Actions",
                driver.findElement(By.xpath("//th[contains(., 'Actions')]")).getText());
       
        //Button "Add new territorial community" translate
        Assert.assertEquals("Add new territorial community",
                driver.findElement(By.cssSelector("p a.btn.btn-success")).getText());
        
        //Check box "Show inactive" translate
        Assert.assertEquals("Show inactive",
                driver.findElement(By.cssSelector("div.pull-right.text-right label")).getText());
        
        //"Edit" and "Delete" button translate
        Assert.assertEquals("Edit",
                driver.findElement(By.xpath("//a[contains(@href, 'editCommunity')]")).getText());
        Assert.assertEquals("Delete",
                driver.findElement(By.xpath("//a[contains(@href, 'deleteCommunity')]")).getText());
        
        // Log out
        driver.findElement(By.cssSelector("button.btn.btn-primary.btn-sm.dropdown-toggle")).click();
        if (isRunDemoMode) Thread.sleep(3000);
        driver.findElement(By.xpath("//a[contains(@href, '/logout')]")).click();

        // Confirm log out
        Assert.assertFalse(driver.findElements(By.xpath("//img[contains(@src, '/ukraine_logo2.gif')]")).isEmpty());

        if (isRunDemoMode) Thread.sleep(3000);
        driver.quit();
    }
}