package com.softserve.edu.test.resourses;

import java.util.HashMap;
import java.util.Map;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.firefox.internal.ProfilesIni;

/**
 * @author Ivan
 * utilite class for initisialization Web drivers.
 */
public final class InitsializeWebDriver {
    /**
     * private constructor.
     */
    private InitsializeWebDriver() { };

    /**
     * method for create ChromeDriver.
     * @return chromeDriver.
     */
    public static WebDriver getChromeDriver() {
        System.setProperty("webdriver.chrome.driver", "./lib/chromedriver.exe");
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--start-maximized");
        Map<String, Object> prefs = new HashMap<String, Object>();
        prefs.put("credentials_enable_service", false);
        prefs.put("profile.password_manager_enabled", false);
        options.setExperimentalOption("prefs", prefs);
        WebDriver driver = new ChromeDriver(options);
        return driver;
    }

    /**
     * method for create FirefoxDriver.
     * @return firefoxDriver.
     */
    public static WebDriver getFirefoxDriver() {
        ProfilesIni profileIni = new ProfilesIni();
        FirefoxProfile profile = profileIni.getProfile("default");
        profile.setAcceptUntrustedCertificates(true);
        profile.setAssumeUntrustedCertificateIssuer(false);
        profile.setPreference("app.update.enabled", false);
        System.setProperty("webdriver.gecko.driver",
                "./lib/geckodriver.exe");
        WebDriver driver = new FirefoxDriver(profile);
        return driver;
    }
}

