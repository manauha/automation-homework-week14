package com.orangehrmlive.demo.pages;

import com.orangehrmlive.demo.utility.Utility;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;

public class AdminPage extends Utility {


    @CacheLookup
    @FindBy(xpath = ("//i[@class='oxd-icon bi-caret-down-fill oxd-userdropdown-icon']"))
    WebElement userProfileLogo;

    @CacheLookup
    @FindBy(linkText = ("Logout"))
    WebElement logoutButton;


    @CacheLookup
    @FindBy(xpath = ("//h6[normalize-space()='Dashboard']"))
    WebElement logintext;


    @CacheLookup
    @FindBy(xpath = ("(//img[@alt='client brand logo']"))
    WebElement loginPageLogo;

    //img[@alt='client brand logo']


    @CacheLookup
    @FindBy(xpath = "//h5[normalize-space()='System Users']")
    WebElement systemUsersText;

    @CacheLookup
    @FindBy(xpath = "//button[normalize-space()='Add']")
    WebElement addButton;
    public void getLoginPageDashboardText(String text) {
        verifyThatTextIsDisplayed(logintext, text);
    }


    public void verifyLogoIsDisplayed(){
        verifyThatElementIsDisplayed(loginPageLogo);
    }

    // *    Click on User Profile logo
    public void clickOnUserProfileLogo() {
        mouseHoverToElementAndClick(userProfileLogo);
    }

    // *    Mouse hover on "Logout" and click
    public void mouseHoverAndClickOnLogoutButton() {
        mouseHoverToElementAndClick(logoutButton);
    }


    public void verifySystemUsersText(String text) {
        verifyThatTextIsDisplayed(systemUsersText, text);
    }

    public void clickOnAddButton() {
        clickOnElement(addButton);
    }
}
