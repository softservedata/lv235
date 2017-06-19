package com.softserve.edu.registrator.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class RegisterNewUserAddressInfo {

    // - - - - - - - - - - - - - - - - - - - - - - - - - - - - - -
    
    // Fields
    
    private WebElement city;
    private WebElement region;
    private WebElement district;
    private WebElement street;
    private WebElement building;
    private WebElement flat;
    private WebElement postcode;
    
    // Public constructor
    
    public RegisterNewUserAddressInfo(WebDriver driver) {
        this.city = driver.findElement(By.id("city"));
        this.region = driver.findElement(By.id("region"));
        this.district = driver.findElement(By.id("district"));
        this.street = driver.findElement(By.id("street"));
        this.building = driver.findElement(By.id("building"));
        this.flat = driver.findElement(By.id("flat"));
        this.postcode = driver.findElement(By.id("postcode"));
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
    
}
