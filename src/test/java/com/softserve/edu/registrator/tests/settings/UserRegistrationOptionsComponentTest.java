package com.softserve.edu.registrator.tests.settings;

import org.junit.Assert;
import org.testng.annotations.Test;

import com.softserve.edu.registrator.data.users.UserRepository;
import com.softserve.edu.registrator.pages.Application;
import com.softserve.edu.registrator.pages.LoginPage;
import com.softserve.edu.registrator.pages.commissioner.CommissionerHomePage;
import com.softserve.edu.registrator.pages.settings.SettingsPage;
import com.softserve.edu.registrator.tests.TestRunner;

public class UserRegistrationOptionsComponentTest extends TestRunner {

	// public static final Logger LOG = Logger
	// .getLogger(UserRegistrationOptionsComponentTest.class);

	@Test
	public void personalRegistrationTest() throws InterruptedException {
		SettingsPage settingsPage = Application.get().load()
				.successAdminLogin(UserRepository.get().admin())
				.clickSettings();
		settingsPage.getUserRegistrationOptionsComponent()
				.clickPersonalRegistration();
		settingsPage.clickConfirmChangesButton();
		Assert.assertTrue(settingsPage.isAlertPresent());
		settingsPage = new SettingsPage(Application.get().getBrowser());
		LoginPage loginPage = settingsPage.logout();
		Assert.assertTrue(loginPage.isRegisterPresent());
		CommissionerHomePage commissionerHomePage = Application.get().load()
				.successCommissionerLogin(UserRepository.get().commissioner());
		Assert.assertFalse(commissionerHomePage.isRegisterNewUserPresent());
	}

	@Test
	public void manualRegistrationTest() {
		SettingsPage settingsPage = Application.get().load()
				.successAdminLogin(UserRepository.get().admin())
				.clickSettings();
		settingsPage.getUserRegistrationOptionsComponent()
				.clickManualRegistration();
		settingsPage.clickConfirmChangesButton();
		Assert.assertTrue(settingsPage.isAlertPresent());
		settingsPage = new SettingsPage(Application.get().getBrowser());
		LoginPage loginPage = settingsPage.logout();
		Assert.assertFalse(loginPage.isRegisterPresent());
		CommissionerHomePage commissionerHomePage = Application.get().load()
				.successCommissionerLogin(UserRepository.get().commissioner());
		Assert.assertTrue(commissionerHomePage.isRegisterNewUserPresent());
	}

	@Test
	public void mixedRegistrationTest() {
		SettingsPage settingsPage = Application.get().load()
				.successAdminLogin(UserRepository.get().admin())
				.clickSettings();
		settingsPage.getUserRegistrationOptionsComponent()
				.clickMixedRegistration();
		settingsPage.clickConfirmChangesButton();
		Assert.assertTrue(settingsPage.isAlertPresent());
		settingsPage = new SettingsPage(Application.get().getBrowser());
		LoginPage loginPage = settingsPage.logout();
		Assert.assertTrue(loginPage.isRegisterPresent());
		CommissionerHomePage commissionerHomePage = Application.get().load()
				.successCommissionerLogin(UserRepository.get().commissioner());
		Assert.assertTrue(commissionerHomePage.isRegisterNewUserPresent());
	}
}
