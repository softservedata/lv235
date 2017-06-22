package com.softserve.edu.registrator.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.softserve.edu.registrator.controls.ITable;
import com.softserve.edu.registrator.controls.Table;

public abstract class RegisteredUsersPage extends AdminHomePage {

    // - - - - - - - - - - - - - - - - - - - - - - - - - - - - - -

    private static final String LOGIN_HEADER_CSSSELECTOR = "th[class*='login sorting']";
    private static final String ACTION_HEADER_CSSSELECTOR = ".sorting_disabled:not(.status)";

    // Fields

    private WebElement actionsButton;
    private ITable table;

    public RegisteredUsersPage(WebDriver driver) {
        super(driver);
        this.actionsButton = driver.findElement(By.id("dLabel"));
        //this.table = new Table(driver.findElement(By.tagName("table"));
        this.table = new Table(driver.findElement(By.id("example")));
    }

    // PageObject

    // get Data

    public WebElement getActionsButton() {
        return this.actionsButton;
    }

    // Functional

    public String getActionsButtonText() {
        return getActionsButton().getText().trim();
    }

    // get inner Data

    // set Data

    public void clickActionsButton() {
        clickLoginAccount();
        getActionsButton().click();
    }

    // set inner Data

    // Business Logic

    public PassiveEditUserPage gotoEditUserByLogin(String login) {
        String loginHeaderName = table.getTableWebElement()
                .findElement(By.cssSelector(LOGIN_HEADER_CSSSELECTOR)).getText().trim();
        int columnLoginIndex = table.getColumnIndexByValueOfHeader(loginHeaderName);
        int rowIndex = table.getRowIndexByValueInColumn(login, columnLoginIndex);
        //
        String actionHeaderName = table.getTableWebElement()
                .findElement(By.cssSelector(ACTION_HEADER_CSSSELECTOR)).getText().trim();
        int columnActionIndex = table.getColumnIndexByValueOfHeader(actionHeaderName);
        table.getCell(rowIndex, columnActionIndex)
                .findElement(By.tagName("button")).click();
        return new PassiveEditUserPage(driver);
     }

}
