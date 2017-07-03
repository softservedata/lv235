package com.softserve.edu.registrator.data.apps;

public final class ApplicationSourcesRepository {

    private ApplicationSourcesRepository() {
    }

    public static String getGeckoDriverPath() {
        return ApplicationSourcesRepository.class.getResource("/lib/geckodriver.exe").getPath().substring(1);
    }

    public static String getChromeDriverPath() {
        return ApplicationSourcesRepository.class.getResource("/lib/chromedriver.exe").getPath().substring(1);
    }

    public static ApplicationSources getDefault() {
        return getChromeTraining();
    }

    public static ApplicationSources getFirefox4701Heroku() {
        return new ApplicationSources("FireFox4x", "", 5L, 30L, 30L, 10L, "implicit",
                "http://regres.herokuapp.com/login",
                "http://regres.herokuapp.com/logout");
    }

    public static ApplicationSources getFirefox4701Training() {
        return new ApplicationSources("FireFox4x", "", 5L, 30L, 30L, 10L, "implicit",
                "http://java.training.local:8080/registrator/login",
                "http://java.training.local:8080/registrator/logout");
    }

    public static ApplicationSources getFirefox5xHeroku() {
        return new ApplicationSources("FireFox5x",
                getGeckoDriverPath(), 5L, 30L, 30L, 10L, "implicit",
                "http://regres.herokuapp.com/login",
                "http://regres.herokuapp.com/logout");
    }

    public static ApplicationSources getFirefox5xTraining() {
        return new ApplicationSources("FireFox5x",
                getGeckoDriverPath(), 5L, 30L, 30L, 10L, "implicit",
                "http://java.training.local:8080/registrator/login",
                "http://java.training.local:8080/registrator/logout");
    }

    public static ApplicationSources getChromeHeroku() {
        return new ApplicationSources("Chrome",

                // "C:\\Program Files
                // (x86)\\Google\\Chrome\\Application\\chromedriver.exe", 5L,
                getChromeDriverPath(), 5L, 30L, 30L, 10L, "implicit",

                "http://regres.herokuapp.com/login",
                "http://regres.herokuapp.com/logout");
    }

    public static ApplicationSources getChromeTraining() {
        return new ApplicationSources("Chrome",

                // "C:\\Program Files
                // (x86)\\Google\\Chrome\\Application\\chromedriver.exe", 5L,
                getChromeDriverPath(), 5L, 30L, 30L, 10L, "implicit",

                "http://java.training.local:8080/registrator/login",
                "http://java.training.local:8080/registrator/logout");
    }

    public static ApplicationSources getHtmlUnitHeroku() {
        return new ApplicationSources("HtmlUnit", "", 5L, 30L, 30L, 10L, "implicit",
                "http://regres.herokuapp.com/login",
                "http://regres.herokuapp.com/logout");
    }

    public static ApplicationSources getHtmlUnitTraining() {
        return new ApplicationSources("HtmlUnit", "", 5L, 30L, 30L, 10L, "implicit",
                "http://java.training.local:8080/registrator/login",
                "http://java.training.local:8080/registrator/logout");
    }

}
