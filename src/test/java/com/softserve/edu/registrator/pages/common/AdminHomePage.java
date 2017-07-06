package com.softserve.edu.registrator.pages.common;

import org.openqa.selenium.WebElement;

import com.softserve.edu.registrator.pages.communities.CommunityPage;
import com.softserve.edu.registrator.pages.registration.NonConfirmedUsersPage;
import com.softserve.edu.registrator.pages.registration.RegisterUserPage;
import com.softserve.edu.registrator.pages.search.user.ActiveUserPageContent;
import com.softserve.edu.registrator.pages.user.ActiveUsersPage;
import com.softserve.edu.registrator.tools.search.Search;

public class AdminHomePage extends ACommonComponent {

    private class CoownersOptions {

        private WebElement active;
        private WebElement inactive;
        private WebElement nonConfirmed;
        private WebElement blocked;

        public CoownersOptions() {
            this.active = Search.xpath("//ul/li[1]/a[contains(@href,'/users/get-all-users')]");
            this.inactive = Search.xpath("//a[contains(@href,'/users/get-all-users?statusType=inactive')]");
            this.nonConfirmed = Search.xpath("//a[contains(@href,'/users/get-all-users?statusType=notcomfirmed')]");
            this.blocked = Search.xpath("//a[contains(@href,'/users/get-all-users?statusType=block')]");
        }

        public WebElement getActiveElement() {
            return this.active;
        }

        public WebElement getInactiveElement() {
            return this.inactive;
        }

        public WebElement getNonConfirmedElement() {
            return this.nonConfirmed;
        }

        public WebElement getBlockedElement() {
            return this.blocked;
        }

    }

    // - - - - - - - - - - - - - - - - - - - - - - - - - - - - - -

    // Fields

    private WebElement home;
    private WebElement users;
    private WebElement settings;
    private WebElement communities;
    private WebElement newUser;
    private WebElement unblockAll;
    private CoownersOptions coownersOptions;

    public AdminHomePage() {
        super();
        this.home = Search.cssSelector("a.glyphicon.glyphicon-home");
        this.users = Search.xpath("//li[@class='dropdown']/a");
        this.settings = Search.xpath("//a[contains(@href,'/settings')]");
        this.communities = Search.xpath("//a[contains(@href,'/communities/show-all-communities')]");
        this.newUser = Search.xpath("//a[contains(@href,'/manualregistration')]");
        this.unblockAll = Search.id("unlockUsers");
    }

    // PageObject

    // get Data

    public WebElement getHome() {
        return this.home;
    }

    public WebElement getUsers() {
        return this.users;
    }

    public WebElement getSettings() {
        return this.settings;
    }

    public WebElement getCommunities() {
        return this.communities;
    }

    public WebElement getNewUser() {
        return this.newUser;
    }

    public WebElement getUnblockAll() {
        return this.unblockAll;
    }

    // Functional

    public String getHomeText() {
        return getHome().getText();
    }

    public String getUsersText() {
        return getUsers().getText();
    }

    public String getSettingsText() {
        return getSettings().getText();
    }

    public String getCommunitiesText() {
        return getCommunities().getText();
    }

    public String getNewUserText() {
        return getNewUser().getText();
    }

    public String getUnblockAllText() {
        return getUnblockAll().getText();
    }

    // get inner Data

    public WebElement getActive() {
        clickUsers();
        return this.coownersOptions.getActiveElement();
    }

    public WebElement getInactive() {
        clickUsers();
        return this.coownersOptions.getInactiveElement();
    }

    public WebElement getNonConfirmed() {
        clickUsers();
        return this.coownersOptions.getNonConfirmedElement();
    }

    public WebElement getBlocked() {
        clickUsers();
        return this.coownersOptions.getBlockedElement();
    }

    // set Data

    public void clickHome() {
        getHome().click();
    }

    public void clickUsers() {
        clickLoginAccount();
        getUsers().click();
        this.coownersOptions = new CoownersOptions();
    }

    public void clickSettings() {
        getSettings().click();
    }

    public CommunityPage clickCommunities() {
        getCommunities().click();
        return new CommunityPage();
    }

    public RegisterUserPage clickNewUser() {
        getNewUser().click();
        return new RegisterUserPage();
    }

    public void clickUnblockAll() {
        getUnblockAll().click();
    }

    // set inner Data

    public ActiveUserPageContent clickActive() {
        getActive().click();
        return new ActiveUserPageContent();
    }

    public void clickInactive() {
        getInactive().click();
    }

    public NonConfirmedUsersPage clickNonConfirmed() {
        getNonConfirmed().click();
        return new NonConfirmedUsersPage();
    }

    public void clickBlocked() {
        getBlocked().click();
    }

    // Business Logic

    public AdminHomePage changeLanguage(ChangeLanguageFields language) {
        setChangeLanguage(language);
        // Return a new page object representing the destination.
        return new AdminHomePage();
    }

    public AdminHomePage gotoAdminHomePage() {
        clickHome();
        return new AdminHomePage();
    }

    public LoginPage logout() {
        clickLogout();
        return new LoginPage();
    }

    public ActiveUsersPage gotoActiveUsers() {
        clickActive();
        return new ActiveUsersPage();
    }

    public NonConfirmedUsersPage gotoNonConfirmedUsers() {
        clickNonConfirmed();
        return new NonConfirmedUsersPage();
    }


}
