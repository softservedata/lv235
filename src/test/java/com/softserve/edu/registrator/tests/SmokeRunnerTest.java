package com.softserve.edu.registrator.tests;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.softserve.edu.registrator.data.users.IUser;
import com.softserve.edu.registrator.data.users.UserRepository;
import com.softserve.edu.registrator.pages.Application;
import com.softserve.edu.registrator.pages.common.CommonPage;
import com.softserve.edu.registrator.pages.user.PassiveEditUserPage;

public class SmokeRunnerTest extends TestRunner {

    @DataProvider // (parallel = true)
    public Object[][] credentials() {
        // Read from ...
        return new Object[][] {
                { UserRepository.get().admin() },
                //{ UserRepository.get().commissioner() },
                //{ UserRepository.get().registrator() },
                };
    }

    //@Test(dataProvider = "credentials")
    public void checkLogin(IUser user) throws Exception {
        //
        CommonPage commonPage = Application.get().load()
                .successLogin(user);
        Thread.sleep(2000);
        //
        Assert.assertEquals(commonPage.getLoginAccountText(),
                user.getAccount().getLogin());
        Thread.sleep(2000);
    }

    @DataProvider // (parallel = true)
    public Object[][] credentialsExistingUser() {
        // Read from ...
        return new Object[][] {
                { UserRepository.get().admin(), UserRepository.get().commissioner() },
                };
    }

    @Test(dataProvider = "credentialsExistingUser")
    public void checkExistingUser(IUser adminUser, IUser existUser) throws Exception {
        logger.info("Start");
        //
        PassiveEditUserPage passiveEditUserPage = Application.get().load()
                .successAdminLogin(adminUser)
                .gotoActiveUsers()
                .gotoEditUserByLogin(existUser.getAccount().getLogin());
        Thread.sleep(2000);
        //
        Assert.assertEquals(passiveEditUserPage.getEmailInputText(),
                existUser.getPerson().getEmail());
        Thread.sleep(2000);
        //
        logger.info("Done");
    }

}