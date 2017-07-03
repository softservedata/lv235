package com.softserve.edu.registrator.data.apps;

public final class ApplicationSources {

    private interface IApplicationFactory {
        void setParameter(ApplicationSources applicationSources, String parameter);
    }

    private static class BrowserNameFactory implements IApplicationFactory {
        public void setParameter(ApplicationSources applicationSources, String parameter) {
            applicationSources.setBrowserName(parameter);
        }
    }

    private static class DriverPathFactory implements IApplicationFactory {
        public void setParameter(ApplicationSources applicationSources, String parameter) {
            applicationSources.setDriverPath(parameter);
        }
    }

    private static class ImplicitWaitTimeOutFactory implements IApplicationFactory {
        public void setParameter(ApplicationSources applicationSources, String parameter) {
            applicationSources.setImplicitWaitTimeOut(Long.parseLong(parameter));
        }
    }

    private static class ImplicitLoadTimeOutFactory implements IApplicationFactory {
        public void setParameter(ApplicationSources applicationSources, String parameter) {
            applicationSources.setImplicitLoadTimeOut(Long.parseLong(parameter));
        }
    }

    private static class ImplicitScriptTimeOutFactory implements IApplicationFactory {
        public void setParameter(ApplicationSources applicationSources, String parameter) {
            applicationSources.setImplicitScriptTimeOut(Long.parseLong(parameter));
        }
    }

    private static class ExplicitTimeOutFactory implements IApplicationFactory {
        public void setParameter(ApplicationSources applicationSources, String parameter) {
            applicationSources.setExplicitTimeOut(Long.parseLong(parameter));
        }
    }

    private static class SearchStrategyFactory implements IApplicationFactory {
        public void setParameter(ApplicationSources applicationSources, String parameter) {
            applicationSources.setSearchStrategy(parameter);
        }
    }

    private static class LoginUrlFactory implements IApplicationFactory {
        public void setParameter(ApplicationSources applicationSources, String parameter) {
            applicationSources.setLoginUrl(parameter);
        }
    }

    private static class LogoutUrlFactory implements IApplicationFactory {
        public void setParameter(ApplicationSources applicationSources, String parameter) {
            applicationSources.setLogoutUrl(parameter);
        }
    }

    public static enum ApplicationParameters {
        BROWSER_NAME("browserName", new BrowserNameFactory()),
        DRIVER_PATH("driverPath", new DriverPathFactory()),
        IMPLICIT_WAIT_TIMEOUT("implicitWaitTimeOut", new ImplicitWaitTimeOutFactory()),
        IMPLICIT_LOAD_TIMEOUT("implicitLoadTimeOut", new ImplicitLoadTimeOutFactory()),
        IMPLICIT_SCRIPT_TIMEOUT("implicitScriptTimeOut", new ImplicitScriptTimeOutFactory()),
        EXPLICIT_TIMEOUT("explicitTimeOut", new ExplicitTimeOutFactory()),
        SEARCH_STRATEGY("searchStrategy", new SearchStrategyFactory()),
        LOGIN_URL("loginUrl", new LoginUrlFactory()),
        LOGOUT_URL("logoutUrl", new LogoutUrlFactory());
        //
        private String field;
        private IApplicationFactory applicationFactory;

        private ApplicationParameters(String field, IApplicationFactory applicationFactory) {
            this.field = field;
            this.applicationFactory = applicationFactory;
        }

        public void setParameter(ApplicationSources applicationSources, String parameter) {
            applicationFactory.setParameter(applicationSources, parameter);
        }

        @Override
        public String toString() {
            return this.field;
        }
    }

    // - - - - - - - - - - - - - - - - - - - - - - - - - - - - - -

    // Browser Data
    private String browserName;
    private String driverPath;
    // private String browserPath;
    // private String defaulProfile;
    //
    // Implicit and Explicit Waits
    private long implicitWaitTimeOut;
    private long implicitLoadTimeOut;
    private long implicitScriptTimeOut;
    private long explicitTimeOut;
    //
    // Localization Strategy
    // private String language;
    //
    // Search Strategy
    private String searchStrategy;
    //
    // Logger Strategy
    // private String loggerStrategy;
    //
    // URLs
    private String loginUrl;
    private String logoutUrl;
    // private String serverUrl;
    //
    // Connect to DB
    // Selenium Version

    // TODO Use Builder
    public ApplicationSources(String browserName, String driverPath, long implicitWaitTimeOut,
            long implicitLoadTimeOut, long implicitScriptTimeOut, long explicitTimeOut,
            String searchStrategy, String loginUrl, String logoutUrl) {
        this.browserName = browserName;
        this.driverPath = driverPath;
        this.implicitWaitTimeOut = implicitWaitTimeOut;
        this.implicitLoadTimeOut = implicitLoadTimeOut;
        this.implicitScriptTimeOut = implicitScriptTimeOut;
        this.explicitTimeOut = explicitTimeOut;
        this.searchStrategy = searchStrategy;
        this.loginUrl = loginUrl;
        this.logoutUrl = logoutUrl;
    }

    // setters
    
    private void setBrowserName(String browserName) {
        this.browserName = browserName;
    }

    private void setDriverPath(String driverPath) {
        this.driverPath = driverPath;
    }

    private void setImplicitWaitTimeOut(long implicitWaitTimeOut) {
        this.implicitWaitTimeOut = implicitWaitTimeOut;
    }

    private void setImplicitLoadTimeOut(long implicitLoadTimeOut) {
        this.implicitLoadTimeOut = implicitLoadTimeOut;
    }
    
    private void setImplicitScriptTimeOut(long implicitScriptTimeOut) {
        this.implicitScriptTimeOut = implicitScriptTimeOut;
    }

    private void setExplicitTimeOut(long explicitTimeOut) {
        this.explicitTimeOut = explicitTimeOut;
    }

    private void setSearchStrategy(String searchStrategy) {
        this.searchStrategy = searchStrategy;
    }

    private void setLoginUrl(String loginUrl) {
        this.loginUrl = loginUrl;
    }

    public void setLogoutUrl(String logoutUrl) {
        this.logoutUrl = logoutUrl;
    }

    // getters

    public String getBrowserName() {
        return browserName;
    }

    public String getDriverPath() {
        return driverPath;
    }

    public long getImplicitWaitTimeOut() {
        return implicitWaitTimeOut;
    }

    public long getImplicitLoadTimeOut() {
        return implicitLoadTimeOut;
    }
    
    public long getImplicitScriptTimeOut() {
        return implicitScriptTimeOut;
    }

    public long getExplicitTimeOut() {
        return explicitTimeOut;
    }

    public String getSearchStrategy() {
        return searchStrategy;
    }

    public String getLoginUrl() {
        return loginUrl;
    }

    public String getLogoutUrl() {
        return logoutUrl;
    }

}
