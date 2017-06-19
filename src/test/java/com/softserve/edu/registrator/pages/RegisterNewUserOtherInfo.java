package com.softserve.edu.registrator.pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class RegisterNewUserOtherInfo {

    // - - - - - - - - - - - - - - - - - - - - - - - - - - - - - -
    
    // Fields
    
    private WebElement phoneNumber;
    private WebElement community;
    private WebElement date;
    private List<WebElement> communitiesOptions; 

    // Public constructor
    
    public RegisterNewUserOtherInfo(WebDriver driver) {
        this.phoneNumber = driver.findElement(By.id("phone_number"));
        this.communitiesOptions = driver.findElements(By.xpath("//*[@id='territorial_Community']/option"));  
        this.community = driver.findElement(By.id("territorial_Community"));
        this.date = driver.findElement(By.id("datepicker"));
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
        Select select = new Select(getCommunity());
        getCommunity().click();
        for (WebElement we : getCommunitiesOptions()) {
            if (we.getText().equals(community)) {
                select.selectByValue(community);
            }
        }        
    }

    public void setDate(String date) {
        getDate().click();
        getDate().clear();
        getDate().sendKeys(date);
    }
    
}
