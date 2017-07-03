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
public class SearchExplicitPresent implements ISearch {
    private WebDriverWait wait;

    public SearchExplicitPresent() {
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
     * Method to explicitly wait for presence of specific element.
     * @param by
     *            locator for element.
     * @return present webelement.
     */
    private WebElement getPresentWebElement(By by) {
        return getWait().until(ExpectedConditions
                .presenceOfElementLocated(by));
    }

    private WebElement getPresentWebElement(By by, WebElement fromWebElement) {
        return getWait().until(ExpectedConditions
                .presenceOfNestedElementLocatedBy(fromWebElement, by));
    }

    /**
     * Method to explicitly wait for presence of specific elements.
     * @param by locator for elements.
     * @return present webelements.
     */
    private List<WebElement> getPresentWebElements(By by) {
        return getWait().until(ExpectedConditions
                .presenceOfAllElementsLocatedBy(by));
    }

    private List<WebElement> getPresentWebElements(By by, WebElement fromWebElement) {
        // TODO Use presenceOfNestedElementLocatedBy Method
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
        return getPresentWebElement(By.id(id));
    }

    @Override
    public WebElement name(String name) {
        return getPresentWebElement(By.name(name));
    }

    @Override
    public WebElement xpath(String xpath) {
        return getPresentWebElement(By.xpath(xpath));
    }

    @Override
    public WebElement cssSelector(String cssSelector) {
        return getPresentWebElement(By.cssSelector(cssSelector));
    }

    @Override
    public WebElement className(String className) {
        return getPresentWebElement(By.className(className));
    }

    @Override
    public WebElement partialLinkText(String partialLinkText) {
        return getPresentWebElement(By.partialLinkText(partialLinkText));
    }

    @Override
    public WebElement linkText(String linkText) {
        return getPresentWebElement(By.linkText(linkText));
    }

    @Override
    public WebElement tagName(String tagName) {
        return getPresentWebElement(By.tagName(tagName));
    }

    // Search From Element

    @Override
    public WebElement id(String id, WebElement fromWebElement) {
        return getPresentWebElement(By.id(id), fromWebElement);
    }

    @Override
    public WebElement name(String name, WebElement fromWebElement) {
        return getPresentWebElement(By.name(name), fromWebElement);
    }

    @Override
    public WebElement xpath(String xpath, WebElement fromWebElement) {
        return getPresentWebElement(By.xpath(xpath), fromWebElement);
    }

    @Override
    public WebElement cssSelector(String cssSelector, WebElement fromWebElement) {
        return getPresentWebElement(By.cssSelector(cssSelector), fromWebElement);
    }

    @Override
    public WebElement className(String className, WebElement fromWebElement) {
        return getPresentWebElement(By.className(className), fromWebElement);
    }

    @Override
    public WebElement partialLinkText(String partialLinkText, WebElement fromWebElement) {
        return getPresentWebElement(By.partialLinkText(partialLinkText), fromWebElement);
    }

    @Override
    public WebElement linkText(String linkText, WebElement fromWebElement) {
        return getPresentWebElement(By.linkText(linkText), fromWebElement);
    }

    @Override
    public WebElement tagName(String tagName, WebElement fromWebElement) {
        return getPresentWebElement(By.tagName(tagName), fromWebElement);
    }

    // Get List

    @Override
    public List<WebElement> names(String name) {
        return getPresentWebElements(By.name(name));
    }

    @Override
    public List<WebElement> xpaths(String xpath) {
        return getPresentWebElements(By.xpath(xpath));
    }

    @Override
    public List<WebElement> xpaths(String xpath, WebElement fromWebElement) {
        return getPresentWebElements(By.xpath(xpath), fromWebElement);
    }

    @Override
    public List<WebElement> cssSelectors(String cssSelector) {
        return getPresentWebElements(By.cssSelector(cssSelector));
    }

    @Override
    public List<WebElement> classNames(String className) {
        return getPresentWebElements(By.className(className));
    }

    @Override
    public List<WebElement> partialLinkTexts(String partialLinkText) {
        return getPresentWebElements(By.partialLinkText(partialLinkText));
    }

    @Override
    public List<WebElement> linkTexts(String linkText) {
        return getPresentWebElements(By.linkText(linkText));
    }

    @Override
    public List<WebElement> tagNames(String tagName) {
        return getPresentWebElements(By.tagName(tagName));
    }
}
