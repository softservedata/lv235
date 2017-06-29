package com.softserve.edu.andrii;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.softserve.edu.registrator.data.users.IUser;
import com.softserve.edu.registrator.data.users.UserRepository;
import com.softserve.edu.registrator.pages.ActiveUsersPage;
import com.softserve.edu.registrator.tests.RegistrationTestRunner;

public class CheckActiveUserSearchTest extends RegistrationTestRunner {

    @DataProvider
    public Object[][] credentials() {
        return new Object[][] {
            { UserRepository.get().admin() },
        };
    }

    @Test(dataProvider = "credentials")
    public void test(IUser user) throws Exception {
        ActiveUsersPage page = getAdminHomePage().clickActive();
        page.getTable().getRowByValueInColumn(user.getAccount().getLogin(), 3);
        
        Assert.assertEquals(page.getTable().getCell(page
                .getTable()
                .getRowIndexByValueInColumn(user.getAccount().getLogin(), 3), 3).getText(),
                user.getAccount().getLogin());
        Thread.sleep(3000);
        
    }
}
