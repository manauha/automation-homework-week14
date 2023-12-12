package com.tutorialsninja.demo.pages;

import com.tutorialsninja.demo.utility.Utility;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;

public class LogoutPage extends Utility {

    @CacheLookup
    @FindBy(xpath = "//h1[contains(text(),'Account Logout')]")
    WebElement logoutText;

    @CacheLookup
    @FindBy(xpath = "//h1[contains(text(),'Account Logout')]")
    WebElement logoutContinueButton;
    //a[normalize-space()='Continue']


    public String getLogoutMessage(){
        return getTextFromElement(logoutText);
    }

    public void clickOnLogoutContinueButton(){
        clickOnElement(logoutContinueButton);
    }


}
