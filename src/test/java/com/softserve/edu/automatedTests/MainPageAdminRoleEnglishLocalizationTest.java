package com.softserve.edu.automatedTests;

import java.util.concurrent.TimeUnit;

import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

/**
 * Testing admin main page "registrator" web application.
 *
 * @version 1.0. 05.06.2017
 * @author Nazar
 *
 */
public class MainPageAdminRoleEnglishLocalizationTest {

    /**Test data: url.*/
    private static final String URL =
            "http://java.training.local:8080/registrator";
    // String url = "http://regres.herokuapp.com/login";
    /**Test data: login.*/
    private static final String LOGIN = "admin";
    /**Test data: password.*/
    private static final String PASSWORD = "admin";
    /**Variable: isRunDemoMode - only for demo.*/
    private static boolean isRunDemoMode = true;
    /**Variable Web Driver.*/
    private static WebDriver driver;

    /**
     * Login as admin.
     * @throws InterruptedException
     *              used by Thread.sleep only for Demo.
     */
    @BeforeClass
    public static void loginAsAdmin() throws InterruptedException {
        System.setProperty("webdriver.chrome.driver",
                "C:/Program Files/Java/Selenium_3.40/chromedriver_2.29.exe");
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--start-maximized");
        options.addArguments("--no-proxy-server");
        driver = new ChromeDriver(options);
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.get(URL);

        // Sign in
        driver.findElement(By.id("login")).sendKeys(LOGIN);
        driver.findElement(By.id("password")).sendKeys(PASSWORD);
        if (isRunDemoMode) Thread.sleep(3000);
        driver.findElement(By.xpath("//button[@type='submit']")).click();
        if (isRunDemoMode) Thread.sleep(2000);
        driver.findElement(By.cssSelector("button.btn.btn-primary.btn-sm:not(.dropdown-toggle)"))
        .click();
    }
/**
  * Change language test as admin.
  * @throws InterruptedException
  *              used by Thread.sleep only for Demo.
  */
    @Test
    public void a1PointChangeLanguageTest() throws InterruptedException {
        // Checking default language
        Assert.assertTrue(
                driver.findElement(By.xpath("//select[@id='changeLanguage']//option[@value='uk']"))
                        .isSelected());
        // Change language
        driver.findElement(By.id("changeLanguage")).click();
        if (isRunDemoMode) Thread.sleep(2000);
        driver.findElement(By.id("changeLanguage"))
                .findElement(By.xpath(".//option[@value='en']")).click();
        // Confirm change language
        Assert.assertTrue(
                driver.findElement(By.xpath("//select[@id='changeLanguage']//option[@value='en']"))
                .isSelected());
        if (isRunDemoMode) Thread.sleep(2000);
    }

    /**
     * Check header test.
     * @throws InterruptedException
     *              used by Thread.sleep only for Demo.
     */
    @Test
    public void checkHeaderTest() throws InterruptedException {
        Assert.assertEquals("Decentralized registry of",
                driver.findElement(By.xpath("//h3[contains(.,'Decentralized')]")).getText());
        Assert.assertEquals("Ukrainian natural resources",
                driver.findElement(By.xpath("//h3[contains(.,'Ukrainian')]")).getText());
    }

    /**
     * Check footer test.
     * @throws InterruptedException
     *              used by Thread.sleep only for Demo.
     */
    @Test
    public void checkFooterTest() throws InterruptedException {
        Assert.assertEquals("©2017 Softserve IT Academy",
                driver.findElement(By.xpath("//div[@id='footer']//span")).getText());
    }

    /**
     * Check navigate menu test.
     * @throws InterruptedException
     *              used by Thread.sleep only for Demo.
     */
    @Test
    public void checkNavigateMenuTest() throws InterruptedException {
        Assert.assertEquals("Coowners",
                driver.findElement(By.cssSelector("a.dropdown-toggle")).getText());
        Assert.assertEquals("Settings",
                driver.findElement(By.xpath("//a[contains(@href, '/settings')]")).getText());
        Assert.assertEquals("Communities",
                driver.findElement(By.xpath("//a[contains(@href, '/show-all-communities')]")).getText());
        Assert.assertEquals("Register new user",
                driver.findElement(By.xpath("//a[contains(@href, '/manualregistration')]")).getText());
        Assert.assertEquals("Unblock all coowners", driver.findElement(By.id("unlockUsers")).getText());
    }

    /**
     * Check "Coowners" sub-menu test.
     * @throws InterruptedException
     *              used by Thread.sleep only for Demo.
     */
    @Test
    public void checkCoownersSubMenuTest() throws InterruptedException {
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
        driver.findElement(By.cssSelector("a.dropdown-toggle")).click();
    }

    /**
     * Check "Coowners" sub-menu test.
     * @throws InterruptedException
     *              used by Thread.sleep only for Demo.
     */
    @Test
    public void checkLogOutMenuTest() throws InterruptedException {
        driver.findElement(By.cssSelector("button.btn.btn-primary.btn-sm.dropdown-toggle")).click();
        Assert.assertEquals("Change my password",
                driver.findElement(By.cssSelector(".change-password")).getText());
        Assert.assertEquals("Reset my password",
                driver.findElement(By.cssSelector(".reset-my-password")).getText());
        Assert.assertEquals("Sign out",
                driver.findElement(By.xpath("//a[contains(@href, '/logout')]")).getText());
        driver.findElement(By.cssSelector("button.btn.btn-primary.btn-sm.dropdown-toggle")).click();
    }

    /**
     * Log out.
     * @throws InterruptedException
     *              used by Thread.sleep only for Demo.
     */
    @AfterClass
    public static void logOutAndQuit() throws InterruptedException {
        // Log out
        driver.findElement(
                By.cssSelector("button.btn.btn-primary.btn-sm.dropdown-toggle")).click();
        if (isRunDemoMode) Thread.sleep(3000);
        driver.findElement(By.xpath("//a[contains(@href, '/logout')]")).click();
        // Confirm log out
        Assert.assertFalse(driver
                .findElements(
                        By.xpath("//img[contains(@src, '/ukraine_logo2.gif')]"))
                .isEmpty());
        if (isRunDemoMode) Thread.sleep(3000);
        driver.quit();
    }
}
