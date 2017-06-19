package com.softserve.edu.registrator.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.softserve.edu.registrator.data.users.User;

public class RegisterUserPage extends AdminHomePage {
    
    // - - - - - - - - - - - - - - - - - - - - - - - - - - - - - -
    
    // Fields

    private WebElement submit;
    private WebElement clearForm;
    private WebElement cancel;
          
    private RegisterNewUserMainInfo mainInfo;
    private RegisterNewUserAddressInfo addressInfo;
    private RegisterNewUserPassportInfo passportInfo;
    private RegisterNewUserOtherInfo otherInfo;
        
    // - - - - - - - - - - - - - - - - - - - - - - - - - - - - - -
    
    // Public constructor
    
    public RegisterUserPage(WebDriver driver) {
        super(driver);
        this.submit = driver.findElement(By.id("submit"));
        this.clearForm = driver.findElement(By.cssSelector(".btn.btn-warning.reset"));
        this.cancel = driver.findElement(By.cssSelector("#registrationForm .btn.btn-primary"));
        
        this.mainInfo = new RegisterNewUserMainInfo(driver);
        this.addressInfo = new RegisterNewUserAddressInfo(driver);
        this.passportInfo = new RegisterNewUserPassportInfo(driver);
        this.otherInfo = new RegisterNewUserOtherInfo(driver);
    }

    // Page object
    
    // get

    public WebElement getSubmit() {
        return submit;
    }

    public WebElement getClearForm() {
        return clearForm;
    }

    public WebElement getCancel() {
        return cancel;
    }
    
    public RegisterNewUserMainInfo getMainInfo() {
        return mainInfo;
    }
    
    public RegisterNewUserAddressInfo getAddressInfo() {
        return addressInfo;
    }
    
    public RegisterNewUserPassportInfo getPassportInfo() {
        return passportInfo;
    }
    
    public RegisterNewUserOtherInfo getOtherInfo() {
        return otherInfo;
    }
    
    // - - - - - - - - - - - - - - - - - - - - - - - - - - - - - -
    
    // Functional
        

    public String getSubmitText() {
        return getSubmit().getText();
    }
    
    public String getClearFormText() {
        return getClearForm().getText();
    }
    
    public String getCancelText() {
        return getCancel().getText();
    }
    
    // - - - - - - - - - - - - - - - - - - - - - - - - - - - - - -

    // set Data
    //TODO add setters for input fields
    
    public void clickSubmit() {
        getSubmit().click();
    }
    
    public void clickClearForm() {
        getClearForm().click();
    }
    
    public void clickCancel() {
        getCancel().click();
    }
       
    // - - - - - - - - - - - - - - - - - - - - - - - - - - - - - -

    // Business logic 
        
    public RegisterUserPage changeLanguage(ChangeLanguageFields language) {
        setChangeLanguage(language);
        return new RegisterUserPage(driver);
    }
    
    //TODO finish this method
    public void registerNewUser(User user) {
        mainInfo.getFirstName().sendKeys(user.getPerson().getFirstname());
        mainInfo.getLastName().sendKeys(user.getPerson().getLastname());
        mainInfo.getMiddleName().sendKeys(user.getPerson().getMiddlename());
        mainInfo.getEmail().sendKeys(user.getPerson().getEmail());
        mainInfo.getLogin().sendKeys(user.getAccount().getLogin());
        mainInfo.getPassword().sendKeys(user.getAccount().getPassword());
        mainInfo.getConfirmPassword().sendKeys(user.getAccount().getPassword());
        //TODO add getCommunity and unnecessary fields
    }
        
    public NonConfirmedCoownersPage successfulRegistration(User user) {
        registerNewUser(user);
        return new NonConfirmedCoownersPage(driver);
    }
    
    public RegisterUserPage unsuccessfulReristration(User user) {
        // registerNewUser(user); // Is it needed???
        return new RegisterUserPage(driver);
    }
    
    public RegisterUserPage clearForm() {
        return new RegisterUserPage(driver);
    }
    
    public AdminHomePage cancelRegistration() {
        return new AdminHomePage(driver);
    }
}
