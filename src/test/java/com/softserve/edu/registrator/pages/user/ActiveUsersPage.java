package com.softserve.edu.registrator.pages.user;

import org.openqa.selenium.WebElement;

import com.softserve.edu.registrator.tools.search.Search;

public class ActiveUsersPage extends RegisteredUsersPage {

	private class ActiveUsersPageAction {

		// Fields

		private WebElement setRole;
		private WebElement setCommunity;
		private WebElement resetPassword;

		public ActiveUsersPageAction() {
			this.setRole = Search.cssSelector(".dropdown-submenu > a");
			this.setCommunity = Search.cssSelector(".set-community");
			this.resetPassword = Search.cssSelector(".reset-password");
		}

		public WebElement getSetRoleElement() {
			return this.setRole;
		}

		public WebElement getSetCommunityElement() {
			return this.setCommunity;
		}

		public WebElement getResetPasswordElement() {
			return this.resetPassword;
		}

	}

	// - - - - - - - - - - - - - - - - - - - - - - - - - - - - - -

	// Fields

	private ActiveUsersPageAction activeUsersPageAction;

	public ActiveUsersPage() {
		super();
	}

	// PageObject

	// get Data

	// Functional

	// get inner Data

	public WebElement getSetRole() {
		clickActionsButton();
		return this.activeUsersPageAction.getSetRoleElement();
	}

	public WebElement getSetCommunity() {
		clickActionsButton();
		return this.activeUsersPageAction.getSetCommunityElement();
	}

	public WebElement getResetPassword() {
		clickActionsButton();
		return this.activeUsersPageAction.getResetPasswordElement();
	}

	// set Data

	@Override
	public void clickActionsButton() {
		super.clickActionsButton();
		this.activeUsersPageAction = new ActiveUsersPageAction();
	}

	// set inner Data

	public void focusSetRole() {
		// TODO Mouse Over / set Focus getSetRole() !!!
		getSetRole().click();
	}

	public void clickSetCommunity() {
		getSetCommunity().click();
	}

	public void clickResetPassword() {
		getResetPassword().click();
	}

	// Business Logic

}
