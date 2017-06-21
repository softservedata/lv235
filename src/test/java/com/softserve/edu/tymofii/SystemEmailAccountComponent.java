package com.softserve.edu.tymofii;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class SystemEmailAccountComponent {

	private class ErrorMessageAfterCheckButtonApplied {
		private WebElement errorMessage;

		public WebElement getErrorMessage() {
			return errorMessage;
		}

		public void setErrorMessage(WebElement errorMessage) {
			this.errorMessage = errorMessage;
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
	// Checkbox
	private WebElement tlsSecureConnectionCheckbox;
	// Button
	private WebElement checkButton;

	public SystemEmailAccountComponent(WebDriver driver) {
		this.componentLabel = driver.findElement(By
				.cssSelector("form div:nth-child(1) div.panel-heading h3"));
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
		this.emailServerAddressField = driver.findElement(By
				.cssSelector("#smtpHost"));
		this.userNameField = driver
				.findElement(By.cssSelector("#smtpUsername"));
		this.tcpPortField = driver.findElement(By.cssSelector("#smtpPort"));
		this.passwordField = driver
				.findElement(By.cssSelector("#smtpPassword"));
		this.protocolSelect = driver.findElement(By
				.cssSelector("#smtpProtocol"));
		this.tlsSecureConnectionCheckbox = driver.findElement(By
				.cssSelector("#smtpParameters.tlsEnabled1"));
		this.checkButton = driver.findElement(By.cssSelector("#checkSMTP"));
	}

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

	public WebElement getPasswordField() {
		return passwordField;
	}

	public WebElement getProtocolSelect() {
		return protocolSelect;
	}

	public WebElement getTlsSecureConnectionCheckbox() {
		return tlsSecureConnectionCheckbox;
	}

	public WebElement getCheckButton() {
		return checkButton;
	}

	public void setTlsSecureConnectionLabel(WebElement tlsSecureConnectionLabel) {
		this.tlsSecureConnectionLabel = tlsSecureConnectionLabel;
	}

	public void setEmailServerAddressField(WebElement emailServerAddressField) {
		this.emailServerAddressField = emailServerAddressField;
	}

	public void setUserNameField(WebElement userNameField) {
		this.userNameField = userNameField;
	}

	public void setTcpPortField(WebElement tcpPortField) {
		this.tcpPortField = tcpPortField;
	}

	public void setPasswordField(WebElement passwordField) {
		this.passwordField = passwordField;
	}

	public void setProtocolSelect(WebElement protocolSelect) {
		this.protocolSelect = protocolSelect;
	}

	public void setTlsSecureConnectionCheckbox(
			WebElement tlsSecureConnectionCheckbox) {
		this.tlsSecureConnectionCheckbox = tlsSecureConnectionCheckbox;
	}

	public void setCheckButton(WebElement checkButton) {
		this.checkButton = checkButton;
	}

}
