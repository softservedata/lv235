package com.softserve.edu.registrator.pages.registration;

import java.util.HashMap;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.softserve.edu.registrator.pages.ATopComponent.ChangeLanguageFields;

public class RegisterNewUserAddressInfo {

// Enum with labels for localization
    
    public static enum AddressInfoL10n {
        ADDRESSINFO_LABEL("Адресні дані", "Адресные данные", "Address infomation"),
        CITY_LABEL("Місто", "Город", "City"),
        REGION_LABEL("Область", "Область", "Region"),
        DISTRICT_LABEL("Район", "Район", "District"),
        STREET_LABEL("Вулиця", "Улица", "Street"),
        BUILDING_LABEL("Будинок", "Дом", "Building"),
        FLAT_LABEL("Квартира", "Квартира", "Flat"),
        POSTCODE_ERROR_LABEL("Поле повинне містити тільки цифри",
                "Поле должно содержать только цифры",
                "The field must contain only digits"),
        POSTCODE_LABEL("Поштовий індекс", "Почтовый индекс", "Postcode");
        
        private HashMap<ChangeLanguageFields, String> field;

        private AddressInfoL10n(String... localization) {
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
    
    public static final String ADDRESSINFO_LABEL_CSSSELECTOR = ".address_header h4";
    public static final String CITY_LABEL_CSSSELECTOR = ".address_header h4+label";
    public static final String CITY_INPUT_ID = "city";
    public static final String REGION_LABEL_CSSSELECTOR = "label[for='region']";
    public static final String REGION_INPUT_ID = "region";
    public static final String DISTRICT_LABEL_CSSSELECTOR = "label[for='district']";
    public static final String DISTRICT_INPUT_ID = "district";
    public static final String STREET_LABEL_CSSSELECTOR = "label[for='street']";
    public static final String STREET_INPUT_ID = "street";
    public static final String BUILDING_LABEL_CSSSELECTOR = "label[for='building']";
    public static final String BUILDING_INPUT_ID = "building";
    public static final String FLAT_LABEL_CSSSELECTOR = "label[for='flat']";
    public static final String FLAT_INPUT_ID = "flat";
    public static final String POSTCODE_ERROR_LABEL_ID = "address.postcode.errors";
    public static final String POSTCODE_LABEL_CSSSELECTOR = "label[for='postcode']";
    public static final String POSTCODE_INPUT_ID = "postcode";
    
    // - - - - - - - - - - - - - - - - - - - - - - - - - - - - - -
    
    // Fields
    
    private WebElement addressInfoLabel; 
    private WebElement cityLabel;
    private WebElement city;
    private WebElement regionLabel;
    private WebElement region;
    private WebElement districtLabel;
    private WebElement district;
    private WebElement streetLabel;
    private WebElement street;
    private WebElement buildingLabel;
    private WebElement building;
    private WebElement flatLabel;
    private WebElement flat;
    private WebElement postcodeLabel;
    private WebElement postcode;
    
    // Public constructor
    
    public RegisterNewUserAddressInfo(WebDriver driver) {
        this.addressInfoLabel = driver.findElement(By.cssSelector(ADDRESSINFO_LABEL_CSSSELECTOR));
        this.cityLabel = driver.findElement(By.cssSelector(CITY_LABEL_CSSSELECTOR));
        this.city = driver.findElement(By.id(CITY_INPUT_ID));
        this.regionLabel = driver.findElement(By.cssSelector(REGION_LABEL_CSSSELECTOR));
        this.region = driver.findElement(By.id(REGION_INPUT_ID));
        this.districtLabel = driver.findElement(By.cssSelector(DISTRICT_LABEL_CSSSELECTOR));
        this.district = driver.findElement(By.id(DISTRICT_INPUT_ID));
        this.streetLabel = driver.findElement(By.cssSelector(STREET_LABEL_CSSSELECTOR));
        this.street = driver.findElement(By.id(STREET_INPUT_ID));
        this.buildingLabel = driver.findElement(By.cssSelector(BUILDING_LABEL_CSSSELECTOR));
        this.building = driver.findElement(By.id(BUILDING_INPUT_ID));
        this.flatLabel = driver.findElement(By.cssSelector(FLAT_LABEL_CSSSELECTOR));
        this.flat = driver.findElement(By.id(FLAT_INPUT_ID));
        this.postcodeLabel = driver.findElement(By.cssSelector(POSTCODE_LABEL_CSSSELECTOR));
        this.postcode = driver.findElement(By.id(POSTCODE_INPUT_ID));
    }

    // get Address info labels

    public WebElement getAddressInfoLabel() {
        return addressInfoLabel;
    }
    
    public WebElement getCityLabel() {
        return cityLabel;
    }
    
    public WebElement getRegionLabel() {
        return regionLabel;
    }
    
    public WebElement getDistrictLabel() {
        return districtLabel;
    }
    
    public WebElement getStreetLabel() {
        return streetLabel;
    }
    
    public WebElement getBuildingLabel() {
        return buildingLabel;
    }
    
    public WebElement getFlatLabel() {
        return flatLabel;
    }
    
    public WebElement getPostcodeLabel() {
        return postcodeLabel;
    }
    
    // get Address info
    
    public WebElement getCity() {
        return this.city;
    }

    public WebElement getRegion() {
        return this.region;
    }

    public WebElement getDistrict() {
        return this.district;
    }

    public WebElement getStreet() {
        return this.street;
    }

    public WebElement getBuilding() {
        return this.building;
    }

    public WebElement getFlat() {
        return this.flat;
    }

    public WebElement getPostcode() {
        return this.postcode;
    }

    
    // set Address info
    
    public void setCity(String city) {
        getCity().click();
        getCity().clear();
        getCity().sendKeys(city);
    }
    
    public void setRegion(String region) {
        getRegion().click();
        getRegion().clear();
        getRegion().sendKeys(region);
    }
    
    public void setDistrict(String district) {
        getDistrict().click();
        getDistrict().clear();
        getDistrict().sendKeys(district);
    }
    
    public void setStreet(String street) {
        getStreet().click();
        getStreet().clear();
        getStreet().sendKeys(street);
    }
    
    public void setBuilding(String building) {
        getBuilding().click();
        getBuilding().clear();
        getBuilding().sendKeys(building);
    }
    
    public void setFlat(String flat) {
        getFlat().click();
        getFlat().clear();
        getFlat().sendKeys(flat);
    }
    
    public void setPostcode(String postcode) {
        getPostcode().click();
        getPostcode().clear();
        getPostcode().sendKeys(postcode);
    }
    
    // Functional
    
    public String getAddressInfoLabelText() {
        return getAddressInfoLabel().getText().trim();
    }
    
    public String getCityLabelText() {
        return getCityLabel().getText().trim();
    }
    
    public String getRegionLabelText() {
        return getRegionLabel().getText().trim();
    }
    
    public String getDistrictLabelText() {
        return getDistrictLabel().getText().trim();
    }
    
    public String getStreetLabelText() {
        return getStreetLabel().getText().trim();
    }
    
    public String getBuildingLabelText() {
        return getBuildingLabel().getText().trim();
    }
    
    public String getFlatLabelText() {
        return getFlatLabel().getText().trim();
    }
    
    public String getPostcodeLabelText() {
        return getPostcodeLabel().getText().trim();
    }
        
}
