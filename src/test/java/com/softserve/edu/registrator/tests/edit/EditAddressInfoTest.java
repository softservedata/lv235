package com.softserve.edu.registrator.tests.edit;

import com.softserve.edu.registrator.data.users.IUser;
import com.softserve.edu.registrator.data.users.UserRepository;
import com.softserve.edu.registrator.pages.Application;
import com.softserve.edu.registrator.pages.common.AdminHomePage;
import com.softserve.edu.registrator.pages.edits.EditPage;
import com.softserve.edu.registrator.pages.user.ActiveUsersPage;
import com.softserve.edu.registrator.pages.user.PassiveEditUserPage;

import com.softserve.edu.registrator.tests.TestRunner;
import com.softserve.edu.registrator.tests.community.AdminHomePageTestRunner;
import com.softserve.edu.registrator.tools.logs.ReporterWrapper;
import jdk.internal.instrumentation.Logger;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.sql.Wrapper;

/**
 * Test to editing passport information
 *@version 1.2
 *@author Ihor
 *
 */
public class EditAddressInfoTest extends TestRunner{


    /**
     * Data provider
     * @return the test data
     */
    @DataProvider
    public Object[][] searchData() {
        return new Object[][]{
                {UserRepository.get().testActiveUserSearch(),}
        };
    }
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
    @Test(dataProvider = "EditAddressInfo")
    public void SearchTestBasicInfo(IUser data) throws Exception {
        logger.info("Started");
        PassiveEditUserPage passiveEditPage = adminHomePage.gotoActiveUsers()
                .gotoEditUserByLogin(data.getAccount().getLogin());
        Thread.sleep(DELAY_FOR_DEMO);
        //Go to Edit page by Login
        EditPage editPage = passiveEditPage.clickEditPageButton();
        //Editing
        editPage.getEditAddressInfo().setCityFieldValue(data.getAddress().getCity());
        editPage.getEditAddressInfo().setRegionFieldValue(data.getAddress().getRegion());
        editPage.getEditAddressInfo().setFlatFieldValue(data.getAddress().getFlat());
        ActiveUsersPage activeUsersPage = editPage.clickConfirmButton();
        //Go to Edit page by Login
        activeUsersPage.gotoEditUserByLogin(data.getAccount().getLogin());
        EditPage editBasic = passiveEditPage.clickEditPageButton();
        //test for editing AddressInfoComponent
        Assert.assertEquals(editBasic.getEditAddressInfo().getCityValueText()
                ,data.getAddress().getCity());
        Assert.assertEquals(editBasic.getEditAddressInfo().getRegionValueText()
                ,data.getAddress().getRegion());
        Assert.assertEquals(editBasic.getEditAddressInfo().getFlatValueNumber()
                ,data.getAddress().getFlat());
        logger.info("Done");
    }

    /**
     * Close browser
     */
    @AfterClass
    public void closeBrowser() {
        Application.get().getBrowser().quit();
    }
}


