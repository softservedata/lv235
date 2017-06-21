package com.softserve.edu.registrator.data.apps;

import java.util.HashMap;

import org.testng.ITestContext;

import com.softserve.edu.registrator.data.apps.ApplicationSources.ApplicationParameters;
import com.softserve.edu.registrator.pages.Application.Browsers;

public final class ApplicationUtils {
    private static final String SUREFIRE_WEBDRIVER_NAME = "surefire.webdriver.name";
    private static final String SUREFIRE_WEBDRIVER_DRIVERPATH = "surefire.webdriver.driverpath";

    private ApplicationUtils() {
    }

    private static boolean isDriverPath(HashMap<String, String> parameters){
        boolean result = false;
        for (String key : parameters.keySet()) {
            if (key.toLowerCase().contains(ApplicationParameters
                    .DRIVER_PATH.toString().toLowerCase())) {
                result = true;
                break;
            }
        }
        return result;
    }
    
    private static void updateDriverPath(ApplicationSources applicationSources) {
        ApplicationParameters.DRIVER_PATH.setParameter(applicationSources, 
                ApplicationSourcesRepository.getChromeDriverPath());
        //if (applicationSources.getBrowserName().toLowerCase().contains())
        for (Browsers browser : Browsers.values()) {
            if (browser.toString().toLowerCase().contains(applicationSources.getBrowserName().toLowerCase())) {
                ApplicationParameters.DRIVER_PATH.setParameter(applicationSources, 
                        browser.getDefaultDriverPath());
                //System.out.println("***** browser.getDefaultDriverPath() = "+browser.getDefaultDriverPath());
                break;
            }
        }
    }
    
    private static ApplicationSources updateApplicationSources(ApplicationSources applicationSources,
            HashMap<String, String> parameters) {
        for (String key : parameters.keySet()) {
            // System.out.println("Suite parameter: key=" + key + " value=" +
            // suiteParameters.get(key));
            for (ApplicationParameters field : ApplicationParameters.values()) {
                if (key.toLowerCase().contains(field.toString().toLowerCase())) {
                    field.setParameter(applicationSources, parameters.get(key));
                    if ((field == ApplicationParameters.BROWSER_NAME)
                            && (!isDriverPath(parameters))) {
                        updateDriverPath(applicationSources);
                    }
                    break;
                }
            }
        }
        return applicationSources;
    }

    public static ApplicationSources updateFromSuite(ApplicationSources applicationSources, ITestContext context) {
        HashMap<String, String> suiteParameters = new HashMap<String, String>(
                context.getCurrentXmlTest().getSuite().getParameters());
        return updateApplicationSources(applicationSources, suiteParameters);
    }

    public static ApplicationSources updateFromTest(ApplicationSources applicationSources, ITestContext context) {
        HashMap<String, String> testParameters = new HashMap<String, String>(
                context.getCurrentXmlTest().getLocalParameters());
        return updateApplicationSources(applicationSources, testParameters);
    }

    public static ApplicationSources updateFromTestNgXML(ApplicationSources applicationSources, ITestContext context) {
        // updateSuiteApplicationSources(applicationSources, context);
        // updateTestApplicationSources(applicationSources, context);
        // return applicationSources;
        HashMap<String, String> allParameters = new HashMap<String, String>(
                context.getCurrentXmlTest().getAllParameters());
        return updateApplicationSources(applicationSources, allParameters);
    }

    public static ApplicationSources updateBrowserFromPOM(ApplicationSources applicationSources) {
        //System.out.println("\t***** getProperty = " + System.getProperty(SUREFIRE_WEBDRIVER_NAME));
        if (System.getProperty(SUREFIRE_WEBDRIVER_NAME) != null) {
            ApplicationParameters.BROWSER_NAME.setParameter(applicationSources,
                    System.getProperty(SUREFIRE_WEBDRIVER_NAME));
            updateDriverPath(applicationSources);
            //System.out.println("\t***** Update DONE +applicationSources.getBrowserName() ="
            //        + applicationSources.getBrowserName());
        }
        if (System.getProperty(SUREFIRE_WEBDRIVER_DRIVERPATH) != null) {
            ApplicationParameters.DRIVER_PATH.setParameter(applicationSources,
                    System.getProperty(SUREFIRE_WEBDRIVER_DRIVERPATH));
        }
//        if ((System.getProperty(SUREFIRE_WEBDRIVER_NAME) != null)
//                && (System.getProperty(SUREFIRE_WEBDRIVER_DRIVERPATH) != null)) {
//            ApplicationParameters.BROWSER_NAME.setParameter(applicationSources,
//                    System.getProperty(SUREFIRE_WEBDRIVER_NAME));
//            ApplicationParameters.DRIVER_PATH.setParameter(applicationSources,
//                    System.getProperty(SUREFIRE_WEBDRIVER_DRIVERPATH));
//        }
        return applicationSources;
    }

    public static ApplicationSources updateAll(ApplicationSources applicationSources, ITestContext context) {
        updateBrowserFromPOM(applicationSources);
        return updateFromTestNgXML(applicationSources, context);
    }
}
