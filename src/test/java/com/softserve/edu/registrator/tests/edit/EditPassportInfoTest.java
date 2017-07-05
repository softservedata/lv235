package com.softserve.edu.registrator.tests.edit;

import com.softserve.edu.registrator.data.users.UserRepository;
import com.softserve.edu.registrator.pages.ActiveUsersPage;
import com.softserve.edu.registrator.pages.AdminHomePage;
import com.softserve.edu.registrator.pages.Application;
import com.softserve.edu.registrator.pages.PassiveEditUserPage;
import com.softserve.edu.registrator.pages.edits.EditPage;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

/**
 * Test to editing passport information
 *@version 1.2
 *@author Ihor
 *
 */
public class EditPassportInfoTest {

    /**
     * Delay for Thread.Sleep().
     */
    private final int DELAY_FOR_DEMO = 1000;

    AdminHomePage adminHomePage;

    /**
     * For login as administrator
     */
    @BeforeClass
    public void goToActiveUserPage() {
        adminHomePage = Application.get().load().successAdminLogin(UserRepository.get().admin());
    }

    /**
     * Test for editing passport fields
     * @throws Exception - used by Thread.sleep() for DEMO
     */
    @Test
    public void SearchTestBasicInfo() throws Exception {

        PassiveEditUserPage passiveEditPage = adminHomePage.gotoActiveUsers().gotoEditUserByLogin("adminIhor");
        Thread.sleep(DELAY_FOR_DEMO);
        //Go to Edit page by Login
        EditPage editPage = passiveEditPage.clickEditPageButton();
        //Editing
        editPage.getEditPassportInfo().setSeriaFiledValue("ЛЛ");
        editPage.getEditPassportInfo().setNumberFieldValue("123456");
        editPage.getEditPassportInfo().setPublishFieldValue("1234567");
        ActiveUsersPage activeUsersPage = editPage.clickConfirmButton();
        //Go to Edit page by Login
        activeUsersPage.gotoEditUserByLogin("adminIhor");
        EditPage editBasic = passiveEditPage.clickEditPageButton();
        //test for editing BasicInfoComponent
        Assert.assertEquals(editBasic.getEditPassportInfo().getSeriaValueText(),"ЛЛ");
        Assert.assertEquals(editBasic.getEditPassportInfo().getNumberValueText(),"123456");
        Assert.assertEquals(editBasic.getEditPassportInfo().getPublishValueText(),"1234567");
    }

    /**
     * Close browser
     */
    @AfterClass
    public void closeBrowser() {
        Application.get().getBrowser().quit();
    }
}
