package com.orangehrmlive.demo.pages;

import com.orangehrmlive.demo.utility.Utility;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;

public class ViewSystemUsersPage extends Utility {
    @CacheLookup
    @FindBy(xpath = ("(//input[@class='oxd-input oxd-input--active'])[2]"))
    WebElement searchWithUsername;

//    @CacheLookup
//    @FindBy(xpath = ("(//div[contains(text(),'-- Select --')])[1]"))
//    WebElement searchWithUserRole;
//
//    @CacheLookup
//    @FindBy(xpath = ("(//div[@class='oxd-select-text-input'][normalize-space()='Admin'])[1]"))
//    WebElement selectAdminAsUserRole;

    @CacheLookup
    @FindBy(xpath = ("//input[@placeholder='Type for hints...']"))
    WebElement employeeName;

    @CacheLookup
    @FindBy(xpath = ("(//i)[13]"))
    WebElement searchWithStatus;
//    @CacheLookup
//    @FindBy(xpath = ("(//div[@class='oxd-select-text-input'][normalize-space()='Enabled'])[1]"))
//    WebElement selectStatus;

    @CacheLookup
    @FindBy(xpath = ("(//button[normalize-space()='Search'])[1]"))
    WebElement searchButton;

    @CacheLookup
    @FindBy(xpath = ("//div[contains(text(),'khilenpatel123')]"))
    WebElement searchResult;

    @CacheLookup
    @FindBy(xpath = ("(//i[@class='oxd-icon bi-check oxd-checkbox-input-icon'])"))
    WebElement checkBox;

    @CacheLookup
    @FindBy(xpath = ("(//i[@class='oxd-icon bi-trash'])"))
    WebElement deleteButton;
    @CacheLookup
    @FindBy(xpath = ("(//div[@role='document'])[1]"))
    WebElement popUpWindow;

    @CacheLookup
    @FindBy(xpath = ("//button[normalize-space()='Yes, Delete']"))
    WebElement yesButton;

    @CacheLookup
    @FindBy(xpath = ("//button[normalize-space()='Reset']"))
    WebElement reSetButton;
    @CacheLookup
    @FindBy(xpath = ("//label[normalize-space()='Username']"))
    WebElement verifyUsername;
    @CacheLookup
    @FindBy(xpath = ("//span[normalize-space()='No Records Found']"))
    WebElement noRecordFound;

    // * Enter Username
    public void searchWithUsername(String name) {
        sendTextToElement(searchWithUsername, name);
    }
    // * Select User Role
//    public void clickOnSelectUserRoleDropDown(){
//        clickOnElement(searchWithUserRole);
//    }
//    public void selectUserRole(String option){
//        selectByVisibleTextFromDropDown(selectAdminAsUserRole, option);
//    }

    // * Enter EmployeeName <employeeName>
    public void enterEmployeeName(String name) {
        sendTextToElement(employeeName, name);
    }

    public void clickOnSearchWithStatusDropDown() {
        clickOnElement(searchWithStatus);
    }

//    public void selectStatusFromDropDownList(String option){
//        selectByVisibleTextFromDropDown(selectStatus, option);
//    }

    public void clickOnSearchButton() {
        clickOnElement(searchButton);
    }

    public void verifyTheSearchResultList(String text) {
        verifyThatTextIsDisplayed(searchResult, text);
    }

    public void clickOnCheckBoxRadioButton() {
        clickOnElement(checkBox);
    }

    public void clickOnDeleteButton() {
        clickOnElement(deleteButton);
    }

    public void verifyThePopUpWindowIsDisplayed() {
        verifyThatElementIsDisplayed(popUpWindow);
    }

    public void clickOnYesButton() {
        clickOnElement(yesButton);
    }

    public void verifyNoRecordFoundMessage(String text) {
        verifyThatTextIsDisplayed(noRecordFound, text);
    }

    public void verifyUsernameLabel(String text) {
        verifyThatTextIsDisplayed(verifyUsername, text);
    }

    public void clickOnReSetButton() {
        clickOnElement(reSetButton);
    }
}
