package com.softserve.edu.registrator.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class RegisterNewUserPassportInfo {

    // - - - - - - - - - - - - - - - - - - - - - - - - - - - - - -
    
    // Fields
        
    private WebElement seria;
    private WebElement passportNumber;
    private WebElement published;
    
    // Public constructor
    
    public RegisterNewUserPassportInfo(WebDriver driver) {
        this.seria = driver.findElement(By.id("passport_seria"));
        this.passportNumber = driver.findElement(By.id("passport_number"));
        this.published = driver.findElement(By.id("published_by_data"));
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
    
    
}
