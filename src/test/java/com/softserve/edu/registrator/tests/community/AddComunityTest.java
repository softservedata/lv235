package com.softserve.edu.registrator.tests.community;

import org.testng.annotations.Test;

import com.softserve.edu.registrator.data.communities.CommunityRepository;
import com.softserve.edu.registrator.data.communities.ICommunity;
import com.softserve.edu.registrator.pages.ATopComponent.ChangeLanguageFields;
import com.softserve.edu.registrator.pages.AdminHomePage;
import com.softserve.edu.registrator.pages.Application;
import com.softserve.edu.registrator.pages.communities.AddCommunityPage;
import com.softserve.edu.registrator.pages.communities.AddCommunityPage.AddCommunityPageL10n;
import com.softserve.edu.registrator.pages.communities.CommunityPage;

import org.testng.annotations.DataProvider;
import org.testng.Assert;

public class AddComunityTest extends AdminHomePageTestRunner {

	@DataProvider
	public Object[][] communityValid() {
		return new Object[][] { { CommunityRepository.getCommunityValidName() },
				{ CommunityRepository.getCommunityValidData() } };
	}

	/**
	 * Test to create new community with valid data.
	 */
	@Test(dataProvider = "communityValid")
	public void createComunityWithValidData(ICommunity community) {
		AdminHomePage adminHomePage = getAdminHomePage().clickCommunities().addNewCommunity()
				.seccesfulAddedCommunity(community);

		if (adminHomePage instanceof CommunityPage) {
			setAdminHomePage(adminHomePage);
			Assert.assertTrue(((CommunityPage) adminHomePage).getCountOfCommunities(community) == 1);
			((CommunityPage) adminHomePage).deleteCommunityIfExist(community);
		} else {
			setAdminHomePage(adminHomePage);
			Assert.assertTrue(false);
		}

	}

	@DataProvider
	public Object[][] communityEmptyName() {
		return new Object[][] {
				{ CommunityRepository.getCommunityEmptyData(), CommunityRepository.getErrorMessageNameCommunity() },
				{ CommunityRepository.getCommunityEmptyName(), CommunityRepository.getErrorMessageNameCommunity() } };
	}

	/**
	 * Test to create new community with empty name community.
	 */
	@Test(dataProvider = "communityEmptyName")
	public void createComunityWithEmptyName(ICommunity community, String validationMessage) {
		AdminHomePage adminHomePage = getAdminHomePage().clickCommunities().addNewCommunity()
				.seccesfulAddedCommunity(community);

		if (adminHomePage instanceof CommunityPage) {
			adminHomePage = new CommunityPage(Application.get().getBrowser());
			((CommunityPage) adminHomePage).deleteCommunityIfExist(community);
			setAdminHomePage(adminHomePage);
			Assert.assertTrue(false);
		}

		adminHomePage = new AddCommunityPage(Application.get().getBrowser());
		setAdminHomePage(adminHomePage);
		Assert.assertEquals(((AddCommunityPage) adminHomePage)
				.getValidationMessageText(((AddCommunityPage) adminHomePage).getActiveElement()), validationMessage);
	}

	@DataProvider
	public Object[][] communityIncorectRegisterNumber() {
		return new Object[][] { { CommunityRepository.getCommunityIncorectNumber() } };
	}

	/**
	 * Test to create new community with incorrect number community.
	 */
	@Test(dataProvider = "communityIncorectRegisterNumber")
	public void createComunityWithIncorectRegisterNimber(ICommunity community) {
		AdminHomePage adminHomePage = getAdminHomePage().clickCommunities().addNewCommunity()
				.seccesfulAddedCommunity(community);

		if (adminHomePage instanceof CommunityPage) {
			adminHomePage = new CommunityPage(Application.get().getBrowser());
			((CommunityPage) adminHomePage).deleteCommunityIfExist(community);
			setAdminHomePage(adminHomePage);
			Assert.assertTrue(false);
		}

		adminHomePage = new AddCommunityPage(Application.get().getBrowser());
		setAdminHomePage(adminHomePage);
		Assert.assertEquals(((AddCommunityPage) adminHomePage).getRegistrationNumberErrorLabelText(),
				AddCommunityPageL10n.INCORECT_REGISTER_COMMUNITY_ERROR_LABLE_TEST
						.getLocalization(ChangeLanguageFields.UKRAINIAN));
	}

	@DataProvider
	public Object[][] communityUsedName() {
		return new Object[][] { { CommunityRepository.getCommunityUsedName() } };
	}

	/**
	 * Test to create new community with used name community.
	 */
	@Test(dataProvider = "communityUsedName")
	public void createComunityWithUsedName(ICommunity community) {
		AdminHomePage adminHomePage = getAdminHomePage().clickCommunities().addNewCommunity()
				.seccesfulAddedCommunity(community);

		if (adminHomePage instanceof CommunityPage) {
			adminHomePage = new CommunityPage(Application.get().getBrowser());
			((CommunityPage) adminHomePage).deleteCommunityIfExist(community);
			setAdminHomePage(adminHomePage);
			Assert.assertTrue(false);
		}

		adminHomePage = new AddCommunityPage(Application.get().getBrowser());
		setAdminHomePage(adminHomePage);
		Assert.assertEquals(((AddCommunityPage) adminHomePage).getNameCommunityErrorLabelText(),
				AddCommunityPageL10n.NAME_COMMUNITY_USED_ERROR_LABLE_TEST
						.getLocalization(ChangeLanguageFields.UKRAINIAN));
	}

	@DataProvider
	public Object[][] communityIncorectName() {
		return new Object[][] { { CommunityRepository.getCommunityIncorectName() } };
	}

	/**
	 * Test to create new community with INCORECT name community.
	 */
	@Test(dataProvider = "communityIncorectName")
	public void createComunityWithIncorectName(ICommunity community) {
		AdminHomePage adminHomePage = getAdminHomePage().clickCommunities().addNewCommunity()
				.seccesfulAddedCommunity(community);

		if (adminHomePage instanceof CommunityPage) {
			adminHomePage = new CommunityPage(Application.get().getBrowser());
			adminHomePage = ((CommunityPage) adminHomePage).deleteCommunityIfExist(community);
			setAdminHomePage(adminHomePage);
			Assert.assertTrue(false);
		}

		adminHomePage = new AddCommunityPage(Application.get().getBrowser());
		setAdminHomePage(adminHomePage);
		Assert.assertTrue(((AddCommunityPage) adminHomePage).getErrorLables().size() == 1);
	}

	@DataProvider
	public Object[][] communityUsedNumber() {
		return new Object[][] { { CommunityRepository.getCommunityUsedNumber() } };
	}

	/**
	 * Test to create new community with used Number Community.
	 */
	@Test(dataProvider = "communityUsedNumber")
	public void createComunityWithUsedNumber(ICommunity community) {
		AdminHomePage adminHomePage = getAdminHomePage().clickCommunities().addNewCommunity()
				.seccesfulAddedCommunity(community);

		if (adminHomePage instanceof CommunityPage) {
			adminHomePage = new CommunityPage(Application.get().getBrowser());
			adminHomePage = ((CommunityPage) adminHomePage).deleteCommunityIfExist(community);

			setAdminHomePage(adminHomePage);
			Assert.assertTrue(false);
		}

		adminHomePage = new AddCommunityPage(Application.get().getBrowser());
		setAdminHomePage(adminHomePage);
		Assert.assertTrue(((AddCommunityPage) adminHomePage).getErrorLables().size() == 1);
	}
}
