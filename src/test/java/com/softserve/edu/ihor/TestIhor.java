package com.softserve.edu.ihor;

import com.softserve.edu.registrator.data.users.IUser;
import com.softserve.edu.registrator.data.users.UserRepository;
import com.softserve.edu.registrator.pages.ActiveCoownersPage;
import com.softserve.edu.registrator.pages.AdminHomePage;
import com.softserve.edu.registrator.pages.Application;
import com.softserve.edu.registrator.pages.EditPage;
import com.softserve.edu.registrator.tests.TestRunner;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.Collections;

/**
 * Created by User on 6/27/2017.
 */
public class TestIhor extends TestRunner {
    private WebDriver driver;

    @BeforeClass
    public void testhr(){
    AdminHomePage adminHomePage = Application.get().load().successAdminLogin(UserRepository.get().admin());
    adminHomePage.clickActive();
    }
    @Test
   public void test()throws Exception{
        ActiveCoownersPage user=new ActiveCoownersPage(driver);
       Thread.sleep(4000);
        user.getEmailField().sendKeys("erf");
    }
}
