package com.softserve.edu.registrator.pages.user;


import org.openqa.selenium.WebElement;

import com.softserve.edu.registrator.controls.ITable;
import com.softserve.edu.registrator.controls.Table;
import com.softserve.edu.registrator.pages.common.AdminHomePage;
import com.softserve.edu.registrator.tools.search.Search;

public abstract class RegisteredUsersPage extends AdminHomePage {

    // - - - - - - - - - - - - - - - - - - - - - - - - - - - - - -

    private static final String LOGIN_HEADER_CSSSELECTOR = "th[class*='login sorting']";
    private static final String ACTION_HEADER_CSSSELECTOR = ".sorting_disabled:not(.status)";

    // Fields

    private WebElement actionsButton;
    private ITable table;

    public RegisteredUsersPage() {
        super();
        this.actionsButton = Search.id("dLabel");
        //this.table = new Table(driver.findElement(By.tagName("table"));
        this.table = new Table(Search.tagName("table"));
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

    public ITable getTable(){
        return this.table;
    }

    public ITable getRefTable(){
        return new Table(Search.tagName("table"));
    }

    // set Data

    public void clickActionsButton() {
        clickLoginAccount();
        getActionsButton().click();
    }

    // set inner Data

    // Business Logic

    public PassiveEditUserPage gotoEditUserByLogin(String login) {
        String loginHeaderName = Search.cssSelector(LOGIN_HEADER_CSSSELECTOR, table.getTableWebElement()).getText().trim();
        int columnLoginIndex = table.getColumnIndexByValueOfHeader(loginHeaderName);
        int rowIndex = table.getRowIndexByValueInColumn(login, columnLoginIndex);
        //
        String actionHeaderName = Search.cssSelector(ACTION_HEADER_CSSSELECTOR, table.getTableWebElement()).getText().trim();
        
        int columnActionIndex = table.getColumnIndexByValueOfHeader(actionHeaderName);
        
        Search.tagName("button", table.getCell(rowIndex, columnActionIndex)).click();
        return new PassiveEditUserPage();
     }
    
}
