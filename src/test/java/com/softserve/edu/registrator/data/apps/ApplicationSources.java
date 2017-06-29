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

    private static class ImplicitTimeOutFactory implements IApplicationFactory {
        public void setParameter(ApplicationSources applicationSources, String parameter) {
            applicationSources.setImplicitTimeOut(Long.parseLong(parameter));
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
        IMPLICIT_TIMEOUT("implicitTimeOut", new ImplicitTimeOutFactory()),
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
    private long implicitTimeOut;
    private String loginUrl;
    private String logoutUrl;

    public ApplicationSources(String browserName, String driverPath, long implicitTimeOut, String loginUrl,
            String logoutUrl) {
        this.browserName = browserName;
        this.driverPath = driverPath;
        this.implicitTimeOut = implicitTimeOut;
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

    private void setImplicitTimeOut(long implicitTimeOut) {
        this.implicitTimeOut = implicitTimeOut;
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

    public long getImplicitTimeOut() {
        return implicitTimeOut;
    }

    public String getLoginUrl() {
        return loginUrl;
    }

    public String getLogoutUrl() {
        return logoutUrl;
    }

}
