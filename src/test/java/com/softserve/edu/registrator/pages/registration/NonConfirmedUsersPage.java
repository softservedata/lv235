package com.softserve.edu.registrator.pages.registration;

import org.openqa.selenium.WebElement;

import com.softserve.edu.registrator.pages.user.RegisteredUsersPage;
import com.softserve.edu.registrator.tools.search.Search;

public class NonConfirmedUsersPage extends RegisteredUsersPage {

    private class NonConfirmedUsersPageAction {

        // Fields

        // private WebDriver driver;
        private WebElement delete;
        private WebElement resendEmail;

        public NonConfirmedUsersPageAction() {
            // this.driver = driver;
            this.delete = Search.id("DELETE");
            this.resendEmail = Search.id("SENDEMAILAGAIN");
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
    
    public NonConfirmedUsersPage() {
        super();
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
