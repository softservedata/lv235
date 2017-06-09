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
 * Testing "Register new user tab" admin main
 * page "registrator" web application.
 *
 * @version 1.0. 05.06.2017
 * @author Nazar
 *
 */
public class RegisterNewUserTabEnglishLocalizationForAdminRoleTest {

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
     * Log in as admin.
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
        driver.findElement(By.xpath("//a[contains(@href, '/manualregistration')]")).click();
    }

    /**
     * Change language test as admin.
     * @throws InterruptedException
     *              used by Thread.sleep only for Demo.
     */
    @Test
    public void a1PointChangeLanguageTest() throws InterruptedException {
        // Checking default language
        Assert.assertTrue(driver
                .findElement(By.xpath("//select[@id='changeLanguage']//option[@value='uk']"))
                .isSelected());
        // Change language
        driver.findElement(By.id("changeLanguage")).click();
        if (isRunDemoMode)
            Thread.sleep(5000);
        driver.findElement(By.id("changeLanguage")).findElement(By.xpath(".//option[@value='en']")).click();
        // Confirm change language
        Assert.assertTrue(
                driver.findElement(By.xpath("//select[@id='changeLanguage']//option[@value='en']"))
                .isSelected());
        if (isRunDemoMode)
            Thread.sleep(2000);
    }

    /**
     * Check "Basic information" block test as admin.
     * @throws InterruptedException
     *              used by Thread.sleep only for Demo.
     */
    @Test
    public void basicInformationBlockTest() throws InterruptedException {
        Assert.assertEquals("Basic information",
                driver.findElement(By.cssSelector("div.personal_header h4"))
                        .getText());
        Assert.assertEquals("First name *",
                driver.findElement(By.cssSelector("label[for='firstName']"))
                        .getText());
        Assert.assertEquals("Second name*",
                driver.findElement(By.cssSelector("label[for='lastName']"))
                        .getText());
        Assert.assertEquals("Middle name",
                driver.findElement(By.cssSelector("label[for='middleName']"))
                        .getText());
        Assert.assertEquals("E-mail *", driver
                .findElement(By.cssSelector("label[for='email']")).getText());
        Assert.assertEquals("Login *", driver
                .findElement(By.cssSelector("label[for='login']")).getText());
        Assert.assertEquals("Password *",
                driver.findElement(By.cssSelector("label[for='password']"))
                        .getText());
        Assert.assertEquals("Confirm password *",
                driver.findElement(
                        By.cssSelector("label[for='confirmPassword']"))
                        .getText());
    }

    /**
     * Check "Address information" block test as admin.
     * @throws InterruptedException
     *              used by Thread.sleep only for Demo.
     */
    @Test
    public void addressInformationTest() throws InterruptedException {
        Assert.assertEquals("Address infomation",
                driver.findElement(By.cssSelector("div.address_header h4"))
                        .getText());
        Assert.assertEquals("City",
                driver.findElement(By.cssSelector("div.address_header label"))
                        .getText());
        Assert.assertEquals("Region", driver
                .findElement(By.cssSelector("label[for='region']")).getText());
        Assert.assertEquals("District",
                driver.findElement(By.cssSelector("label[for='district']"))
                        .getText());
        Assert.assertEquals("Street", driver
                .findElement(By.cssSelector("label[for='street']")).getText());
        Assert.assertEquals("Building",
                driver.findElement(By.cssSelector("label[for='building']"))
                        .getText());
        Assert.assertEquals("Flat", driver
                .findElement(By.cssSelector("label[for='flat']")).getText());
        Assert.assertEquals("Postcode",
                driver.findElement(By.cssSelector("label[for='postcode']"))
                        .getText());
    }

    /**
     * Check "Passport information" block test as admin.
     * @throws InterruptedException
     *              used by Thread.sleep only for Demo.
     */
    @Test
    public void passportInformationTest() throws InterruptedException {
        // Chech "Passport information" fields
        Assert.assertEquals("Passport information",
                driver.findElement(By.cssSelector("div.passport_header h4"))
                        .getText());
        Assert.assertEquals("Seria",
                driver.findElement(
                        By.cssSelector("label[for='passport_seria']"))
                        .getText());
        Assert.assertEquals("Number",
                driver.findElement(
                        By.cssSelector("label[for='passport_number']"))
                        .getText());
        Assert.assertEquals("Published by",
                driver.findElement(
                        By.cssSelector("label[for='published_by_data']"))
                        .getText());
    }

    /**
     * Check "Other data" block test as admin.
     * @throws InterruptedException
     *              used by Thread.sleep only for Demo.
     */
    @Test
    public void otherDataTest() throws InterruptedException {
        Assert.assertEquals("Phone number",
                driver.findElement(By.cssSelector("label[for='phone_number']"))
                        .getText());
        Assert.assertTrue(
                driver.findElement(By.cssSelector("input[id='phone_number']"))
                        .getAttribute("placeholder").contains("For example:"));
        Assert.assertEquals("Community *",
                driver.findElement(
                        By.cssSelector("label[for='territorial_Community']"))
                        .getText());

        driver.findElement(By.id("territorial_Community")).click();
        Assert.assertEquals("Choose community",
                driver.findElement(By.cssSelector(
                        "select[id='territorial_Community'] option[value]"))
                        .getText());
        driver.findElement(By.id("territorial_Community")).click();

        Assert.assertEquals("Date of accession to the treaty*",
                driver.findElement(
                        By.cssSelector("label[for='dateOfAccession']"))
                        .getText());
    }

    /**
     * Check buttons block test as admin.
     * @throws InterruptedException
     *              used by Thread.sleep only for Demo.
     */
    @Test
    public void checkButtonBlockTest() throws InterruptedException {
        Assert.assertEquals("Send", driver
                .findElement(By.cssSelector("button[id='submit']")).getText());
        Assert.assertEquals("Clear form",
                driver.findElement(By.cssSelector("button.reset")).getText());
        Assert.assertEquals("Cancel",
                driver.findElement(
                        By.cssSelector("button.btn.btn-primary[onclick]"))
                        .getText());
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
