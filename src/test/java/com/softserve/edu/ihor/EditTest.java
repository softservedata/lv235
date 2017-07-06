package com.softserve.edu.ihor;

import com.softserve.edu.registrator.data.users.UserRepository;
import com.softserve.edu.registrator.pages.Application;
import com.softserve.edu.registrator.pages.common.AdminHomePage;
import com.softserve.edu.registrator.pages.edits.EditPage;
import com.softserve.edu.registrator.pages.user.PassiveEditUserPage;
import com.softserve.edu.registrator.tests.TestRunner;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

/**
 * Created by User on 6/28/2017.
 */
public class EditTest extends TestRunner {

    AdminHomePage adminHomePage;

    @BeforeClass
    public void goToActiveUserPage(){
        adminHomePage = Application.get().load().successAdminLogin(UserRepository.get().admin());
    }

    @Test
    public void SearchTest() throws Exception{
        PassiveEditUserPage passiveEditPage = adminHomePage.gotoActiveUsers().gotoEditUserByLogin("adminIhor");
        Thread.sleep(4000);
        EditPage editPage=passiveEditPage.clickEditPageButton();
        editPage.getEditBasicInfo().setFirstNameValue("ihor");
        editPage.clickConfirmButton();


        Thread.sleep(4000);

    }
    @AfterClass
    public void closeBrowser(){
     Application.get().getBrowser().quit();
    }
}
