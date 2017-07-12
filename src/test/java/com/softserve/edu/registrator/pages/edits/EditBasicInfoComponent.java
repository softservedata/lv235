package com.softserve.edu.registrator.pages.edits;

import java.util.HashMap;
import java.util.List;

import com.softserve.edu.registrator.data.users.IUser;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import com.softserve.edu.registrator.pages.common.ATopComponent.ChangeLanguageFields;
import com.softserve.edu.registrator.tools.search.Search;

/**
 * Created by User on 6/20/2017.
 */
public class EditBasicInfoComponent {

    public static enum EditBasicL10n {
        MAIN_BASIC_LABEL_XPATH("Основна інформація", "Основная информация", "Basic information"),
        FIRST_NAME_LABEL("Ім'я*", "Имя*", "First name*"),
        SECOND_NAME_LABEL("Прізвище* ", "Фамилия* ", "Second name* "),
        MIDDLE_NAME_LABEL("По-батькові", "Отчество", "Middle name"),
        LOGIN_NAME_LABEL("Логін", "Логин", "Login"),
        EMAIL_LABEL("Електронна пошта*", "Электронная почта* ", "E-mail* "),
        ROLE_LABEL("Роль", "Роль", "Role"),
        STATUS_LABEL("Статус", "Статус", "Status");

        private HashMap<ChangeLanguageFields, String> fieldsStringHashMap;

        private EditBasicL10n(String... localization) {
            this.fieldsStringHashMap = new HashMap<ChangeLanguageFields, String>();
            int i = 0;
            for (ChangeLanguageFields language : ChangeLanguageFields.values()) {
                this.fieldsStringHashMap.put(language, localization[i]);
                i++;
            }
        }

        public String getLocalization(ChangeLanguageFields languageFields) {
            return this.fieldsStringHashMap.get(languageFields).trim();
        }
    }

    public static final String FIRST_NAME_LABEL = "//input [@id='firstName']/../..//label";
    public static final String SECOND_NAME_LABEL = "//input [@id='lastname']/../..//label";
    public static final String MIDDLE_NAME_LABEL = "//input [@id='middlename']/../..//label";
    public static final String LOGIN_NAME_LABEL = "//input [@id='login']/../..//label";
    public static final String EMAIL_LABEL = "//input [@id='email']/../..//label";
    public static final String ROLE_LABEL = "//select [@id='roleId']/../..//label";
    public static final String STATUS_LABEL = "//select [@id='userStatusId']/../..//label";
    public static final String MAIN_BASIC_LABEL_XPATH = "//input[@id='firstName']/../../..//legend";

    public static final String FIRST_NAME_ID = "firstName";
    public static final String SECOND_NAME_ID = "lastname";
    public static final String MIDDLE_NAME_ID = "middlename";
    public static final String LOGIN_ID = "login";
    public static final String EMAIL_ID = "email";
    public static final String ROLE_ID = "roleId";
    public static final String STATUS_ID = "userStatusId";
    public static final String ACTIVE_USER_XPATH = "//option[@value='ACTIVE']";
    public static final String BLOCK_USER_XPATH = "//option[@value='BLOCK']";
    public static final String ADMIN_ROLE_XPATH = "//option[@value='ADMIN']";
    public static final String USER_ROLE_XPATH = "//option[@value='USER']";
    public static final String COMMISSIONER_ROLE_XPATH = "//option[@value='COMMISSIONER']";
    public static final String REGISTRATOR_ROLE_XPATH = "//option[@value='REGISTRATOR']";
    //For functional search by VALUE
    public static final String VALUE = "value";

    private WebElement firstNameLabel;
    private WebElement secondNameLabel;
    private WebElement middleNameLabel;
    private WebElement loginLabel;
    private WebElement emailLabel;
    private WebElement roleLabel;
    private WebElement statusLabel;
    private WebElement basicLabel;

    private WebElement fistNameField;
    private WebElement secondNameField;
    private WebElement middleNameField;
    private WebElement loginField;
    private WebElement emailField;
    private WebElement roleField;
    private WebElement statusField;
    private WebElement activeUser;
    private WebElement blockUser;
    private WebElement adminRole;
    private WebElement registratorRole;
    private WebElement userRole;
    private WebElement commissionerRole;
    private List<WebElement> roles;
    private Select select;
    
    public EditBasicInfoComponent() {
        //labels
        this.registratorRole = Search.xpath(REGISTRATOR_ROLE_XPATH);
        this.commissionerRole = Search.xpath(COMMISSIONER_ROLE_XPATH);
        this.userRole = Search.xpath(USER_ROLE_XPATH);
        this.adminRole = Search.xpath(ADMIN_ROLE_XPATH);
        this.firstNameLabel = Search.xpath(FIRST_NAME_LABEL);
        this.secondNameLabel = Search.xpath(SECOND_NAME_LABEL);
        this.middleNameLabel = Search.xpath(MIDDLE_NAME_LABEL);
        this.loginLabel = Search.xpath(LOGIN_NAME_LABEL);
        this.emailLabel = Search.xpath(EMAIL_LABEL);
        this.roleLabel = Search.xpath(ROLE_LABEL);
        this.statusLabel = Search.xpath(STATUS_LABEL);
        this.basicLabel = Search.xpath(MAIN_BASIC_LABEL_XPATH);
        //fields
        this.blockUser = Search.xpath(BLOCK_USER_XPATH);
        this.activeUser = Search.xpath(ACTIVE_USER_XPATH);
        this.fistNameField = Search.id(FIRST_NAME_ID);
        this.secondNameField = Search.id(SECOND_NAME_ID);
        this.middleNameField = Search.id(MIDDLE_NAME_ID);
        this.loginField = Search.id(LOGIN_ID);
        this.emailField = Search.id(EMAIL_ID);
        this.roleField = Search.id(ROLE_ID);
        this.roles = Search.xpaths("//*[@id='roleId']/option");
        this.select = new Select(getRoleField());
        this.statusField = Search.id(STATUS_ID);
    }
    
    // get Label

    public WebElement getBasicLabel() {
        return this.basicLabel;
    }

    public WebElement getFirstNameLabel() {
        return this.firstNameLabel; }

    public WebElement getSecondNameLabel() {
        return this.secondNameLabel;
    }

    public WebElement getMiddleNameLabel() {
        return this.middleNameLabel;
    }

    public WebElement getLoginLabel() {
        return this.loginLabel;
    }

    public WebElement getEmailLabel() {
        return this.emailLabel;
    }

    public WebElement getRoleLabel() {
        return this.roleLabel;
    }

    public WebElement getStatusLabel() {
        return this.statusLabel;
    }

    //fields
    public WebElement getRegistratorRole(){
        return this.registratorRole;
    }
    public WebElement getAdminRole(){
        return this.adminRole;
    }
    public WebElement getUserRole(){
        return this.userRole;
    }
    public WebElement getCommissionerRole(){
        return this.commissionerRole;
    }

    //get methods
    public WebElement getBlockUser() {
        return this.blockUser;
    }

    public WebElement getActiveUser() {
        return this.activeUser;
    }

    public WebElement getFistNameField() {
        return this.fistNameField;
    }

    public WebElement getSecondNameField() {
        return this.secondNameField;
    }

    public WebElement getMiddleNameField() {
        return this.middleNameField;
    }

    public WebElement getLoginField() {
        return this.loginField;
    }

    public WebElement getEmailField() {
        return this.emailField;
    }

    public WebElement getRoleField() {
        return this.roleField;
    }

    public List<WebElement> getRoles() {
        return this.roles;
    }
    
    public WebElement getStatusField() {
        return this.statusField;
    }

    //Functional for labels
    public String getMainBasicLabelText() {
        return getBasicLabel().getText().trim();
    }

    public String getFirstNameText() {
        return getFirstNameLabel().getText().trim();
    }

    public String getSecondNameText() {
        return getSecondNameLabel().getText().trim();
    }

    public String getMiddleNameText() {
        return getMiddleNameLabel().getText().trim();
    }

    public String getLoginNameLabelText() {
        return getLoginLabel().getText().trim();
    }

    public String getEmailLabelText() {
        return getEmailLabel().getText().trim();
    }

    public String getRoleLabelText() {
        return getRoleLabel().getText().trim();
    }

    public String getStatusLabelText() {
        return getStatusLabel().getText().trim();
    }

    //Functional for values
     public String getFirstNameValueText(){
       return  getFistNameField().getAttribute(VALUE);
     }
    public String getSecondNameValueText(){
        return  getSecondNameField().getAttribute(VALUE);
    }
    public String getEmailValueText(){
        return getEmailField().getAttribute(VALUE);
    }

    //Functional for fields
    public void setFirstNameValue(String firstName) {
        getFistNameField().clear();
        getFistNameField().sendKeys(firstName);
    }

    public void setSecondNameValue(String lastName) {
        getSecondNameField().clear();
        getSecondNameField().sendKeys(lastName);
    }

    public void setMiddleNameValue(String middleName) {
        getMiddleNameField().clear();
        getMiddleNameField().sendKeys();
    }

    public void setLoginValue(String login) {
        getLoginField().clear();
        getLoginField().sendKeys(login);
    }

    public void setEmailValue(String email) {
        getEmailField().clear();
        getEmailField().sendKeys(email);
    }

    public void setRoleValue(String role) {
        getRoleField().click();
        for (WebElement we : getRoles()) {
            if (we.getText().trim().equals(role)) {
                select.selectByVisibleText(role);
                break;
            }
        }
    }

    public void setStatusValue() {
        getStatusField().click();
    }

    public void setActiveUser() {
        getActiveUser().click();
    }

    public void setBlockUser() {
        getStatusField().click();
        getBlockUser().click();
        getStatusField().click();
    }
    //******************************************
    public String getNameFieldValue(IUser testName) {
        return testName.getPerson().getFirstname();
    }
    public String getLastNameFieldValue(IUser testLastName) {
        return testLastName.getPerson().getLastname();
    }
    public String getEmailFieldValue(IUser testEmail) {
        return testEmail.getPerson().getEmail();
    }

}
