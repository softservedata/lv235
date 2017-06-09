package com.softserve.edu.test.resourses;

import java.io.File;
import java.util.concurrent.TimeUnit;

import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

/**
 * Class for testing editing comunity.
 * @author Ivan
 */
public class EditComunityTest {

    /**
     * Web driver.
     */
    private static WebDriver driver;

    /**
     * object for login user.
     */
    private static UserLogin userLogin;

    /**
     * name folder for saving bag info.
     */
    private static String folderName;

    /**
     * method before class.
     */
    @BeforeClass
    public static void before() {
        driver = InitsializeWebDriver.getChromeDriver();
        driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
        userLogin = UserLogin.getUserLogin(driver);
        userLogin.login();
        folderName = FileHelper.createDerectory("EditComunity");
    }

    /**
     * Test when do not apply editing comunity.
     */
    @Test
    public void editComutyNotApply() {
        String nameComunity = "Uzhgorod";
        editComunityFormOpen(nameComunity);
        File screenShot = ((TakesScreenshot) driver)
                    .getScreenshotAs(OutputType.FILE);
        driver.findElement(
                    By.cssSelector("input[name = 'name']")).sendKeys("1");
        driver.findElement(
                    By.cssSelector("input[name = 'registrationNumber']"))
                    .clear();
        driver.findElement(
                    By.xpath("//a[contains(@href,'/show-all-communities')]"))
                    .click();
        SleepThread.sleep(1);  // must be deleted!!!
        if (driver.findElements(By.xpath("//td/a[text() = '"
                            + nameComunity + "']")).isEmpty()) {
            FileHelper.saveBugAttachments(folderName + "/editComutyNotApply",
                        screenShot, driver);
            Assert.fail();
        }
    }

    /**
     * Edit comunity name.
     */
    @Test
    public void editComutyChangeName() {
        String oldNameComunity = "Uzhgorod";
        String newNameComunity = "Uzhgorod2";
        editComunityFormOpen(oldNameComunity);
        File screenShot = ((TakesScreenshot) driver)
                .getScreenshotAs(OutputType.FILE);
        driver.findElement(By.cssSelector("input[name = 'name']")).clear();
        driver.findElement(By.cssSelector("input[name = 'name']"))
                .sendKeys(newNameComunity);
        driver.findElement(By.cssSelector("input[type='submit']")).click();
        SleepThread.sleep(1);  // must be deleted!!!
        if (driver.findElements(By.xpath("//td/a[text() = '"
                + newNameComunity + "']")).isEmpty()) {
            FileHelper.saveBugAttachments(folderName + "/editComutyChangeName",
                    screenShot, driver);
            Assert.fail();
        }
        toPreviousState(oldNameComunity, newNameComunity);
    }

    /**
     * Edit name and number comunity.
     */
    @Test
    public void editComutyChangeAll() {
        String oldNameComunity = "Uzhgorod";
        String newNameComunity = "Uzhgorod2";
        String newNamberComunity = "999:00:00:999:99999";
        editComunityFormOpen(oldNameComunity);

        driver.findElement(By.cssSelector("input[name = 'name']")).clear();
        driver.findElement(By.cssSelector("input[name = 'name']"))
                .sendKeys(newNameComunity);
        driver.findElement(By.cssSelector("input[name = 'registrationNumber']"))
                .clear();
        driver.findElement(By.cssSelector("input[name = 'registrationNumber']"))
                .sendKeys(newNamberComunity);
        File screenShot = ((TakesScreenshot) driver)
                .getScreenshotAs(OutputType.FILE);
        driver.findElement(By.cssSelector("input[type='submit']")).click();
        SleepThread.sleep(1);  // must be deleted!!!
        if (driver.findElements(By.xpath("//td/a[text() = '"
                + newNameComunity + "']")).isEmpty() || driver.findElements(
                        By.xpath("//td[text() = '" + newNamberComunity + "']"))
                                .isEmpty()) {
            FileHelper.saveBugAttachments(folderName + "/editComutyChangeAll",
                        screenShot, driver);
            Assert.fail();
        }
        toPreviousState(oldNameComunity, newNameComunity);
    }

    /**
     * Edit comunity not changed enything.
     */
    @Test
    public void editComutyNotChangeAnything() {
        String nameComunity = "Uzhgorod";
        editComunityFormOpen(nameComunity);
        File screenShot = ((TakesScreenshot) driver)
                .getScreenshotAs(OutputType.FILE);
        driver.findElement(By.cssSelector("input[type='submit']")).click();
        SleepThread.sleep(1);  // must be deleted!!!
        if (driver.findElements(
                By.xpath("//td/a[text() ='" + nameComunity + "']")).isEmpty()) {
            FileHelper.saveBugAttachments(folderName
                    + "/editComutyNotChangeAnything", screenShot, driver);
            Assert.fail();
        }
    }

    /**
     * Edit number comunity.
     */
    @Test
    public void editComutyChangeNumber() {
        String nameComunity = "Uzhgorod";
        editComunityFormOpen(nameComunity);
        String newNumber = "111:11:11:111:11111";
        driver.findElement(
                By.cssSelector("input[name = 'registrationNumber']")).clear();
        driver.findElement(By.cssSelector("input[name = 'registrationNumber']"))
                .sendKeys(newNumber);
        File screenShot = ((TakesScreenshot) driver)
                .getScreenshotAs(OutputType.FILE);
        driver.findElement(By.cssSelector("input[type='submit']")).click();
        SleepThread.sleep(1);  // must be deleted!!!
        if (driver.findElements(
                By.xpath("//td[text() = '" + newNumber + "']")).isEmpty()) {
            FileHelper.saveBugAttachments(folderName + "/editComutyNumber",
                    screenShot, driver);
            Assert.fail();
        }
    }

    /**
     * Open form editing comunity.
     * @param name Comunity name for editing.
     */
    private void editComunityFormOpen(final String name) {
        driver.findElement(
                By.xpath("//a[contains(@href,'/show-all-communities')]"))
                .click();
        driver.findElement(By.xpath("//a[text() = '"
                + name + "']/../..//a[contains(@href,'editCommunity')]"))
                .click();
    }

    /**
     * Return comunity to previous state.
     * @param oldName name comunity before editing.
     * @param newName name comunity after editing
     */
    private void toPreviousState(final String oldName, final String newName) {
        if (!driver.findElements(
                    By.xpath("//td/a[text() = '" + newName + "']")).isEmpty()) {
            editComunityFormOpen(newName);
            driver.findElement(By.cssSelector("input[name = 'name']")).clear();
            driver.findElement(
                    By.cssSelector("input[name = 'name']")).sendKeys(oldName);
            driver.findElement(By.cssSelector("input[type='submit']")).click();
            SleepThread.sleep(1);  // must be deleted!!!
        }
    }

    /**
     * After calass method.
     */
    @AfterClass
    public static void after() {
        userLogin.quit();
        driver.quit();
    }
}
