package com.softserve.edu.test.resourses;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * Class for deleting exists comunity.
 * @author Ivan
 *
 */
public final class DeletingComunity {

    /**
     * Emplicid wait time.
     */
    private static final int TIME_FOR_WAIT = 5;

    /**
     * Instanse for creating singelton.
     */
    private static DeletingComunity instanse;

    /**
     * field for acces to browser.
     */
    private WebDriver webDriver;

    /**
     * private constructor.
     * @param driver for acces to browser
     */
    private DeletingComunity(final WebDriver driver) {
        this.webDriver = driver;
    }

    /**
     * method for creation or getting instanse DeletingComunity.
     * @param driver for acces to browser
     * @return object DeletingComunity.
     */
    public static DeletingComunity getDeletingComunity(
            final WebDriver driver)  {
        if ((instanse) == null) {
            instanse = new DeletingComunity(driver);
        }
        return instanse;
    }

    /**
     * Delete comunity if it exist.
     * @param nameComunity Name comunity for deleting.
     */
    public void deleteComunityIfExistOk(final String nameComunity) {
        webDriver.findElement(By.xpath(
                "//a[contains(@href,'/show-all-communities')]")).click();
        SleepThread.sleep(1); // mus be deleted
        if (isExistComunity(nameComunity)) {
            webDriver.findElement(By.xpath("//a[text() = '" + nameComunity
                    + "']/../..//a[contains(@href,'deleteCommunity/')]"))
                    .click();
            WebDriverWait wait = new WebDriverWait(webDriver, TIME_FOR_WAIT);
            wait.until(ExpectedConditions.visibilityOf(webDriver.findElement(
                    By.cssSelector("button[class='btn btn-primary']"))));
            webDriver.findElement(
                    By.xpath("//button[@class='btn btn-primary']")).click();
        }
    }

    /**
     * Method verify if community is exist in list.
     * @param nameComunity name COmunity for deleting.
     * @return is comunity exist in list.
     */
    private boolean isExistComunity(final String nameComunity) {
        return webDriver.findElements(By.xpath("//a[text() = '" + nameComunity
                + "']/../..//a[contains(@href,'deleteCommunity/')]"))
                .size() > 0;
    }

    /**
     * cancel deleting comunity if it exist.
     * @param nameComunity Name comunity for deleting.
     */
    public void deleteComunityIfExistCancel(final String nameComunity) {
        webDriver.findElement(By.xpath(
                "//a[contains(@href,'/show-all-communities')]")).click();
        SleepThread.sleep(1); // mus be deleted
        if (isExistComunity(nameComunity)) {
            webDriver.findElement(By.xpath("//a[text() = '" + nameComunity
                    + "']/../..//a[contains(@href,'deleteCommunity/')]"))
                    .click();
            WebDriverWait wait = new WebDriverWait(webDriver, TIME_FOR_WAIT);
            wait.until(ExpectedConditions.visibilityOf(webDriver.findElement(
                    By.cssSelector("button[class='btn btn-primary']"))));
            webDriver.findElement(
                    By.xpath("//button[@class='btn btn-default']")).click();
            SleepThread.sleep(1); // mus be deleted
        }
    }
}
