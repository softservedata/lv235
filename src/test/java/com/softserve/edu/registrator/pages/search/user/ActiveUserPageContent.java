package com.softserve.edu.registrator.pages.search.user;

import org.openqa.selenium.WebElement;

import com.softserve.edu.registrator.pages.user.ActiveUsersPage;
import com.softserve.edu.registrator.tools.search.Search;

/**
 * @author ihor
 */
public class ActiveUserPageContent extends ActiveUsersPage {

    private class ActionList {
        // private WebDriver driver;
        private WebElement role;
        private WebElement community;
        private WebElement password;

        //Public ActionList constructor
        public ActionList() {
            this.role = Search.cssSelector("#actionList > ul > li.dropdown-submenu > a");
            this.community = Search.cssSelector(".set-community");
            this.password = Search.cssSelector(".reset-password");
        }

        //method GET
        public WebElement getRoleElement() {
            return this.role;
        }

        public WebElement getPasswordElement() {
            return this.password;
        }

        public WebElement getCommunityElement() {
            return this.community;
        }
    }

    //Constants for locators
    private final static String FIRST_NAME_FIELD = "inputIndex1";

    //----------------------------------------------------------------------------
    //Fields
    private WebElement firstNameField;
    private WebElement lastNameField;
    private WebElement loginField;
    private WebElement territorialCommunityField;
    private WebElement emailField;
    private WebElement roleValue;
    private WebElement userValue;
    private WebElement adminValue;
    private WebElement registratorValue;
    private WebElement commissionerValue;
    private WebElement testValue;

    private WebElement actionDropdownList;
    private WebElement searchButton;
    private WebElement editButton;
    private WebElement previousButton;
    private WebElement nextButton;

    private WebElement firstNameSorting;
    private WebElement lastNameSorting;
    private WebElement loginSorting;
    private WebElement territorialCommunitySorting;
    private WebElement emailSorting;
    private WebElement roleSorting;
    private ActionList actionList;

    public ActiveUserPageContent() {
        super();
        //Fields for Searching
        this.testValue = Search.xpath("//td[@class=' email'][text()='IvaTest@gmail.com']");
        this.firstNameField = Search.id(FIRST_NAME_FIELD);
        this.lastNameField = Search.id("inputIndex2");
        this.loginField = Search.id("inputIndex3");
        this.territorialCommunityField = Search.id("inputIndex4");
        this.emailField = Search.id("inputIndex5");
        this.roleValue = Search.id("inputIndex6");
        //Values for Role DropDown
        this.userValue = Search.xpath("//option[@value='USER']");
        this.adminValue = Search.xpath("//option[@value='ADMIN']");
        this.registratorValue = Search.xpath("//option[@value='REGISTRATOR']");
        this.commissionerValue = Search.xpath("//option[@value='COMMISSIONER']");
        //Buttons
        this.actionDropdownList = Search.id("dLabel");
        this.editButton = Search.xpath("//td[text()='adminIhor']/../td/button");
        this.searchButton = Search.id("bth-search");
        this.nextButton = Search.id("example_next");
        this.previousButton = Search.id("example_previous");
        //Labels for sorting
        this.firstNameSorting = Search.cssSelector(".firstName.sorting");
        this.lastNameSorting = Search.cssSelector(".lastName.sorting");
        this.loginSorting = Search.cssSelector(".login.sorting_asc");
        this.territorialCommunitySorting = Search.cssSelector(".territorialCommunity_name.sorting");
        this.emailSorting = Search.cssSelector(".email.sorting");
        this.roleSorting = Search.cssSelector(".role_type.sorting");
    }

    //get testValue
    public WebElement getTestValue() {
        return this.testValue;
    }

    //methods for Search fields
    public WebElement getFirstNameField() {
        return this.firstNameField;
    }

    public WebElement getLastNameField() {
        return this.lastNameField;
    }

    public WebElement getLoginField() {
        return this.loginField;
    }

    public WebElement getTerritorialCommunityField() {
        return this.territorialCommunityField;
    }

    public WebElement getEmailField() {
        return this.emailField;
    }

    // for Role
    public WebElement getRoleValue() {
        return this.roleValue;
    }

    public void clickRoleValue() {
        getRoleValue().click();
    }

    // for Role options
    public WebElement getUserValue() {
        return this.userValue;
    }

    public void selectUserValue() {
        clickRoleValue();
        getUserValue().click();
    }

    public WebElement getAdminValue() {
        return this.adminValue;
    }

    public void selectAdminValue() {
        clickRoleValue();
        getAdminValue().click();
    }

    public WebElement getRegistratorValue() {
        return registratorValue;
    }

    public void selectRegistratorValue() {
        clickRoleValue();
        getRegistratorValue().click();
    }

    public WebElement getCommissionerValue() {
        return commissionerValue;
    }

    public void selectCommissionerValue() {
        clickRoleValue();
        getCommissionerValue().click();
    }

    //methods for buttons
    public WebElement getActionDropdown() {
        return this.actionDropdownList;
    }

    public WebElement getSearchButton() {
        return this.searchButton;
    }

    public WebElement getEditButton() {
        return this.editButton;
    }

    public WebElement getPreviousButton() {
        return this.previousButton;
    }

    public WebElement getNextButton() {
        return this.nextButton;
    }

    //methods for sorting labels
    public WebElement getFirstNameSorting() {
        return this.firstNameSorting;
    }

    public WebElement getLastNameSorting() {
        return this.lastNameSorting;
    }

    public WebElement getLoginSorting() {
        return this.loginSorting;
    }

    public WebElement getTerritorialCommunitySorting() {
        return this.territorialCommunitySorting;
    }

    public WebElement getEmailSorting() {
        return this.emailSorting;
    }

    public WebElement getRoleSorting() {
        return this.roleSorting;
    }


    //methods for access the Action Lists elements
    public void clickActionDropDownList() {
        getActionDropdown().click();
        actionList = new ActionList();
    }

    public void selectCommunity() {
        clickActionDropDownList();
        actionList.getCommunityElement().click();
    }

    public void selectRole() {
        clickActionDropDownList();
        actionList.getRoleElement().click();
    }

    public void selectPassword() {
        clickActionDropDownList();
        actionList.getPasswordElement().click();
    }

    //method for buttons
    public void clickSearchButton() {
        getSearchButton().click();
    }

    //functional for fields
    public void inputInFirstNameField(String name) {
        getFirstNameField().clear();
        getFirstNameField().sendKeys(name);
    }

    public void inputInLastNameField(String name) {
        getLastNameField().clear();
        getLastNameField().sendKeys(name);
    }

    public void inputInLoginField(String name) {
        getLoginField().clear();
        getLoginField().sendKeys(name);
    }

    public void inputInCommunityField(String name) {
        getTerritorialCommunityField().clear();
        getTerritorialCommunityField().sendKeys(name);
    }

    public void inputInEmailField(String name) {
        getEmailField().clear();
        getEmailField().sendKeys(name);
    }

    //Data provider  get methods
    public String getEmail(ISearchFields data) {
        return data.getEmail();
    }

    //Data provider set methods
    public void inputFirstNameData(ISearchFields data) {
        getFirstNameField().clear();
        getFirstNameField().sendKeys(data.getFirstName());
    }
}
