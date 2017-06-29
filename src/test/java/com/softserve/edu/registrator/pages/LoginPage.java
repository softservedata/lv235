package com.softserve.edu.registrator.pages;

import java.util.HashMap;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.softserve.edu.registrator.data.users.IUser;
import com.softserve.edu.registrator.pages.commissioner.CommissionerHomePage;
import com.softserve.edu.volodya.RegistratorHomePage;

public class LoginPage extends ATopComponent {

	public static enum LoginPageL10n {
		LOGIN_LABEL("Логін", "Логин", "Login"), PASSWORD_LABEL("Пароль",
				"Пароль", "Password"), SUBMIT_BUTTON("Увійти", "Войти",
				"Sign in");

		private HashMap<ChangeLanguageFields, String> field;

		private LoginPageL10n(String... localization) {
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

	// public static final Logger logger =
	// LoggerFactory.getLogger(LoginPage.class);
	public static final String NAME_IMAGE = "ukraine_logo2.gif";
	//
	private static final String LOGIN_LABEL_XPATH = "//label[contains(@for,'inputEmail')]";
	private static final String LOGIN_INPUT_ID = "login";
	private static final String PASSWORD_LABEL_XPATH = "//label[contains(@for,'inputPassword')]";
	private static final String PASSWORD_INPUT_ID = "password";
	private static final String SIGNIN_CSSSELECTOR = "button.btn.btn-primary";
	private static final String LOGO_CSSSELECTOR = "img.login_logo.col-md-8.col-xs-12";
	private static final String REGISTER_CSSSELECTOR = ".btn.btn-success";

	// Fields

	// private WebDriver driver;
	//
	private WebElement loginLabel;
	private WebElement loginInput;
	private WebElement passwordLabel;
	private WebElement passwordInput;
	private WebElement signin;
	private WebElement logo;

	public LoginPage(WebDriver driver) {
		super(driver);
		// this.driver = driver;
		//
		// this.loginLabel =
		// Application.get().getBrowser().findElement(By.xpath(LOGIN_LABEL_XPATH));
		this.loginLabel = driver.findElement(By.xpath(LOGIN_LABEL_XPATH));
		this.loginInput = driver.findElement(By.id(LOGIN_INPUT_ID));
		this.passwordLabel = driver.findElement(By.xpath(PASSWORD_LABEL_XPATH));
		this.passwordInput = driver.findElement(By.id(PASSWORD_INPUT_ID));
		this.signin = driver.findElement(By.cssSelector(SIGNIN_CSSSELECTOR));
		this.logo = driver.findElement(By.cssSelector(LOGO_CSSSELECTOR));
	}

	// PageObject

	// get Data

	public WebElement getLoginLabel() {
		return this.loginLabel;
		// return driver.findElement(By.xpath(LOGIN_LABEL_XPATH));
	}

	public WebElement getLoginInput() {
		// logger.debug("Start");
		return this.loginInput;
		// return driver.findElement(By.id(LOGIN_INPUT_ID));
	}

	public WebElement getPasswordLabel() {
		return this.passwordLabel;
		// return driver.findElement(By.xpath(PASSWORD_LABEL_XPATH));
	}

	public WebElement getPasswordInput() {
		// logger.debug("Start");
		return this.passwordInput;
		// return driver.findElement(By.id(PASSWORD_INPUT_ID));
	}

	public WebElement getSignin() {
		// logger.debug("Start");
		return this.signin;
		// return driver.findElement(By.cssSelector(SIGNIN_CSSSELECTOR));
	}

	public WebElement getLogo() {
		return this.logo;
		// return driver.findElement(By.cssSelector(LOGO_CSSSELECTOR));
	}

	public WebElement getRegister() {
		return isRegisterPresent() ? driver.findElement(By
				.cssSelector(REGISTER_CSSSELECTOR)) : null;
	}

	public boolean isRegisterPresent() {
		return !driver.findElements(By.cssSelector(REGISTER_CSSSELECTOR))
				.isEmpty();
	}

	// Functional

	public String getLoginLabelText() {
		return getLoginLabel().getText().trim();
	}

	public String getLoginInputAttributeText(String attribute) {
		return getLoginInput().getAttribute(attribute);
	}

	public String getLoginInputText() {
		return getLoginInputAttributeText(VALUE_ATTRIBUTE);
	}

	public String getPasswordLabelText() {
		return getPasswordLabel().getText().trim();
	}

	public String getPasswordInputAttributeText(String attribute) {
		return getPasswordInput().getAttribute(attribute);
	}

	public String getPasswordInputText() {
		return getPasswordInputAttributeText(VALUE_ATTRIBUTE);
	}

	public String getSignintText() {
		return getSignin().getText().trim();
	}

	public String getLogoAttributeText(String attribute) {
		return getLogo().getAttribute(attribute).trim();
	}

	public String getLogoAttributeSrcText() {
		return getLogoAttributeText(SRC_ATTRIBUTE);
	}

	// set Data

	public void setLoginInput(String login) {
		getLoginInput().sendKeys(login);
	}

	public void setLoginInputClear(String login) {
		clearLoginInput();
		setLoginInput(login);
	}

	public void setPasswordInput(String password) {
		getPasswordInput().sendKeys(password);
	}

	public void setPasswordInputClear(String password) {
		clearPasswordInput();
		setPasswordInput(password);
	}

	public void clearLoginInput() {
		getLoginInput().clear();
	}

	public void clearPasswordInput() {
		getPasswordInput().clear();
	}

	public void clickLogin() {
		getLoginInput().click();
	}

	public void clickPassword() {
		getPasswordInput().click();
	}

	public void clickSignin() {
		getSignin().click();
	}

	public void clickRegister() {
		getRegister().click();
	}

	// Business Logic

	public LoginPage changeLanguage(ChangeLanguageFields language) {
		setChangeLanguage(language);
		// Return a new page object representing the destination.
		return new LoginPage(driver);
	}

	// TODO(done) Develop User class
	private void setLoginData(IUser user) {
		// private void setLoginData(String login, String password) { // Code
		// Smell
		// logger.debug("Start");
		setLoginInputClear(user.getAccount().getLogin());
		// logger.trace("setLoginInputClear() Done, User Login = " +
		// user.getLogin());
		setPasswordInputClear(user.getAccount().getPassword());
		// logger.trace("setPasswordInputClear() Done, User Password = " +
		// user.getPassword());
		//
		// setLoginInputClear(login);
		// setPasswordInputClear(password);
		clickSignin();
		// logger.trace("clickSignin() Done");
		// logger.debug("Done");
	}

	public CommonPage successLogin(IUser user) {
		// public CommonPage successLogin(String login, String password) { //
		// Code Smell
		setLoginData(user);
		// setLoginData(login, password); // Code Smell
		// Return a new page object representing the destination.
		return new CommonPage(driver);
	}

	public AdminHomePage successAdminLogin(IUser admin) {
		// public AdminHomePage successAdminLogin(String login, String password)
		// { // Code Smell
		setLoginData(admin);
		// setLoginData(login, password); // Code Smell
		// Return a new page object representing the destination.
		return new AdminHomePage(driver);
	}

	public RegistratorHomePage successRegistratorLogin(IUser registrator) {
		setLoginData(registrator);
		return new RegistratorHomePage(driver);
	}

	public CommissionerHomePage successCommissionerLogin(IUser commissioner) {
		setLoginData(commissioner);
		return new CommissionerHomePage(driver);
	}
	// public RegistratorHomePage successRegistratorLogin(IUser registrator) {
	// setLoginData(registrator);
	// // Return a new page object representing the destination.
	// return new RegistratorHomePage();
	// }
	//
	// TODO Develop User class
	// public LoginValidatorPage unsuccessfulLogin(IUser invalidUser) {
	// //public LoginValidatorPage unsuccessfulLogin(String login, String
	// password) {
	// setLoginData(invalidUser);
	// //setLoginData(login, password);
	// return new LoginValidatorPage(driver); // return this;
	// }

}
