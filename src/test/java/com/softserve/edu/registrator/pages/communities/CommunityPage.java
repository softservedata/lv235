package com.softserve.edu.registrator.pages.communities;

import java.util.HashMap;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.softserve.edu.registrator.controls.ITable;
import com.softserve.edu.registrator.controls.Table;
import com.softserve.edu.registrator.data.communities.Community;
import com.softserve.edu.registrator.data.communities.ICommunity;
import com.softserve.edu.registrator.pages.AdminHomePage;

public class CommunityPage extends AdminHomePage {

	public class DeleteCommunityAlert {
		private WebElement alertLabel;
		private WebElement okButton;
		private WebElement cancelButton;
		private WebElement closeButton;

		public DeleteCommunityAlert() {
			alertLabel = driver.findElement(By.cssSelector(".bootbox-body"));
			okButton = driver.findElement(By
					.xpath("//button[@data-bb-handler='confirm']"));
			cancelButton = driver.findElement(By
					.xpath("//button[@data-bb-handler='cancel']"));
			closeButton = driver.findElement(By
					.cssSelector(".bootbox-close-button.close"));
		}

		// Getters
		public WebElement getAlertLabel() {
			return this.alertLabel;
		}

		public WebElement getOkButton() {
			return this.okButton;
		}

		public WebElement getCancelButton() {
			return this.cancelButton;
		}

		public WebElement getCloseButton() {
			return this.closeButton;
		}

		// Functional getters
		public String getAlertLabelText() {
			return getAlertLabel().getText();
		}

		public String getOkButtonText() {
			return getOkButton().getText();
		}

		public String getCancelButtonText() {
			return getCancelButton().getText();
		}

		// Setters

		public void clickOkButton() {
			getOkButton().click();
		}

		public void clickCancelButton() {
			getCancelButton().click();
		}

		public void clickCloseButton() {
			getCloseButton().click();
		}

		// Business Logic

		public CommunityPage ok() {
			clickOkButton();
			return new CommunityPage(driver);
		}

		public CommunityPage cancel() {
			clickCancelButton();
			return new CommunityPage(driver);
		}

		public CommunityPage close() {
			clickCloseButton();
			return new CommunityPage(driver);
		}
	}
	
	public static enum CommunityPageL10n {
		COMMUNITY_LABEL("Громади", "Общины", "Communities"), 
		ADD_COMMUNITY_BUTTON("Додати нову територіальну громаду", "Добавить новую общину",
				"Add new territorial community"),
		SHOW_NONE_ACTIVE_CBOX("Показати неактивні", "Показать неактивные", "Show inactive"), 
		TERETORIAL_COMMUNITY_COLUMN_NAME("Територіальна громада", "Территоральная община",
				"Territorial community"), 
		REGISTRATION_NUMBER_COLUMN_NAME("Реєстраційний номер", "Регистрационный номер",
				"Registration number"), 
		ACTIONS_COMMUNITY_COLUMN_NAME("Дії","Действия", "Actions"), 
		EDIT_BUTTON("Редагувати", "Изменить ","Edit"), 
		DELETE_BUTTON("Видалити ", "Удалить", "Delete"),
		ALERT_LABEL("Ви впевнені, що хочете видалити цю громаду?",
				"Вы уверены, что хотите удалить эту общину?",
				"Do you really want to delete this community?"), 
		ALERT_OK_BUTTON("Так", "Да", "OK"), 
		ALERT_CANCEL_BUTTON("Відмінити", "Отменить", "Cancel");

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
	private ITable tableCommunity;

	public CommunityPage(WebDriver driver) {
		super(driver);
		tableCommunity = new Table(driver.findElement(By.tagName("table")));
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

	public WebElement getTeretorialCommunityHeader() {
		return this.teretorialCommunity;
	}

	public WebElement getRegistrationNumberHeader() {
		return this.registrationNumber;
	}

	public WebElement getActionsHeader() {
		return this.actions;
	}

	// Functional getters
	public String getLabelCommunityText() {
		return getCommunityLable().getText().trim();
	}

	public String getButtonAddNewCommunityText() {
		return getAddNewCommunityButton().getText().trim();
	}

	public String getActionsHeaderText() {
		return getActionsHeader().getText().trim();
	}

	public String getTeretorialCommunityHeaderText() {
		return getTeretorialCommunityHeader().getText().trim();
	}

	public String getRegistrationNumberHeaderText() {
		return getRegistrationNumberHeader().getText().trim();
	}

	public String getCBoxShowNoneActiveText() {
		return getShowNoneActiveCBox().getText().trim();
	}

	public String getRegistrationNumberText(Community community) {
		return tableCommunity.getCell(tableCommunity.
				getRowIndexByValueInColumn(community
						.getNameCommunity(), getNameCommunityColumnIndex()),
				getRegisterNumberColumnIndex()).getText().trim();
	}

	private int getNameCommunityColumnIndex() {
		return tableCommunity.getColumnIndexByValueOfHeader(getTeretorialCommunityHeaderText());
	}
	
	private int getRegisterNumberColumnIndex() {
		return tableCommunity.getColumnIndexByValueOfHeader(getRegistrationNumberHeaderText());
	}
	
	private int getActionsColumnIndex() {
		return tableCommunity.getColumnIndexByValueOfHeader(getActionsHeaderText());
	}
	
	private WebElement getEditButtonByIndexOfRow(int indexRow) {
		return tableCommunity
				.getCell(indexRow, getActionsColumnIndex())
				.findElement(By.cssSelector(".btn.btn-primary"));
	}
	
	private WebElement getDeleteButtonByIndexOfRow(int indexRow) {
		return tableCommunity
				.getCell(indexRow, getActionsColumnIndex())
				.findElement(By.cssSelector(".btn.btn-danger"));
	}
	
	public String getEditButtonText() {
		return getEditButtonByIndexOfRow(0).getText();
	}

	public String getDeleteButtonText() {
		return getDeleteButtonByIndexOfRow(0).getText();
	}

	// Setters

	public void clickCBoxShowNoneActive() {
		getShowNoneActiveCBox().click();
	}

	public void clickButtonAddNewCommunity() {
		getAddNewCommunityButton().click();
	}

	public void clickEditButton(Community community) {
		getEditButtonByIndexOfRow(tableCommunity
				.getRowIndexByValueInColumn(community.getNameCommunity(),
						getNameCommunityColumnIndex())).click();
	}

	public void clickDeleteButton(ICommunity community) {
		getDeleteButtonByIndexOfRow(tableCommunity
				.getRowIndexByValueInColumn(community.getNameCommunity(),
						getNameCommunityColumnIndex()))
		.click();
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
		return new DeleteCommunityAlert();
	}
}
