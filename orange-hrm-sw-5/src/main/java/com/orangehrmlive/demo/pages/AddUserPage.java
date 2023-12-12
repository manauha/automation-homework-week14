package com.orangehrmlive.demo.pages;

import com.aventstack.extentreports.Status;
import com.orangehrmlive.demo.customlisteners.CustomListeners;
import com.orangehrmlive.demo.utility.Utility;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;

public class AddUserPage extends Utility {

    @CacheLookup
    @FindBy(xpath = ("//h6[normalize-space()='Add User']"))
    WebElement addUserText;

    @CacheLookup
    @FindBy(xpath = "(//div[@class='oxd-select-text-input'][normalize-space()='-- Select --'])[1]")
    WebElement selectDropDown;

    @CacheLookup
    @FindBy(xpath = "(//span[contains(text(),'Admin')])[1]")
    WebElement userRole;

    @CacheLookup
    @FindBy(xpath = "//input[@placeholder='Type for hints...']")
    WebElement employeeName;
    @CacheLookup
    @FindBy(xpath = "//input[@placeholder='Type for hints...']")
    WebElement employeeDropDown;

    @CacheLookup
    @FindBy(xpath = "//input[@class='oxd-input oxd-input--focus']")
    WebElement enterUsername;

    @CacheLookup
    @FindBy(xpath = "//span[normalize-space()='Disabled']")
    WebElement disabledStatus;

    @CacheLookup
    @FindBy(xpath = ("(//input[@type='password'])[1]"))
    WebElement passwordField;
    //By passwordField = By.xpath("//input[@type = 'password']");

    @CacheLookup
    @FindBy(xpath = ("(//input[@type='password'])[2]"))
    WebElement confirmPasswordField;

    @CacheLookup
    @FindBy(xpath = ("//button[normalize-space()='Save']"))
    WebElement saveButton;

    @CacheLookup
    //@FindBy(xpath = ("//div[@class = 'oxd-toast-content oxd-toast-content--success']"))
    @FindBy(xpath = ("//p[@class='oxd-text oxd-text--p oxd-text--toast-message oxd-toast-content-text']"))
    //  @FindBy(xpath = ("//h5[@class='oxd-text oxd-text--h5 oxd-table-filter-title']"))
    WebElement successfullySaveMessage;

    public void getTextAddUser(String text) {
        verifyThatTextIsDisplayed(addUserText, text);

    }

    public void clickOnDropDownList() {
        clickOnElement(selectDropDown);
    }

    public void selectUserRoleFromDropDownList(String option) {
        dynamicListDropDown(userRole, option);
        CustomListeners.test.log(Status.SKIP, "There is a bug");
    }

    public void clickOnEmployeeNameOption() {
        mouseHoverToElementAndClick(employeeDropDown);
    }

    public void enterEmployeeNameToTheField(String name) {
        sendTextToElement(employeeName, name);
        CustomListeners.test.log(Status.SKIP, "There is a bug");

    }

    public void selectUsernameInToTheUsernameField(String username) {
        sendTextToElement(enterUsername, username);
        CustomListeners.test.log(Status.SKIP, "There is a bug");
    }

    public void selectStatusFromDropDownList(String option) {
        dynamicListDropDown(disabledStatus, option);
    }

    public void enterPasswordInToThePasswordField(String password) {
        sendTextToElement(passwordField, password);
    }

    public void enterConfirmPasswordInToTheConfirmPasswordField(String confirmPassword) {
        sendTextToElement(confirmPasswordField, confirmPassword);
    }

    public void clickOnSaveButton() {
        clickOnElement(saveButton);
    }

    public void getTextForSuccessfullyMessageAfterSavedAddedUser(String text) {
        verifyThatTextIsDisplayed(successfullySaveMessage, text);
    }
}
