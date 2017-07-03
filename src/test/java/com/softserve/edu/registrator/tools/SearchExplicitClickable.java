package com.softserve.edu.registrator.tools;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.softserve.edu.registrator.pages.Application;

public class SearchExplicitClickable extends ASearch {
    private WebDriverWait wait;

    public SearchExplicitClickable() {
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

    private WebDriverWait getWait() {
        return this.wait;
    }

    /**
     * Method to explicitly wait for clickability of
     * specific element.
     *
     * @param by locator for element.
     * @return clickable webelement.
     */
    @Override
    protected WebElement getWebElement(By by) {
        return getWait().until(ExpectedConditions
                .elementToBeClickable(by));
    }

    @Override
    protected WebElement getWebElement(By by, WebElement fromWebElement) {
        // TODO Use elementToBeClickable for Next Version
        return getWait().until(ExpectedConditions
                .visibilityOfNestedElementsLocatedBy(fromWebElement, by)).get(0);
    }

    @Override
    protected List<WebElement> getWebElements(By by) {
        // TODO Use elementToBeClickable for Next Version
        return getWait().until(ExpectedConditions
                .visibilityOfAllElementsLocatedBy(by));
    }

    @Override
    protected List<WebElement> getWebElements(By by, WebElement fromWebElement) {
        // TODO Use elementToBeClickable for Next Version
        return getWait().until(ExpectedConditions
                .visibilityOfNestedElementsLocatedBy(fromWebElement, by));
    }

    @Override
    public boolean stalenessOf(WebElement webElement) {
        // TODO Use elementToBeClickable for Next Version
        return getWait().until(ExpectedConditions
                .stalenessOf(webElement));
    }
    
}
