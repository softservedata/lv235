package com.softserve.edu.registrator.tests.community;

import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.softserve.edu.registrator.data.communities.Community;
import com.softserve.edu.registrator.data.communities.ICommunity;
import com.softserve.edu.registrator.data.users.UserRepository;
import com.softserve.edu.registrator.pages.AdminHomePage;
import com.softserve.edu.registrator.pages.Application;
import com.softserve.edu.registrator.pages.communities.CommunityPage;
import com.softserve.edu.registrator.tests.TestRunner;


public class SmokeTest extends TestRunner {
		
		AdminHomePage adminHomePage;
	
	    @BeforeClass
	    public void beforeClass() {
	    	adminHomePage = Application.get().load().successAdminLogin(UserRepository.get().admin());
	    }
	
	    @AfterClass
	    public void afterClass() {
	    	Application.get().getBrowser().quit();
	    }
	
	    @DataProvider 
	    public Object[][] community() {
	        return new Object[][] {
	                { new Community("mykolaiv", "")}
	                };
	    }

	    @Test(dataProvider = "community")
	    public void checkCommunitySecces(ICommunity community) throws Exception {
	    	CommunityPage communityPage = adminHomePage.clickCommunities();
	    	communityPage = communityPage.addNewCommunity().seccesfulAddedCommunity(community);
	    	Assert.assertTrue(!communityPage.getTtableCommunity().getRowsByValue(community.getNameCommunity()).isEmpty()); 	
	        communityPage.deleteCommunity(community).ok(); //TODO
	    	Thread.sleep(3000);
	    }
}
