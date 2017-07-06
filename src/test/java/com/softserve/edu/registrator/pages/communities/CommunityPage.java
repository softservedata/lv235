package com.softserve.edu.registrator.pages.communities;

import java.util.HashMap;


import org.openqa.selenium.WebElement;

import com.softserve.edu.registrator.controls.ITable;
import com.softserve.edu.registrator.controls.Table;
import com.softserve.edu.registrator.data.communities.Community;
import com.softserve.edu.registrator.data.communities.ICommunity;
import com.softserve.edu.registrator.pages.common.AdminHomePage;
import com.softserve.edu.registrator.tools.search.Search;

public class CommunityPage extends AdminHomePage {

	public class DeleteCommunityAlert {
		private WebElement alertLabel;
		private WebElement okButton;
		private WebElement cancelButton;
		private WebElement closeButton;

		public DeleteCommunityAlert() {
			Search.setExplicitVisibleStrategy();
			alertLabel = Search.cssSelector(".bootbox-body");
			Search.setExplicitClickableStrategy();
			okButton = Search.xpath("//button[@data-bb-handler='confirm']");
			cancelButton = Search.xpath("//button[@data-bb-handler='cancel']");
			closeButton = Search.cssSelector(".bootbox-close-button.close");
			Search.setImplicitStrategy();
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
			return new CommunityPage();
		}

		public CommunityPage cancel() {
			clickCancelButton();
			return new CommunityPage();
		}

		public CommunityPage close() {
			clickCloseButton();
			return new CommunityPage();
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
	private ITable communityTable; 

	public CommunityPage() {
		super();
		initPage();
	}
	
	private void initPage() {
			Search.setExplicitVisibleStrategy();
			communityLable = Search.cssSelector("h4");
			addNewCommunityButton = Search.cssSelector("a[href= 'addCommunity']");
			showNoneActiveCBox = Search.cssSelector("label");
			teretorialCommunity = Search.xpath("//tr/th[1]");
			registrationNumber = Search.xpath("//tr/th[2]");
			actions = Search.xpath("//tr/th[3]");
			setTtableCommunity();
			Search.setImplicitStrategy();
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
	
	public ITable getTtableCommunity() {
		return this.communityTable;
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
		return getTtableCommunity().getCell(getTtableCommunity().
				getRowIndexByValueInColumn(community
						.getNameCommunity(), getNameCommunityColumnIndex()),
				getRegisterNumberColumnIndex()).getText().trim();
	}

	private int getNameCommunityColumnIndex() {
		return getTtableCommunity().getColumnIndexByValueOfHeader(getTeretorialCommunityHeaderText());
	}
	
	private int getRegisterNumberColumnIndex() {
		return getTtableCommunity().getColumnIndexByValueOfHeader(getRegistrationNumberHeaderText());
	}
	
	private int getActionsColumnIndex() {
		return getTtableCommunity().getColumnIndexByValueOfHeader(getActionsHeaderText());
	}
	
	private WebElement getEditButtonByIndexOfRow(int indexRow) {
		return Search.cssSelector(".btn.btn-primary", getTtableCommunity()
				.getCell(indexRow, getActionsColumnIndex()));

	}
	
	private WebElement getDeleteButtonByIndexOfRow(int indexRow) {
		return Search.cssSelector(".btn.btn-danger", getTtableCommunity()
				.getCell(indexRow, getActionsColumnIndex()));
	}
	
	public String getEditButtonText() {
		return getEditButtonByIndexOfRow(0).getText();
	}

	public String getDeleteButtonText() {
		return getDeleteButtonByIndexOfRow(0).getText();
	}
	
	public int getCountOfCommunities(ICommunity community) {
		return getTtableCommunity().getRowsByValue(
				community.getNameCommunity()).size();
	}

	// Setters

	public void setTtableCommunity() {
		this.communityTable = new Table(Search.tagName("table"));
	}
	
	public void clickCBoxShowNoneActive() {
		getShowNoneActiveCBox().click();
	}

	public void clickButtonAddNewCommunity() {
		getAddNewCommunityButton().click();
	}

	public void clickEditButton(ICommunity community) {
		getEditButtonByIndexOfRow(getTtableCommunity()
				.getRowIndexByValueInColumn(community.getNameCommunity(),
						getNameCommunityColumnIndex())).click();
	}

	public void clickDeleteButton(ICommunity community) {
		getDeleteButtonByIndexOfRow(getTtableCommunity()
				.getRowIndexByValueInColumn(community.getNameCommunity(),
						getNameCommunityColumnIndex()))
		.click();
	}

	// Business logic

	public CommunityPage checkedCBoxShowNoneActive() {
		getCommunities().click();
		clickCBoxShowNoneActive();
		return new CommunityPage();
	}

	public CommunityPage uncheckedCBoxShowNoneActive() {
		getCommunities().click();
		clickCBoxShowNoneActive();
		clickCBoxShowNoneActive();
		return new CommunityPage();
	}

	public AddCommunityPage addNewCommunity() {
		getAddNewCommunityButton().click();
		return new AddCommunityPage();
	}

	public CommunityPage changeLanguage(ChangeLanguageFields language) {
		setChangeLanguage(language);
		return new CommunityPage();
	}

	public EditCmmunityPage editCommunity(ICommunity community) {
		clickEditButton(community);
		return new EditCmmunityPage();
	}

	public DeleteCommunityAlert deleteCommunity(ICommunity community) {
		clickDeleteButton(community);
		return new DeleteCommunityAlert();
	}
	
	public CommunityPage deleteCommunityIfExist(ICommunity community) {
		if(getTtableCommunity().getColumnsByValue(community.getNameCommunity()).size() == 1){
			return deleteCommunity(community).ok();
		}
		else {
			return this;
		}
	}
	
	public CommunityPage deleteCommunityOk(ICommunity community) {
			return deleteCommunity(community).ok();
	}
}
