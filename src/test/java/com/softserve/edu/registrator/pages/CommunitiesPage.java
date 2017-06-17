package com.softserve.edu.registrator.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.softserve.edu.registrator.pages.ATopComponent.ChangeLanguageFields;

public class CommunitiesPage extends AdminHomePage {

    WebElement addCommunity;
    WebElement showInactive;
    WebElement editCommunity;
    WebElement deleteCommunity;
    
    // - - - - - - - - - - - - - - - - - - - - - - - - - - - - - -
    
    // Public constructor
    
    public CommunitiesPage(WebDriver driver) {
        super(driver);
        this.addCommunity = driver.findElement(By.cssSelector(".btn.btn-success"));
        this.showInactive = driver.findElement(By.id("inactiveCheckbox"));
        this.editCommunity = driver.findElement(By.id("editcommunity"));
        this.deleteCommunity = driver.findElement(By.id("deletecommunity"));
    }

    // - - - - - - - - - - - - - - - - - - - - - - - - - - - - - -
    
    // Page object
    
    // get
    
    public WebElement getAddCommunity() {
        return addCommunity;
    }

    public WebElement getShowInactive() {
        return showInactive;
    }

    public WebElement getEditCommunity() {
        return editCommunity;
    }

    public WebElement getDeleteCommunity() {
        return deleteCommunity;
    }

    // - - - - - - - - - - - - - - - - - - - - - - - - - - - - - -
    
    // set
    
    public void clickAddCommunity() {
        getAddCommunity().click();
    }

    public void clickShowInactive() {
        getShowInactive().click();
    }

    public void clickEditCommunity() {
        getEditCommunity().click();
    }

    public void clickDeleteCommunity() {
        getDeleteCommunity().click();
    }
    
    // - - - - - - - - - - - - - - - - - - - - - - - - - - - - - -
    
    // Business logic
    
    public CommunitiesPage changeLanguage(ChangeLanguageFields language) {
        setChangeLanguage(language);
        return new CommunitiesPage(driver);
    }
    
}
