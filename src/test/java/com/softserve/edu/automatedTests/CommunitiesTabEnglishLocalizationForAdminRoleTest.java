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
 * Testing "Communities tab" main page "registrator" web application.
 *
 * @version 1.0. 05.06.2017
 * @author Nazar
 *
 */
public class CommunitiesTabEnglishLocalizationForAdminRoleTest {

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
        driver.findElement(By.xpath("//a[contains(@href, '/show-all-communities')]")).click();
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
            Thread.sleep(3000);
        driver.findElement(By.id("changeLanguage")).findElement(By.xpath(".//option[@value='en']")).click();
        // Confirm change language
        Assert.assertTrue(
                driver.findElement(By.xpath("//select[@id='changeLanguage']//option[@value='en']"))
                .isSelected());
        if (isRunDemoMode)
            Thread.sleep(3000);
    }

    /**
     * Check label "Coowners" tab test.
     * @throws InterruptedException
     *              used by Thread.sleep only for Demo.
     */
    @Test
    public void checkLabelTest() throws InterruptedException {
        Assert.assertEquals("Communities", driver.findElement(By.xpath("//div[@id='body']//h4")).getText());
    }

    /**
     * Check button "Add new territorial community" test.
     * @throws InterruptedException
     *              used by Thread.sleep only for Demo.
     */
    @Test
    public void checkButtonAddNewTerritorialCommunityTest() throws InterruptedException {
        Assert.assertEquals("Add new territorial community",
                driver.findElement(By.cssSelector("p a.btn.btn-success")).getText());
    }

    /**
     * Check radio-button "ShowInactive" test.
     * @throws InterruptedException
     *              used by Thread.sleep only for Demo.
     */
    @Test
    public void checkShowInactiveCheckBoxTranslateTest() throws InterruptedException {
        Assert.assertEquals("Show inactive",
                driver.findElement(By.cssSelector("div.pull-right.text-right label")).getText());
    }

    /**
     * Check table header test.
     * @throws InterruptedException
     *              used by Thread.sleep only for Demo.
     */
    @Test
    public void checkTheTableHeadersTest() throws InterruptedException {
        Assert.assertEquals("Territorial community",
                driver.findElement(By.xpath("//th[contains(., 'Territorial community')]")).getText());
        Assert.assertEquals("Registration number",
                driver.findElement(By.xpath("//th[contains(., 'Registration number')]")).getText());
        Assert.assertEquals("Actions", driver.findElement(By.xpath("//th[contains(., 'Actions')]")).getText());
    }

    /**
     * Check buttons "Edit" and "Delete" test.
     * @throws InterruptedException
     *              used by Thread.sleep only for Demo.
     */
    @Test
    public void checkButtonsEditAndDeleteTest() throws InterruptedException {
        Assert.assertEquals("Edit", driver.findElement(By.xpath("//a[contains(@href, 'editCommunity')]")).getText());
        Assert.assertEquals("Delete",
                driver.findElement(By.xpath("//a[contains(@href, 'deleteCommunity')]")).getText());
    }

    /**
     * Log out.
     * @throws InterruptedException
     *              used by Thread.sleep only for Demo.
     */
    @AfterClass
    public static void logOutAndQuit() throws InterruptedException {
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
