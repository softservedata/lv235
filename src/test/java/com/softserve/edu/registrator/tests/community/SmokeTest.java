package com.softserve.edu.registrator.tests.community;

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
	    	adminHomePage.logout();
	    }
	
	    @DataProvider // (parallel = true)
	    public Object[][] seccessAdded() {
	        // Read from ...
	        return new Object[][] {
	                { new Community("mykolaiv", "")}, 
	                { new Community("Odesa", "200:00:00:000:00001")}
	                };
	    }
	    
	    @DataProvider // (parallel = true)
	    public Object[][] errorAdded() {
	        // Read from ...
	        return new Object[][] {
	                { new Community("Lviv", "")}, 
	                { new Community("Lviv", "000:00:00:000:00001")}
	                };
	    }

	    @Test(dataProvider = "seccessAdded")
	    public void checkCommunitySecces(ICommunity community) throws Exception {
	    	CommunityPage communityPage = adminHomePage.clickCommunities();
	    	communityPage = communityPage.addNewCommunity().seccesfulAddedCommunity(community);
	    	Thread.sleep(3000);
	    	communityPage = communityPage.deleteCommunity(community).ok();
	    	adminHomePage = communityPage;
	    	Thread.sleep(3000);
	    }
  
	    @Test(dataProvider = "errorAdded")
	    public void checkCommunityError(ICommunity community) throws Exception {
	    	CommunityPage communityPage = adminHomePage.clickCommunities();
	    	communityPage = communityPage.addNewCommunity().seccesfulAddedCommunity(community);
	    	Thread.sleep(3000);
	    	adminHomePage = communityPage;
	    	Thread.sleep(3000);
	    }
}
