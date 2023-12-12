package com.tutorialsninja.demo.pages;

import com.tutorialsninja.demo.utility.Utility;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends Utility {

    @CacheLookup
    @FindBy(name = "email")
    WebElement email;
    @CacheLookup
    @FindBy(name = "password")
    WebElement password;
    @CacheLookup
    @FindBy(xpath = "//input[@value='Login']")
    WebElement loginButton;

    public void enterEmail(String inputEmail){
        sendTextToElement(email, inputEmail);
    }

    public void enterPassword(String inputPassword){
        sendTextToElement(password,inputPassword);
    }

    public void clickOnLogin(){
        clickOnElement(loginButton);
    }
}
