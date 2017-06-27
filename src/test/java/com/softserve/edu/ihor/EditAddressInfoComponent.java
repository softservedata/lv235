package com.softserve.edu.registrator.pages;

import com.softserve.edu.registrator.pages.ATopComponent.ChangeLanguageFields;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.security.SecureRandom;
import java.util.HashMap;

/**
 * Created by User on 6/20/2017.
 */
public class EditAddressInfoComponent {
    //Enum for LOCALIZATION
    public static enum EitAddressL10n {
        MAIN_ADDRESS_LABEL_XPATH("Адресні дані", "Адресные данные", "Address infomation"),
        REGION_LABEL("Область", "Область", "Region"),
        CITY_LABEL("Місто", "Город", "City"),
        DISTRICT_LABE("Район", "Район", "District"),
        STREET_LABEL("Вулиця", "Улица", "Street"),
        BUILDING_ID("Будинок", "Дом", "Building"),
        FLAT_LABEL("Квартира", "Квартира", "Flat"),
        POSTCODE_LABEL("Поштовий індекс", "Почтовый индекс", "Postcode");

        private HashMap<ChangeLanguageFields, String> fieldsStringHashMap;

        private EitAddressL10n(String... localization) {
            this.fieldsStringHashMap = new HashMap<ChangeLanguageFields, String>();
            int i = 0;
            for (ChangeLanguageFields languageFields : ChangeLanguageFields.values()) {
                this.fieldsStringHashMap.put(languageFields, localization[i]);
                i++;
            }
        }

        public String getLocalization(ChangeLanguageFields languageFields) {
            return this.fieldsStringHashMap.get(languageFields).trim();
        }
    }


    public static final String REGION_LABEL = "//input[@id='region']/../..//label";
    public static final String CITY_LABEL = "//input[@id='city']/../..//label";
    public static final String DISTRICT_LABEL = "//input[@id='district']/../..//label";
    public static final String STREET_LABEL = "//input[@id='street']/../..//label";
    public static final String BUILDING_LABEL = "//input[@id='building']/../..//label";
    public static final String FLAT_LABEL = "//input[@id='flat']/../..//label";
    public static final String POSTCODE_LABEL = "//input[@id='postcode']/../..//label";
    public static final String MAIN_ADDRESS_LABEL_XPATH = "//input[@id='region']/../../..//legend";

    public static final String REGION_ID = "region";
    public static final String CITY_ID = "city";
    public static final String DISTRICT_ID = "district";
    public static final String STREET_ID = "street";
    public static final String BUILDING_ID = "building";
    public static final String FLAT_ID = "flat";
    public static final String POSTCODE_ID = "postcode";

    //WebDriver
    private WebDriver driver;
    //label
    private WebElement addressMainLabel;
    private WebElement regionLabel;
    private WebElement cityLabel;
    private WebElement districtLabel;
    private WebElement streetLabel;
    private WebElement buildingLabel;
    private WebElement flatLabel;
    private WebElement postcodeLabel;
    //fields
    private WebElement regionField;
    private WebElement cityField;
    private WebElement districtField;
    private WebElement streetField;
    private WebElement buildingField;
    private WebElement flatField;
    private WebElement postcodeField;

    public EditAddressInfoComponent(WebDriver driver) {
        this.driver=driver;
        //labels
        this.regionLabel = driver.findElement(By.xpath(REGION_LABEL));
        this.cityLabel = driver.findElement(By.xpath(CITY_LABEL));
        this.districtLabel = driver.findElement(By.xpath(DISTRICT_LABEL));
        this.streetLabel = driver.findElement(By.xpath(STREET_LABEL));
        this.buildingLabel = driver.findElement(By.xpath(BUILDING_LABEL));
        this.flatLabel = driver.findElement(By.xpath(FLAT_LABEL));
        this.postcodeLabel = driver.findElement(By.xpath(POSTCODE_LABEL));
        this.addressMainLabel = driver.findElement(By.xpath(MAIN_ADDRESS_LABEL_XPATH));
        //fields
        this.regionField = driver.findElement(By.id(REGION_ID));
        this.cityField = driver.findElement(By.id(CITY_ID));
        this.districtField = driver.findElement(By.id(DISTRICT_ID));
        this.streetField = driver.findElement(By.id(STREET_ID));
        this.buildingField = driver.findElement(By.id(BUILDING_ID));
        this.flatField = driver.findElement(By.id(FLAT_ID));
        this.postcodeField = driver.findElement(By.id(POSTCODE_ID));
    }
    // get driver
    public WebDriver getDriver(){
        return driver;
    }
    // get LABEl

    public WebElement getAddressMainLabel() {
        return this.addressMainLabel;
    }

    public WebElement getRegionLabel() {
        return this.regionLabel;
    }

    public WebElement getCityLabel() {
        return this.cityLabel;
    }

    public WebElement getDistrictLabel() {
        return this.districtLabel;
    }

    public WebElement getStreetLabel() {
        return this.streetLabel;
    }

    public WebElement getBuildingLabel() {
        return this.buildingLabel;
    }

    public WebElement getFlatLabel() {
        return this.flatLabel;
    }

    public WebElement getPostcodeLabel() {
        return this.postcodeLabel;
    }

    // get Fields
    public WebElement getRegionField() {
        return this.regionField;
    }

    public WebElement getCityField() {
        return this.cityField;
    }

    public WebElement getDistrictField() {
        return this.districtField;
    }

    public WebElement getStreetField() {
        return this.streetField;
    }

    public WebElement getBuildingField() {
        return this.buildingField;
    }

    public WebElement getFlatField() {
        return this.flatField;
    }

    public WebElement getPostcodeField() {
        return this.postcodeField;
    }
    //Functional for labels
    public String getMainAddressLabelTetx(){
        return getAddressMainLabel().getText().trim();
    }
    public  String getRegionLabelTetx(){
        return getRegionLabel().getText().trim();
    }
    public String getCityLabelText(){
        return getCityLabel().getText().trim();
    }
    public String getDistrictLabelText(){
        return getDistrictLabel().getText().trim();
    }
    public String getStreetLabelText(){
        return getStreetLabel().getText().trim();
    }
    public String getBuildingLabelTetx(){
        return getBuildingLabel().getText().trim();
    }
    public String getFlatLabelText(){
        return getFlatLabel().getText().trim();
    }
    public String getPostcodeLabelText(){
       return getPostcodeLabel().getText().trim();
    }

    //Functional methods, relating to address fields
    public void setRegionFieldValue(String region){
     getRegionField().clear();
     getRegionField().sendKeys(region);
    }
    public  void setCityFieldValue(String city){
        getCityField().clear();
        getCityField().sendKeys(city);
    }
    public void setDistrictFieldValue(String district){
    getDistrictField().clear();
    getDistrictField().sendKeys(district);
    }
    public void setStreetFieldValue(String street){
    getStreetField().clear();
    getStreetField().sendKeys(street);
    }
    public void setBuildingFieldValue(String building){
        getBuildingField().clear();
        getBuildingField().sendKeys(building);
    }
    public void setFlatFieldValue(String flat) {
        getFlatField().clear();
        getFlatField().sendKeys(flat);
    }
    public void setPostcode(String postcode){
    getPostcodeField().clear();
    getPostcodeField().sendKeys(postcode);
    }

}
