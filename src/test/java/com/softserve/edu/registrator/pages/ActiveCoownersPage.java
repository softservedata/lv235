package com.softserve.edu.registrator.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

/**
 * Created by User on 6/17/2017.
 */
public class ActiveCoownersPage extends AdminHomePage{

    private class ActionList{
        // Fields

        // private WebDriver driver;
        private WebElement actionDropdown;
        private WebElement setRole;
        private WebElement setCommunity;
        private WebElement setPassword;
      //Public ActionList constructor
        public ActionList(){
            this.setRole = driver.findElement(By.cssSelector("#actionList > ul > li.dropdown-submenu > a"));
            this.setCommunity = driver.findElement(By.cssSelector(".set-community"));
            this.setPassword=driver.findElement(By.cssSelector(".reset-password"));
            this.actionDropdown=driver.findElement(By.cssSelector("#dLabel"));
        }
        //method GET
        public WebElement getSetRole(){
            return this.setRole;
        }
        public  WebElement getSetPassword(){
            return this.setPassword;
        }
        public  WebElement getSetCommunity(){
            return  this.setCommunity;
        }
         public WebElement getActionDropdown(){
            return this.actionDropdown;
         }

    }
    //----------------------------------------------------------------------------
    //Fields
    private WebElement firstNameField;
    private WebElement lastNameField;
    private WebElement login;
    private WebElement territorialCommunityField;
    private WebElement emailField;
    private WebElement role;

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


    public ActiveCoownersPage(WebDriver driver) {
        super(driver);
        //Fields for Searching
        this.firstNameField=driver.findElement((By.id("inputIndex1")));
        this.lastNameField=driver.findElement((By.id("inputIndex2")));
        this.login=driver.findElement((By.id("inputIndex3")));
        this.territorialCommunityField=driver.findElement((By.id("inputIndex4")));
        this.emailField=driver.findElement((By.id("inputIndex5")));
        this.role=driver.findElement((By.id("inputIndex6")));
        //Buttons
        this.editButton=driver.findElement(By.xpath("//td[text()='adminIhor']/../td/button"));
        this.searchButton=driver.findElement(By.id("edit"));
        this.nextButton=driver.findElement(By.id("example_next"));
        this.previousButton=driver.findElement(By.id("example_previous"));
        //Labels for sorting
        this.firstNameSorting=driver.findElement(By.cssSelector(".firstName.sorting"));
        this.lastNameSorting=driver.findElement(By.cssSelector(".lastName.sorting"));
        this.loginSorting=driver.findElement(By.cssSelector(".login.sorting_asc"));
        this.territorialCommunitySorting=driver.findElement(By.cssSelector(".territorialCommunity_name.sorting"));
        this.emailSorting=driver.findElement(By.cssSelector(".email.sorting"));
        this.roleSorting=driver.findElement(By.cssSelector(".role_type.sorting"));
    }
    //methods for Search fields
    public WebElement getFirstNameField(){
        return this.firstNameField;
    }
    public WebElement getLastNameField(){
        return this.lastNameField;
    }
    public WebElement getLogin(){
        return this.login;
    }
    public WebElement getTerritorialCommunityField(){
        return this.territorialCommunityField;
    }
    public  WebElement getEmailField(){
        return this.emailField;
    }
    //???? TODO should know how solve this problem
    public WebElement getRole(){
        return  this.role;
    }
    //methods for buttons
    public  WebElement getSearchButton(){
        return this.searchButton;
    }
    public WebElement getEditButton(){
        return this.editButton;
    }
    public WebElement getPreviousButton(){
        return this.previousButton;
    }
    public WebElement getNextButton(){
        return this.nextButton;
    }
    //methods for sorting labels
    public WebElement getFirstNameSorting(){

        return this.firstNameSorting;
    }
    public WebElement getLastNameSorting(){

        return this.lastNameSorting;
    }
    public WebElement getLoginSorting(){
        return this.loginSorting;
    }
    public WebElement getTerritorialCommunitySorting(){
        return this.territorialCommunitySorting;
    }
    public WebElement getEmailSorting(){
        return this.emailSorting;
    }
    public WebElement getRoleSorting(){
        return this.roleSorting;
    }
    // set data
    public void setFirstNameField(String name){
    getFirstNameField().click();
    getFirstNameField().sendKeys(name);
    }
}
