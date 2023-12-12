package com.orangehrmlive.demo.pages;

import com.orangehrmlive.demo.utility.Utility;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;

public class HomePage extends Utility {

    @CacheLookup
    @FindBy(name = "username")
    WebElement enterUserName;

    @CacheLookup
    @FindBy(name = "password")
    WebElement enterPassword;

    @CacheLookup
    @FindBy(xpath = "//button[normalize-space()='Login']")
    WebElement clickLogin;



    @CacheLookup
    @FindBy(xpath = "//h5[normalize-space()='Login']")
    WebElement loginPanel;

   //h5[normalize-space()='Login']
    //button[normalize-space()='Login'])[1]

    @CacheLookup
    @FindBy(xpath = "//div[@class='orangehrm-login-slot-wrapper']//div[1]//div[1]//span[1]")
    WebElement invalidInput;
    //div[@class='orangehrm-login-slot-wrapper']//div[1]//div[1]//span[1]
    //div[@class='orangehrm-login-slot-wrapper']//div[1]//div[1]//span[1]
    //p[@class='oxd-text oxd-text--p oxd-alert-content-text']


    public void logInToApplication(String userName, String password) {
        sendTextToElement(enterUserName, userName);
        sendTextToElement(enterPassword, password);
        clickOnElement(clickLogin);
    }



    public void verifyLoginPanelText(String text) {
        verifyThatTextIsDisplayed(loginPanel, text);
    }


    public String getInvalidInputMessage() {
        return getTextFromElement(invalidInput);

    }
}
