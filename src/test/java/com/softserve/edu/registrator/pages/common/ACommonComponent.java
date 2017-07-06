package com.softserve.edu.registrator.pages.common;

import org.openqa.selenium.WebElement;

import com.softserve.edu.registrator.tools.search.Search;

public abstract class ACommonComponent extends ATopComponent {

    private class UserAccount {

        // Fields

        // private WebDriver driver;
        //
        private WebElement changePassword;
        private WebElement resetPassword;
        private WebElement logout;
        //public final WebElement logout;

        // public UserAccount(WebDriver driver) {
        public UserAccount() {
            // this.driver = driver;
            this.changePassword = Search.cssSelector("a.change-password");
            this.resetPassword = Search.cssSelector("a.reset-my-password");
            this.logout = Search.xpath("//a[contains(@href,'/logout')]");
        }

        // PageObject

        // get Data

        public WebElement getChangePasswordElement() {
            return this.changePassword;
        }

        public WebElement getResetPasswordElement() {
            return this.resetPassword;
        }

        public WebElement getLogoutElement() {
            return this.logout;
        }

    }

    // - - - - - - - - - - - - - - - - - - - - - - - - - - - - - -

    // Fields

    private WebElement loginAccount;
    private WebElement menuAccount;
    private UserAccount userAccount;

    public ACommonComponent() {
        super();
        // TODO use cssSelector with not
        this.loginAccount = Search.xpath("//button[@class='btn btn-primary btn-sm']");
        this.menuAccount = Search.cssSelector(".btn.btn-primary.btn-sm.dropdown-toggle");
    }

    // PageObject

    // get Data

    public WebElement getLoginAccount() {
        return this.loginAccount;
    }

    public WebElement getMenuAccount() {
        return this.menuAccount;
    }

    // get inner Data

    public WebElement getChangePassword() {
        clickMenuAccount();
        return this.userAccount.getChangePasswordElement();
    }

    public WebElement getResetPassword() {
        clickMenuAccount();
        return this.userAccount.getResetPasswordElement();
    }

    public WebElement getLogout() {
        clickMenuAccount();
        return this.userAccount.getLogoutElement();
    }

    // Functional

    public String getLoginAccountText() {
        return getLoginAccount().getText();
    }

    public String getChangePasswordText() {
        return getChangePassword().getText();
    }

    public String getResetPasswordText() {
        return getResetPassword().getText();
    }

    public String getLogoutText() {
        return getLogout().getText();
    }

    // set Data

    public void clickLoginAccount() {
        getLoginAccount().click();
    }

    public void clickMenuAccount() {
        clickLoginAccount();
        getMenuAccount().click();
        // userAccount = new UserAccount(driver);
        this.userAccount = new UserAccount();
    }

    public void clickChangePassword() {
        getChangePassword().click();
    }

    public void clickResetPassword() {
        getResetPassword().click();
    }

    public void clickLogout() {
        getLogout().click();
    }

    // Business Logic

}
