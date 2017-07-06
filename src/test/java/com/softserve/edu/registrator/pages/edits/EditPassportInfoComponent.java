package com.softserve.edu.registrator.pages.edits;

import java.util.HashMap;
import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import com.softserve.edu.registrator.pages.common.ATopComponent;
import com.softserve.edu.registrator.pages.common.ATopComponent.ChangeLanguageFields;
import com.softserve.edu.registrator.tools.search.Search;

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
    public static final String VALUE = "value";
    private WebElement seriaFiled;
    private WebElement numberField;
    private WebElement publishField;
    private WebElement communityField;

    public EditPassportInfoComponent() {
        this.seriaFiled = Search.id(SERIA_ID);
        this.numberField = Search.id(NUMBER_ID);
        this.publishField = Search.id(PUBLISH_ID);
        this.communityField = Search.id(COMMUNITY_ID);

        this.seriaLabel = Search.xpath(SERIA_LABEL_XPATH);
        this.numberLabel = Search.xpath(NUMBER_LABEL_XPATH);
        this.publishLabel = Search.xpath(PUBLISHED_LABEL_XPATH);
        this.communityLabel = Search.xpath(COMMUNITY_LABEL_XPATH);
        this.passportInfoLabel = Search.xpath(MAIN_PASSPORT_LABEL_XPATH);
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

    //Functional for values
    public String getSeriaValueText(){
        return getSeriaFiled().getAttribute(VALUE);
    }

    public String getNumberValueText(){
        return getNumberField().getAttribute(VALUE);
    }

    public  String getPublishValueText(){
        return getPublishField().getAttribute(VALUE);
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
