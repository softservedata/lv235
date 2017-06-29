package com.softserve.edu.andrii;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.softserve.edu.ihor.EditPage;
import com.softserve.edu.registrator.data.users.IUser;
import com.softserve.edu.registrator.data.users.UserRepository;
import com.softserve.edu.registrator.pages.ActiveUsersPage;
import com.softserve.edu.registrator.pages.AdminHomePage;
import com.softserve.edu.registrator.pages.Application;
import com.softserve.edu.registrator.pages.CommonPage;
import com.softserve.edu.registrator.pages.LoginPage;
import com.softserve.edu.registrator.pages.PassiveEditUserPage;
import com.softserve.edu.registrator.pages.RegisteredUsersPage;
import com.softserve.edu.registrator.pages.registration.RegisterUserPage;
import com.softserve.edu.registrator.tests.RegistrationTestRunner;

public class RegistrationTest extends RegistrationTestRunner {

    @DataProvider
    public Object[][] credentials() {
        return new Object[][] {
            { UserRepository.get().testAdmin() },
            { UserRepository.get().testCoowner() },
//            { UserRepository.get().testCommissioner() },
//            { UserRepository.get().testRegistrator() },
        };
    }

    @Test(dataProvider = "credentials")
    public void CheckUserRegistration(IUser user) throws Exception {
        System.out.println("\t\t\t\t+++++TEST RUNNING+++++");
        Thread.sleep(2000);
        
        RegisterUserPage registrationPage = getAdminHomePage().clickNewUser();
        AdminHomePage adminHomePage = registrationPage.clickCancel();
        Assert.assertEquals(Application.get().getBrowser().getCurrentUrl(),
                "http://java.training.local:8080/registrator/");
        
        registrationPage = adminHomePage.clickNewUser();
        Thread.sleep(2000);
        Assert.assertEquals(Application.get().getBrowser().getCurrentUrl(),
                "http://java.training.local:8080/registrator/manualregistration");
        
        registrationPage.registerNewUser(user);
        Thread.sleep(2000);
        
        registrationPage.clickClearForm();
        Thread.sleep(2000);
        Assert.assertEquals(Application.get().getBrowser().getCurrentUrl(),
                "http://java.training.local:8080/registrator/manualregistration");
        
        registrationPage.registerNewUser(user);
        Thread.sleep(2000);
        // TODO Drop database
//        RegisteredUsersPage registeredUsers = registrationPage.clickSubmit();
        RegisteredUsersPage registeredUsers = registrationPage.clickNonConfirmed();
        
        Thread.sleep(2000);
        Assert.assertTrue(Application.get()
                .getBrowser()
                .getCurrentUrl()
                .contains("statusType=notcomfirmed"));
        
        PassiveEditUserPage passiveEditUserPage = registeredUsers
                .gotoEditUserByLogin(user
                    .getAccount()
                    .getLogin());
        Thread.sleep(2000);
        
        // TODO CHANGE USER STATUS AND ROLE
               
        EditPage editPage = passiveEditUserPage.clickEditPageButton();
        editPage.getEditBasicInfo().setActiveUser();
        editPage.getEditBasicInfo().setRoleValue(user.getAccount().getRole());
        Thread.sleep(2000);
        
        
        ActiveUsersPage activeUsersPage = passiveEditUserPage
                .gotoActiveUsers();
//        Assert.assertEquals(activeUsersPage.getTable().getCell(activeUsersPage
//                .getTable()
//                .getRowIndexByValueInColumn(
//                        user
//                        .getAccount()
//                        .getLogin(), 3)
//                , 3).getText(),
//                user.getAccount().getLogin());        
//        Thread.sleep(3000);
//        
        LoginPage loginPage = activeUsersPage.logout();
//        CommonPage commonPage = loginPage.successLogin(user);
//        Assert.assertEquals(commonPage.getLoginAccountText(),
//                user.getAccount().getLogin());
        
    }
}
