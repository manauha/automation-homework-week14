package com.nopcommerce.demo.pages;

import com.nopcommerce.demo.utility.Utility;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;

public class DesktopsPage extends Utility {

    @CacheLookup
    @FindBy(xpath = "//h1[normalize-space()='Desktops']")
    WebElement desktopsText;
    //h1[normalize-space()='Desktops']

    @CacheLookup
    @FindBy(xpath = "//a[normalize-space()='Build your own computer']")
    WebElement buildYourOwnComputer;
    //a[normalize-space()='Build your own computer']

    public void clickOnBuildYourOwnComputer(){
        clickOnElement(buildYourOwnComputer);
    }

    public String verifyDesktopsText(){
        return getTextFromElement(desktopsText);
    }


    /*
    Desktops text, Sortby, Display, selectProductList Locators and it's actions
     */
}
