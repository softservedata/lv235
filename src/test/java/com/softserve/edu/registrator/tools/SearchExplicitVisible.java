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
public class SearchExplicitVisible implements ISearch {
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

    private WebDriverWait getWait() {
        return this.wait;
    }
    
    /**
     * Method to explicitly wait for visibility of specific element.
     * @param by locator for element.
     * @return present webelement.
     */
    private WebElement getVisibleWebElement(By by) {
        // return new WebDriverWait(Application.get().getBrowser(), EXPLICIT_WAIT_TIMEOUT)
        //            .until(ExpectedConditions.visibilityOfElementLocated(by));
        return getWait().until(ExpectedConditions
                .visibilityOfElementLocated(by));
    }

    private WebElement getVisibleWebElement(By by, WebElement fromWebElement) {
        return getWait().until(ExpectedConditions
                .visibilityOfNestedElementsLocatedBy(fromWebElement, by)).get(0);
    }

    /**
     * Method to explicitly wait for visibility of specific elements.
     * @param by locator for elements.
     * @return present webelements.
     */
    private List<WebElement> getVisibleWebElements(By by) {
        return getWait().until(ExpectedConditions
                .visibilityOfAllElementsLocatedBy(by));
    }

    private List<WebElement> getVisibleWebElements(By by, WebElement fromWebElement) {
        return getWait().until(ExpectedConditions
                .visibilityOfNestedElementsLocatedBy(fromWebElement, by));
    }

    public boolean stalenessOf(WebElement webElement) {
        return getWait().until(ExpectedConditions
                .stalenessOf(webElement));
    }

    // Search Element

    /*
     * Methods, used by Search entity.
     */
    @Override
    public WebElement id(String id) {
        return getVisibleWebElement(By.id(id));
    }

    @Override
    public WebElement name(String name) {
        return getVisibleWebElement(By.name(name));
    }

    @Override
    public WebElement xpath(String xpath) {
        return getVisibleWebElement(By.xpath(xpath));
    }

    @Override
    public WebElement cssSelector(String cssSelector) {
        return getVisibleWebElement(By.cssSelector(cssSelector));
    }

    @Override
    public WebElement className(String className) {
        return getVisibleWebElement(By.className(className));
    }

    @Override
    public WebElement partialLinkText(String partialLinkText) {
        return getVisibleWebElement(By.partialLinkText(partialLinkText));
    }

    @Override
    public WebElement linkText(String linkText) {
        return getVisibleWebElement(By.linkText(linkText));
    }

    @Override
    public WebElement tagName(String tagName) {
        return getVisibleWebElement(By.tagName(tagName));
    }

    // Search From Element

    @Override
    public WebElement id(String id, WebElement fromWebElement) {
        return getVisibleWebElement(By.id(id), fromWebElement);
    }

    @Override
    public WebElement name(String name, WebElement fromWebElement) {
        return getVisibleWebElement(By.name(name), fromWebElement);
    }

    @Override
    public WebElement xpath(String xpath, WebElement fromWebElement) {
        return getVisibleWebElement(By.xpath(xpath), fromWebElement);
    }

    @Override
    public WebElement cssSelector(String cssSelector, WebElement fromWebElement) {
        return getVisibleWebElement(By.cssSelector(cssSelector), fromWebElement);
    }

    @Override
    public WebElement className(String className, WebElement fromWebElement) {
        return getVisibleWebElement(By.className(className), fromWebElement);
    }

    @Override
    public WebElement partialLinkText(String partialLinkText, WebElement fromWebElement) {
        return getVisibleWebElement(By.partialLinkText(partialLinkText), fromWebElement);
    }

    @Override
    public WebElement linkText(String linkText, WebElement fromWebElement) {
        return getVisibleWebElement(By.linkText(linkText), fromWebElement);
    }

    @Override
    public WebElement tagName(String tagName, WebElement fromWebElement) {
        return getVisibleWebElement(By.tagName(tagName), fromWebElement);
    }

    // Get List

    @Override
    public List<WebElement> names(String name) {
        return getVisibleWebElements(By.name(name));
    }

    @Override
    public List<WebElement> xpaths(String xpath) {
        return getVisibleWebElements(By.xpath(xpath));
    }

    @Override
    public List<WebElement> xpaths(String xpath, WebElement fromWebElement) {
        return getVisibleWebElements(By.xpath(xpath), fromWebElement);
    }

    @Override
    public List<WebElement> cssSelectors(String cssSelector) {
        return getVisibleWebElements(By.cssSelector(cssSelector));
    }

    @Override
    public List<WebElement> classNames(String className) {
        return getVisibleWebElements(By.className(className));
    }

    @Override
    public List<WebElement> partialLinkTexts(String partialLinkText) {
        return getVisibleWebElements(By.partialLinkText(partialLinkText));
    }

    @Override
    public List<WebElement> linkTexts(String linkText) {
        return getVisibleWebElements(By.linkText(linkText));
    }

    @Override
    public List<WebElement> tagNames(String tagName) {
        return getVisibleWebElements(By.tagName(tagName));
    }

}
