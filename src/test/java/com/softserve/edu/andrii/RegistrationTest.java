package com.softserve.edu.andrii;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.softserve.edu.registrator.data.users.IUser;
import com.softserve.edu.registrator.data.users.UserRepository;
import com.softserve.edu.registrator.pages.AdminHomePage;
import com.softserve.edu.registrator.pages.Application;
import com.softserve.edu.registrator.pages.RegisteredUsersPage;
import com.softserve.edu.registrator.pages.registration.RegisterUserPage;
import com.softserve.edu.registrator.tests.RegistrationTestRunner;

public class RegistrationTest extends RegistrationTestRunner {

    @DataProvider
    public Object[][] credentials() {
        return new Object[][] {
            { UserRepository.get().testAdmin() },
//            { UserRepository.get().testCoowner() },
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
        RegisteredUsersPage registeredUsers = registrationPage.clickSubmit();
        
        Thread.sleep(2000);
        Assert.assertTrue(Application.get()
                .getBrowser()
                .getCurrentUrl()
                .contains("statusType=notcomfirmed"));
        
        registeredUsers.gotoEditUserByLogin(user
                    .getAccount()
                    .getLogin());
        Thread.sleep(2000);
        
        
        
        
    }
}
