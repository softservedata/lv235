package com.softserve.edu.registrator.tests.community;

import org.testng.annotations.Test;

import com.softserve.edu.registrator.data.communities.Community;
import com.softserve.edu.registrator.data.communities.ICommunity;
import com.softserve.edu.registrator.pages.ATopComponent.ChangeLanguageFields;
import com.softserve.edu.registrator.pages.communities.AddCommunityPage;
import com.softserve.edu.registrator.pages.communities.AddCommunityPage.AddCommunityPageL10n;
import com.softserve.edu.registrator.pages.communities.CommunityPage;

import org.testng.annotations.DataProvider;
import org.testng.Assert;

public class AddComunityTest extends AdminHomePageTestRunner {

	@DataProvider
	public Object[][] communityValid() {
		return new Object[][] { 
			{ new Community("Mykolaiv", "") }, 
			{ new Community("Kyiv", "120:00:94:860:35001") } 
			};
	}

	/**
	 * Test to create new community with valid data.
	 */
	@Test(dataProvider = "communityValid")
	public void createComunityWithValidData(ICommunity community) {
		CommunityPage communityPage = getAdminHomePage().clickCommunities().addNewCommunity()
				.seccesfulAddedCommunity(community);
		Assert.assertTrue(communityPage.getCountOfCommunities(community) == 1);
		setCommunityPage(communityPage);
		communityPage.deleteCommunityIfExist(community);
	}

	@DataProvider
	public Object[][] communityEmptyName() {
		return new Object[][] { { new Community("", ""), "Please fill out this field." },
				{ new Community("", "124:00:94:960:35001"), "Please fill out this field." } };
	}

	/**
	 * Test to create new community with empty name community.
	 */
	@Test(dataProvider = "communityEmptyName")
	public void createComunityWithEmptyName(ICommunity community, String validationMessage) {
		AddCommunityPage addCommunityPage = getAdminHomePage().clickCommunities().addNewCommunity()
				.errorAddedCommunity(community);
		setCommunityPage(addCommunityPage);
		if (getAdminHomePage() instanceof CommunityPage) {
			((CommunityPage) getAdminHomePage()).deleteCommunityIfExist(community);
		}
		Assert.assertEquals(addCommunityPage.getValidationMessageText(addCommunityPage.getActiveElement()),
				validationMessage);
	}

	@DataProvider
	public Object[][] communityIncorectRegisterNumber() {
		return new Object[][] {
				{ new Community("*]sv12.'", "srb")},
				{ new Community("Kyiv", "376")}
		};
	}

	/**
	 * Test to create new community with incorrect number community.
	 */
	@Test(dataProvider = "communityIncorectRegisterNumber")
	public void createComunityWithIncorectRegisterNimber(ICommunity community) {
		AddCommunityPage addCommunityPage = getAdminHomePage().clickCommunities().addNewCommunity()
				.errorAddedCommunity(community);
		setCommunityPage(addCommunityPage);
		if (addCommunityPage.getCountofRegNumberErrorLabels() == 0) {
			if (getAdminHomePage() instanceof CommunityPage) {
				((CommunityPage) getAdminHomePage()).deleteCommunityIfExist(community);
			}
			Assert.assertTrue(false);
		}
		Assert.assertEquals(addCommunityPage.getRegistrationNumberErrorLabelText(),
				AddCommunityPageL10n.INCORECT_REGISTER_COMMUNITY_ERROR_LABLE_TEST
				.getLocalization(ChangeLanguageFields.UKRAINIAN));
	}
	
	
	@DataProvider
	public Object[][] communityUsedName() {
		return new Object[][] {
				{ new Community("Lviv", "")},
				{ new Community("Lviv", "262:07:60:025:68001")}
		};
	}
	
	/**
	 * Test to create new community with used name community.
	 */
	@Test(dataProvider = "communityUsedName")
	public void createComunityWithUsedName(ICommunity community) {
		AddCommunityPage addCommunityPage = getAdminHomePage().clickCommunities().addNewCommunity()
				.errorAddedCommunity(community);
		setCommunityPage(addCommunityPage);
		if (addCommunityPage.getCountofRegNumberErrorLabels() == 0) {
			if (getAdminHomePage() instanceof CommunityPage) {
				((CommunityPage) getAdminHomePage()).deleteCommunityIfExist(community);
			}
			Assert.assertTrue(false);
		}
		Assert.assertEquals(addCommunityPage.getNameCommunityErrorLabelText(),
				AddCommunityPageL10n.NAME_COMMUNITY_USED_ERROR_LABLE_TEST
				.getLocalization(ChangeLanguageFields.UKRAINIAN));
	}
}
