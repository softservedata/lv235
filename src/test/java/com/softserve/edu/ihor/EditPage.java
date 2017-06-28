package com.softserve.edu.ihor;

import com.softserve.edu.registrator.data.users.IUser;
import com.softserve.edu.registrator.pages.PassiveEditUserPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import java.util.HashMap;


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

        private String getLocalization(ChangeLanguageFields language) {
            return this.fieldsHashMap.get(language).trim();
        }
    }

    //----------------------------------------------------------------------------
    public static final String EDIT_BUTTON_ID = "edit";
    public static final String CONFIRM_BUTTON_ID = "ok";

    //----------------------------------------------------------------------------
    //Buttons
    private WebElement editButton;
    private WebElement confirmButton;

    //Classes relating to EditPage
    private EditPassportInfoComponent editPassportInfoComponent;
    private EditAddressInfoComponent editAddressInfoComponent;
    private EditBasicInfoComponent editBasicInfoComponent;

    //Constructor
    public EditPage(WebDriver driver) {
        super(driver);
        // class
        this.editAddressInfoComponent = new EditAddressInfoComponent(driver);
        this.editPassportInfoComponent = new EditPassportInfoComponent(driver);
        this.editBasicInfoComponent = new EditBasicInfoComponent(driver);
        //Buttons
      //  this.editButton = driver.findElement(By.id(EDIT_BUTTON_ID));
        this.confirmButton = driver.findElement(By.id(CONFIRM_BUTTON_ID));
    }

    //Get  buttons
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

    //----------------------------------------------------------------------------
    //Functional
    public EditPage changeLanguage(ChangeLanguageFields language){
        setChangeLanguage(language);
        return new EditPage(driver);
    }
     public void clickConfirmButton(){
       getConfirmButton().click();
     }
     public void clickEditButton(){
         getEditButton().click();
     }

}