package com.softserve.edu.registrator.tests.settings.l10n;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.softserve.edu.registrator.data.users.UserRepository;
import com.softserve.edu.registrator.pages.ATopComponent.ChangeLanguageFields;
import com.softserve.edu.registrator.pages.Application;
import com.softserve.edu.registrator.pages.settings.DefaultTimeZoneComponent.DefaultTimeZoneComponentL10n;
import com.softserve.edu.registrator.pages.settings.EmailConfigurationComponent.EmailConfigurationComponentL10n;
import com.softserve.edu.registrator.pages.settings.SettingsPage;
import com.softserve.edu.registrator.pages.settings.SettingsPage.SettingsPageL10n;
import com.softserve.edu.registrator.pages.settings.UserRegistrationOptionsComponent.UserRegistrationOptionsComponentL10n;
import com.softserve.edu.registrator.tests.TestRunner;

public class SettingsPageL10nTestEN extends TestRunner {

	@Test
	public void userRegistrationOptionsComponentTestEN() {
		SettingsPage settingsPage = Application.get().load()
				.successAdminLogin(UserRepository.get().admin())
				.clickSettings();
		settingsPage.setChangeLanguage(ChangeLanguageFields.ENGLISH);
		settingsPage = new SettingsPage(Application.get().getBrowser());
		Assert.assertEquals(settingsPage.getUserRegistrationOptionsComponent()
				.getComponentLabelText(),
				UserRegistrationOptionsComponentL10n.COMPONENT_LABEL
						.getLocalization(ChangeLanguageFields.ENGLISH));
		Assert.assertEquals(settingsPage.getUserRegistrationOptionsComponent()
				.getOptionLabelText(),
				UserRegistrationOptionsComponentL10n.OPTION_LABEL
						.getLocalization(ChangeLanguageFields.ENGLISH));
		Assert.assertEquals(settingsPage.getUserRegistrationOptionsComponent()
				.getPersonalRegistrationText(),
				UserRegistrationOptionsComponentL10n.PERSONAL_REGISTRATION
						.getLocalization(ChangeLanguageFields.ENGLISH));
		Assert.assertEquals(settingsPage.getUserRegistrationOptionsComponent()
				.getManualRegistrationText(),
				UserRegistrationOptionsComponentL10n.MANUAL_REGISTRATION
						.getLocalization(ChangeLanguageFields.ENGLISH));
		Assert.assertEquals(settingsPage.getUserRegistrationOptionsComponent()
				.getMixedRegistrationText(),
				UserRegistrationOptionsComponentL10n.MIXED_REGISTRATION
						.getLocalization(ChangeLanguageFields.ENGLISH));

	}

	@Test
	public void defaultTimeZoneComponentTestEN() {
		SettingsPage settingsPage = Application.get().load()
				.successAdminLogin(UserRepository.get().admin())
				.clickSettings();
		settingsPage.setChangeLanguage(ChangeLanguageFields.ENGLISH);
		settingsPage = new SettingsPage(Application.get().getBrowser());
		Assert.assertEquals(settingsPage.getDefaultTimeZoneComponent()
				.getComponentLabelText(),
				DefaultTimeZoneComponentL10n.COMPONENT_LABEL
						.getLocalization(ChangeLanguageFields.ENGLISH));
		Assert.assertEquals(settingsPage.getDefaultTimeZoneComponent()
				.getInnerLabelText(), DefaultTimeZoneComponentL10n.INNER_LABEL
				.getLocalization(ChangeLanguageFields.ENGLISH));
	}

	@Test
	public void emailConfigurationComponentTestEN() {
		SettingsPage settingsPage = Application.get().load()
				.successAdminLogin(UserRepository.get().admin())
				.clickSettings();
		settingsPage.setChangeLanguage(ChangeLanguageFields.ENGLISH);
		settingsPage = new SettingsPage(Application.get().getBrowser());
		Assert.assertEquals(settingsPage.getEmailConfigurationComponent()
				.getComponentLabelText(),
				EmailConfigurationComponentL10n.COMPONENT_LABEL
						.getLocalization(ChangeLanguageFields.ENGLISH));
		Assert.assertEquals(settingsPage.getEmailConfigurationComponent()
				.getEmailServerAddressLabelText(),
				EmailConfigurationComponentL10n.EMAIL_SERVER_ADDRESS_LABEL
						.getLocalization(ChangeLanguageFields.ENGLISH));
		Assert.assertEquals(settingsPage.getEmailConfigurationComponent()
				.getUserNameLabelText(),
				EmailConfigurationComponentL10n.USERNAME_LABEL
						.getLocalization(ChangeLanguageFields.ENGLISH));
		Assert.assertEquals(settingsPage.getEmailConfigurationComponent()
				.getTcpPortLabelText(),
				EmailConfigurationComponentL10n.TCP_PORT_LABEL
						.getLocalization(ChangeLanguageFields.ENGLISH));
		Assert.assertEquals(settingsPage.getEmailConfigurationComponent()
				.getProtocolLabelText(),
				EmailConfigurationComponentL10n.PROTOCOL_LABEL
						.getLocalization(ChangeLanguageFields.ENGLISH));
		Assert.assertEquals(settingsPage.getEmailConfigurationComponent()
				.getPasswordLabelText(),
				EmailConfigurationComponentL10n.PASSWORD_LABEL
						.getLocalization(ChangeLanguageFields.ENGLISH));
		Assert.assertEquals(settingsPage.getEmailConfigurationComponent()
				.getTlsSecureConnectionLabelText(),
				EmailConfigurationComponentL10n.TLS_SECURE_CONNECTION_LABEL
						.getLocalization(ChangeLanguageFields.ENGLISH));
		Assert.assertEquals(settingsPage.getEmailConfigurationComponent()
				.getCheckButtonText(),
				EmailConfigurationComponentL10n.CHECK_BUTTON
						.getLocalization(ChangeLanguageFields.ENGLISH));
	}

	@Test
	public void emailConfigurationComponentEmailAlertTestEN()
			throws InterruptedException {
		SettingsPage settingsPage = Application.get().load()
				.successAdminLogin(UserRepository.get().admin())
				.clickSettings();
		settingsPage.setChangeLanguage(ChangeLanguageFields.ENGLISH);
		settingsPage = new SettingsPage(Application.get().getBrowser());
		settingsPage.getEmailConfigurationComponent().clickCheckButton();
		Thread.sleep(1000);
		Assert.assertEquals(settingsPage.getEmailConfigurationComponent()
				.getEmailAlertText(),
				EmailConfigurationComponentL10n.EMAIL_ALERT
						.getLocalization(ChangeLanguageFields.ENGLISH));
	}

	@Test
	public void settingsPageTestEN() {
		SettingsPage settingsPage = Application.get().load()
				.successAdminLogin(UserRepository.get().admin())
				.clickSettings();
		settingsPage.setChangeLanguage(ChangeLanguageFields.ENGLISH);
		settingsPage = new SettingsPage(Application.get().getBrowser());
		Assert.assertEquals(settingsPage.getConfirmChangesButtonText(),
				SettingsPageL10n.CONFIRM_CHANGES_BUTTON
						.getLocalization(ChangeLanguageFields.ENGLISH));
	}

	@Test
	public void settingsPageAlertTestEN() {
		SettingsPage settingsPage = Application.get().load()
				.successAdminLogin(UserRepository.get().admin())
				.clickSettings();
		settingsPage.setChangeLanguage(ChangeLanguageFields.ENGLISH);
		settingsPage = new SettingsPage(Application.get().getBrowser());
		settingsPage.clickConfirmChangesButton();
		Assert.assertEquals(settingsPage.getAlertText(), SettingsPageL10n.ALERT
				.getLocalization(ChangeLanguageFields.ENGLISH));
	}

}
