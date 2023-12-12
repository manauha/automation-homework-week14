package com.nopcommerce.demo.pages;

import com.nopcommerce.demo.utility.Utility;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;

public class ComputerPage extends Utility {

    @CacheLookup
    @FindBy(xpath = "//h1[normalize-space()='Computers']")
    WebElement verifyComputers;
    //h1[normalize-space()='Computers']

    @CacheLookup
    @FindBy(xpath = "//a[@title='Show products in category Desktops'][normalize-space()='Desktops']")
    WebElement clickOnDesktops;
    //a[@title='Show products in category Desktops'][normalize-space()='Desktops']

    public String verifyComputerText(){
        return getTextFromElement(verifyComputers);
    }

    public void clickOnDesktops() {
        clickOnElement(clickOnDesktops);
    }
    /*
    Computers text, DesktopsLink, NotebooksLink, SoftwareLink Locators and create appropriate methods for it.
     */
}
