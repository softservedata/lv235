package com.softserve.edu.registrator.pages.subclass;

import java.util.List;

import org.openqa.selenium.WebElement;

import com.softserve.edu.registrator.data.subclass.ISubclass;
import com.softserve.edu.registrator.pages.common.RegistratorHomePage;
import com.softserve.edu.registrator.tools.search.Search;

public class SubclassPage extends RegistratorHomePage {

	private static final String ADD_SUBCLASS_BUTTON_XPATH = "//a[contains(@href,'/addrestype')]";
	// private ITable tableSubclass;

	/*
	 * Constructor
	 */
	public SubclassPage() {
		super();
		// tableSubclass = new Table(driver.findElement(By.tagName("table")));
	}

	// Get

	public WebElement getAddSubclassButton() {
		return Search.xpath(ADD_SUBCLASS_BUTTON_XPATH);
	}

	public WebElement getOkButton() {
		return Search.cssSelector(".bootbox.modal.fade.bootbox-confirm.in", Search.cssSelector(".btn.btn-primary"));
	}

	// Click

	public AddSubclassPage clickAddSubclassButton() {
		getAddSubclassButton().click();
		return new AddSubclassPage();
	}

	public void clickOkButton() {
		getOkButton().click();
	}

	// Functions

	public void clickDeleteCurrentSubclass(ISubclass subclassName) {
		Search.xpath(
				".//*[@id='datatable']//td[contains(text(),'" + subclassName.getNameSubclass() + "')]/../td[6]/div/a")
				.click();
		;
	}

	public String FindSubclassName(ISubclass subclassName) {
		return Search.xpath(".//*[@id='datatable']//td[contains(.,'" + subclassName.getNameSubclass() + "')]")
				.getText();
	}

	public List<WebElement> CheckSubclassName(ISubclass subclassName) {
		return Search.xpaths(".//*[@id='datatable']//td[contains(text(),'" + subclassName.getNameSubclass() + "')]");
	}

}
