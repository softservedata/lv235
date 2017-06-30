package com.softserve.edu.registrator.tests.community;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.softserve.edu.registrator.data.communities.Community;
import com.softserve.edu.registrator.data.communities.ICommunity;
import com.softserve.edu.registrator.pages.AdminHomePage;
import com.softserve.edu.registrator.pages.communities.CommunityPage;


public class SmokeTest extends AdminHomePageTestRunner {
	
	    @DataProvider 
	    public Object[][] community() {
	        return new Object[][] {
	                { new Community("Kyiv", "470:09:30:461:05471")}
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
