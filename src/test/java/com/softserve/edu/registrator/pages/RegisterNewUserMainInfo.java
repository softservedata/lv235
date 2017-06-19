package com.softserve.edu.registrator.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class RegisterNewUserMainInfo  {

    // - - - - - - - - - - - - - - - - - - - - - - - - - - - - - -
    
    // Fields

    private WebElement firstName;
    private WebElement lastName;
    private WebElement middleName;
    private WebElement email;
    private WebElement login;
    private WebElement password;
    private WebElement confirmPassword;
    
    // Public constructor
    
    public RegisterNewUserMainInfo(WebDriver driver) {
        this.firstName = driver.findElement(By.id("firstName"));
        this.lastName = driver.findElement(By.id("lastName"));
        this.middleName = driver.findElement(By.id("middleName"));
        this.email = driver.findElement(By.id("email"));
        this.login = driver.findElement(By.id("login"));
        this.password = driver.findElement(By.id("password"));
        this.confirmPassword = driver.findElement(By.id("confirmPassword"));
    }

    // get Main info
    
    public WebElement getFirstName() {
        return this.firstName;
    }

    public WebElement getLastName() {
        return this.lastName;
    }

    public WebElement getMiddleName() {
        return this.middleName;
    }

    public WebElement getEmail() {
        return this.email;
    }

    public WebElement getLogin() {
        return this.login;
    }

    public WebElement getPassword() {
        return this.password;
    }

    public WebElement getConfirmPassword() {
        return this.confirmPassword;
    }
    
    // set Main info
    
    public void setFirstName(String firstName) {
        getFirstName().click();
        getFirstName().clear();
        getFirstName().sendKeys(firstName);
    }
    
    public void setLastName(String lastName) {
        getLastName().click();
        getLastName().clear();
        getLastName().sendKeys(lastName);
    }
    
    public void setMiddleName(String middleName) {
        getMiddleName().click();
        getMiddleName().clear();
        getMiddleName().sendKeys(middleName);
    }
    
    public void setEmail(String email) {
        getEmail().click();
        getEmail().clear();
        getEmail().sendKeys(email);
    }
    
    public void setLogin(String login) {
        getLogin().click();
        getLogin().clear();
        getLogin().sendKeys(login);
    }
    
    public void setPassword(String password) {
        getPassword().click();
        getPassword().clear();
        getPassword().sendKeys(password);
    }
    
    public void setConfirmPassword(String confirmPassword) {
        getConfirmPassword().click();
        getConfirmPassword().clear();
        getConfirmPassword().sendKeys(confirmPassword);
    }
    
    
}
