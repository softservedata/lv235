package com.softserve.edu.registrator.pages.registration;

import java.util.HashMap;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.softserve.edu.registrator.pages.ATopComponent.ChangeLanguageFields;
import com.softserve.edu.registrator.pages.Application;

public class RegisterNewUserMainInfo {

    // Enum with labels for localization
    
    public static enum MainInfoL10n {
        MAININFO_LABEL("Основна інформація", "Основная информация", "Basic information"),
        FIRSTNAME_ERROR_LABEL("Некоректне введення, лише літери",
                "Некорректный ввод, только буквы",
                "Incorrect inputting, only letters are valid"),
        FIRSTNAME_LABEL("Ім'я *", "Имя *", "First name *"),
        LASTNAME_ERROR_LABEL("Некоректне введення, лише літери",
                "Некорректный ввод, только буквы",
                "Incorrect inputting, only letters are valid"),
        LASTNAME_LABEL("Прізвище*", "Фамилия*", "Second name*"),
        MIDDLENAME_ERROR_LABEL("Від 1 до 30 символів, цифри недопустимі",
                "От 1 до 30 символов, цифры недопустимы",
                "From 1 to 30 symbols, digits arent valid"),
        MIDDLENAME_LABEL("По-батькові", "Отчество", "Middle name"),
        EMAIL_ERROR_LABEL("Введіть коректну адресу",
                "Введите корректный адресс",
                "Please, enter correct email"),
        EMAIL_LABEL("Електронна пошта *", "Электронная почта *", "E-mail *"),
        LOGIN_ERROR_LABEL(
                "Логін повинен складатись лише з латинських літер і/або цифр, від 6 до 20 символів",
                "Логин должен состоять только с латинских букв и/или цифр, от 6 до 20 символов",
                "The login must contain only latin letters and/or digits, from 6 to 20 characters"),
        LOGIN_LABEL("Логін *", "Логин *", "Login *"),
        PASSWORD_ERROR_LABEL(
                "Пароль повинен складатись з латинських літер і/або цифр, від 6 до 20 символів",
                "Пароль должен состоять только с латинских букв и/или цифр, от 6 до 20 символов",
                "The password must contain only latin letters and/or digits, from 6 to 20 characters"),
        PASSWORD_LABEL("Пароль *", "Пароль *", "Password *"),
        CONFIRMPASSWORD_ERROR_LABEL("Підтвердження паролю неправильне",
                "Подтверждение пароля неверное",
                "You've entered bad password confirmation"),
        CONFIRMPASSWORD_LABEL("Підтвердження паролю *", "Подтверждение пароля *", "Confirm password *");
        
        private HashMap<ChangeLanguageFields, String> field;

        private MainInfoL10n(String... localization) {
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
    
    public static final String MAININFO_LABEL_CSSSELECTOR = ".personal_header.col-lg-4 h4";
    public static final String FIRSTNAME_ERROR_LABEL_ID = "firstName.errors";
    public static final String FIRSTNAME_LABEL_CSSSELECTOR = "label[for='firstName']";
    public static final String FIRSTNAME_INPUT_ID = "firstName";
    public static final String LASTNAME_ERROR_LABEL_ID = "lastName.errors";
    public static final String LASTNAME_LABEL_CSSSELECTOR = "label[for='lastName']";
    public static final String LASTNAME_INPUT_ID = "lastName";
    public static final String MIDDLENAME_ERROR_LABEL_ID = "middleName.errors";
    public static final String MIDDLENAME_LABEL_CSSSELECTOR = "label[for='middleName']";
    public static final String MIDDLENAME_INPUT_ID = "middleName";
    public static final String EMAIL_ERROR_LABEL_ID = "email.errors";
    public static final String EMAIL_LABEL_CSSSELECTOR = "label[for='email']";
    public static final String EMAIL_INPUT_ID = "email";
    public static final String LOGIN_ERROR_LABEL_ID = "login.errors";
    public static final String LOGIN_LABEL_CSSSELECTOR = "label[for='login']";
    public static final String LOGIN_INPUT_ID = "login";
    public static final String PASSWORD_ERROR_LABEL_ID = "password.errors";
    public static final String PASSWORD_LABEL_CSSSELECTOR = "label[for='password']";
    public static final String PASSWORD_INPUT_ID = "password";
    public static final String CONFIRMPASSWORD_ERROR_LABEL_ID = "confirmPassword.errors";
    public static final String CONFIRMPASSWORD_LABEL_CSSSELECTOR = "label[for='confirmPassword']";
    public static final String CONFIRMPASSWORD_INPUT_ID = "confirmPassword";
    
    // - - - - - - - - - - - - - - - - - - - - - - - - - - - - - -
    
    // Fields
    
    private WebDriver driver;
    private WebElement mainInfoLabel;
    private WebElement firstNameLabel;
    private WebElement firstName;
    private WebElement lastNameLabel;
    private WebElement lastName;
    private WebElement middleNameLabel;
    private WebElement middleName;
    private WebElement emailLabel;
    private WebElement email;
    private WebElement loginLabel;
    private WebElement login;
    private WebElement passwordLabel;
    private WebElement password;
    private WebElement confirmPasswordLabel;
    private WebElement confirmPassword;
    
    // Public constructor
    
    public RegisterNewUserMainInfo(WebDriver driver) {
        this.driver = driver;
        this.mainInfoLabel = driver.findElement(By.cssSelector(MAININFO_LABEL_CSSSELECTOR));
        this.firstNameLabel = driver.findElement(By.cssSelector(FIRSTNAME_LABEL_CSSSELECTOR));
        this.firstName = driver.findElement(By.id(FIRSTNAME_INPUT_ID));
        this.lastNameLabel = driver.findElement(By.cssSelector(LASTNAME_LABEL_CSSSELECTOR));
        this.lastName = driver.findElement(By.id(LASTNAME_INPUT_ID));
        this.middleNameLabel = driver.findElement(By.cssSelector(MIDDLENAME_LABEL_CSSSELECTOR));
        this.middleName = driver.findElement(By.id(MIDDLENAME_INPUT_ID));
        this.emailLabel = driver.findElement(By.cssSelector(EMAIL_LABEL_CSSSELECTOR));
        this.email = driver.findElement(By.id(EMAIL_INPUT_ID));
        this.loginLabel = driver.findElement(By.cssSelector(LOGIN_LABEL_CSSSELECTOR));
        this.login = driver.findElement(By.id(LOGIN_INPUT_ID));
        this.passwordLabel = driver.findElement(By.cssSelector(PASSWORD_LABEL_CSSSELECTOR));
        this.password = driver.findElement(By.id(PASSWORD_INPUT_ID));
        this.confirmPasswordLabel = driver.findElement(By.cssSelector(CONFIRMPASSWORD_LABEL_CSSSELECTOR));
        this.confirmPassword = driver.findElement(By.id(CONFIRMPASSWORD_INPUT_ID));
    }

    // get Main info error labels
    
    public WebElement getFirstNameErrorLabel() {
        return getDriver().findElement(By.id(FIRSTNAME_ERROR_LABEL_ID));
    }
    
    public WebElement getLastNameErrorLabel() {
        return getDriver().findElement(By.id(LASTNAME_ERROR_LABEL_ID));
    }
    
    public WebElement getMiddleNameErrorLabel() {
        return getDriver().findElement(By.id(MIDDLENAME_ERROR_LABEL_ID));
    }
    
    public WebElement getEmailErrorLabel() {
        return getDriver().findElement(By.id(EMAIL_ERROR_LABEL_ID));
    }
    
    public WebElement getLoginErrorLabel() {
        return getDriver().findElement(By.id(LOGIN_ERROR_LABEL_ID));
    }
    
    public WebElement getPasswordErrorLabel() {
        return getDriver().findElement(By.id(PASSWORD_ERROR_LABEL_ID));
    }
    
    public WebElement getConfirmPasswordErrorLabel() {
        return getDriver().findElement(By.id(CONFIRMPASSWORD_ERROR_LABEL_ID));
    }
    
    // get Main info labels

    public WebElement getMainInfoLabel() {
        return this.mainInfoLabel;
    }
    
    public WebElement getFirstNameLabel() {
        return this.firstNameLabel;
    }

    public WebElement getLastNameLabel() {
        return this.lastNameLabel;
    }

    public WebElement getMiddleNameLabel() {
        return this.middleNameLabel;
    }

    public WebElement getEmailLabel() {
        return this.emailLabel;
    }

    public WebElement getLoginLabel() {
        return this.loginLabel;
    }

    public WebElement getPasswordLabel() {
        return this.passwordLabel;
    }

    public WebElement getConfirmPasswordLabel() {
        return this.confirmPasswordLabel;
    }
    
    // get Main info

    public WebDriver getDriver() {
        return this.driver;
    }
    
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
    
    // Functional
    
    public String getMainInfoLabelText() {
        return getMainInfoLabel().getText().trim();
    }
    
    public String getFirstNameLabelText() {
        return getFirstNameLabel().getText().trim();
    }
    
    public String getLastNameLabelText() {
        return getLastNameLabel().getText().trim();
    }
    
    public String getMiddleNameLabelText() {
        return getMiddleNameLabel().getText().trim();
    }
    
    public String getEmailLabelText() {
        return getEmailLabel().getText().trim();
    }
    
    public String getLoginLabelText() {
        return getLoginLabel().getText().trim();
    }
    
    public String getPasswordLabelText() {
        return getPasswordLabel().getText().trim();
    }
    
    public String getConfirmPasswordLabelText() {
        return getConfirmPassword().getText().trim();
    }
    
}
