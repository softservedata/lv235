package com.softserve.edu.automatedTests;

import java.util.concurrent.TimeUnit;

import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

/**
 * Testing "Setting tab" admin main page "registrator" web application.
 *
 * @version 1.0. 05.06.2017
 * @author Nazar
 *
 */
public class SettingTabEnglishLocalizationForAdminRoleTest {

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
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.get(URL);

        // Sign in
        driver.findElement(By.id("login")).sendKeys(LOGIN);
        driver.findElement(By.id("password")).sendKeys(PASSWORD);
        if (isRunDemoMode)
            Thread.sleep(3000);
        driver.findElement(By.xpath("//button[@type='submit']")).click();
        if (isRunDemoMode)
            Thread.sleep(4000);
        driver.findElement(By.cssSelector("button.btn.btn-primary.btn-sm:not(.dropdown-toggle)")).click();
        driver.findElement(By.xpath("//a[contains(@href, '/settings')]")).click();
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
        if (isRunDemoMode)
            Thread.sleep(3000);
        driver.findElement(By.id("changeLanguage"))
                .findElement(By.xpath(".//option[@value='en']")).click();
        // Confirm change language
        Assert.assertTrue(
                driver.findElement(By.xpath("//select[@id='changeLanguage']//option[@value='en']"))
                .isSelected());
        if (isRunDemoMode)
            Thread.sleep(2000);
    }

    /**
     * Check "method of registering new users" block test as admin.
     * @throws InterruptedException
     *              used by Thread.sleep only for Demo.
     */
    @Test
    public void methodOfRegisteringNewUsersTest() throws InterruptedException {
        Assert.assertEquals("Method of registering new users",
                driver.findElement(By.cssSelector("div[max] h3")).getText());
        Assert.assertEquals("Select one of the options",
                driver.findElement(By.cssSelector("div[max] p")).getText());
        Assert.assertEquals("Personal registration",
                driver.findElement(By.xpath("//input[@value='PERSONAL']/.."))
                        .getText());
        Assert.assertEquals("Only commissioner can register new co-owner",
                driver.findElement(By.xpath("//input[@value='MANUAL']/.."))
                        .getText());
        Assert.assertEquals("Both registration method are available", driver
                .findElement(By.xpath("//input[@value='MIXED']/..")).getText());
    }

    /**
     * Check "default time zone" block test as admin.
     * @throws InterruptedException
     *              used by Thread.sleep only for Demo.
     */
    @Test
    public void defaultTimeZoneBlockTest() throws InterruptedException {
        Assert.assertEquals("Default time zone",
                driver.findElement(By.cssSelector(
                        "div.panel.panel-default:not([max]) h3.panel-title"))
                        .getText());
        Assert.assertEquals("Enter city or time zone",
                driver.findElement(By.cssSelector(
                        "div.panel.panel-default:not([max]) div.panel-body.panel30 p"))
                        .getText());
    }

    /**
     * Check "system e-mail account" block test as admin.
     * @throws InterruptedException
     *              used by Thread.sleep only for Demo.
     */
    @Test
    public void systemEmailAccountBlockTest() throws InterruptedException {
        Assert.assertEquals("Email server address",
                driver.findElement(By.cssSelector("label[for='smtpHost']"))
                        .getText());
        Assert.assertEquals("TCP port",
                driver.findElement(By.cssSelector("label[for='smtpPort']"))
                        .getText());
        Assert.assertEquals("Protocol",
                driver.findElement(By.cssSelector("label[for='smtpProtocol']"))
                        .getText());
        Assert.assertEquals("TLS secure connection",
                driver.findElement(By
                        .cssSelector("label[for='smtpParameters.tlsEnabled1']"))
                        .getText());
        Assert.assertEquals("User name",
                driver.findElement(By.cssSelector("label[for='smtpUsername']"))
                        .getText());
        Assert.assertEquals("Password",
                driver.findElement(By.cssSelector("label[for='smtpPassword']"))
                        .getText());
        Assert.assertEquals("Check",
                driver.findElement(By.id("checkSMTP")).getText());
        Assert.assertEquals("Confirm changes",
                driver.findElement(
                        By.cssSelector("input[id='confirmRegistrationMethod']"))
                        .getAttribute("value"));
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
