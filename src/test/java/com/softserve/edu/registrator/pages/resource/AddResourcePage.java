package com.softserve.edu.registrator.pages.resource;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.softserve.edu.registrator.pages.common.ACommonComponent;

public class AddResourcePage extends ACommonComponent {

	public AddResourcePage(WebDriver driver) {
		super(driver);
	}
	
	private static int paramNumber = 1;

	public static int getParamNumber() {
		return paramNumber;
	}

	public static void setParamNumber(int paramNumber) {
		AddResourcePage.paramNumber = paramNumber;
	}

	private static final String OWNER_FIELD_ID = "owner_search";
	private static final String OBJECT_NAME_ID = "w-input-search";
	private static final String SUBCLASS_SELECT_ID = "resourcesTypeSelect";
	private static final String PROCURATIONS_ID = "delivery";
	private static final String POINTS_BUTTON_XPATH = "//a[contains(@data-target,'#points')]";
	private static final String POINT_NUMBER_ID = "myparam" + paramNumber;
	private static final String PERIMETER_AREA_XPATH = "//*[@id='calculatedParamsTab']";
	private static final String DISCRETE_VALUE_ID = "discreteValue";
	private static final String DISCRETE_COMMENT_ID = "discreteComment";
	private static final String LINEAR_VALUE_ID = "linearBegin";
	private static final String LINEAR_COMMENT_ID = "linearEnd";
	private static final String MAP_BUTTON_XPATH = "//a[contains(@data-target,'#map')]";
	private static final String ALL_UKRAINE_CHECKBOX_ID = "allUkraine";
	private static final String SAVE_BUTTON_ID = "submitForm";

	
	// Getters
	
	public WebElement getOwnerField() {
		return  driver.findElement(By.id(OWNER_FIELD_ID));
	}

	public WebElement getObjectName() {
		return driver.findElement(By.id(OBJECT_NAME_ID));
	}

	public WebElement getSubclassSelect() {
		return driver.findElement(By.id(SUBCLASS_SELECT_ID));
	}

	public WebElement getProcurations() {
		return driver.findElement(By.id(PROCURATIONS_ID));
	}

	public WebElement getPointsButton() {
		return driver.findElement(By.xpath(POINTS_BUTTON_XPATH));
	}

	public WebElement getPointNumber() {
		return driver.findElement(By.id(POINT_NUMBER_ID));
	}

	public WebElement getPerimeterArea() {
		return driver.findElement(By.xpath(PERIMETER_AREA_XPATH));
	}

	public WebElement getDiscreteValue() {
		return driver.findElement(By.id(DISCRETE_VALUE_ID));
	}

	public WebElement getDiscreteComment() {
		return driver.findElement(By.id(DISCRETE_COMMENT_ID));
	}

	public WebElement getLinearValue() {
		return driver.findElement(By.id(LINEAR_VALUE_ID));
	}

	public WebElement getLinearComment() {
		return driver.findElement(By.id(LINEAR_COMMENT_ID));
	}

	public WebElement getMapButton() {
		return driver.findElement(By.xpath(MAP_BUTTON_XPATH));
	}

	public WebElement getAllUkraineCheckbox() {
		return driver.findElement(By.id(ALL_UKRAINE_CHECKBOX_ID));
	}

	public WebElement getSaveButton() {
		return driver.findElement(By.id(SAVE_BUTTON_ID));
	}
	
	// Clicks
	
	public void clickOwnerField() {
		getOwnerField().click();
	}
	
	public void clickObjectName() {
		getObjectName().click();
	}
	
	public void clickSubclassSelect() {
		getSubclassSelect().click();
	}
	
	public void clickProcurations() {
		getProcurations().click();
	}
	
	public void	clickPointsButton() {
		getPointsButton().click();
	}
	
	public void	clickPerimeterArea() {
		getPerimeterArea().click();
	}
	
	public void	clickDiscreteValue() {
		getDiscreteValue().click();
	}
	
	public void	clickDiscreteComment() {
		getDiscreteComment().click();
	}
	
	public void	clickLinearValue() {
		getLinearValue().click();
	}
	
	public void	clickLinearComment() {
		getLinearComment().click();
	}
	
	public void	clickMapButton() {
		getMapButton().click();
	}
	
	public void	clickAllUkraineCheckbox() {
		getAllUkraineCheckbox().click();
	}
	
	public void	clickSaveButton() {
		getSaveButton().click();
	}
	
	public void clickResourceByName(String name) {
		clickSubclassSelect();
		driver.findElement(By.cssSelector("*[value='"+ name + "']")).click();
	}
	
	// Fills
	
	public void fillOwnerField(String owner) {
		clickOwnerField();
		getOwnerField().sendKeys(owner);
	}
	
	public void fillObjectName(String object) {
		clickObjectName();
		getObjectName().sendKeys(object);
	}
	
	public void fillDiscreteComment(String comment) {
		clickDiscreteComment();
		getDiscreteComment().sendKeys(comment);
	}
	public void fillDiscreteValue(String value) {
		clickDiscreteValue();
		getDiscreteValue().sendKeys(value);
	}
	public void fillLinearValue(String value) {
		clickLinearValue();
		getLinearValue().sendKeys(value);
	}
	public void fillLinearComment(String comment) {
		clickLinearComment();
		getLinearComment().sendKeys(comment);
	}
	
	//
	// Functions
	//
	//
	//
	//
	//
	
	public void fillPoints() {
		driver.findElement(By.id("myparam1")).click();
		driver.findElement(By.id("myparam1")).clear();
		driver.findElement(By.id("myparam1")).sendKeys("1");
		driver.findElement(By.id("myparam2")).click();
		driver.findElement(By.id("myparam2")).clear();
		driver.findElement(By.id("myparam2")).sendKeys("1");
		driver.findElement(By.id("myparam3")).click();
		driver.findElement(By.id("myparam3")).clear();
		driver.findElement(By.id("myparam3")).sendKeys("1.1");
		driver.findElement(By.id("myparam4")).click();
		driver.findElement(By.id("myparam4")).clear();
		driver.findElement(By.id("myparam4")).sendKeys("1");
		driver.findElement(By.id("myparam5")).click();
		driver.findElement(By.id("myparam5")).clear();
		driver.findElement(By.id("myparam5")).sendKeys("1");
		driver.findElement(By.id("myparam6")).click();
		driver.findElement(By.id("myparam6")).clear();
		driver.findElement(By.id("myparam6")).sendKeys("1.1");
		driver.findElement(By.id("btnAddAreaPoint")).click();
		driver.findElement(By.cssSelector("#areaInput2 #myparam1")).click();
		driver.findElement(By.cssSelector("#areaInput2 #myparam1")).clear();
		driver.findElement(By.cssSelector("#areaInput2 #myparam1")).sendKeys("2");
		driver.findElement(By.cssSelector("#areaInput2 #myparam2")).click();
		driver.findElement(By.cssSelector("#areaInput2 #myparam2")).clear();
		driver.findElement(By.cssSelector("#areaInput2 #myparam2")).sendKeys("2");
		driver.findElement(By.cssSelector("#areaInput2 #myparam3")).click();
		driver.findElement(By.cssSelector("#areaInput2 #myparam3")).clear();
		driver.findElement(By.cssSelector("#areaInput2 #myparam3")).sendKeys("2.1");
		driver.findElement(By.cssSelector("#areaInput2 #myparam4")).click();
		driver.findElement(By.cssSelector("#areaInput2 #myparam4")).clear();
		driver.findElement(By.cssSelector("#areaInput2 #myparam4")).sendKeys("2");
		driver.findElement(By.cssSelector("#areaInput2 #myparam5")).click();
		driver.findElement(By.cssSelector("#areaInput2 #myparam5")).clear();
		driver.findElement(By.cssSelector("#areaInput2 #myparam5")).sendKeys("2");
		driver.findElement(By.cssSelector("#areaInput2 #myparam6")).click();
		driver.findElement(By.cssSelector("#areaInput2 #myparam6")).clear();
		driver.findElement(By.cssSelector("#areaInput2 #myparam6")).sendKeys("2.1");
		driver.findElement(By.id("btnAddAreaPoint")).click();
		driver.findElement(By.cssSelector("#areaInput3 #myparam1")).click();
		driver.findElement(By.cssSelector("#areaInput3 #myparam1")).clear();
		driver.findElement(By.cssSelector("#areaInput3 #myparam1")).sendKeys("3");
		driver.findElement(By.cssSelector("#areaInput3 #myparam2")).click();
		driver.findElement(By.cssSelector("#areaInput3 #myparam2")).clear();
		driver.findElement(By.cssSelector("#areaInput3 #myparam2")).sendKeys("3");
		driver.findElement(By.cssSelector("#areaInput3 #myparam3")).click();
		driver.findElement(By.cssSelector("#areaInput3 #myparam3")).clear();
		driver.findElement(By.cssSelector("#areaInput3 #myparam3")).sendKeys("3.1");
		driver.findElement(By.cssSelector("#areaInput3 #myparam4")).click();
		driver.findElement(By.cssSelector("#areaInput3 #myparam4")).clear();
		driver.findElement(By.cssSelector("#areaInput3 #myparam4")).sendKeys("3");
		driver.findElement(By.cssSelector("#areaInput3 #myparam5")).click();
		driver.findElement(By.cssSelector("#areaInput3 #myparam5")).clear();
		driver.findElement(By.cssSelector("#areaInput3 #myparam5")).sendKeys("3");
		driver.findElement(By.cssSelector("#areaInput3 #myparam6")).click();
		driver.findElement(By.cssSelector("#areaInput3 #myparam6")).clear();
		driver.findElement(By.cssSelector("#areaInput3 #myparam6")).sendKeys("3.1");
	}


	
}
