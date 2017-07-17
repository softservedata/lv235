package com.softserve.edu.registrator.tests.edit;

import com.softserve.edu.registrator.data.users.IUser;
import com.softserve.edu.registrator.tests.TestRunner;
import com.softserve.edu.registrator.tests.community.AdminHomePageTestRunner;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.softserve.edu.registrator.data.users.UserRepository;
import com.softserve.edu.registrator.pages.Application;
import com.softserve.edu.registrator.pages.common.AdminHomePage;
import com.softserve.edu.registrator.pages.edits.EditPage;
import com.softserve.edu.registrator.pages.user.ActiveUsersPage;
import com.softserve.edu.registrator.pages.user.PassiveEditUserPage;

/**
 * Test to editing passport information
 *
 * @version 1.2
 * @author Ihor
 *
 */
public class EditPassportInfoTest extends TestRunner{
	/**
	 * Data provider
	 * @return the test data
	 */
	@DataProvider
	public Object[][] EditPassportInfo() {
		return new Object[][]{
				{UserRepository.get().testActiveUserSearch(),}
		};
	}

	/**
	 * Delay for Thread.Sleep().
	 */
	private final int DELAY_FOR_DEMO = 1000;

	AdminHomePage adminHomePage;

	/**
	 * For login as administrator
	 */
	@BeforeClass
	public void goToActiveUserPage() {
		adminHomePage = Application.get().load().successAdminLogin(UserRepository.get().admin());
	}

	/**
	 * Test for editing passport fields
	 *
	 * @throws Exception
	 *             - used by Thread.sleep() for DEMO
	 */
	@Test(dataProvider = "EditPassportInfo")
	public void SearchTestBasicInfo(IUser data) throws Exception {
        logger.info("Started");
		PassiveEditUserPage passiveEditPage = adminHomePage.gotoActiveUsers()
				.gotoEditUserByLogin(data.getAccount().getLogin());
		Thread.sleep(DELAY_FOR_DEMO);
		// Go to Edit page by Login
		EditPage editPage = passiveEditPage.clickEditPageButton();
		// Editing
		editPage.getEditPassportInfo().setSeriaFiledValue(data.getPassport().getSeria());
		editPage.getEditPassportInfo().setNumberFieldValue(data.getPassport().getNumber());
		Thread.sleep(DELAY_FOR_DEMO);
		editPage.getEditPassportInfo().setPublishFieldValue(data.getPassport().getPublished());
		Thread.sleep(DELAY_FOR_DEMO);
		ActiveUsersPage activeUsersPage = editPage.clickConfirmButton();
		Thread.sleep(DELAY_FOR_DEMO);
		// Go to Edit page by Login
		activeUsersPage.gotoEditUserByLogin(data.getAccount().getLogin());
		Thread.sleep(DELAY_FOR_DEMO);
		EditPage editBasic = passiveEditPage.clickEditPageButton();
		// test for editing BasicInfoComponent
		Assert.assertEquals(editBasic.getEditPassportInfo().getSeriaValueText()
				, data.getPassport().getSeria());
		Assert.assertEquals(editBasic.getEditPassportInfo().getNumberValueText()
				, data.getPassport().getNumber());
		Assert.assertEquals(editBasic.getEditPassportInfo().getPublishValueText()
				, data.getPassport().getPublished());
		logger.info("Done");
		System.out.println(data.getPassport().getPublished());
	}

	/**
	 * Close browser
	 */
	@AfterClass
	public void closeBrowser() {
		Application.get().getBrowser().quit();
	}
}
