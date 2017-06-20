package com.softserve.edu.registrator;

import java.util.HashMap;

import org.testng.Assert;
import org.testng.ITestContext;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.softserve.edu.registrator.data.users.UserRepository;

public class AppTest {
    
    @BeforeSuite
    //public void beforeSuite() {
    public void beforeSuite(ITestContext context) {
        System.out.println("@BeforeSuite");
//        HashMap<String, String> allParameters = new HashMap<String, String>(
//                context.getCurrentXmlTest().getAllParameters());
//        for (String key : allParameters.keySet()) {
//            System.out.println("*** parameter: key=" + key + " value=" + allParameters.get(key));
//        }
    }

    @AfterSuite
    public void afterSuite() {
        System.out.println("@AfterSuite");
    }

    @BeforeTest
    //public void beforeTest() {
    public void beforeTest(ITestContext context) {
        System.out.println("\t@BeforeTest");
//        HashMap<String, String> allParameters = new HashMap<String, String>(
//                context.getCurrentXmlTest().getAllParameters());
//        for (String key : allParameters.keySet()) {
//            System.out.println("*** parameter: key=" + key + " value=" + allParameters.get(key));
//        }
    }

    @AfterTest
    public void afterTest() {
        System.out.println("\t@AfterTest");
    }

    @BeforeClass
    //public void beforeClass() {
    public void beforeClass(ITestContext context) {
        System.out.println("\t\t@BeforeClass");
//        HashMap<String, String> allParameters = new HashMap<String, String>(
//                context.getCurrentXmlTest().getAllParameters());
//        for (String key : allParameters.keySet()) {
//            System.out.println("*** parameter: key=" + key + " value=" + allParameters.get(key));
//        }
    }

    @AfterClass
    public void afterClass() {
        System.out.println("\t\t@AfterClass");
    }

    @BeforeMethod
    //public void beforeMethod() {
    public void beforeMethod(ITestContext context) {
        System.out.println("\t\t\t@BeforeMethod");
        //System.out.println("context = " + context.toString());
//        HashMap<String, String> allParameters = new HashMap<String, String>(
//                context.getCurrentXmlTest().getAllParameters());
//        for (String key : allParameters.keySet()) {
//            System.out.println("*** parameter: key=" + key + " value=" + allParameters.get(key));
//        }
    }

    @AfterMethod
    public void afterMethod() {
        System.out.println("\t\t\t@AfterMethod");
    }

    @DataProvider//(parallel = true)
    public Object[][] example(ITestContext context) {
        System.out.println("\t\t\t\t@DataProvider");
        //System.out.println("context = " + context.toString());
        HashMap<String, String> allParameters = new HashMap<String, String>(
                //context.getCurrentXmlTest().getAllParameters());
                //context.getCurrentXmlTest().getTestParameters()); // Deprecated
                //context.getCurrentXmlTest().getSuite().getParameters()); // Suite
                context.getCurrentXmlTest().getLocalParameters()); // NEW getTestParameters()
        for (String key : allParameters.keySet()) {
            System.out.println("\t\t\t\t*** parameter: key=" + key + " value=" + allParameters.get(key));
        }
        // Read from ...
        return new Object[][] { 
            { "admin", "admin" },
            { "registrator", "registrator" },
            };
    }

    @Test(dataProvider = "example")
    public void testApp(String login, String password) {
        System.out.println("surefire.reports.directory = " 
                + System.getProperty("surefire.reports.directory"));
        //
        System.out.println("\nUsed Memory = " 
                + (Runtime.getRuntime().totalMemory() 
                        - Runtime.getRuntime().freeMemory()) / (1024.0 * 1024.0) + "Mb");
        System.out.println("\nTotal Amount of Memory = " 
                + Runtime.getRuntime().totalMemory() / (1024.0 * 1024.0) + "Mb");
        System.out.println("\nMaximum Amount of Memory = " 
                + Runtime.getRuntime().maxMemory() / (1024.0 * 1024.0) + "Mb");
        //
        System.out.println("Test done");
        Assert.assertTrue(true);
    }
    
}
