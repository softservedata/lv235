package com.softserve.edu.registrator.tests;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.softserve.edu.registrator.pages.ATopComponent.ChangeLanguageFields;
import com.softserve.edu.registrator.pages.LoginPage;
import com.softserve.edu.registrator.pages.LoginPage.LoginPageL10n;

public class I18nTest {

    @DataProvider // (parallel = true)
    public Object[][] localization() {
        return new Object[][] {
                { ChangeLanguageFields.UKRAINIAN },
                { ChangeLanguageFields.RUSSIAN },
                { ChangeLanguageFields.ENGLISH } };
    }

    @Test(dataProvider = "localization")
    public void checkLocalization(ChangeLanguageFields language) throws Exception {
        //
        // Precondition
        //
        // TODO Remove from test
        System.setProperty("webdriver.chrome.driver",
                "./lib/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        // driver.get("http://regres.herokuapp.com/login");
        driver.get("http://java.training.local:8080/registrator/login");
        Thread.sleep(1000);
        //
        // Steps
        //
        LoginPage loginPage = new LoginPage(driver);
        Thread.sleep(2000);
        loginPage = loginPage.changeLanguage(language);
        //
        // Check
        System.out.println("Start Assert LOGIN_LABEL");
        Assert.assertEquals(loginPage.getLoginLabelText(),
                LoginPageL10n.LOGIN_LABEL.getLocalization(language));
        System.out.println("Start Assert PASSWORD_LABEL");
        Assert.assertEquals(loginPage.getPasswordLabelText(),
                LoginPageL10n.PASSWORD_LABEL.getLocalization(language));
        // LoginPageL10n.PASSWORD_LABEL.getLocalization(language)+"1");
        System.out.println("Start Assert SUBMIT_BUTTON");
        Assert.assertEquals(loginPage.getSignintText(),
                LoginPageL10n.SUBMIT_BUTTON.getLocalization(language));
        //
        // TODO Must be deleted
        Thread.sleep(5000);
        //
        // Return to previous state
        driver.quit();
    }

}
