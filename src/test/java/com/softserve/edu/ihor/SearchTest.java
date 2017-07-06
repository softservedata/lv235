package com.softserve.edu.ihor;
import com.softserve.edu.registrator.data.users.IUser;
import com.softserve.edu.registrator.data.users.UserRepository;
import com.softserve.edu.registrator.pages.Application;
import com.softserve.edu.registrator.pages.common.AdminHomePage;
import com.softserve.edu.registrator.tests.TestRunner;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

/**
 * Created by User on 6/27/2017.
 */
public class SearchTest extends TestRunner {

    AdminHomePage adminHomePage;

    @BeforeClass
    public void goToActiveUserPage() {
        adminHomePage = Application.get().load().successAdminLogin(UserRepository.get().admin());
    }

    @Test
    public void SearchTest() throws Exception {
//    // ActiveCoownersPage activeCoownersPage=adminHomePage.clickActive();
//     activeCoownersPage.inputInFirstNameField("ihor");
//     activeCoownersPage.clickSearchButton();
//     Thread.sleep(4000);
    // Assert.assertTrue();
    }

    @AfterClass
    public void closeBrowser(){
        Application.get().getBrowser().quit();
    }
}
