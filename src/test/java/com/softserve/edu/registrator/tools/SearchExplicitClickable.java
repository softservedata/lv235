package com.softserve.edu.registrator.tools;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.softserve.edu.registrator.pages.Application;

public class SearchExplicitClickable implements ISearch {
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
    private WebElement getClickableWebElement(By by) {
        return getWait().until(ExpectedConditions
                .elementToBeClickable(by));
    }

    private WebElement getClickableWebElement(By by, WebElement fromWebElement) {
        // TODO Use elementToBeClickable for Next Version
        return getWait().until(ExpectedConditions
                .visibilityOfNestedElementsLocatedBy(fromWebElement, by)).get(0);
    }

    private List<WebElement> getClickableWebElements(By by) {
        // TODO Use elementToBeClickable for Next Version
        return getWait().until(ExpectedConditions
                .visibilityOfAllElementsLocatedBy(by));
    }

    private List<WebElement> getClickableWebElements(By by, WebElement fromWebElement) {
        // TODO Use elementToBeClickable for Next Version
        return getWait().until(ExpectedConditions
                .visibilityOfNestedElementsLocatedBy(fromWebElement, by));
    }

    public boolean stalenessOf(WebElement webElement) {
        // TODO Use elementToBeClickable for Next Version
        return getWait().until(ExpectedConditions
                .stalenessOf(webElement));
    }

    // Search Element

    /*
    Methods, used by Search entity.
     */
    @Override
    public WebElement id(String id) {
        return getClickableWebElement(By.id(id));
    }

    @Override
    public WebElement name(String name) {
        return getClickableWebElement(By.name(name));
    }

    @Override
    public WebElement xpath(String xpath) {
        return getClickableWebElement(By.xpath(xpath));
    }

    @Override
    public WebElement cssSelector(String cssSelector) {
        return getClickableWebElement(By.cssSelector(cssSelector));
    }



    @Override
    public WebElement className(String className) {
        return getClickableWebElement(By.className(className));
    }

    @Override
    public WebElement partialLinkText(String partialLinkText) {
        return getClickableWebElement(By.partialLinkText(partialLinkText));
    }

    @Override
    public WebElement linkText(String linkText) {
        return getClickableWebElement(By.linkText(linkText));
    }

    @Override
    public WebElement tagName(String tagName) {
        return getClickableWebElement(By.tagName(tagName));
    }

    // Search From Element

    //TODO
    @Override
    public WebElement id(String id, WebElement fromWebElement) {
        return getClickableWebElement(By.id(id), fromWebElement);
    }

    @Override
    public WebElement name(String name, WebElement fromWebElement) {
        return getClickableWebElement(By.name(name), fromWebElement);
    }

    @Override
    public WebElement xpath(String xpath, WebElement fromWebElement) {
        return getClickableWebElement(By.xpath(xpath), fromWebElement);
    }

    @Override
    public WebElement cssSelector(String cssSelector, WebElement fromWebElement) {
        return getClickableWebElement(By.cssSelector(cssSelector), fromWebElement);
    }

    @Override
    public WebElement className(String className, WebElement fromWebElement) {
        return getClickableWebElement(By.className(className), fromWebElement);
    }

    @Override
    public WebElement partialLinkText(String partialLinkText, WebElement fromWebElement) {
        return getClickableWebElement(By.partialLinkText(partialLinkText), fromWebElement);
    }

    @Override
    public WebElement linkText(String linkText, WebElement fromWebElement) {
        return getClickableWebElement(By.linkText(linkText), fromWebElement);
    }

    @Override
    public WebElement tagName(String tagName, WebElement fromWebElement) {
        return getClickableWebElement(By.tagName(tagName), fromWebElement);
    }

    // Get List

    @Override
    public List<WebElement> names(String name) {
        return null;
    }

    @Override
    public List<WebElement> xpaths(String xpath) {
        return null;
    }

    @Override
    public List<WebElement> cssSelectors(String cssSelector) {
        return null;
    }

    @Override
    public List<WebElement> classNames(String className) {
        return null;
    }

    @Override
    public List<WebElement> partialLinkTexts(String partialLinkText) {
        return null;
    }

    @Override
     public List<WebElement> linkTexts (String linkText){
        return null;
     }

     @Override
     public List<WebElement> tagNames (String tagName){
         return null;
     }

     @Override
     public List<WebElement> xpaths(String xpath, WebElement fromWebElement) {
         return null;
     }

     //@Override
    // public List<WebElement> tagNames(String tagName, WebElement fromWebElement) {
     //    return null;
     //}

}
