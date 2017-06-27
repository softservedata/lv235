package com.softserve.edu.registrator.pages;

import com.softserve.edu.registrator.pages.ATopComponent.ChangeLanguageFields;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import java.util.HashMap;
import java.util.List;

/**
 * Created by User on 6/20/2017.
 */
public class EditPassportInfoComponent {

    public static enum EditPassportPageL10n {
        PASSPORT_INFO_LABEL_XPATH("Паспортні дані", "Паспортные данные", "Passport information"),
        SERIA_LABEL_XPATH("Серія", "Серия", "Seria"),
        NUMBER_LABEL_XPATH("Номер", "Номер", "Number"),
        PUBLISHED_LABEL_XPATH("Виданий", "Выданный", "Published by"),
        COMMUNITY_LABEL_XPATH("Громада* ", "Община* ", "Community* ");

        private HashMap<ATopComponent.ChangeLanguageFields, String> fieldsStringHashMap;

        private EditPassportPageL10n(String... localization) {
            this.fieldsStringHashMap = new HashMap<ChangeLanguageFields, String>();
            int i = 0;
            for (ChangeLanguageFields language : ChangeLanguageFields.values()) {
                this.fieldsStringHashMap.put(language, localization[i]);
                i++;
            }
        }

        public String getLocalization(ChangeLanguageFields languageFields) {
            return this.fieldsStringHashMap.get(languageFields).trim();
        }
    }

    //Labels
    private WebElement passportInfoLabel;
    private WebElement seriaLabel;
    private WebElement numberLabel;
    private WebElement publishLabel;
    private WebElement communityLabel;
    private List<WebElement> communitiesOptions;
    private Select select;

    public static final String MAIN_PASSPORT_LABEL_XPATH = "//input[@id='seria']/../../..//legend";
    public static final String SERIA_LABEL_XPATH = "//input[@id='seria']/../..//label";
    public static final String NUMBER_LABEL_XPATH = "//input[@id='number']/../..//label";
    public static final String PUBLISHED_LABEL_XPATH = "//input[@id='published']/../..//label";
    public static final String COMMUNITY_LABEL_XPATH = "//select[@id='community']/../..//label";



    //Fields
    public static final String SERIA_ID = "seria";
    public static final String NUMBER_ID = "number";
    public static final String PUBLISH_ID = "published";
    public static final String COMMUNITY_ID = "community";
    private WebElement seriaFiled;
    private WebElement numberField;
    private WebElement publishField;
    private WebElement communityField;

    public EditPassportInfoComponent(WebDriver driver) {
        this.seriaFiled = driver.findElement(By.id(SERIA_ID));
        this.numberField = driver.findElement(By.id(NUMBER_ID));
        this.publishField = driver.findElement(By.id(PUBLISH_ID));
        this.communityField = driver.findElement(By.id(COMMUNITY_ID));

        this.seriaLabel = driver.findElement(By.xpath(SERIA_LABEL_XPATH));
        this.numberLabel = driver.findElement(By.xpath(NUMBER_LABEL_XPATH));
        this.publishLabel = driver.findElement(By.xpath(PUBLISHED_LABEL_XPATH));
        this.communityLabel = driver.findElement(By.xpath(COMMUNITY_LABEL_XPATH));
        this.passportInfoLabel = driver.findElement(By.xpath(MAIN_PASSPORT_LABEL_XPATH));
        this.select = new Select(getCommunity());
    }

    // Get  Passport fields and labels
    public WebElement getPassportLabel() {
        return this.passportInfoLabel;
    }

    public WebElement getSeriaFiled() {
        return this.seriaFiled;
    }

    public WebElement getSeriaLabel() {
        return this.seriaLabel;
    }

    public WebElement getNumberLabel() {
        return this.numberLabel;
    }

    public WebElement getNumberField() {
        return this.numberField;
    }

    public WebElement getPublishLabel() {
        return this.publishLabel;
    }

    public WebElement getPublishedField() {
        return this.publishField;
    }

    public WebElement getCommunityLabel() {
        return this.communityLabel;
    }

    public WebElement getCommunity() {
        return this.communityField;
    }

    public Select getSelect() {
        return this.select;
    }

    public WebElement getPublishField() {
        return this.publishField;
    }

    public WebElement getCommunityField() {
        return this.communityField;
    }

    public List<WebElement> getCommunitiesOptions() {
        return this.communitiesOptions;
    }

    //Functional for labels
    public String getPassportInfoLabelText() {
        return getPassportLabel().getText().trim();
    }

    public String getSeriaLabelText() {
        return getSeriaLabel().getText().trim();
    }

    public String getNumberLabelText() {
        return getNumberLabel().getText().trim();
    }

    public String getPublishedLabelText() {
        return getPublishLabel().getText().trim();
    }

    public String getCommunityLabelText() {
        return getCommunityLabel().getText().trim();
    }

    //Functional for  passport data

    public void setCommunitiesOptions(String communitiesOptions) {
        getCommunityField().click();
        for (WebElement web : getCommunitiesOptions()) {
            if (web.getText().equals(communitiesOptions)) {
                select.deselectByVisibleText(communitiesOptions);
                break;
            }
        }

    }

    public void setSeriaFiledValue(String seria) {
        getSeriaFiled().clear();
        getSeriaFiled().sendKeys(seria);
    }

    public void setNumberFieldValue(String number) {
        getNumberField().clear();
        getNumberField().sendKeys(number);
    }

    public void setPublishFieldValue(String publish) {
        getPublishedField().clear();
        getPublishedField().sendKeys(publish);
    }

}
