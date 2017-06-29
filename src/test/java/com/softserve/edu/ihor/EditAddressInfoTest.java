package com.softserve.edu.ihor;

import com.softserve.edu.registrator.data.users.UserRepository;
import com.softserve.edu.registrator.pages.ActiveUsersPage;
import com.softserve.edu.registrator.pages.AdminHomePage;
import com.softserve.edu.registrator.pages.Application;
import com.softserve.edu.registrator.pages.PassiveEditUserPage;
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
public class EditAddressInfoTest {
    /**
     * Delay for Thread.Sleep().
     */
    private final int DELAY_FOR_DEMO = 1000;

    /**
     * For login as administrator
     */

    AdminHomePage adminHomePage;

    /**
     * For login as administrator
     */
    @BeforeClass
    public void goToActiveUserPage() {
        adminHomePage = Application.get().load().successAdminLogin(UserRepository.get().admin());
    }

    /**
     * Test for editing address fields
     * @throws Exception - used by Thread.sleep() for DEMO
     */
    @Test
    public void SearchTestBasicInfo() throws Exception {

        PassiveEditUserPage passiveEditPage = adminHomePage.gotoActiveUsers().gotoEditUserByLogin("adminIhor");
        Thread.sleep(DELAY_FOR_DEMO);
        //Go to Edit page by Login
        EditPage editPage = passiveEditPage.clickEditPageButton();
        //Editing
        editPage.getEditAddressInfo().setCityFieldValue("Lviv");
        editPage.getEditAddressInfo().setRegionFieldValue("Lvivska");
        editPage.getEditAddressInfo().setFlatFieldValue("34");
        ActiveUsersPage activeUsersPage = editPage.clickConfirmButton();
        //Go to Edit page by Login
        activeUsersPage.gotoEditUserByLogin("adminIhor");
        EditPage editBasic = passiveEditPage.clickEditPageButton();
        //test for editing AddressInfoComponent
        Assert.assertEquals(editBasic.getEditAddressInfo().getCityValueText(),"Lviv");
        Assert.assertEquals(editBasic.getEditAddressInfo().getRegionValueText(),"Lvivska");
        Assert.assertEquals(editBasic.getEditAddressInfo().getFlatValueNumber(),"34");
    }

    /**
     * Close browser
     */
    @AfterClass
    public void closeBrowser() {
        Application.get().getBrowser().quit();
    }
}


