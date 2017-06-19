package com.softserve.edu.registrator.data.apps;

public final class ApplicationSourcesRepository {

    private ApplicationSourcesRepository() {
    }

    public static ApplicationSources getDefault() {
        return getChromeTraining();
    }

    public static ApplicationSources getFirefox4701Heroku() {
        return new ApplicationSources("FireFox4x", "", 5L,
                "http://regres.herokuapp.com/login",
                "http://regres.herokuapp.com/logout");
    }

    public static ApplicationSources getFirefox4701Training() {
        return new ApplicationSources("FireFox4x", "", 5L,
                "http://java.training.local:8080/registrator/login",
                "http://java.training.local:8080/registrator/logout");
    }

    public static ApplicationSources getFirefox5xHeroku() {
        // System.out.println("+++++ PATH = "
        // +
        // ApplicationSourcesRepository.class.getResource("/lib/geckodriver.exe").getPath().substring(1));
        return new ApplicationSources("FireFox5x",
                ApplicationSourcesRepository.class.getResource("/lib/geckodriver.exe").getPath().substring(1), 5L,
                "http://regres.herokuapp.com/login",
                "http://regres.herokuapp.com/logout");
    }

    public static ApplicationSources getFirefox5xTraining() {
        // System.out.println("+++++ PATH = "
        // +
        // ApplicationSourcesRepository.class.getResource("/lib/geckodriver.exe").getPath().substring(1));
        return new ApplicationSources("FireFox5x",
                ApplicationSourcesRepository.class.getResource("/lib/geckodriver.exe").getPath().substring(1), 5L,
                "http://java.training.local:8080/registrator/login",
                "http://java.training.local:8080/registrator/logout");
    }

    public static ApplicationSources getChromeHeroku() {
        return new ApplicationSources("Chrome",
                // "C:\\Program Files
                // (x86)\\Google\\Chrome\\Application\\chromedriver.exe", 5L,
                ApplicationSourcesRepository.class.getResource("/lib/chromedriver.exe").getPath().substring(1), 5L,
                "http://regres.herokuapp.com/login",
                "http://regres.herokuapp.com/logout");
    }

    public static ApplicationSources getChromeTraining() {
        return new ApplicationSources("Chrome",
                // "C:\\Program Files
                // (x86)\\Google\\Chrome\\Application\\chromedriver.exe", 5L,
                ApplicationSourcesRepository.class.getResource("/lib/chromedriver.exe").getPath().substring(1), 5L,
                "http://java.training.local:8080/registrator/login",
                "http://java.training.local:8080/registrator/logout");
    }

    public static ApplicationSources getHtmlUnitHeroku() {
        return new ApplicationSources("HtmlUnit", "", 5L,
                "http://regres.herokuapp.com/login",
                "http://regres.herokuapp.com/logout");
    }

    public static ApplicationSources getHtmlUnitTraining() {
        return new ApplicationSources("HtmlUnit", "", 5L,
                "http://java.training.local:8080/registrator/login",
                "http://java.training.local:8080/registrator/logout");
    }

}