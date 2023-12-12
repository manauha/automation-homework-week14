package com.tutorialsninja.demo.pages;

import com.tutorialsninja.demo.utility.Utility;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;

public class AccountCreationPage extends Utility {

    @CacheLookup
    @FindBy(xpath = "//div[@id='content']//h1[normalize-space()='Your Account Has Been Created!']")
    WebElement accountCreationText;
    //h1[normalize-space()='Your Account Has Been Created!']
    //div[@id='content']//h1[normalize-space()='Your Account Has Been Created!']
    @CacheLookup
    @FindBy(xpath = "//a[text()='Continue']")
    WebElement continueAfterAccountCreation;

    public String getAccountCreationMessage() {
        return getTextFromElement(accountCreationText);
    }

    public void clickOnContinueAfterAccountCreation() {
        clickOnElement(continueAfterAccountCreation);
    }


}
