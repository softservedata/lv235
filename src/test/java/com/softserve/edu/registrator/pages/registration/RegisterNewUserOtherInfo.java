package com.softserve.edu.registrator.pages.registration;

import java.util.HashMap;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import com.softserve.edu.registrator.pages.ATopComponent.ChangeLanguageFields;

public class RegisterNewUserOtherInfo {

    public static enum OtherInfoL10n {
        OTHERINFO_LABEL("Інші дані", "Другие данные", "Other data"),
        PHONENUMBER_ERROR_LABEL("Некоректний номер телефону", 
                "Некорректный телефонный номер", 
                "Incorrect phone number"),
        PHONENUMBER_LABEL("Номер телефону", "Номер телефона", "Phone number"),
        COMMUNITY_LABEL("Громада *", "Община *", "Community *"),
        DATE_LABEL("Дата приєднання до договору*", 
                "Дата присоединения к договору*", 
                "Date of accession to the treaty*");

        private HashMap<ChangeLanguageFields, String> field;

        private OtherInfoL10n(String... localization) {
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
    
    public static final String OTHERINFO_LABEL_XPATH = "//*[@id='registrationForm']//h4[2]";
    public static final String PHONENUMBER_ERROR_LABEL_ID = "phoneNumber.errors";
    public static final String PHONENUMBER_LABEL_CSSSELECTOR = "label[for='phone_number']";
    public static final String PHONENUMBER_INPUT_ID = "phone_number";
    public static final String COMMUNITY_LABEL_CSSSELECTOR = "label[for='territorial_Community']";
    public static final String COMMUNITY_DROPDOWN_ID = "territorial_Community";
    public static final String COMMUNITIESOPTIONS_XPATH = "//*[@id='territorial_Community']/option";
    public static final String DATE_LABEL_CSSSELECTOR = "label[for='dateOfAccession']";
    public static final String DATE_INPUT_ID = "datepicker";
    
    // - - - - - - - - - - - - - - - - - - - - - - - - - - - - - -
    
    // Fields
    
    private WebElement otherInfoLabel;
    private WebElement phoneNumberLabel;
    private WebElement phoneNumber;
    private WebElement communityLabel;
    private WebElement community;
    private WebElement dateLabel;
    private WebElement date;
    private List<WebElement> communitiesOptions;
    private Select select;

    // Public constructor
    
    public RegisterNewUserOtherInfo(WebDriver driver) {
        this.otherInfoLabel = driver.findElement(By.xpath(OTHERINFO_LABEL_XPATH));
        this.phoneNumberLabel = driver.findElement(By.cssSelector(PHONENUMBER_LABEL_CSSSELECTOR));
        this.phoneNumber = driver.findElement(By.id(PHONENUMBER_INPUT_ID));
        this.communityLabel = driver.findElement(By.cssSelector(COMMUNITY_LABEL_CSSSELECTOR));
        this.community = driver.findElement(By.id(COMMUNITY_DROPDOWN_ID));
        this.communitiesOptions = driver.findElements(By.xpath(COMMUNITIESOPTIONS_XPATH));  
        this.dateLabel = driver.findElement(By.cssSelector(DATE_LABEL_CSSSELECTOR));
        this.date = driver.findElement(By.id(DATE_INPUT_ID));
        this.select = new Select(getCommunity());
    }

    // get Other info labels

    public WebElement getOtherInfoLabel() {
        return otherInfoLabel;
    }
    
    public WebElement getPhoneNumberLabel() {
        return phoneNumberLabel;
    }
    
    public WebElement getCommunityLabel() {
        return communityLabel;
    }
    
    public WebElement getDateLabel() {
        return dateLabel;
    }

    // get Other info
    
    public WebElement getPhoneNumber() {
        return this.phoneNumber;
    }

    public WebElement getCommunity() {
        return this.community;
    }

    public WebElement getDate() {
        return this.date;
    }

    public List<WebElement> getCommunitiesOptions() {
        return this.communitiesOptions;
    }
    
    // set Other info

    public void setPhoneNumber(String phoneNumber) {
        getPhoneNumber().click();
        getPhoneNumber().clear();
        getPhoneNumber().sendKeys(phoneNumber);
    }

    public void setCommunity(String community) {
        getCommunity().click();
        for (WebElement we : getCommunitiesOptions()) {
            if (we.getText().equals(community)) {
                select.selectByVisibleText(community);
                break;
            }
        }        
    }

    public void setDate(String date) {
        getDate().click();
        getDate().clear();
        getDate().sendKeys(date);
    }
    
    // Functional
    
    public String getOtherInfoLabelText() {
        return getOtherInfoLabel().getText().trim();
    }
    
    public String getPhoneNumberLabelText() {
        return getPhoneNumberLabel().getText().trim();
    }
    
    public String getCommunityLabelText() {
        return getCommunityLabel().getText().trim();
    }
    
    public String getDateLabelText() {
        return getDateLabel().getText().trim();
    }
}
