package com.softserve.edu.registrator.pages.edits;


import java.util.HashMap;

import org.openqa.selenium.WebElement;

import com.softserve.edu.registrator.controls.ITable;
import com.softserve.edu.registrator.pages.user.ActiveUsersPage;
import com.softserve.edu.registrator.pages.user.PassiveEditUserPage;
import com.softserve.edu.registrator.tools.search.Search;


/**
 * Created by User on 6/18/2017.
 */
public class EditPage extends PassiveEditUserPage {

    public static enum EditPageL10n {
        EDIT_BUTTON("Редагувати", "Редактировать", "Edit"),
        CONFIRM_BUTTON("Підтвердити", "Подтвердить", "Confirm");


        private HashMap<ChangeLanguageFields, String> fieldsHashMap;

        private EditPageL10n(String... localization) {
            this.fieldsHashMap = new HashMap<ChangeLanguageFields, String>();
            int i = 0;
            for (ChangeLanguageFields language : ChangeLanguageFields.values()) {
                this.fieldsHashMap.put(language, localization[i]);
                i++;
            }
        }

        public String getLocalization(ChangeLanguageFields language) {
            return this.fieldsHashMap.get(language).trim();
        }
    }

    //buttons
    public static final String EDIT_BUTTON_ID = "edit";
    public static final String CONFIRM_BUTTON_ID = "ok";
    private WebElement editButton;
    private WebElement confirmButton;

    //Classes relating to EditPage
    private ITable table;
    private EditPassportInfoComponent editPassportInfoComponent;
    private EditAddressInfoComponent editAddressInfoComponent;
    private EditBasicInfoComponent editBasicInfoComponent;

    //Constructor
    public EditPage() {
        super();
        // class
        this.editAddressInfoComponent = new EditAddressInfoComponent();
        this.editPassportInfoComponent = new EditPassportInfoComponent();
        this.editBasicInfoComponent = new EditBasicInfoComponent();
        //Buttons
        this.confirmButton = Search.id(CONFIRM_BUTTON_ID);
    }

    //Get  buttons
    public ITable getTable(){
        return this.table;
    }

    public WebElement getEditButton() {
        return this.editButton;
    }

    public WebElement getConfirmButton() {
        return this.confirmButton;
    }

    //Get class
    public EditBasicInfoComponent getEditBasicInfo() {
        return editBasicInfoComponent;
    }

    public EditAddressInfoComponent getEditAddressInfo() {
        return editAddressInfoComponent;
    }

    public EditPassportInfoComponent getEditPassportInfo() {
        return editPassportInfoComponent;
    }

    //Functional
    public EditPage changeLanguage(ChangeLanguageFields language){
        setChangeLanguage(language);
        return new EditPage();
    }
     public ActiveUsersPage clickConfirmButton(){
       getConfirmButton().click();
       return new ActiveUsersPage();
     }


}