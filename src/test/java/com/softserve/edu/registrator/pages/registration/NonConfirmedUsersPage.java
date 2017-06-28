package com.softserve.edu.registrator.pages.registration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.softserve.edu.registrator.pages.RegisteredUsersPage;

public class NonConfirmedUsersPage extends RegisteredUsersPage {

    private class NonConfirmedUsersPageAction {

        // Fields

        // private WebDriver driver;
        private WebElement delete;
        private WebElement resendEmail;

        public NonConfirmedUsersPageAction() {
            // this.driver = driver;
            this.delete = driver.findElement(By.id("DELETE"));
            this.resendEmail = driver.findElement(By.id("SENDEMAILAGAIN"));
        }

        public WebElement getDelete() {
            return this.delete;
        }

        public WebElement getResendEmail() {
            return this.resendEmail;
        }

    }

    // - - - - - - - - - - - - - - - - - - - - - - - - - - - - - -
    
    // Fields

    private NonConfirmedUsersPageAction nonConfirmedUsersPageAction;
    
    public NonConfirmedUsersPage(WebDriver driver) {
        super(driver);
    }

    // Page Object
    
    // get Data

    // Functional
    
    // get inner Data 
    
    public WebElement getDelete() {
        clickActionsButton();
        return this.nonConfirmedUsersPageAction.getDelete();
    }
    
    public WebElement getResendEmail() {
        clickActionsButton();
        return this.nonConfirmedUsersPageAction.getResendEmail();
    }
    
    // set Data
    
    @Override
    public void clickActionsButton() {
        super.clickActionsButton();
        this.nonConfirmedUsersPageAction = new NonConfirmedUsersPageAction();
    }
        
    // set inner Data
    
    public void clickDelete() {
        getDelete().click();
    }
    
    public void clickResendEmail() {
        getResendEmail().click();
    }
    
}
