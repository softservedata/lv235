package com.softserve.edu.registrator.tests.registration;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.softserve.edu.registrator.data.users.IUser;
import com.softserve.edu.registrator.data.users.UserRepository;
import com.softserve.edu.registrator.pages.common.CommonPage;
import com.softserve.edu.registrator.pages.common.LoginPage;
import com.softserve.edu.registrator.pages.registration.RegisterUserPage;
import com.softserve.edu.registrator.tests.SmokeTest;
import com.softserve.edu.registrator.tests.TestRunner;

public class RegisterSmokeTest extends TestRunner {
    
    @DataProvider
    public Object[][] userTestData() {
        return new Object[][] {
            {UserRepository.get().admin()}
        };
    }
    
    @Test(dataProvider = "userTestData")
    public void checkUnsuccessfulRegistration(IUser user) throws Exception {
        System.out.println("Path to driver: "
                + SmokeTest.class.getResource("/lib/chromedriver.exe").getPath());
        System.setProperty("webdriver.chrome.driver",
                SmokeTest.class.getResource("/lib/chromedriver.exe").getPath().substring(1));
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        // driver.get("http://regres.herokuapp.com/login");
        driver.get("http://java.training.local:8080/registrator/login");
        //
        LoginPage loginPage = new LoginPage();
        //
        // Steps
        //
        //CommonPage commonPage = loginPage.successLogin(login, password);
        CommonPage commonPage = loginPage.successLogin(user);
        Thread.sleep(2000);
        //
        // Check
        //
        //Assert.assertEquals(commonPage.getLoginAccountText(), login);
        Assert.assertEquals(commonPage.getLoginAccountText(), user.getAccount().getLogin());
        
        driver.get("http://java.training.local:8080/registrator/manualregistration");
        
        RegisterUserPage registerUserPage = new RegisterUserPage();
        
        registerUserPage.registerNewUser(user);
        Assert.assertEquals("Цей логін уже використовується", 
                registerUserPage.getMainInfo().getLoginErrorLabel().getText());
        Thread.sleep(2000);
        
        driver.close();
    }
    
}
