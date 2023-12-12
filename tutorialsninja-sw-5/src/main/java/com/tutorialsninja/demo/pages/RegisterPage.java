package com.tutorialsninja.demo.pages;

import com.tutorialsninja.demo.utility.Utility;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;

public class RegisterPage extends Utility {

    @CacheLookup
    @FindBy(xpath = "//h1[contains(text(),'Register Account')]")
    WebElement registerAccountText;

    @CacheLookup
    @FindBy(name = "firstname")
    WebElement enterFirstName;
    @CacheLookup
    @FindBy(name = "lastname")
    WebElement enterLastName;
    @CacheLookup
    @FindBy(name = "email")
    WebElement enterEmail;
    @CacheLookup
    @FindBy(name = "telephone")
    WebElement enterTelephone;
    @CacheLookup
    @FindBy(name = "password")
    WebElement enterPassword;
    @CacheLookup
    @FindBy(name = "confirm")
    WebElement enterConfirmPassword;
    @CacheLookup
    @FindBy(name = "newsletter")
    WebElement checkNewsletter;
    @CacheLookup
    @FindBy(name = "agree")
    WebElement privacyPolicy;
    @CacheLookup
    @FindBy(xpath = "//input[@type='submit']")
    WebElement continueAfterPrivacyButton;

    public void enterFirstName(String firstName){
        sendTextToElement(enterFirstName, firstName);
    }

    public void enterLastName(String lastName){
        sendTextToElement(enterLastName,lastName);
    }

    public void enterEmail(String email){
        sendTextToElement(enterEmail, email);
    }

    public void enterTelephone(String telephone){
        sendTextToElement(enterTelephone, telephone);
    }

    public void enterPassword(String password){
        sendTextToElement(enterPassword, password);
    }

    public void enterConfirmPassword(String confirmPassword){
        sendTextToElement(enterConfirmPassword, confirmPassword);
    }

    public void clickOnSubscribeToNewsletter(){
        clickOnElement(checkNewsletter);
    }

    public void clickOnPrivacyPolicy(){
        clickOnElement(privacyPolicy);
    }

    public void clickOnContinueAfterPrivacyButton(){
        clickOnElement(continueAfterPrivacyButton);
    }

    public String getRegisterAccountText(){
        return getTextFromElement(registerAccountText);
    }

}
