package com.softserve.edu.registrator.tests;

import com.softserve.edu.registrator.pages.AdminHomePage;
import org.testng.ITestContext;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;

import com.softserve.edu.registrator.data.apps.ApplicationSourcesRepository;
import com.softserve.edu.registrator.data.apps.ApplicationUtils;
import com.softserve.edu.registrator.pages.Application;

public class TestRunner {
    // Use, if class Application is not singleton
    // protected Application application;
    private AdminHomePage adminHomePage;
    @BeforeClass
    public void beforeClass(ITestContext context) {
        System.out.println("@BeforeClass");
        // System.out.println("***@BeforeClass MAVEN"
        // + System.getProperty("surefire.reports.directory"));
        // Use, if class Application is not singleton
        // application = new Application();
        //Application.get(ApplicationSourcesRepository.getChromeTraining());
//        Application.get(ApplicationUtils
//                .updateFromTestNgXML(ApplicationSourcesRepository.getChromeTraining(), context));
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
        //Application.get().load();
        // Application.get().login();
    }

    @AfterMethod
    public void afterMethod() {
        System.out.println("@AfterMethod");
    }

}
