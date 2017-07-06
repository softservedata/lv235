package com.softserve.edu.registrator.tests.edit;

import com.softserve.edu.registrator.data.users.UserRepository;
import com.softserve.edu.registrator.pages.Application;
import com.softserve.edu.registrator.pages.common.AdminHomePage;
import com.softserve.edu.registrator.pages.edits.EditPage;
import com.softserve.edu.registrator.pages.user.ActiveUsersPage;
import com.softserve.edu.registrator.pages.user.PassiveEditUserPage;
import com.softserve.edu.registrator.tests.TestRunner;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

/**
 * Test to editing passport information
 * 
 * @version 1.2
 * @author Ihor
 *
 */
public class EditBasicInfoTest extends TestRunner {

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
	 * 
	 * @throws Exception
	 *             - used by Thread.sleep() for DEMO
	 */
	@Test
	public void SearchTestBasicInfo() throws Exception {

		PassiveEditUserPage passiveEditPage = adminHomePage.gotoActiveUsers().gotoEditUserByLogin("adminIhor");
		Thread.sleep(DELAY_FOR_DEMO);
		// Go to Edit page by Login
		EditPage editPage = passiveEditPage.clickEditPageButton();
		// Editing
		editPage.getEditBasicInfo().setFirstNameValue("ihor");
		editPage.getEditBasicInfo().setSecondNameValue("IvaTestSurname");
		editPage.getEditBasicInfo().setEmailValue("IvaTest@gmail.com");
		ActiveUsersPage activeUsersPage = editPage.clickConfirmButton();
		// Go to Edit page by Login
		activeUsersPage.gotoEditUserByLogin("adminIhor");
		EditPage editBasic = passiveEditPage.clickEditPageButton();
		// test for editing BasicInfoComponent
		Assert.assertEquals(editBasic.getEditBasicInfo().getFirstNameValueText(), "ihor");
		Assert.assertEquals(editBasic.getEditBasicInfo().getSecondNameValueText(), "IvaTestSurname");
		Assert.assertEquals(editBasic.getEditBasicInfo().getEmailValueText(), "IvaTest@gmail.com");
	}

	/**
	 * Close browser
	 */
	@AfterClass
	public void closeBrowser() {
		Application.get().getBrowser().quit();
	}
}
