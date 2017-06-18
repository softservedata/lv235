package com.softserve.edu.registrator.pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.softserve.edu.registrator.data.users.User;

public class RegisterUserPage extends AdminHomePage {
    
    // - - - - - - - - - - - - - - - - - - - - - - - - - - - - - -
    
    // Fields

    private WebElement submit;
    private WebElement clearForm;
    private WebElement cancel;
    
    /*
     * TODO make Lists of WebElements for fields of registration page
     * - - - - - - - - - - - - - Example: - - - - - - - - - - - - -
     * List<WebElement> mainInfo = driver.findElements(By.cssSelector(".personal_header.col-lg-4"));
     * This list must contain info from firstName to confirmPassword fields
     */
        
    private WebElement firstName;
    private WebElement lastName;
    private WebElement middleName;
    private WebElement email;
    private WebElement login;
    private WebElement password;
    private WebElement confirmPassword;

    private WebElement city;
    private WebElement region;
    private WebElement district;
    private WebElement street;
    private WebElement building;
    private WebElement flat;
    private WebElement postcode;
    
    private WebElement seria;
    private WebElement passportNumber;
    private WebElement published;
    
    private WebElement phoneNumber;
    private WebElement community;
    private WebElement date;
    
    public List<WebElement> communitiesOptions; 
    // TODO List of community options from community dropdown
    // this.communitiesOptions = driver.findElements(By.xpath("//*[@id='territorial_Community']/option"));  
    
    // - - - - - - - - - - - - - - - - - - - - - - - - - - - - - -
    
    // Public constructor
    
    public RegisterUserPage(WebDriver driver) {
        super(driver);
        this.submit = driver.findElement(By.id("submit"));
        this.clearForm = driver.findElement(By.cssSelector(".btn.btn-warning.reset"));
        this.cancel = driver.findElement(By.cssSelector("#registrationForm .btn.btn-primary"));
        
        this.firstName = driver.findElement(By.id("firstName"));
        this.lastName = driver.findElement(By.id("lastName"));
        this.middleName = driver.findElement(By.id("middleName"));
        this.email = driver.findElement(By.id("email"));
        this.login = driver.findElement(By.id("login"));
        this.password = driver.findElement(By.id("password"));
        this.confirmPassword = driver.findElement(By.id("confirmPassword"));
        
        this.city = driver.findElement(By.id("city"));
        this.region = driver.findElement(By.id("region"));
        this.district = driver.findElement(By.id("district"));
        this.street = driver.findElement(By.id("street"));
        this.building = driver.findElement(By.id("building"));
        this.flat = driver.findElement(By.id("flat"));
        this.postcode = driver.findElement(By.id("postcode"));
        
        this.seria = driver.findElement(By.id("passport_seria"));
        this.passportNumber = driver.findElement(By.id("passport_number"));
        this.published = driver.findElement(By.id("published_by_data"));
        
        this.phoneNumber = driver.findElement(By.id("phone_number"));
        this.community = driver.findElement(By.id("territorial_Community"));
        this.date = driver.findElement(By.id("datepicker"));
        
        
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
    
    // get Address info
    
    public WebElement getCity() {
        return this.city;
    }

    public WebElement getRegion() {
        return this.region;
    }

    public WebElement getDistrict() {
        return this.district;
    }

    public WebElement getStreet() {
        return this.street;
    }

    public WebElement getBuilding() {
        return this.building;
    }

    public WebElement getFlat() {
        return this.flat;
    }

    public WebElement getPostcode() {
        return this.postcode;
    }
    
    // get Passport info

    public WebElement getSeria() {
        return seria;
    }

    public WebElement getPassportNumber() {
        return passportNumber;
    }

    public WebElement getPublished() {
        return published;
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
        getFirstName().sendKeys(user.getPerson().getFirstname());
        getLastName().sendKeys(user.getPerson().getLastname());
        getEmail().sendKeys(user.getPerson().getEmail());
        getLogin().sendKeys(user.getAccount().getLogin());
        getPassword().sendKeys(user.getAccount().getPassword());
        getConfirmPassword().sendKeys(user.getAccount().getPassword());
        getDate().sendKeys(user.getAccount().getData());
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
