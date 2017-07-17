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
import com.softserve.edu.registrator.tools.assertion.FlexAssert;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
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
	 * Data provider
	 * @return the test data
	 */
	@DataProvider
	public Object[][] EditBasicInfo() {
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
		logger.info("Started");
		adminHomePage = Application.get().load().successAdminLogin(UserRepository.get().admin());
	}

	/**
	 * Test for editing address fields
	 * 
	 * @throws Exception
	 *             - used by Thread.sleep() for DEMO
	 */
	@Test(dataProvider = "EditBasicInfo")
	public void SearchTestBasicInfo(IUser data) throws Exception {
        logger.info("Started");
		PassiveEditUserPage passiveEditPage = adminHomePage.gotoActiveUsers().gotoEditUserByLogin(
				data.getAccount().getLogin());
		Thread.sleep(DELAY_FOR_DEMO);
		// Go to Edit page by Login
		EditPage editPage = passiveEditPage.clickEditPageButton();
		// Editing
		editPage.getEditBasicInfo().setFirstNameValue(data.getPerson().getFirstname());
		editPage.getEditBasicInfo().setSecondNameValue(data.getPerson().getLastname());
		editPage.getEditBasicInfo().setEmailValue(data.getPerson().getEmail());
		ActiveUsersPage activeUsersPage = editPage.clickConfirmButton();
		// Go to Edit page by Login
		activeUsersPage.gotoEditUserByLogin(data.getAccount().getLogin());
		EditPage editBasic = passiveEditPage.clickEditPageButton();
		// test for editing BasicInfoComponent
		Assert.assertEquals(editBasic.getEditBasicInfo().getFirstNameValueText()
				, data.getPerson().getFirstname());
		Assert.assertEquals(editBasic.getEditBasicInfo().getSecondNameValueText()
				, data.getPerson().getLastname());
		Assert.assertEquals(editBasic.getEditBasicInfo().getEmailValueText()
				, data.getPerson().getEmail());
		logger.info("Done");
	}

	/**
	 * Close browser
	 */
	@AfterClass
	public void closeBrowser() {
		Application.get().getBrowser().quit();
		logger.info("Done");
	}
}
