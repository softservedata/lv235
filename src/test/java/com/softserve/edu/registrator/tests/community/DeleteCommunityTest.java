package com.softserve.edu.registrator.tests.community;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.softserve.edu.registrator.data.communities.CommunityRepository;
import com.softserve.edu.registrator.data.communities.ICommunity;
import com.softserve.edu.registrator.pages.communities.CommunityPage;

public class DeleteCommunityTest extends AdminHomePageTestRunner {

	@DataProvider
	public Object[][] dataCommunity() {
		return new Object[][] { 
			{ CommunityRepository.getCommunityValidData() }
		};
	}
	
	@Test(dataProvider = "dataCommunity")
	public void DeleteCommunityOk(ICommunity community) throws InterruptedException {
		CommunityPage communityPage = getAdminHomePage()
				.clickCommunities()
				.deleteCommunityOk(community);
		setAdminHomePage(communityPage);
		Assert.assertTrue(communityPage.getTtableCommunity()
				.getColumnsByValue(community.getNameCommunity()).isEmpty());
	}
	
	@Test(dataProvider = "dataCommunity")
	public void DeleteCommunityCancel(ICommunity community) {
		CommunityPage communityPage = getAdminHomePage()
				.clickCommunities()
				.deleteCommunity(community)
				.cancel();
		setAdminHomePage(communityPage);
		Assert.assertTrue(!communityPage.getTtableCommunity()
				.getColumnsByValue(community.getNameCommunity()).isEmpty());
	}
  
}
