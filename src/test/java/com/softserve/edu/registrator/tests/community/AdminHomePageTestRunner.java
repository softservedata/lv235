package com.softserve.edu.registrator.tests.community;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.ITestContext;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;

import com.softserve.edu.registrator.data.apps.ApplicationSourcesRepository;
import com.softserve.edu.registrator.data.apps.ApplicationUtils;
import com.softserve.edu.registrator.data.users.UserRepository;
import com.softserve.edu.registrator.pages.Application;
import com.softserve.edu.registrator.pages.common.AdminHomePage;
import com.softserve.edu.registrator.tests.TestRunner;

public class AdminHomePageTestRunner extends TestRunner {
    protected final Logger logger = LoggerFactory.getLogger(this.getClass());

    /**
     * object Home Page for Administrator.
     */
	private AdminHomePage adminHomePage;

	@Override
	@BeforeClass
    public void beforeClass(ITestContext context) {
        Application.get(ApplicationUtils
                .updateAll(ApplicationSourcesRepository.getChromeTraining(), context));
        adminHomePage = Application.get()
        		.load()
        		.successAdminLogin(UserRepository.get().admin());
    }
	
	@Override
    @AfterClass
    public void afterClass() {
        //TODO must be deleted
        try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
    }
    
	
    @AfterSuite
    public void afterSuit() {
        Application.remove();
    }

    @Override
    @BeforeMethod
    public void beforeMethod() { }
    
    @Override
    @AfterMethod
    public void afterMethod() {
    	//TODO must be deleted
        try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
    }

	public AdminHomePage getAdminHomePage() {
		return adminHomePage;
	}
	
	public void setAdminHomePage(AdminHomePage adminHomePage) {
		this.adminHomePage = adminHomePage;
	}
}