package com.softserve.edu.registrator.tests.community;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.softserve.edu.registrator.data.communities.CommunityRepository;
import com.softserve.edu.registrator.data.communities.ICommunity;
import com.softserve.edu.registrator.pages.common.AdminHomePage;
import com.softserve.edu.registrator.pages.communities.CommunityPage;


public class SmokeTest extends AdminHomePageTestRunner {
	
	    @DataProvider 
	    public Object[][] community() {
	        return new Object[][] {
	                { CommunityRepository.getCommunityValidData()}
	                };
	    }

	    @Test(dataProvider = "community")
	    public void checkCommunityAdd(ICommunity community) throws Exception {
	    	AdminHomePage adminHomePage = getAdminHomePage()
	    			.clickCommunities()
	    			.addNewCommunity()
	    			.seccesfulAddedCommunity(community);
	    	Assert.assertTrue(!((CommunityPage)adminHomePage).getTtableCommunity().getRowsByValue(community.getNameCommunity()).isEmpty()); 	
	    	Thread.sleep(1000);
	    	setAdminHomePage(adminHomePage);
	    }
}
