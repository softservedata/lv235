package com.softserve.edu.registrator.tests.community;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.softserve.edu.registrator.data.communities.Community;
import com.softserve.edu.registrator.data.communities.ICommunity;
import com.softserve.edu.registrator.pages.communities.CommunityPage;

public class DeleteCommunityTest extends AdminHomePageTestRunner {

	@DataProvider
	public Object[][] dataCommunity() {
		return new Object[][] { 
			{ new Community("Kyiv", "") }
		};
	}
	
	@Test(dataProvider = "dataCommunity")
	public void DeleteCommunityOk(ICommunity community) {
		CommunityPage communityPage = getAdminHomePage()
				.clickCommunities()
				.deleteCommunityOk(community);
		setCommunityPage(communityPage);
		Assert.assertTrue(communityPage.getTtableCommunity()
				.getColumnsByValue(community.getNameCommunity()).isEmpty());
	}
	
	@Test(dataProvider = "dataCommunity")
	public void DeleteCommunityCancel(ICommunity community) {
		CommunityPage communityPage = getAdminHomePage()
				.clickCommunities()
				.deleteCommunity(community)
				.cancel();
		setCommunityPage(communityPage);
		Assert.assertTrue(!communityPage.getTtableCommunity()
				.getColumnsByValue(community.getNameCommunity()).isEmpty());
	}
  
}
