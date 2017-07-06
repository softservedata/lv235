package com.softserve.edu.registrator.pages.user;

import org.openqa.selenium.WebElement;

import com.softserve.edu.registrator.pages.common.AdminHomePage;
import com.softserve.edu.registrator.pages.edits.EditPage;
import com.softserve.edu.registrator.tools.search.Search;

public class PassiveEditUserPage extends AdminHomePage {

    // Fields
    private WebElement emailInput;

    public PassiveEditUserPage() {
        super();
        this.emailInput = Search.id("email");
    }

    // PageObject

    // get Data

    public WebElement getEmailInput() {
        return this.emailInput;
    }

    // Functional

    public String getEmailInputAttributeText(String attribute) {
        return getEmailInput().getAttribute(attribute);
    }

    public String getEmailInputText() {
        return getEmailInputAttributeText(VALUE_ATTRIBUTE);
    }

    public EditPage clickEditPageButton() {
    	Search.id("edit").click();
        return  new EditPage();
    }

    // get inner Data

    // set Data

    // set inner Data

    // Business Logic

}
