package com.softserve.edu.registrator.tests;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.softserve.edu.registrator.data.external.ListUtils;
import com.softserve.edu.registrator.data.users.IUser;
import com.softserve.edu.registrator.data.users.UserRepository;
import com.softserve.edu.registrator.pages.Application;
import com.softserve.edu.registrator.pages.common.ATopComponent.ChangeLanguageFields;
import com.softserve.edu.registrator.pages.common.CommonPage;
import com.softserve.edu.registrator.pages.common.LoginPage;
import com.softserve.edu.registrator.pages.common.LoginPage.LoginPageL10n;
import com.softserve.edu.registrator.pages.user.PassiveEditUserPage;
import com.softserve.edu.registrator.tools.assertion.FlexAssert;

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

    @DataProvider // (parallel = true)
    public Object[][] external() {
        //return ListUtils.toMultiArray(UserRepository.get().fromCVSFile());
        return ListUtils.toMultiArray(UserRepository.get().fromExcelFile());
    }

    //@Test(dataProvider = "credentials")
  //  @Test(dataProvider = "external")
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
                { UserRepository.get().admin(),
                  UserRepository.get().commissioner() },
                };
    }

    //@Test(dataProvider = "credentialsExistingUser")
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

    @DataProvider//(parallel = true)
    public Object[][] localization() {
        return new Object[][] {
            //{ ChangeLanguageFields.UKRAINIAN },
            { ChangeLanguageFields.RUSSIAN },
            //{ ChangeLanguageFields.ENGLISH }
            };
    }

    @Test(dataProvider = "localization")
    public void checkLocalization(ChangeLanguageFields language) throws Exception {
        System.out.println("Start, language = " + language.toString());
        // Steps
        LoginPage loginPage = Application.get().load();
        Thread.sleep(1000);
        loginPage = loginPage.changeLanguage(language);
        //
        // Check
        System.out.println("Checking LOGIN_LABEL ...");
        FlexAssert.assertEquals(loginPage.getLoginLabelText(),
                LoginPageL10n.LOGIN_LABEL.getLocalization(language));
        //
        System.out.println("Checking PASSWORD_LABEL ...");
        //
        String addError = new String();
        if (language == ChangeLanguageFields.RUSSIAN) {
            addError = "_ERROR";
        }
        FlexAssert.assertEquals(loginPage.getPasswordLabelText(),
                //LoginPageL10n.PASSWORD_LABEL.getLocalization(language));
                LoginPageL10n.PASSWORD_LABEL.getLocalization(language) + addError);
        //
        System.out.println("Checking SUBMIT_BUTTON ...");
        FlexAssert.assertEquals(loginPage.getSignintText(),
                LoginPageL10n.SUBMIT_BUTTON.getLocalization(language));
        //
        // MUST BE DELETE
        Thread.sleep(2000);
        //
        // Return to previous state
        //driver.quit();
        FlexAssert.assertAll();
    }

}
