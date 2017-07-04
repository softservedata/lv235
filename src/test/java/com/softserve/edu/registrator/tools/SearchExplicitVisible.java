package com.softserve.edu.registrator.tools;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.softserve.edu.registrator.pages.Application;

/**
 * Class for searching present elements with explicit timeout.
 */
public class SearchExplicitVisible extends ASearch {
	
    private WebDriverWait wait;

    public SearchExplicitVisible() {
        this.wait = new WebDriverWait(Application.get().getBrowser(),
                Application.get().getApplicationSources().getExplicitTimeOut());
        Application.get().getBrowser().manage().timeouts()
            .implicitlyWait(0L, TimeUnit.SECONDS);
        // TODO
        //Application.get().getBrowser().manage().timeouts()
        //    .pageLoadTimeout(0L, TimeUnit.SECONDS);
        //Application.get().getBrowser().manage().timeouts()
        //    .setScriptTimeout(0L, TimeUnit.SECONDS);
    }

    protected WebDriverWait getWait() {
        return this.wait;
    }
    
    /**
     * Method to explicitly wait for visibility of specific element.
     * @param by locator for element.
     * @return present webelement.
     */
    @Override
    protected WebElement getWebElement(By by) {
        // return new WebDriverWait(Application.get().getBrowser(), EXPLICIT_WAIT_TIMEOUT)
        //            .until(ExpectedConditions.visibilityOfElementLocated(by));
        return getWait().until(ExpectedConditions
                .visibilityOfElementLocated(by));
    }

    @Override
    protected WebElement getWebElement(By by, WebElement fromWebElement) {
        return getWait().until(ExpectedConditions
                .visibilityOfNestedElementsLocatedBy(fromWebElement, by)).get(0);
    }

    /**
     * Method to explicitly wait for visibility of specific elements.
     * @param by locator for elements.
     * @return present webelements.
     */
    @Override
    protected List<WebElement> getWebElements(By by) {
        return getWait().until(ExpectedConditions
                .visibilityOfAllElementsLocatedBy(by));
    }
    
    @Override
    protected List<WebElement> getWebElements(By by, WebElement fromWebElement) {
        return getWait().until(ExpectedConditions
                .visibilityOfNestedElementsLocatedBy(fromWebElement, by));
    }

    public boolean stalenessOf(WebElement webElement) {
        return getWait().until(ExpectedConditions
                .stalenessOf(webElement));
    }
}
