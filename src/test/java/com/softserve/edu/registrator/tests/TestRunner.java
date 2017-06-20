package com.softserve.edu.registrator.tests;

import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;

import com.softserve.edu.registrator.data.apps.ApplicationSourcesRepository;
import com.softserve.edu.registrator.pages.Application;

public class TestRunner {
    // Use, if class Application is not singleton
    // protected Application application;

    @BeforeClass
    public void beforeClass() {
        System.out.println("@BeforeClass");
        // System.out.println("***@BeforeClass MAVEN"
        // + System.getProperty("surefire.reports.directory"));
        // Use, if class Application is not singleton
        // application = new Application();
        Application.get(ApplicationSourcesRepository.getChromeTraining());
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
        Application.get().logout();
    }

}
