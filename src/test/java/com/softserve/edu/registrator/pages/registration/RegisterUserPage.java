package com.softserve.edu.registrator.pages.registration;

import java.util.HashMap;

import org.openqa.selenium.WebElement;

import com.softserve.edu.registrator.data.users.IUser;
import com.softserve.edu.registrator.data.users.User;
import com.softserve.edu.registrator.pages.common.AdminHomePage;
import com.softserve.edu.registrator.tools.search.Search;

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
    
    public RegisterUserPage() {
        super();
        this.submit = Search.id(SUBMIT_ID);
        this.clearForm = Search.cssSelector(CLEARFORM_CSSSELECTOR);
        this.cancel = Search.cssSelector(CANCEL_CSSSELECTOR);
        
        this.mainInfo = new RegisterNewUserMainInfo();
        this.addressInfo = new RegisterNewUserAddressInfo();
        this.passportInfo = new RegisterNewUserPassportInfo();
        this.otherInfo = new RegisterNewUserOtherInfo();
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
    
    public NonConfirmedUsersPage clickSubmit() {
        getSubmit().click();
        return new NonConfirmedUsersPage();
    }
    
    public void clickClearForm() {
        getClearForm().click();
    }
    
    public AdminHomePage clickCancel() {
        getCancel().click();
        return new AdminHomePage();
    }
       
    // - - - - - - - - - - - - - - - - - - - - - - - - - - - - - -

    // Business logic 
        
    public RegisterUserPage changeLanguage(ChangeLanguageFields language) {
        setChangeLanguage(language);
        return new RegisterUserPage();
    }
    
    public void registerNewUser(IUser newUser) {
        clickClearForm();
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
        getAddressInfo().getDistrict().sendKeys(newUser.getAddress().getDistrict());
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
    }
        
    public NonConfirmedUsersPage successfulRegistration(User user) {
        registerNewUser(user);
        return new NonConfirmedUsersPage();
    }
    
    public RegisterUserPage unsuccessfulReristration(User user) {
        registerNewUser(user); // Is it needed???
        return new RegisterUserPage();
    }
    
    public RegisterUserPage clearForm() {
        return new RegisterUserPage();
    }
    
    public AdminHomePage cancelRegistration() {
        return new AdminHomePage();
    }
}
