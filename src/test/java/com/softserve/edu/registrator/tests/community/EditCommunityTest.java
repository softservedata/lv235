package com.softserve.edu.registrator.tests.community;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.softserve.edu.registrator.data.communities.Community;
import com.softserve.edu.registrator.data.communities.ICommunity;
import com.softserve.edu.registrator.pages.AdminHomePage;
import com.softserve.edu.registrator.pages.communities.CommunityPage;
import com.softserve.edu.registrator.pages.communities.EditCmmunityPage;

public class EditCommunityTest extends AdminHomePageTestRunner {

	@DataProvider
	public Object[][] dataCommunity() {
		return new Object[][] {
				{ new Community("Kyiv", "470:09:30:461:05471")} };
	}

	@Test(dataProvider = "dataCommunity")
	public void editCommunityCancel(ICommunity community) {
		EditCmmunityPage editCommunityPage = getAdminHomePage()
				.clickCommunities()
				.editCommunity(community);
		editCommunityPage.setCommunityData(community);
		CommunityPage communityPage = editCommunityPage.clickCommunities();
		
		Assert.assertTrue(!communityPage.getTtableCommunity().getRowsByValue(community.getNameCommunity()).isEmpty());
		setAdminHomePage(communityPage);				
	}
	
	
	@DataProvider
	public Object[][] dataCommunitiesAll() {
		return new Object[][] {
				{ new Community("Kyiv", "470:09:30:461:05471"), new Community("Kyiv2", "120:00:94:860:35001") } };
	}
	
	@Test(dataProvider = "dataCommunitiesAll")
	public void editCommunityAllOk(ICommunity communityBeforeEdit, ICommunity communityAfterEdit) {
		CommunityPage communityPage = getAdminHomePage()
				.clickCommunities()
				.editCommunity(communityBeforeEdit)
				.seccesfulEditedCommunity(communityAfterEdit);
		
		Assert.assertTrue(!communityPage.getTtableCommunity().getRowsByValue(communityAfterEdit.getNameCommunity()).isEmpty());
		
		communityPage = communityPage.editCommunity(communityAfterEdit)
				.seccesfulEditedCommunity(communityBeforeEdit);
		
		setAdminHomePage(communityPage);				
	}
	
	
	@DataProvider
	public Object[][] dataCommunitiesNumner() {
		return new Object[][] {
				{ new Community("Kyiv", "470:09:30:461:05471"), new Community("Kyiv", "120:00:94:860:35001") } };
	}
	
	@Test(dataProvider = "dataCommunitiesNumner")
	public void editCommunityNumnerOk(ICommunity communityBeforeEdit, ICommunity communityAfterEdit) {
		AdminHomePage adminHomePage = getAdminHomePage()
				.clickCommunities()
				.editCommunity(communityBeforeEdit)
				.seccesfulEditedCommunity(communityAfterEdit);
		
		if(adminHomePage instanceof CommunityPage){
			Assert.assertTrue(!((CommunityPage)adminHomePage).getTtableCommunity().getRowsByValue(communityAfterEdit.getNameCommunity()).isEmpty()
					&& !((CommunityPage)adminHomePage).getTtableCommunity().getRowsByValue(communityAfterEdit.getRegistrationNumber()).isEmpty());
			adminHomePage = ((CommunityPage)adminHomePage).editCommunity(communityAfterEdit)
					.seccesfulEditedCommunity(communityBeforeEdit);
		} else {
			Assert.assertTrue(false);
		}
		
		setAdminHomePage(adminHomePage);				
	}

}
