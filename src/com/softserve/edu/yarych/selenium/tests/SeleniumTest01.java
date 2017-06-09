package com.softserve.edu.yarych.selenium.tests;

import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

/**
 * @author Andriy
 *
 */
public class SeleniumTest01 {

    /**
     * Number 5.
     */
    public static final int FIVE = 5;


    /**
     * Number ONE_THOUSAND for Thread.sleep() ONLY.
     */
    public static final int ONE_THOUSAND = 1000;

    /**
     * Number THREE_THOUSAND for Thread.sleep() ONLY.
     */
    public static final int THREE_THOUSAND = 3000;

    /**
     * Selenium web-driver for launching Google Chrome.
     */
    private WebDriver driver;

    /**
     * BeforeTest method.
     */
    @Before
    public void setUp() {
        System.setProperty("webdriver.chrome.driver",
                "E:/SoftServe/SeleniumWebDriver/chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(FIVE, TimeUnit.SECONDS);
        driver.get("http://java.training.local:8080/registrator/");

        //Logging in as an administrator
        driver.findElement(By.id("login")).sendKeys("admin");
        driver.findElement(By.id("password")).sendKeys("admin");
        driver.findElement(By.xpath("//button[@type = 'submit']")).click();
    }

    /**
     * AfterTest method.
     */
    @After
    public void tearDown() {
        driver.quit();
    }

    /**
     * Method for testing user registration.
     * @throws Exception for Thread.sleep() ONLY.
     */
    @Test
    public void testRegistration() throws Exception {

        //Check if we really logged in as administrator
        Assert.assertEquals("Розблокувати всіх співвласників",
                driver.findElement(By.partialLinkText(
                        "Розблокувати всіх співвласників")).getText());

        //clicking on manual registration button
        driver.findElement(By.xpath("//a[contains(@href,"
                + "'manualregistration')]")).click();

        //Check if "Cancel" button works properly
        Thread.sleep(THREE_THOUSAND);
        driver.findElement(By.xpath("//*[@class = 'btn btn-primary']")).click();
        Assert.assertTrue(driver.getCurrentUrl()
                .equals("http://java.training.local:8080/registrator/"));
        Thread.sleep(ONE_THOUSAND);

        //clicking on manual registration button
        driver.findElement(By
                .xpath("//a[contains(@href, 'manualregistration')]")).click();

        //Check if system reacts properly to invalid user data
        enterInvalidData();
        Assert.assertEquals("Введіть коректну адресу",
                driver.findElement(By.id("email.errors")).getText());

        //Entering valid user data and clicking "Clear" button
        enterValidData();
        driver.findElement(By
                .xpath("//*[@class = 'btn btn-warning reset']")).click();
        Assert.assertEquals("",
                driver.findElement(By.id("firstName")).getText());

        //Submitting and registering the user
        enterValidData();
        driver.findElement(By.id("submit")).click();

        //Checking if right page is opened
        Assert.assertEquals("Непідтверджені співвласники",
                driver.findElement(By
                        .xpath("//*[@id='body']/div/div/h4")).getText());

        //Searching for just created user
        driver.findElement(By.id("inputIndex3")).sendKeys("ivan_test_admin");
        driver.findElement(By.id("bth-search")).click();
        Thread.sleep(THREE_THOUSAND);
        Assert.assertEquals("ivan_test_admin",
                driver.findElement(By
                        .xpath("//*[@id='example']/tbody/tr/td[4]")).getText());

        //clicking on 'Edit' button
        driver.findElement(By.id("edit")).click();
        Thread.sleep(THREE_THOUSAND);

        //check if we are on the right page
        Assert.assertTrue(driver.getCurrentUrl()
                .contains("edit-registrated-user"));

        //edit existing user
        driver.findElement(By.id("edit")).click();
        driver.findElement(By.id("roleId")).click();
        driver.findElement(By
                .xpath("//option[@value = 'ADMIN']")).click();

        driver.findElement(By.id("userStatusId")).click();
        driver.findElement(By
                .cssSelector("#userStatusId > option:nth-child(2)")).click();
        Thread.sleep(THREE_THOUSAND);

        driver.findElement(By.id("ok")).click();
        Thread.sleep(THREE_THOUSAND);
        Assert.assertTrue(driver.getCurrentUrl()
                .equals("http://java.training.local:8080/"
                + "registrator/administrator/users/get-all-users"));

        //checking if user is in active users table
        driver.findElement(By.id("inputIndex3")).sendKeys("ivan_test_admin");
        driver.findElement(By.id("bth-search")).click();
        Thread.sleep(THREE_THOUSAND);
        Assert.assertEquals("ivan_test_admin",
                driver.findElement(By
                        .xpath("//*[@id='example']/tbody/tr/td[4]")).getText());

        //logging out
        driver.findElement(By.xpath("//*[@class = "
                + "'btn btn-primary btn-sm dropdown-toggle']")).click();
        driver.findElement(By.xpath("//a[contains(@href, "
                + "'/registrator/logout')]")).click();

        //Checking if we logged out correctly
        Assert.assertTrue(driver.getCurrentUrl()
                .contains("http://java.training.local:8080/registrator/login"));

        //Logging in as our user
        driver.findElement(By.id("login")).clear();
        driver.findElement(By.id("login")).sendKeys("ivan_test_admin");
        driver.findElement(By.id("password")).clear();
        driver.findElement(By.id("password")).sendKeys("ivan_test_admin");
        driver.findElement(By
                .xpath("//*[@class = 'btn btn-primary']")).click();

        //Checking if we logged in correctly
        Assert.assertEquals("ivan_test_admin", driver.findElement(
                By.xpath("//*[@class = 'btn btn-primary btn-sm']")).getText());
    }

    /**
     * Method for entering valid user data into manual registration fields.
     * @throws Exception for Thread.sleep() ONLY.
     */
    public void enterValidData() throws Exception {
      //Filling in user data
        driver.findElement(By.id("firstName")).clear();
        driver.findElement(By.id("firstName")).sendKeys("Іван");
        driver.findElement(By.id("lastName")).clear();
        driver.findElement(By.id("lastName")).sendKeys("Іванів");
        driver.findElement(By.id("middleName")).clear();
        driver.findElement(By.id("middleName")).sendKeys("Іванович");
        driver.findElement(By.id("email")).clear();
        driver.findElement(By.id("email")).sendKeys("ivanivaniv@ukr.net");
        driver.findElement(By.id("login")).clear();
        driver.findElement(By.id("login")).sendKeys("ivan_test_admin");
        driver.findElement(By.id("password")).clear();
        driver.findElement(By.id("password")).sendKeys("password");
        driver.findElement(By.id("confirmPassword")).clear();
        driver.findElement(By.id("confirmPassword")).sendKeys("password");
        Thread.sleep(THREE_THOUSAND);

        //Filling in address information about user
        driver.findElement(By.id("city")).clear();
        driver.findElement(By.id("city")).sendKeys("Львів");
        driver.findElement(By.id("region")).clear();
        driver.findElement(By.id("region")).sendKeys("Львівська");
        driver.findElement(By.id("district")).clear();
        driver.findElement(By.id("district")).sendKeys("Франківський");
        driver.findElement(By.id("street")).clear();
        driver.findElement(By.id("street")).sendKeys("вул. Бандери");
        driver.findElement(By.id("building")).clear();
        driver.findElement(By.id("building")).sendKeys("12");
        driver.findElement(By.id("flat")).clear();
        driver.findElement(By.id("flat")).sendKeys("21");
        driver.findElement(By.id("postcode")).clear();
        driver.findElement(By.id("postcode")).sendKeys("79013");
        Thread.sleep(THREE_THOUSAND);

        //Filling in user's passport data
        driver.findElement(By.id("passport_seria")).clear();
        driver.findElement(By.id("passport_seria")).sendKeys("КН");
        driver.findElement(By.id("passport_number")).clear();
        driver.findElement(By.id("passport_number")).sendKeys("574129");
        driver.findElement(By.id("published_by_data")).clear();
        driver.findElement(By.id("published_by_data"))
                .sendKeys("Львівський РВ УМВС");
        Thread.sleep(THREE_THOUSAND);

        //Filling in other info about user
        driver.findElement(By.id("phone_number")).clear();
        driver.findElement(By.id("phone_number")).sendKeys("0660233211");
        driver.findElement(By.id("territorial_Community")).click();
        driver.findElement(By.xpath("//option[@value = 'Україна']")).click();
        Thread.sleep(THREE_THOUSAND);
    }

    /**
     * Method for entering invalid user data into manual registration fields.
     * @throws Exception for Thread.sleep() ONLY.
     */
    public void enterInvalidData() throws Exception {
        driver.findElement(By.id("submit")).click();
        driver.findElement(By.id("firstName")).clear();
        driver.findElement(By.id("firstName")).sendKeys("123");
        driver.findElement(By.id("lastName")).clear();
        driver.findElement(By.id("lastName")).sendKeys("321");
        driver.findElement(By.id("email")).clear();
        driver.findElement(By.id("email")).sendKeys("invaliddata");
        driver.findElement(By.id("login")).clear();
        driver.findElement(By.id("login")).sendKeys("!@#$%");
        driver.findElement(By.id("password")).clear();
        driver.findElement(By.id("password")).sendKeys("#@!");
        driver.findElement(By.id("confirmPassword")).clear();
        driver.findElement(By.id("confirmPassword")).sendKeys("#@!$");
        driver.findElement(By.id("territorial_Community")).click();
        driver.findElement(By.xpath("//option[@value = 'Україна']")).click();
        Thread.sleep(THREE_THOUSAND);
        driver.findElement(By.id("submit")).click();
    }
}
