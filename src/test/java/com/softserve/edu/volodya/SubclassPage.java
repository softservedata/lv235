package com.softserve.edu.volodya;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class SubclassPage extends RegistratorHomePage {



	private static final String ADD_SUBCLASS_BUTTON_XPATH = "//a[contains(@href,'/addrestype')]";
//	private ITable tableSubclass;
	
	/*
	 * Constructor
	 */
	public SubclassPage(WebDriver driver) {
		super(driver);
	//	tableSubclass = new Table(driver.findElement(By.tagName("table")));
	}
	
	// Get
	
	public WebElement getAddSubclassButton() {
		return driver.findElement(By.xpath(ADD_SUBCLASS_BUTTON_XPATH));
	}
	
	public WebElement getOkButton() {
		return driver.findElement(By.cssSelector(".bootbox.modal.fade.bootbox-confirm.in")).findElement(By.cssSelector(".btn.btn-primary"));
	}
	
	// Click
	
	public AddSubclassPage clickAddSubclassButton() {
		getAddSubclassButton().click();
		return new AddSubclassPage(driver);
	}
	
	public void clickOkButton() {
		getOkButton().click();
	}
	
	// Functions
	
	public void clickDeleteCurrentSubclass (ISubclass subclassName) {
		driver.findElement(By.xpath(".//*[@id='datatable']//td[contains(text(),'"+ subclassName.getNameSubclass() +"')]/../td[6]/div/a")).click();;
	}
	
	public String FindSubclassName(ISubclass subclassName) {
		return driver.findElement(By.xpath(".//*[@id='datatable']//td[contains(.,'"+ subclassName.getNameSubclass() +"')]")).getText();
	}
		
	public List<WebElement> CheckSubclassName(ISubclass subclassName) {
		return driver.findElements(By.xpath(".//*[@id='datatable']//td[contains(.,'"+ subclassName.getNameSubclass() +"')]"));
	}

}