package com.softserve.edu.registrator.tools.search;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public abstract class ASearch implements ISearch {

	protected abstract  WebElement getWebElement(By by);
	
	protected abstract WebElement getWebElement(By by, WebElement fromWebElement);
	
	protected abstract List<WebElement> getWebElements(By by);
	
	protected abstract List<WebElement> getWebElements(By by, WebElement fromWebElement);
	
	@Override
	public abstract boolean stalenessOf(WebElement webElement);

    // Search Element
	
	@Override
	public WebElement id(String id) {
		return getWebElement(By.id(id));
	}

	@Override
	public WebElement name(String name) {
		return getWebElement(By.name(name));
	}

	@Override
	public WebElement xpath(String xpath) {
		 return getWebElement(By.xpath(xpath));
	}

	@Override
	public WebElement cssSelector(String cssSelector) {
		return getWebElement(By.cssSelector(cssSelector));
	}

	@Override
	public WebElement className(String className) {
		return getWebElement(By.className(className));
	}

	@Override
	public WebElement partialLinkText(String partialLinkText) {
		return getWebElement(By.partialLinkText(partialLinkText));
	}

	@Override
	public WebElement linkText(String linkText) {
		return getWebElement(By.linkText(linkText));
	}

	@Override
	public WebElement tagName(String tagName) {
		return getWebElement(By.tagName(tagName));
	}

	// Search From Element
	
	@Override
	public WebElement id(String id, WebElement fromWebElement) {
		return getWebElement(By.id(id), fromWebElement);
	}

	@Override
	public WebElement name(String name, WebElement fromWebElement) {
		return getWebElement(By.name(name), fromWebElement);
	}

	@Override
	public WebElement xpath(String xpath, WebElement fromWebElement) {
		return getWebElement(By.xpath(xpath), fromWebElement);
	}

	@Override
	public WebElement cssSelector(String cssSelector, WebElement fromWebElement) {
		return getWebElement(By.cssSelector(cssSelector), fromWebElement);
	}

	@Override
	public WebElement className(String className, WebElement fromWebElement) {
		return getWebElement(By.className(className), fromWebElement);
	}

	@Override
	public WebElement partialLinkText(String partialLinkText, WebElement fromWebElement) {
		return getWebElement(By.partialLinkText(partialLinkText), fromWebElement);
	}

	@Override
	public WebElement linkText(String linkText, WebElement fromWebElement) {
		return getWebElement(By.linkText(linkText), fromWebElement);
	}

	@Override
	public WebElement tagName(String tagName, WebElement fromWebElement) {
		return getWebElement(By.tagName(tagName), fromWebElement);
	}

	// Get List 
	
	@Override
	public List<WebElement> names(String name) {
		return getWebElements(By.name(name));
	}

	@Override
	public List<WebElement> xpaths(String xpath) {
		return getWebElements(By.xpath(xpath));
	}
	
	@Override
	public List<WebElement> xpaths(String xpath, WebElement fromWebElement) {
		return getWebElements(By.xpath(xpath), fromWebElement);
	}

	@Override
	public List<WebElement> cssSelectors(String cssSelector) {
		return getWebElements(By.cssSelector(cssSelector));
	}

	@Override
	public List<WebElement> classNames(String className) {
		return getWebElements(By.className(className));
	}

	@Override
	public List<WebElement> partialLinkTexts(String partialLinkText) {
		return getWebElements(By.partialLinkText(partialLinkText));
	}

	@Override
	public List<WebElement> linkTexts(String linkText) {
		return getWebElements(By.linkText(linkText));
	}

	@Override
	public List<WebElement> tagNames(String tagName) {
		return getWebElements(By.tagName(tagName));
	}

}
