package com.softserve.edu.registrator.pages.communities;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class DeleteCommunityAlert {
	
	
	private CommunityPage communityPage;
	private WebElement alertLabel;
	private WebElement okButton;
	private WebElement cancelButton;
	private WebElement closeButton;
	
	public DeleteCommunityAlert(WebDriver driver, CommunityPage communityPage) {
		this.communityPage = communityPage;
		alertLabel = driver.findElement(By.cssSelector(".bootbox-body"));
		okButton = driver.findElement(By.xpath("//button[@data-bb-handler='confirm']"));
		cancelButton = driver.findElement(By.xpath("//button[@data-bb-handler='cancel']"));
		closeButton = driver.findElement(By.cssSelector(".bootbox-close-button.close"));
	}

	//Getters
	public WebElement getAlertLabel() {
		return this.alertLabel;
	}

	public WebElement getOkButton() {
		return this.okButton;
	}

	public WebElement getCancelButton() {
		return this.cancelButton;
	}

	public WebElement getCloseButton() {
		return this.closeButton;
	}
	
	
	//Functional getters
	public String getAlertLabelText() {
		return getAlertLabel().getText();
	}

	public String getOkButtonText() {
		return getOkButton().getText();
	}

	public String getCancelButtonText() {
		return getCancelButton().getText();
	}
	
	//Setters
	
	public void clickOkButton() {
		getOkButton().click();
	}
	
	public void clickCancelButton() {
		getCancelButton().click();
	}
	
	public void clickCloseButton() {
		getCloseButton().click();
	}
	
	//Business Logic
	
	public CommunityPage ok() {
		clickOkButton();
		return communityPage;
	}
	
	public CommunityPage cancel() {
		clickCancelButton();;
		return communityPage;
	}
	
	public CommunityPage close() {
		clickCloseButton();
		return communityPage;
	}
}
