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
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * Class for testing adding new communoty.
 * @author Ivan
 */
public class AddComunityTests {

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
     * Emplicid wait time.
     */
    private static final int TIME_FOR_WAIT = 5;

    /**
     * method before class.
     */
    @BeforeClass
    public static void beforeClass() {
        driver = InitsializeWebDriver.getChromeDriver();
        driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
        userLogin = UserLogin.getUserLogin(driver);
        userLogin.login();
        folderName = FileHelper.createDerectory("AddNewComunity");
    }

    /**
     * Test to create new community with valid name and valid number community.
     */
    @Test
    public void createComunityWithValidData() {
        String name = "Ternopil";
        String number = "214:35:09:346:45789";
        File screenShot = addComunity(name, number);
        if (!isPresentComunity(name)) {
            String nameFolder = "TestValidData";
            FileHelper.saveBugAttachments(
                    folderName + "/" + nameFolder, screenShot, driver);
            DeletingComunity.getDeletingComunity(driver)
                    .deleteComunityIfExistOk(name);
            Assert.fail();
        }
        DeletingComunity.getDeletingComunity(driver)
                .deleteComunityIfExistOk(name);
        SleepThread.sleep(1); // mus be deleted
    }

    /**
     * Test to create new community with valid name and empty number community.
     */
    @Test
    public void createComunityWithValidNameEmptyNumber() {
        String name = "Kyiv";
        String number = "";
        File screenShot = addComunity(name, number);
        if (!isPresentComunity(name)) {
            String nameFolder = "TestValidNameEmptyNumber";
            FileHelper.saveBugAttachments(
                    folderName + "/" + nameFolder, screenShot, driver);
            DeletingComunity.getDeletingComunity(driver)
                    .deleteComunityIfExistOk(name);
            Assert.fail();
        }
        DeletingComunity.getDeletingComunity(driver)
                .deleteComunityIfExistOk(name);
        SleepThread.sleep(1); // mus be deleted
    }

    /**
     * Test to create new community with valid name and
     * invalid number community.
     */
    @Test
    public void createComunityWithValidNameInvalidNumber() {
        String name = "Odessa";
        String number = "123";
        File screenShot = addComunity(name, number);
        if (!isPresentErrorLabel("Невірний формат")) {
            String nameFolder = "TestValidNameInvalidNumber";
            FileHelper.saveBugAttachments(
                    folderName + "/" + nameFolder, screenShot, driver);
            DeletingComunity.getDeletingComunity(driver)
                    .deleteComunityIfExistOk(name);
            Assert.fail();
        }
        DeletingComunity.getDeletingComunity(driver)
                .deleteComunityIfExistOk(name);
        SleepThread.sleep(1); // mus be deleted
    }

    /**
     * Test to create new community with valid name and eused number community.
     */
    @Test
    public void createComunityWithValidNameUsedNumber() {
        String name = "Ivano-Frankivsk";
        String number = "000:25:09:376:40009";
        File screenShot = addComunity(name, number);
        if (driver.findElements(By.xpath("//form//span")).size() != 1) {
            String nameFolder = "TestValidNameUsedNumber";
            FileHelper.saveBugAttachments(
                    folderName + "/" + nameFolder, screenShot, driver);
            DeletingComunity.getDeletingComunity(driver)
                    .deleteComunityIfExistOk(name);
            Assert.fail();
        }
        DeletingComunity.getDeletingComunity(driver)
                .deleteComunityIfExistOk(name);
        SleepThread.sleep(1); // mus be deleted
    }

    /**
     * Test to create new community with used name and empty number community.
     */
    @Test
    public void createComunityWithUsedNameEmptyNumber() {
        String name = "Lviv";
        String number = "";
        File screenShot = addComunity(name, number);
        if (!isPresentErrorLabel("Підклас з вказаним іменем вже існує")) {
            String nameFolder = "TestUsedNameEmptyNumber";
            FileHelper.saveBugAttachments(
                    folderName + "/" + nameFolder, screenShot, driver);
            Assert.fail();
        }
        SleepThread.sleep(1); // mus be deleted
    }

    /**
     * Test to create new community with valid name and
     * invalid number community.
     */
    @Test
    public void createComunityWithUsedNameInvalidNumber() {
        String name = "Lviv";
        String number = "123";
        File screenShot = addComunity(name, number);
        if (!isPresentErrorLabel("Підклас з вказаним іменем вже існує")
                || !isPresentErrorLabel("Невірний формат")) {
            String nameFolder = "TestUsedNameInvalidNumber";
            FileHelper.saveBugAttachments(
                    folderName + "/" + nameFolder, screenShot, driver);
            Assert.fail();
        }
        SleepThread.sleep(1); // mus be deleted
    }

    /**
     * Test to create new community with used name and used number community.
     */
    @Test
    public void createComunityWithUsedNameUsedNumber() {
        String name = "Lviv";
        String number = "000:25:09:376:40009";
        File screenShot = addComunity(name, number);
        if (driver.findElements(By.cssSelector("#body span")).size() != 2) {
            String nameFolder = "TestUsedNumberUsedNumber";
            FileHelper.saveBugAttachments(
                    folderName + "/" + nameFolder, screenShot, driver);
            Assert.fail();
        }
        SleepThread.sleep(1); // mus be deleted
    }

    /**
     * Test to create new community with empty name.
     */
    @Test
    public void createComunityWithEmptyName() {
        String name = "";
        String number = "123";
        File screenShot = addComunity(name, number);
        if (!driver.switchTo().activeElement().getAttribute("validationMessage")
                .equals("Заповніть це поле.")) {
            FileHelper.saveBugAttachments(
                    folderName + "/TestEmptyName", screenShot, driver);
            DeletingComunity.getDeletingComunity(driver)
                    .deleteComunityIfExistOk(name);
            Assert.fail();
        }
        SleepThread.sleep(1); // mus be deleted
    }

    /**
     * Test to create new community with invalid name and
     * empty number community.
     */
    @Test
    public void createComunityWithInvalidNameEmptyNumber() {
        String name = "/.";
        String number = "";
        File screenShot = addComunity(name, number);
        if (driver.findElements(By.cssSelector("#body span")).size() != 1) {
            String nameFolder = "TestInvalidNameEmptyNumber";
            FileHelper.saveBugAttachments(
                    folderName + "/" + nameFolder, screenShot, driver);
            DeletingComunity.getDeletingComunity(driver)
                    .deleteComunityIfExistOk(name);
            Assert.fail();
        }
        SleepThread.sleep(1); // mus be deleted
    }

    /**
     * Test to create new community with invalid name and
     * invalid number community.
     */
    @Test
    public void createComunityWithInvalidNameInvalidNumber() {
        String name = "/.";
        String number = "123";
        File screenShot = addComunity(name, number);
        if (driver.findElements(By.cssSelector("#body span")).size() != 2) {
            String nameFolder = "TestInvalidNameInvalidNumber";
            FileHelper.saveBugAttachments(
                    folderName + "/" + nameFolder, screenShot, driver);
            DeletingComunity.getDeletingComunity(driver)
                    .deleteComunityIfExistOk(name);
            Assert.fail();
        }
        SleepThread.sleep(1); // mus be deleted
    }

    /**
     * Test to create new community with invalid name and used number community.
     */
    @Test
    public void createComunityWithInvalidNameUsedNumber() {
        String name = "#4/^";
        String number = "123:54:67:123:98734";
        File screenShot = addComunity(name, number);
        if (driver.findElements(By.cssSelector("#body span")).size() != 1) {
            String nameFolder = "TestInvalidNameUsedNamber";
            FileHelper.saveBugAttachments(
                    folderName + "/" + nameFolder, screenShot, driver);
            DeletingComunity.getDeletingComunity(driver)
                    .deleteComunityIfExistOk(name);
            Assert.fail();
        }
        SleepThread.sleep(1); // mus be deleted
    }

    /**
     * Test verify if field is empty by defult.
     */
    @Test
    public void isEmptyFiledByDefault() {
        driver.findElement(
                By.xpath("//a[contains(@href,'/show-all-communities')]"))
                .click();
        File screenShot = ((TakesScreenshot) driver)
                .getScreenshotAs(OutputType.FILE);
        driver.findElement(By.cssSelector("a[href= 'addCommunity']")).click();
        SleepThread.sleep(1); // mus be deleted
        if (!driver.findElement(By.name("name")).getText().equals("")
                && !driver.findElement(
                        By.name("registrationNumber")).getText().equals("")) {
            String nameFolder = "TestEmptyFiledByDefault";
            FileHelper.saveBugAttachments(
                    folderName + "/" + nameFolder, screenShot, driver);
            Assert.fail();
        }
        SleepThread.sleep(1); // mus be deleted
    }

    /**
     * Test verify if field is empty after clik butoon cancel.
     */
    @Test
    public void isEmptyFiledAfterCancel() {
        driver.findElement(
                By.xpath("//a[contains(@href,'/show-all-communities')]"))
                .click();
        driver.findElement(By.cssSelector("a[href= 'addCommunity']")).click();
        File screenShot = ((TakesScreenshot) driver)
                .getScreenshotAs(OutputType.FILE);
        driver.findElement(By.name("name")).sendKeys("Harkiv");
        driver.findElement(By.name("registrationNumber"))
                .sendKeys("111:22:55:666:99999");
        driver.findElement(By.cssSelector("button[type='reset']")).click();
        SleepThread.sleep(2); // mus be deleted
        if (!driver.findElement(By.name("name")).getText().equals("")
                && !driver.findElement(
                        By.name("registrationNumber")).getText().equals("")) {
            String nameFolder = "TestEmptyFiledAfterClear";
            FileHelper.saveBugAttachments(
                    folderName + "/" + nameFolder, screenShot, driver);
            Assert.fail();
        }
        SleepThread.sleep(1); // mus be deleted
    }

    /**
     * After calass method.
     */
    @AfterClass
    public static void afterClass() {
        userLogin.quit();
        driver.quit();
    }

    /**
     * Method adding comunity.
     * @param name Community name.
     * @param number Community number.
     * @return screenShot.
     */
    public File addComunity(final String name, final String number) {
        WebDriverWait wait = new WebDriverWait(driver, TIME_FOR_WAIT);
        wait.until(ExpectedConditions.elementToBeClickable(driver
                .findElement(By.xpath(
                     "//a[contains(@href,'/show-all-communities')]"))));
        SleepThread.sleep(1); // mus be deleted
        driver.findElement(
                By.xpath("//a[contains(@href,'/show-all-communities')]"))
                .click();
        driver.findElement(By.cssSelector("a[href= 'addCommunity']")).click();
        SleepThread.sleep(1); // mus be deleted
        driver.findElement(By.name("name")).click();
        driver.findElement(By.name("name")).clear();
        driver.findElement(By.name("name")).sendKeys(name);
        driver.findElement(By.name("registrationNumber")).click();
        driver.findElement(By.name("registrationNumber")).clear();
        driver.findElement(By.name("registrationNumber")).sendKeys(number);
        SleepThread.sleep(1); // mus be deleted
        File viewBeforeTestExecute = ((TakesScreenshot) driver)
                .getScreenshotAs(OutputType.FILE);
        driver.findElement(By.cssSelector("input[type = 'submit']")).click();
        SleepThread.sleep(1); // mus be deleted
        return viewBeforeTestExecute;
    }

    /**
     * Verify if error lable is visible.
     * @param message error message.
     * @return result.
     */
    public boolean isPresentErrorLabel(final String message) {
        return driver.findElements(
                By.xpath("//span[text() = '" + message + "']")).size() > 0;
    }

    /**
     * Verify if community presented in list.
     * @param name Community name.
     * @return result.
     */
    public boolean isPresentComunity(final String name) {
        return driver.findElements(
                By.xpath("//td/a[text() = '" + name + "']")).size() > 0;
    }
}
