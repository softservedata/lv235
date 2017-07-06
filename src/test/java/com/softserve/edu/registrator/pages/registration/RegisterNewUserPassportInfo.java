package com.softserve.edu.registrator.pages.registration;

import java.util.HashMap;

import org.openqa.selenium.WebElement;

import com.softserve.edu.registrator.pages.common.ATopComponent.ChangeLanguageFields;
import com.softserve.edu.registrator.tools.search.Search;

public class RegisterNewUserPassportInfo {

    public static enum PassportInfoL10n {
        PASSPORTINFO_LABEL("Паспортні дані", "Паспортные данные", "Passport information"),
        SERIA_ERROR_LABEL("Поле повинне містити 2 великі літери",
                "Поле должно содержать только 2 большие буквы", 
                "The field must contain only two big cyrillic letters"),
        SERIA_LABEL("Серія", "Серия", "Seria"),
        PASSPORTNUMBER_ERROR_LABEL("Поле повинне містити 6 цифр", 
                "Поле должно содержать 6 цифр", 
                "The field must contain 6 digits"),
        PASSPORTNUMBER_LABEL("Номер", "Номер", "Number"),
        PUBLISHED_LABEL("Виданий", "Выданный", "Published by");

        private HashMap<ChangeLanguageFields, String> field;

        private PassportInfoL10n(String... localization) {
            this.field = new HashMap<ChangeLanguageFields, String>();
            int i = 0;
            for (ChangeLanguageFields language : ChangeLanguageFields.values()) {
                this.field.put(language, localization[i]);
                i++;
            }
        }

        public String getLocalization(ChangeLanguageFields language) {
            return this.field.get(language).trim();
        }
    }
    
    public static final String PASSPORTINFO_LABEL_CSSSELECTOR = ".passport_header.col-lg-4 h4:first-child";
    public static final String SERIA_ERROR_LABEL_ID = "passport.seria.errors";
    public static final String SERIA_LABEL_CSSSELECTOR = "label[for='passport_seria']";
    public static final String SERIA_INPUT_ID = "passport_seria";
    public static final String PASSPORTNUMBER_ERROR_LABEL_ID = "passport.number.errors";
    public static final String PASSPORTNUMBER_LABEL_CSSSELECTOR = "label[for='passport_number']";
    public static final String PASSPORTNUMBER_INPUT_ID = "passport_number";
    public static final String PUBLISHED_LABEL_CSSSELECTOR = "label[for='published_by_data']";
    public static final String PUBLISHED_INPUT_ID = "published_by_data";
    
    // - - - - - - - - - - - - - - - - - - - - - - - - - - - - - -
    
    // Fields
        
    private WebElement passportInfoLabel;
    private WebElement seriaLabel;
    private WebElement seria;
    private WebElement passportNumberLabel;
    private WebElement passportNumber;
    private WebElement publishedLabel;
    private WebElement published;
    
    // Public constructor
    
    public RegisterNewUserPassportInfo() {
        this.passportInfoLabel = Search.cssSelector(PASSPORTINFO_LABEL_CSSSELECTOR);
        this.seriaLabel = Search.cssSelector(SERIA_LABEL_CSSSELECTOR);
        this.seria = Search.id(SERIA_INPUT_ID);
        this.passportNumberLabel = Search.cssSelector(PASSPORTNUMBER_LABEL_CSSSELECTOR);
        this.passportNumber = Search.id(PASSPORTNUMBER_INPUT_ID);
        this.publishedLabel = Search.cssSelector(PUBLISHED_LABEL_CSSSELECTOR);
        this.published = Search.id(PUBLISHED_INPUT_ID);
    }
    
    // get Passport info labels

    public WebElement getPassportInfoLabel() {
        return passportInfoLabel;
    }
    
    public WebElement getSeriaLabel() {
        return seriaLabel;
    }
    
    public WebElement getPassportNumberLabel() {
        return passportNumberLabel;
    }
    
    public WebElement getPublishedLabel() {
        return publishedLabel;
    }

    // get Passport info
    
    public WebElement getSeria() {
        return this.seria;
    }

    public WebElement getPassportNumber() {
        return this.passportNumber;
    }

    public WebElement getPublished() {
        return this.published;
    }

    // set Passport info
    
    public void setSeria(String seria) {
        getSeria().click();
        getSeria().clear();
        getSeria().sendKeys(seria);
    }

    public void setPassportNumber(String passportNumber) {
        getPassportNumber().click();
        getPassportNumber().clear();
        getPassportNumber().sendKeys(passportNumber);
    }

    public void setPublished(String published) {
        getPublished().click();
        getPublished().clear();
        getPublished().sendKeys(published);
    }
    
    // Functional
    
    public String getPassportInfoLabelText() {
        return getPassportInfoLabel().getText().trim();
    }
    
    public String getSeriaLabelText() {
        return getSeriaLabel().getText().trim();
    }
    
    public String getPassportNumberLabelText() {
        return getPassportNumberLabel().getText().trim();
    }
    
    public String getPublishedLabelText() {
        return getPublishedLabel().getText().trim();
    }
    
}
