package com.softserve.edu.registrator.pages.registration;

import java.util.HashMap;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.softserve.edu.registrator.data.users.IUser;
import com.softserve.edu.registrator.data.users.User;
import com.softserve.edu.registrator.pages.AdminHomePage;

public class RegisterUserPage extends AdminHomePage {
    
    public static enum RegisterUserPageL10n {
        SUBMIT_BUTTON("Надіслати", "Отправить", "Send"),
        CLEARFORM_BUTTON("Очистити форму", "Очистить форму", "Clear form"),
        CANCEL_BUTTON("Відмінити", "Отменить", "Cancel");
        // REQUIREDFIELDS_LABEL("Поля, позначені зірочкою (*), є обов'язковими для заповнення",
        //      "Поля, отмеченные звездочкой (*), обязательны для заполнения", 
        //      "Required fields are marked with an (*)");

        private HashMap<ChangeLanguageFields, String> field;

        private RegisterUserPageL10n(String... localization) {
            this.field = new HashMap<ChangeLanguageFields, String>();
            int i = 0;
            for (ChangeLanguageFields language : ChangeLanguageFields.values()) {
                this.field.put(language, localization[i]);
                i++;
            }
        }

        public String getLocalization(ChangeLanguageFields language) {
            return this.field.get(language).trim();
        }
    }
       
    // - - - - - - - - - - - - - - - - - - - - - - - - - - - - - -
    
    public static final String SUBMIT_ID = "submit";
    public static final String CLEARFORM_CSSSELECTOR = ".btn.btn-warning.reset";
    public static final String CANCEL_CSSSELECTOR = "#registrationForm .btn.btn-primary";
    
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
        this.submit = driver.findElement(By.id(SUBMIT_ID));
        this.clearForm = driver.findElement(By.cssSelector(CLEARFORM_CSSSELECTOR));
        this.cancel = driver.findElement(By.cssSelector(CANCEL_CSSSELECTOR));
        
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
    
    public void registerNewUser(IUser newUser) {
        // Adding main info about user
        getMainInfo().getFirstName().sendKeys(newUser.getPerson().getFirstname());
        getMainInfo().getLastName().sendKeys(newUser.getPerson().getLastname());
        getMainInfo().getMiddleName().sendKeys(newUser.getPerson().getMiddlename());
        getMainInfo().getEmail().sendKeys(newUser.getPerson().getEmail());
        getMainInfo().getLogin().sendKeys(newUser.getAccount().getLogin());
        getMainInfo().getPassword().sendKeys(newUser.getAccount().getPassword());
        getMainInfo().getConfirmPassword().sendKeys(newUser.getAccount().getPassword());
        // Adding address info about user
        getAddressInfo().getCity().sendKeys(newUser.getAddress().getCity());
        getAddressInfo().getRegion().sendKeys(newUser.getAddress().getRegion());
        getAddressInfo().getStreet().sendKeys(newUser.getAddress().getStreet());
        getAddressInfo().getBuilding().sendKeys(newUser.getAddress().getBuilding());
        getAddressInfo().getFlat().sendKeys(newUser.getAddress().getFlat());
        getAddressInfo().getPostcode().sendKeys(newUser.getAddress().getPostcode());
        // Adding passport info about user
        getPassportInfo().getSeria().sendKeys(newUser.getPassport().getSeria());
        getPassportInfo().getPassportNumber().sendKeys(newUser.getPassport().getNumber());
        getPassportInfo().getPublished().sendKeys(newUser.getPassport().getPublished());
        // Adding other info about user
        getOtherInfo().getPhoneNumber().sendKeys(newUser.getPerson().getPhonenumber());
        getOtherInfo().setCommunity(newUser.getAccount().getCommunity());
        getOtherInfo().getDate().sendKeys(newUser.getAccount().getData());
        // Registering new user
        clickSubmit();
    }
        
    public NonConfirmedCoownersPage successfulRegistration(User user) {
        registerNewUser(user);
        return new NonConfirmedCoownersPage(driver);
    }
    
    public RegisterUserPage unsuccessfulReristration(User user) {
        registerNewUser(user); // Is it needed???
        return new RegisterUserPage(driver);
    }
    
    public RegisterUserPage clearForm() {
        return new RegisterUserPage(driver);
    }
    
    public AdminHomePage cancelRegistration() {
        return new AdminHomePage(driver);
    }
}
