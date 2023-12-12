package com.orangehrmlive.demo.pages;

import com.orangehrmlive.demo.utility.Utility;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends Utility {



    @CacheLookup
    @FindBy(xpath = ("(//img[@alt='orangehrm-logo'])[2]"))
    WebElement logoElement;
    // By logoElement = By.xpath("//div[@id='divLogo']//img");
    @CacheLookup
    @FindBy(xpath = ("(//img[@alt='client brand banner'])[1]"))
    WebElement logoElement1;

    @CacheLookup
    @FindBy(xpath = ("(//img[@alt='client brand logo']"))
    WebElement loginPageLogo;

    //img[@alt='client brand logo']


    @CacheLookup
    @FindBy(xpath = "(//span[@class='oxd-text oxd-text--span oxd-input-field-error-message oxd-input-group__message'][normalize-space()='Required'])[1]")
    WebElement errorMessage;

    @CacheLookup
    @FindBy(xpath = "//div[@class='orangehrm-login-slot-wrapper']//div[1]//div[1]//span[1]")
    WebElement invalidInput;
    //div[@class='orangehrm-login-slot-wrapper']//div[1]//div[1]//span[1]
    //div[@class='orangehrm-login-slot-wrapper']//div[1]//div[1]//span[1]
    //p[@class='oxd-text oxd-text--p oxd-alert-content-text']





    //HR for All Logo
    public void getLogoElement(String text) {

        verifyThatTextIsDisplayed(logoElement, text);
    }

    public void getLogoElement1(String text) {
        verifyThatTextIsDisplayed(logoElement1, text);
    }



    public String getErrorMessage() {
        return getTextFromElement(errorMessage);

    }



}
