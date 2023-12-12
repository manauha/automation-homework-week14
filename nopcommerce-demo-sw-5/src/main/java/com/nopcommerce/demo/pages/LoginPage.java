package com.nopcommerce.demo.pages;

import com.aventstack.extentreports.Status;
import com.nopcommerce.demo.customlisteners.CustomListeners;
import com.nopcommerce.demo.utility.Utility;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends Utility {

    @CacheLookup
    @FindBy(xpath = "//button[normalize-space()='Log in']")
    WebElement getWelcomePageMessage;

    @CacheLookup
    @FindBy(xpath ="//h1[contains(text(),'Welcome, Please Sign In!')]")
    WebElement welcomeText;
    //h1[normalize-space()='Welcome, Please Sign In!']

    @CacheLookup
    @FindBy(id="Email")
    WebElement emailField;
    //By emailField = By.id("Email");
    //input[@id='Email']

    @CacheLookup
    @FindBy(name= "Password")
    WebElement passwordField;
    //By passwordField = By.name("Password");
    //input[@id='Password']

    @CacheLookup
    @FindBy(xpath = "//button[contains(text(),'Log in')]")
    WebElement loginButton;
    //button[normalize-space()='Log in'] OR class="button-1 login-button"

    @CacheLookup
    @FindBy(xpath = "//div[@class='message-error validation-summary-errors']")
    WebElement errorMessage;
    //By errorMessage = By.xpath("//div[@class='message-error validation-summary-errors']");

    @CacheLookup
    @FindBy(xpath = "//a[normalize-space()='Log out']")
    WebElement logout;
    //a[normalize-space()='Log out'] OR class="ico-logout"


    public String getWelcomePageMessage(){
        return(getWelcomePageMessage());
    }
    public String getWelcomeText(){
        String message = getTextFromElement(welcomeText);
        return message;
    }

    public void enterEmailId(String email){
        sendTextToElement(emailField, email);
        CustomListeners.test.log(Status.PASS,"Enter EmailId " + email);
    }

    public void enterPassword(String password){
        sendTextToElement(passwordField, password);
        CustomListeners.test.log(Status.PASS,"Enter Password " + password);
    }

    public void clickOnLoginButton(){
        clickOnElement(loginButton);
        CustomListeners.test.log(Status.PASS,"Click on loginButton");
    }

    public String getErrorMessage(){
        String message = getTextFromElement(errorMessage);
        CustomListeners.test.log(Status.PASS,"Get errorMessage");
        return message;
    }

    public void clickOnLogout(){
        clickOnElement(logout);
    }

    public String getLogoutText(){
        return getTextFromElement(logout);
    }
}









