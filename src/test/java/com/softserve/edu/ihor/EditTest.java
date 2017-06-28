package com.softserve.edu.ihor;

import com.softserve.edu.registrator.data.users.UserRepository;
import com.softserve.edu.registrator.pages.AdminHomePage;
import com.softserve.edu.registrator.pages.Application;
import com.softserve.edu.registrator.pages.PassiveEditUserPage;
import com.softserve.edu.registrator.tests.TestRunner;
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
        EditPage editPage = passiveEditPage.clickEdditButton();
    }
    @AfterClass
    public void closeBrowser(){

    }
}
