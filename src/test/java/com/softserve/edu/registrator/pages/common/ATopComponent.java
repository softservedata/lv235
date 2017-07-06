package com.softserve.edu.registrator.pages.common;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import com.softserve.edu.registrator.tools.search.Search;

public abstract class ATopComponent {

    public static enum ChangeLanguageFields {
        UKRAINIAN("українська"),
        RUSSIAN("русский"),
        ENGLISH("english");
        //
        private String field;

        private ChangeLanguageFields(String field) {
            this.field = field;
        }

        @Override
        public String toString() {
            return field;
        }
    }

    // - - - - - - - - - - - - - - - - - - - - - - - - - - - - - -

    public static final String CLASS_ATTRIBUTE = "class"; 
    public static final String SRC_ATTRIBUTE = "src"; 
    public static final String VALUE_ATTRIBUTE = "value"; 

    // Fields
    //
    private WebElement titleMessage;
    private Select changeLanguage;

    protected ATopComponent() {
        //this.titleMessage = driver.findElement(By.cssSelector("div.col-md-7.col-xs-12"));
        //this.changeLanguage = new Select(driver.findElement(By.id("changeLanguage")));
        //
        this.titleMessage = Search.cssSelector("div.col-md-7.col-xs-12");
        this.changeLanguage = new Select(Search.id("changeLanguage"));
    }

    // PageObject

    // get Data

    public Select getChangeLanguage() {
        return this.changeLanguage;
    }

    public WebElement getTitleMessage() {
        return this.titleMessage;
    }

    public WebElement getChangeLanguageSelected() {
        return getChangeLanguage().getFirstSelectedOption();
    }

    // Functional

    public String getTitleMessageText() {
        return getTitleMessage().getText();
    }

    public String getChangeLanguageSelectedText() {
        return getChangeLanguageSelected().getText().trim();
    }



    // set Data


    public void setChangeLanguage(ChangeLanguageFields language) {
        getChangeLanguage().selectByVisibleText(language.toString());
    }

    // Business Logic

}
