package com.softserve.edu.test.resourses;

import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

/**
 * Class for login user.
 * @author Ivan
 */
public final class UserLogin {

    /**
     * Emplicid wait time.
     */
    private static final int TIME_FOR_WAIT = 5;

    /**
     * instanse.
     */
    private static  UserLogin userLogin;

    /**
     * Web Driver.
     */
    private WebDriver webDriver;

    /**
     * private constructor.
     * @param driver Web Driver.
     */
    private UserLogin(final WebDriver driver) {
        this.webDriver = driver;
    }

    /**
     * getting object UserLogin.
     * @param driver Web Driver.
     * @return object this class.
     */
    public static UserLogin getUserLogin(final WebDriver driver) {
        if ((userLogin) == null) {
            userLogin = new UserLogin(driver);
        }
        return userLogin;
    }

    /**
     * Logining user.
     */
    public void login()  {
        webDriver.manage().timeouts()
                .implicitlyWait(TIME_FOR_WAIT, TimeUnit.SECONDS);
        webDriver.get("http://java.training.local:8080/registrator/login");
        webDriver.findElement(By.id("login")).click();
        webDriver.findElement(By.id("login")).clear();
        webDriver.findElement(By.id("login")).sendKeys("admin");
        webDriver.findElement(By.id("password")).click();
        webDriver.findElement(By.id("password")).clear();
        webDriver.findElement(By.id("password")).sendKeys("admin");
        webDriver.findElement(By.cssSelector(".btn.btn-primary")).submit();
    }

    /**
     * logout user.
     */
    public void quit() {
        SleepThread.sleep(2);
        webDriver.findElement(
                By.cssSelector(".btn.btn-primary.btn-sm.dropdown-toggle"))
                .click();
        webDriver.findElement(
                By.xpath("//a[contains(@href,'/logout')]"))
                .click();
    }
}
