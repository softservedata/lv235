package com.softserve.edu.registrator.tests.community;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.ITestContext;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;

import com.softserve.edu.registrator.data.apps.ApplicationSourcesRepository;
import com.softserve.edu.registrator.data.apps.ApplicationUtils;
import com.softserve.edu.registrator.data.users.UserRepository;
import com.softserve.edu.registrator.pages.AdminHomePage;
import com.softserve.edu.registrator.pages.Application;
import com.softserve.edu.registrator.tests.TestRunner;

public class CommunityTestRunner extends TestRunner {
    protected final Logger logger = LoggerFactory.getLogger(this.getClass());

    /**
     * object Home Page for Administrator.
     */
	private AdminHomePage adminHomePage;

	@BeforeClass
    public void beforeClass(ITestContext context) {
        System.out.println("@BeforeClass");
        Application.get(ApplicationUtils
                .updateAll(ApplicationSourcesRepository.getChromeTraining(), context));
        adminHomePage = Application.get()
        		.load()
        		.successAdminLogin(UserRepository.get().admin());
    }

    @AfterClass
    public void afterClass() {
        System.out.println("@AfterClass");
        Application.remove();
    }

    @Override
    @BeforeMethod
    public void beforeMethod() {
        System.out.println("@BeforeMethod");
    }
    
    @Override
    @AfterMethod
    public void afterMethod() {
        System.out.println("@AfterMethod");
    }

	public AdminHomePage getAdminHomePage() {
		return adminHomePage;
	}
	
	public void setCommunityPage(AdminHomePage adminHomePage) {
		this.adminHomePage = adminHomePage;
	}
}