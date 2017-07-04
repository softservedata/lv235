package com.softserve.edu.registrator.tests;

import org.testng.ITestContext;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;

import com.softserve.edu.registrator.data.apps.ApplicationSourcesRepository;
import com.softserve.edu.registrator.data.apps.ApplicationUtils;
import com.softserve.edu.registrator.data.users.UserRepository;
import com.softserve.edu.registrator.pages.Application;
import com.softserve.edu.registrator.pages.common.AdminHomePage;

public class RegistrationTestRunner extends TestRunner {

    private AdminHomePage adminHomePage;
    
    @BeforeClass
    public void beforeClass(ITestContext context) {
        System.out.println("@BeforeClass");
        Application.get(ApplicationUtils
                .updateAll(ApplicationSourcesRepository.getChromeTraining(), context));
    }

    @AfterClass
    public void afterClass() {
        System.out.println("@AfterClass");
        Application.remove();
    }

    @BeforeMethod
    public void beforeMethod() {
        System.out.println("@BeforeMethod");
        adminHomePage = Application.get().load()
                .successAdminLogin(UserRepository.get().admin());
    }

    @AfterMethod
    public void afterMethod() {
        System.out.println("@AfterMethod");
        Application.get().logout();
    }

    public AdminHomePage getAdminHomePage() {
        return adminHomePage;
    }

    public void setAdminHomePage(AdminHomePage adminHomePage) {
        this.adminHomePage = adminHomePage;
    }

}
