package com.softserve.edu.registrator.pages.settings;

import java.util.HashMap;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.mysql.jdbc.Driver;
import com.softserve.edu.registrator.pages.Application;
import com.softserve.edu.registrator.pages.ATopComponent.ChangeLanguageFields;

public class EmailConfigurationComponent {

	public static enum EmailConfigurationComponentL10n {
		COMPONENT_LABEL("Налаштування надсилання електронної пошти",
				"Настройки отправки электронной почты", "System email account"), EMAIL_SERVER_ADDRESS_LABEL(
				"Адреса сервера", "Адрес сервера", "Email server address"), USERNAME_LABEL(
				"Ім'я користувача", "Имя пользователя", "User name"), TCP_PORT_LABEL(
				"Порт TCP", "Порт TCP", "TCP port"), PROTOCOL_LABEL("Протокол",
				"Протокол", "Protocol"), PASSWORD_LABEL("Пароль", "Пароль",
				"Password"), TLS_SECURE_CONNECTION_LABEL(
				"Захищене з'єднання TLS", "Защищенное соединение TLS",
				"TLS secure connection"), CHECK_BUTTON("Перевірити",
				"Проверить", "Check"), EMAIL_ALERT(
				"Не вдалось встановити зєднання з сервером. Перевірте вказані параметри.",
				"Не удалось соединиться с сервером. Проверьте параметры подключения.",
				"Couldnt connect to server. Check parameters.");

		private HashMap<ChangeLanguageFields, String> field;

		private EmailConfigurationComponentL10n(String... localization) {
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

	// Labels
	private WebElement componentLabel;
	private WebElement emailServerAddressLabel;
	private WebElement userNameLabel;
	private WebElement tcpPortLabel;
	private WebElement protocolLabel;
	private WebElement passwordLabel;
	private WebElement tlsSecureConnectionLabel;
	// Fields
	private WebElement emailServerAddressField;
	private WebElement userNameField;
	private WebElement tcpPortField;
	private WebElement passwordField;
	// Select
	private WebElement protocolSelect;
	private WebElement protocolSelectSMTP;
	private WebElement protocolSelectSMTPS;
	// Checkbox
	private WebElement tlsSecureConnectionCheckbox;
	// Button
	private WebElement checkButton;

	private static final String EMAIL_ALERT_CSS_SELECTOR = "div.bootbox-body";

	public EmailConfigurationComponent(WebDriver driver) {
		this.componentLabel = driver.findElement(By
				.cssSelector("form div:nth-child(3) div.panel-heading h3"));
		this.emailServerAddressLabel = driver.findElement(By
				.cssSelector("label[for = 'smtpHost']"));
		this.userNameLabel = driver.findElement(By
				.cssSelector("label[for = 'smtpUsername']"));
		this.tcpPortLabel = driver.findElement(By
				.cssSelector("label[for = 'smtpPort']"));
		this.protocolLabel = driver.findElement(By
				.cssSelector("label[for = 'smtpProtocol']"));
		this.passwordLabel = driver.findElement(By
				.cssSelector("label[for = 'smtpPassword']"));
		this.tlsSecureConnectionLabel = driver.findElement(By
				.cssSelector("label[for = 'smtpParameters.tlsEnabled1']"));
		this.emailServerAddressField = driver.findElement(By.id("smtpHost"));
		this.userNameField = driver.findElement(By.id("smtpUsername"));
		this.tcpPortField = driver.findElement(By.id("smtpPort"));
		this.passwordField = driver.findElement(By.id("smtpPassword"));
		this.protocolSelect = driver.findElement(By.id("smtpProtocol"));
		this.protocolSelectSMTP = driver.findElement(By
				.cssSelector("#smtpProtocol option[value = 'SMTP']"));
		this.protocolSelectSMTPS = driver.findElement(By
				.cssSelector("#smtpProtocol option[value = 'SMTPS']"));
		this.tlsSecureConnectionCheckbox = driver.findElement(By
				.id("smtpParameters.tlsEnabled1"));
		this.checkButton = driver.findElement(By.id("checkSMTP"));
	}

	// Getters for labels
	public WebElement getComponentLabel() {
		return componentLabel;
	}

	public WebElement getEmailServerAddressLabel() {
		return emailServerAddressLabel;
	}

	public WebElement getUserNameLabel() {
		return userNameLabel;
	}

	public WebElement getTcpPortLabel() {
		return tcpPortLabel;
	}

	public WebElement getProtocolLabel() {
		return protocolLabel;
	}

	public WebElement getPasswordLabel() {
		return passwordLabel;
	}

	public WebElement getTlsSecureConnectionLabel() {
		return tlsSecureConnectionLabel;
	}

	// Text getters for labels
	public String getComponentLabelText() {
		return getComponentLabel().getText().trim();
	}

	public String getEmailServerAddressLabelText() {
		return getEmailServerAddressLabel().getText().trim();
	}

	public String getUserNameLabelText() {
		return getUserNameLabel().getText().trim();
	}

	public String getTcpPortLabelText() {
		return getTcpPortLabel().getText().trim();
	}

	public String getProtocolLabelText() {
		return getProtocolLabel().getText().trim();
	}

	public String getPasswordLabelText() {
		return getPasswordLabel().getText().trim();
	}

	public String getTlsSecureConnectionLabelText() {
		return getTlsSecureConnectionLabel().getText().trim();
	}

	// Getters and methods with fields
	public WebElement getEmailServerAddressField() {
		return emailServerAddressField;
	}

	public void typeInEmailServerAddressField(String text) {
		getEmailServerAddressField().sendKeys(text);
	}

	public WebElement getUserNameField() {
		return userNameField;
	}

	public void typeInUserNameField(String text) {
		getUserNameField().sendKeys(text);
	}

	public WebElement getTcpPortField() {
		return tcpPortField;
	}

	public void typeInTcpPortField(String text) {
		getTcpPortField().sendKeys(text);
	}

	public WebElement getPasswordField() {
		return passwordField;
	}

	public void typeInPasswordField(String text) {
		getPasswordField().sendKeys(text);
	}

	// Getters and methods for select
	public WebElement getProtocolSelect() {
		return protocolSelect;
	}

	public WebElement getProtocolSelectSMTP() {
		return protocolSelectSMTP;
	}

	public WebElement getProtocolSelectSMTPS() {
		return protocolSelectSMTPS;
	}

	public void selectProtocolSMTP() {
		getProtocolSelectSMTP().click();
	}

	public void selectProtocolSMTPS() {
		getProtocolSelectSMTPS().click();
	}

	public WebElement getTlsSecureConnectionCheckbox() {
		return tlsSecureConnectionCheckbox;
	}

	public WebElement getCheckButton() {
		return checkButton;
	}

	public void clickCheckButton() {
		getCheckButton().click();
	}

	public String getCheckButtonText() {
		return getCheckButton().getText().trim();
	}

	public WebElement getEmailAlert() {
		return isEmailAlertPresent() ? Application.get().getBrowser()
				.findElement(By.cssSelector(EMAIL_ALERT_CSS_SELECTOR)) : null;
	}

	public String getEmailAlertText() {
		return getEmailAlert().getText().trim();
	}

	public boolean isEmailAlertPresent() {
		return !Application.get().getBrowser()
				.findElements(By.cssSelector(EMAIL_ALERT_CSS_SELECTOR))
				.isEmpty();
	}
}
