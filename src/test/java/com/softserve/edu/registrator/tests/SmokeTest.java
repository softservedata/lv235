<<<<<<< HEAD
package com.softserve.edu.registrator.tests;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.softserve.edu.registrator.data.apps.ApplicationSourcesRepository;
import com.softserve.edu.registrator.data.users.IUser;
import com.softserve.edu.registrator.data.users.UserRepository;
import com.softserve.edu.registrator.pages.CommonPage;
import com.softserve.edu.registrator.pages.LoginPage;

public class SmokeTest {

    @DataProvider//(parallel = true)
    public Object[][] credentials() {
    	// Read from ...
        return new Object[][] { 
            //{ "admin", "admin" },
            //{ "registrator", "registrator" },
        	{ UserRepository.get().admin() },
        	{ UserRepository.get().commissioner() },
        	{ UserRepository.get().registrator() },
            };
    }

    @Test(dataProvider = "credentials")
    public void checkLogin(IUser user) throws Exception {
    //public void checkLogin(String login, String password) throws Exception {
        //
        // Precondition
        //
        // TODO Remove from test
        //System.setProperty("webdriver.chrome.driver",
        //        "./lib/chromedriver.exe");
        System.out.println("Path to driver: "
                + SmokeTest.class.getResource("/lib/chromedriver.exe").getPath());
        System.setProperty("webdriver.chrome.driver",
                SmokeTest.class.getResource("/lib/chromedriver.exe").getPath().substring(1));
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        // driver.get("http://regres.herokuapp.com/login");
        driver.get("http://java.training.local:8080/registrator/login");
        Thread.sleep(1000);
        //
        LoginPage loginPage = new LoginPage(driver);
        Thread.sleep(2000);
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
        //
        // Return to previous state
        //
        // TODO Must be deleted
        Thread.sleep(2000);
        commonPage.clickLogout();
        Thread.sleep(2000);
        driver.quit();
    }

}
=======
package com.softserve.edu.registrator.tests;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.softserve.edu.registrator.data.users.IUser;
import com.softserve.edu.registrator.data.users.UserRepository;
import com.softserve.edu.registrator.pages.CommonPage;
import com.softserve.edu.registrator.pages.LoginPage;

public class SmokeTest {

    @DataProvider//(parallel = true)
    public Object[][] credentials() {
    	// Read from ...
        return new Object[][] { 
            //{ "admin", "admin" },
            //{ "registrator", "registrator" },
        	{ UserRepository.get().admin() },
        	{ UserRepository.get().commissioner() },
        	{ UserRepository.get().registrator() },
            };
    }

    @Test(dataProvider = "credentials")
    public void checkLogin(IUser user) throws Exception {
    //public void checkLogin(String login, String password) throws Exception {
        //
        // Precondition
        //
        // TODO Remove from test
        //System.setProperty("webdriver.chrome.driver",
        //        "./lib/chromedriver.exe");
        System.out.println("Path to driver: "
                + SmokeTest.class.getResource("/lib/chromedriver.exe").getPath());
        System.setProperty("webdriver.chrome.driver",
                SmokeTest.class.getResource("/lib/chromedriver.exe").getPath().substring(1));
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        // driver.get("http://regres.herokuapp.com/login");
        driver.get("http://java.training.local:8080/registrator/login");
        Thread.sleep(1000);
        //
        LoginPage loginPage = new LoginPage(driver);
        Thread.sleep(2000);
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
        //
        // Return to previous state
        //
        // TODO Must be deleted
        Thread.sleep(2000);
        commonPage.clickLogout();
        Thread.sleep(2000);
        driver.quit();
    }

}
>>>>>>> 98de4368300538b047f570aa9d10bd9417bd2e73
