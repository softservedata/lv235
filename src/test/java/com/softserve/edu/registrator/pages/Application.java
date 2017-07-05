package com.softserve.edu.registrator.pages;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;

import com.softserve.edu.registrator.data.apps.ApplicationSources;
import com.softserve.edu.registrator.data.apps.ApplicationSourcesRepository;
import com.softserve.edu.registrator.pages.common.LoginPage;
import com.softserve.edu.registrator.tools.browser.BrowserWrapper;
import com.softserve.edu.registrator.tools.search.Search;

public class Application {

	// Use Singleton, Repository
	private static volatile Application instance;
	//
	// Fields
	//
	// TODO Change for parallel work
	private BrowserWrapper browser;
	private ApplicationSources applicationSources;
	// etc.

	private Application(ApplicationSources applicationSources) {
		this.applicationSources = applicationSources;
		this.browser = new BrowserWrapper(applicationSources);
	}

	public static Application get() {
		return get(null);
	}

	public static Application get(ApplicationSources applicationSources) {
		if (instance == null) {
			synchronized (Application.class) {
				if (instance == null) {
					if (applicationSources == null) {
						applicationSources = ApplicationSourcesRepository.getDefault();
					}
					instance = new Application(applicationSources);
					instance.init();
				}
			}
		}
		return instance;
	}

	public static void remove() {
		if (instance != null) {
			instance.getBrowser().quit();
		}
		instance = null;
	}

	public void init() {
		//initWebDriver(); // Use Constructor
		//initWaits();
	    //
        // Init Strategy from ApplicationSources
	    Search.initSearch(getApplicationSources());
		// TODO
		// Init DB access, etc.
	}

	public LoginPage load() {
		logout();
		getBrowser().get(applicationSources.getLoginUrl());
		return new LoginPage(getBrowser());
	}

	public LoginPage login() {
		logout();
		getBrowser().get(applicationSources.getLoginUrl());
		return new LoginPage(getBrowser());
	}

	public LoginPage logout() {
		getBrowser().get(applicationSources.getLogoutUrl());
		return new LoginPage(getBrowser());
	}

	// TODO Change for parallel work
	public WebDriver getBrowser() {
		// TODO For parallel work
		return browser.getDriver();
	}

	// TODO Change for parallel work
	public ApplicationSources getApplicationSources() {
		return applicationSources;
	}

}
