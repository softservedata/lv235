package com.softserve.edu.registrator.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class NonConfirmedCoownersPage extends AdminHomePage {

    // - - - - - - - - - - - - - - - - - - - - - - - - - - - - - -
    
    // Fields
    
    private WebElement actionsDropdown;
    private WebElement countDropdown;
    
    private WebElement firstNameSorting;
    private WebElement lastNameSorting;
    private WebElement loginSorting;
    private WebElement territorialCommunitySorting;
    private WebElement emailSorting;
    private WebElement roleSorting;
    
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
    
    // - - - - - - - - - - - - - - - - - - - - - - - - - - - - - -
    
    // Public Constructor
    
    public NonConfirmedCoownersPage(WebDriver driver) {
        super(driver);
        this.actionsDropdown = driver.findElement(By.id("dLabel"));
        this.countDropdown = driver.findElement(By.name("example_length"));
        
        this.firstNameSorting = driver.findElement(By.cssSelector("c"));
        this.lastNameSorting = driver.findElement(By.cssSelector(".lastName.sorting"));
        this.loginSorting = driver.findElement(By.cssSelector(".login.sorting_asc"));
        this.territorialCommunitySorting = driver.findElement(By.cssSelector(".territorialCommunity_name.sorting"));
        this.emailSorting = driver.findElement(By.cssSelector(".email.sorting"));
        this.roleSorting = driver.findElement(By.cssSelector(".role_type.sorting"));
        
        this.firstNameField = driver.findElement((By.id("inputIndex1")));
        this.lastNameField = driver.findElement((By.id("inputIndex2")));
        this.login = driver.findElement((By.id("inputIndex3")));
        this.territorialCommunityField = driver.findElement((By.id("inputIndex4")));
        this.emailField = driver.findElement((By.id("inputIndex5")));
        this.role = driver.findElement((By.id("inputIndex6")));
        
        
    }
    
    
}
