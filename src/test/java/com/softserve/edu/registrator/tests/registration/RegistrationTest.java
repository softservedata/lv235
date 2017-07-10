package com.softserve.edu.registrator.tests.registration;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.softserve.edu.registrator.data.users.IUser;
import com.softserve.edu.registrator.data.users.UserRepository;
import com.softserve.edu.registrator.pages.Application;
import com.softserve.edu.registrator.pages.common.AdminHomePage;
import com.softserve.edu.registrator.pages.edits.EditPage;
import com.softserve.edu.registrator.pages.registration.RegisterUserPage;
import com.softserve.edu.registrator.pages.user.ActiveUsersPage;
import com.softserve.edu.registrator.pages.user.PassiveEditUserPage;
import com.softserve.edu.registrator.pages.user.RegisteredUsersPage;
import com.softserve.edu.registrator.tests.RegistrationTestRunner;

public class RegistrationTest extends RegistrationTestRunner {

    @DataProvider
    public Object[][] credentials() {
        return new Object[][] {
            { UserRepository.get().testRegistrator() },
        };
    }

    @Test(dataProvider = "credentials")
    public void CheckUserRegistration(IUser user) throws Exception {
        
        RegisterUserPage registrationPage = getAdminHomePage().clickNewUser();
        AdminHomePage adminHomePage = registrationPage.clickCancel();
        Assert.assertEquals(Application.get().getBrowser().getCurrentUrl(),
                "http://java.training.local:8080/registrator/");
        
        registrationPage = adminHomePage.clickNewUser();
        Thread.sleep(1000);
        Assert.assertEquals(Application.get().getBrowser().getCurrentUrl(),
                "http://java.training.local:8080/registrator/manualregistration");
        
        registrationPage.registerNewUser(user);
        
        registrationPage.clickClearForm();
        Assert.assertEquals(Application.get().getBrowser().getCurrentUrl(),
                "http://java.training.local:8080/registrator/manualregistration");
                
        Thread.sleep(1000);
        registrationPage.registerNewUser(user);
        // TODO Drop database
        RegisteredUsersPage registeredUsers = registrationPage.clickSubmit();
        Thread.sleep(1000);
        Assert.assertTrue(Application.get()
                .getBrowser()
                .getCurrentUrl()
                .contains("statusType=notcomfirmed"));
        
        PassiveEditUserPage passiveEditUserPage = registeredUsers
                .gotoEditUserByLogin(user
                    .getAccount()
                    .getLogin());
        Thread.sleep(2000);
        Assert.assertTrue(Application.get()
                .getBrowser()
                .getCurrentUrl()
                .contains("edit-registrated-user"));
        Assert.assertEquals(passiveEditUserPage.getEmailInputText(), 
                user.getPerson().getEmail());

        EditPage editPage = passiveEditUserPage.clickEditPageButton();
        editPage.getEditBasicInfo().setActiveUser();
        editPage.getEditBasicInfo().setRoleValue(user.getAccount().getRole());
        Thread.sleep(2000);
                
        ActiveUsersPage activeUsersPage = editPage.clickConfirmButton();
        Assert.assertEquals(activeUsersPage.getTable().getCell(activeUsersPage
                .getTable()
                .getRowIndexByValueInColumn(
                        user
                        .getAccount()
                        .getLogin(), 3)
                , 3).getText(),
                user.getAccount().getLogin());        
        Thread.sleep(3000);
        
        
//        ActiveUsersPage activeUsersPage = passiveEditUserPage
//                .gotoActiveUsers();
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
//        LoginPage loginPage = activeUsersPage.logout();
//        CommonPage commonPage = loginPage.successLogin(user);
//        Assert.assertEquals(commonPage.getLoginAccountText(),
//                user.getAccount().getLogin());
        
    }
}
