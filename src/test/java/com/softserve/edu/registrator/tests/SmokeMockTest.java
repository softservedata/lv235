package com.softserve.edu.registrator.tests;

import org.mockito.Mockito;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.softserve.edu.registrator.data.users.IUser;
import com.softserve.edu.registrator.data.users.UserRepository;
import com.softserve.edu.registrator.pages.Application;
import com.softserve.edu.registrator.pages.common.LoginPage;

public class SmokeMockTest extends TestRunner {

    @DataProvider//(parallel = true)
    public Object[][] admins() {
        return new Object[][] {
                {  UserRepository.get().admin() },
        };
    }

	@Test(dataProvider = "admins")
	public void adminLogin(IUser admin) throws Exception {
		// Preconditions.
	    Application.get().load();
        Thread.sleep(2000);
		// Test Steps.
	    // Mockito.spy(...) Running Real Method First Mockito.when(loginPage.getRegister())
		//LoginPage loginPage = Mockito.spy(Application.get().load());
		LoginPage loginPage = Mockito.mock(LoginPage.class);
		//
		WebElement register = Mockito.mock(WebElement.class);
		Mockito.when(register.getText()).thenReturn("register");
		//
		//Mockito.stub(loginPage.getRegister()).toReturn(register);
		Mockito.when(loginPage.getRegister()).thenReturn(register);
		Mockito.doCallRealMethod().when(loginPage).getRegisterText();
		//
		// Checking.
		Thread.sleep(2000);
		Assert.assertEquals(loginPage.getRegisterText(), "register");;
		//
	}

}
