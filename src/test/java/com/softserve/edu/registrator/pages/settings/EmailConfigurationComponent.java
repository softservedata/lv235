package com.softserve.edu.registrator.pages.settings;

import java.util.HashMap;

import org.openqa.selenium.WebElement;

import com.softserve.edu.registrator.pages.common.ATopComponent.ChangeLanguageFields;
import com.softserve.edu.registrator.tools.search.Search;

public class EmailConfigurationComponent {
	// TODO
	// private class ErrorMessageAfterCheckButtonApplied {
	// private WebElement errorMessage;
	//
	// public ErrorMessageAfterCheckButtonApplied(WebElement errorMessage) {
	// this.errorMessage = errorMessage;
	// }
	// }

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
				"Проверить", "Check");

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

	public EmailConfigurationComponent() {
		this.componentLabel = Search.cssSelector("form div:nth-child(1) div.panel-heading h3");
		this.emailServerAddressLabel = Search
				.cssSelector("label[for = 'smtpHost']");
		this.userNameLabel = Search
				.cssSelector("label[for = 'smtpUsername']");
		this.tcpPortLabel = Search
				.cssSelector("label[for = 'smtpPort']");
		this.protocolLabel = Search
				.cssSelector("label[for = 'smtpProtocol']");
		this.passwordLabel = Search
				.cssSelector("label[for = 'smtpPassword']");
		this.tlsSecureConnectionLabel = Search
				.cssSelector("label[for = 'smtpParameters.tlsEnabled1']");
		this.emailServerAddressField = Search.id("smtpHost");
		this.userNameField = Search.id("smtpUsername");
		this.tcpPortField = Search.id("smtpPort");
		this.passwordField = Search.id("smtpPassword");
		this.protocolSelect = Search.id("smtpProtocol");
		this.protocolSelectSMTP = Search
				.cssSelector("#smtpProtocol option[value = 'SMTP']");
		this.protocolSelectSMTPS = Search
				.cssSelector("#smtpProtocol option[value = 'SMTPS']");
		this.tlsSecureConnectionCheckbox = Search
				.id("smtpParameters.tlsEnabled1");
		this.checkButton = Search.id("checkSMTP");
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
}
