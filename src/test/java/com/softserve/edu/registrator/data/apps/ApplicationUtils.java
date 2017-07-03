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
        for (Browsers browser : Browsers.values()) {
            if (browser.toString().toLowerCase().contains(applicationSources.getBrowserName().toLowerCase())) {
                ApplicationParameters.DRIVER_PATH.setParameter(applicationSources, 
                        browser.getDefaultDriverPath());
                break;
            }
        }
    }
    
    private static ApplicationSources updateApplicationSources(ApplicationSources applicationSources,
            HashMap<String, String> parameters) {
        for (String key : parameters.keySet()) {
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
        return updateApplicationSources(applicationSources,
                new HashMap<String, String>(context
                        .getCurrentXmlTest().getSuite().getParameters()));
    }

    public static ApplicationSources updateFromTest(ApplicationSources applicationSources, ITestContext context) {
        return updateApplicationSources(applicationSources, 
                new HashMap<String, String>(context
                        .getCurrentXmlTest().getLocalParameters()));
    }

    public static ApplicationSources updateFromTestNgXML(ApplicationSources applicationSources, ITestContext context) {
        return updateApplicationSources(applicationSources, 
                new HashMap<String, String>(context
                        .getCurrentXmlTest().getAllParameters()));
    }

    public static ApplicationSources updateBrowserFromPOM(ApplicationSources applicationSources) {
        if (System.getProperty(SUREFIRE_WEBDRIVER_NAME) != null) {
            ApplicationParameters.BROWSER_NAME.setParameter(applicationSources,
                    System.getProperty(SUREFIRE_WEBDRIVER_NAME));
            updateDriverPath(applicationSources);
        }
        if (System.getProperty(SUREFIRE_WEBDRIVER_DRIVERPATH) != null) {
            ApplicationParameters.DRIVER_PATH.setParameter(applicationSources,
                    System.getProperty(SUREFIRE_WEBDRIVER_DRIVERPATH));
        }
        return applicationSources;
    }

    public static ApplicationSources updateAll(ApplicationSources applicationSources, ITestContext context) {
        updateBrowserFromPOM(applicationSources);
        return updateFromTestNgXML(applicationSources, context);
    }
}
