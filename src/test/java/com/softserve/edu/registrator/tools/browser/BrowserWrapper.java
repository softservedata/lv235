package com.softserve.edu.registrator.tools.browser;

import java.util.HashMap;
import java.util.Map;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;

import com.softserve.edu.registrator.data.apps.ApplicationSources;
import com.softserve.edu.registrator.data.apps.ApplicationSourcesRepository;

public class BrowserWrapper {

    private interface IBrowser {
        WebDriver getBrowser(ApplicationSources applicationSources);
    }

    private static class Firefox4xTemporary implements IBrowser {
        public WebDriver getBrowser(ApplicationSources applicationSources) {
            return new FirefoxDriver();
        }
    }

    private static class Firefox5xTemporary implements IBrowser {
        public WebDriver getBrowser(ApplicationSources applicationSources) {
            System.setProperty("webdriver.gecko.driver", applicationSources.getDriverPath());
            return new FirefoxDriver();
        }
    }

    private static class ChromeTemporary implements IBrowser {
        public WebDriver getBrowser(ApplicationSources applicationSources) {
            System.setProperty("webdriver.chrome.driver", applicationSources.getDriverPath());
            ApplicationSourcesRepository.getChromeDriverPath();
            
            ChromeOptions options = new ChromeOptions();
            options.addArguments("--start-maximized");
            Map<String, Object> prefs = new HashMap<String, Object>();
            prefs.put("credentials_enable_service", false);
            prefs.put("profile.password_manager_enabled", false);
            options.setExperimentalOption("prefs", prefs);
            
            return new ChromeDriver(options);
        }
    }

    private static class HtmlUnitTemporary implements IBrowser {
        public WebDriver getBrowser(ApplicationSources applicationSources) {
            // WebDriver driver = null;
            WebDriver driver = new HtmlUnitDriver(true);
            ((HtmlUnitDriver) driver).setJavascriptEnabled(true);
            return driver;
        }
    }

    public static enum Browsers {
        DEFAULT_TEMPORARY("ChromeTemporary", ApplicationSourcesRepository.getChromeDriverPath(),
                    new ChromeTemporary()),
        FIREFOX4X_TEMPORARY("FireFox4xTemporary", new String(),
                    new Firefox4xTemporary()),
        FIREFOX5X_TEMPORARY("FireFox5xTemporary", ApplicationSourcesRepository.getGeckoDriverPath(),
                    new Firefox5xTemporary()),
        CHROME_TEMPORARY("ChromeTemporary", ApplicationSourcesRepository.getChromeDriverPath(),
                    new ChromeTemporary()),
        HTMLUNIT_TEMPORARY("HtmlUnitTemporary", new String(), new HtmlUnitTemporary());
        //
        private String browserName;
        private String defaultDriverPath;
        private IBrowser browser;

        private Browsers(String browserName, String defaultDriverPath, IBrowser browser) {
            this.browserName = browserName;
            this.defaultDriverPath = defaultDriverPath;
            this.browser = browser;
        }

        public WebDriver runBrowser(ApplicationSources applicationSources) {
            return browser.getBrowser(applicationSources);
        }

        @Override
        public String toString() {
            return browserName;
        }

        public String getDefaultDriverPath() {
            return defaultDriverPath;
        }
    }

    // - - - - - - - - - - - - - - - - - - - - - - - - - - - - - -

    private WebDriver driver;

    
    public BrowserWrapper(ApplicationSources applicationSources) {
        initWebDriver(applicationSources);
    }
    
    private void initWebDriver(ApplicationSources applicationSources) {
        Browsers currentBrowser = Browsers.DEFAULT_TEMPORARY;
        for (Browsers browser : Browsers.values()) {
            if (browser.toString().toLowerCase().contains(applicationSources.getBrowserName().toLowerCase())) {
                currentBrowser = browser;
                break;
            }
        }
        driver = currentBrowser.runBrowser(applicationSources);
    }
    
    public WebDriver getDriver() {
        return driver;
    }

    public void quit() {
        if (getDriver() != null) {
            getDriver().quit();
        }
    }

}
