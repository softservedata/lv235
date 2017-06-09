package com.softserve.edu.test.resourses;


import java.util.concurrent.TimeUnit;

import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

/**
 * Test delete existing comunity.
 * @author Ivan
 */
public class DeleteComunityTests {

    /**
     * Web Driver.
     */
    private static WebDriver driver;

    /**
     * object for login.
     */
    private static UserLogin userLogin;

    /**
     * Before class method.
     */
    @BeforeClass
    public static void before() {
        driver = InitsializeWebDriver.getChromeDriver();
        driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
        userLogin = UserLogin.getUserLogin(driver);
        userLogin.login();
    }

    /**
     * Test completly delete comunity.
     */
    @Test
    public void deleteComunityOK() {
        String nameComunity = "Uzhgorod";
        DeletingComunity.getDeletingComunity(driver)
                .deleteComunityIfExistOk(nameComunity);
        SleepThread.sleep(2);  // must be deleted!!!
        Assert.assertTrue(driver.findElements(
                By.xpath("//a[text() = '" + nameComunity
                + "']/../..//a[contains(@href,'deleteCommunity/')]"))
                .isEmpty());
    }

    /**
     * Test cencel dleting comunity.
     */
    @Test
    public void deleteComunityCancel() {
        String nameComunity = "Lviv";
        DeletingComunity.getDeletingComunity(driver)
                .deleteComunityIfExistCancel("Lviv");
        SleepThread.sleep(2); // must be deleted!!!
        Assert.assertTrue(!driver.findElements(
                By.xpath("//a[text() = '" + nameComunity
                + "']/../..//a[contains(@href,'deleteCommunity/')]"))
                .isEmpty());
    }

    /**
     * After class method.
     */
    @AfterClass
    public static void after() {
        userLogin.quit();
        driver.quit();
    }
}
