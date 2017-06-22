package com.softserve.edu.registrator.pages.communities;

import java.util.HashMap;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.softserve.edu.registrator.data.communities.Community;
import com.softserve.edu.registrator.data.communities.ICommunity;
import com.softserve.edu.registrator.pages.AdminHomePage;

public class CommunityPage extends AdminHomePage {

	private class CommunityTableRow {

		private WebElement nameCommunityLable;
		private WebElement registrationNumberLable;
		private WebElement editButton;
		private WebElement deleteButton;

		public CommunityTableRow(ICommunity community) {
			nameCommunityLable = driver.findElement(By.linkText(community
					.getNameCommunity()));
			registrationNumberLable = driver.findElement(By
					.xpath("//a[text()='" + community.getNameCommunity()
							+ "']/../../td[2]"));
			editButton = driver.findElement(By.xpath("//a[text()='"
					+ community.getNameCommunity().trim() + "']/../..//a["
					+ "contains(@href,  'editCommunity')]"));
			deleteButton = driver.findElement(By.xpath("//a[text()='"
					+ community.getNameCommunity().trim() + "']/../..//a["
					+ "contains(@href,  'deleteCommunity')]"));
		}

		public CommunityTableRow(int index) {
			nameCommunityLable = driver.findElement(By
					.xpath("//tr[@class = 'commun'][" + index
							+ "]//a[contains(@href,  '#')]"));
			registrationNumberLable = driver.findElement(By
					.xpath("//tr[@class = 'commun'][" + index + "]//td[2]"));
			editButton = driver.findElement(By.xpath("//tr[@class = 'commun']["
					+ index + "]//a[contains(@href,  'editCommunity')]"));
			deleteButton = driver.findElement(By
					.xpath("//tr[@class = 'commun'][" + index
							+ "]//a[contains(@href,  'deleteCommunity')]"));
		}

		public WebElement getNameCommunityLable() {
			return this.nameCommunityLable;
		}

		public WebElement getRegistrationNumberLable() {
			return this.registrationNumberLable;
		}

		public WebElement getEditButton() {
			return this.editButton;
		}

		public WebElement getDeleteButton() {
			return this.deleteButton;
		}

		// Functional getters

		public String getNameCommunityLableText() {
			return getNameCommunityLable().getText();
		}

		public String getRegistrationNumberLableText() {
			return getRegistrationNumberLable().getText();
		}

		public String getEditButtonText() {
			return getEditButton().getText();
		}

		public String getDeleteButtonText() {
			return getDeleteButton().getText();
		}

		// Setters

		public void clickEditButton() {
			getEditButton().click();
		}

		public void clickDeleteButton() {
			getDeleteButton().click();
		}
	}

	public static enum CommunityPageL10n {
		COMMUNITY_LABEL("Громади", "Общины", "Communities"), ADD_COMMUNITY_BUTTON(
				"Додати нову територіальну громаду", "Добавить новую общину",
				"Add new territorial community"), SHOW_NONE_ACTIVE_CBOX(
				"Показати неактивні", "Показать неактивные", "Show inactive"), TERETORIAL_COMMUNITY_COLUMN_NAME(
				"Територіальна громада", "Территоральная община",
				"Territorial community"), REGISTRATION_NUMBER_COLUMN_NAME(
				"Реєстраційний номер", "Регистрационный номер",
				"Registration number"), ACTIONS_COMMUNITY_COLUMN_NAME("Дії",
				"Действия", "Actions"), EDIT_BUTTON("Редагувати", "Изменить ",
				"Edit"), DELETE_BUTTON("Видалити ", "Удалить", "Delete");

		private HashMap<ChangeLanguageFields, String> field;

		private CommunityPageL10n(String... localization) {
			this.field = new HashMap<ChangeLanguageFields, String>();
			int i = 0;
			for (ChangeLanguageFields language : ChangeLanguageFields.values()) {
				this.field.put(language, localization[i]);
				i++;
			}
		}

		public String getLocalization(ChangeLanguageFields language) {
			return this.field.get(language).trim();
		}
	}

	private WebElement communityLable;
	private WebElement addNewCommunityButton;
	private WebElement showNoneActiveCBox;
	private WebElement teretorialCommunity;
	private WebElement registrationNumber;
	private WebElement actions;

	public CommunityPage(WebDriver driver) {
		super(driver);
		communityLable = driver.findElement(By.cssSelector("h4"));
		addNewCommunityButton = driver.findElement(By
				.cssSelector("a[href= 'addCommunity']"));
		showNoneActiveCBox = driver.findElement(By.cssSelector("label"));
		teretorialCommunity = driver.findElement(By.xpath("//tr/th[1]"));
		registrationNumber = driver.findElement(By.xpath("//tr/th[2]"));
		actions = driver.findElement(By.xpath("//tr/th[3]"));
	}

	public WebElement getCommunityLable() {
		return this.communityLable;
	}

	public WebElement getAddNewCommunityButton() {
		return this.addNewCommunityButton;
	}

	public WebElement getShowNoneActiveCBox() {
		return this.showNoneActiveCBox;
	}

	public WebElement getTeretorialCommunity() {
		return this.teretorialCommunity;
	}

	public WebElement getRegistrationNumber() {
		return this.registrationNumber;
	}

	public WebElement getActions() {
		return this.actions;
	}

	// Functional getters
	public String getLabelCommunityText() {
		return getCommunityLable().getText().trim();
	}

	public String getButtonAddNewCommunityText() {
		return getAddNewCommunityButton().getText().trim();
	}

	public String getActionsText() {
		return getShowNoneActiveCBox().getText().trim();
	}

	public String getTeretorialCommunityText() {
		return getTeretorialCommunity().getText().trim();
	}

	public String getRegistrationNumberText() {
		return getRegistrationNumber().getText().trim();
	}

	public String getCBoxShowNoneActiveText() {
		return getShowNoneActiveCBox().getText().trim();
	}

	public String getCommunityNameText(Community community) {
		return new CommunityTableRow(community).getNameCommunityLableText();
	}

	public String getRegistrationNumberText(Community community) {
		return new CommunityTableRow(community)
				.getRegistrationNumberLableText();
	}

	public String getEditButtonText() {
		return new CommunityTableRow(1).getEditButtonText();
	}

	public String getDeleteButtonText() {
		return new CommunityTableRow(1).getDeleteButtonText();
	}

	// Setters

	public void clickCBoxShowNoneActive() {
		getShowNoneActiveCBox().click();
	}

	public void clickButtonAddNewCommunity() {
		getAddNewCommunityButton().click();
	}

	public void clickEditButton(Community community) {
		new CommunityTableRow(community).clickEditButton();
		;
	}

	public void clickDeleteButton(ICommunity community) {
		new CommunityTableRow(community).clickDeleteButton();
	}

	// Business logic

	public CommunityPage checkedCBoxShowNoneActive() {
		getCommunities().click();
		clickCBoxShowNoneActive();
		return new CommunityPage(driver);
	}

	public CommunityPage uncheckedCBoxShowNoneActive() {
		getCommunities().click();
		clickCBoxShowNoneActive();
		clickCBoxShowNoneActive();
		return new CommunityPage(driver);
	}

	public AddCommunityPage addNewCommunity() {
		getAddNewCommunityButton().click();
		return new AddCommunityPage(driver);
	}

	public CommunityPage changeLanguage(ChangeLanguageFields language) {
		setChangeLanguage(language);
		return new CommunityPage(driver);
	}

	public EditCmmunityPage editCommunity(Community community) {
		clickEditButton(community);
		return new EditCmmunityPage(driver);
	}

	public DeleteCommunityAlert deleteCommunity(ICommunity community) {
		clickDeleteButton(community);
		return new DeleteCommunityAlert(driver, this);
	}
}
