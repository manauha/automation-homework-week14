package com.orangehrmlive.demo.pages;

import com.orangehrmlive.demo.utility.Utility;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;

public class DashboardPage extends Utility {

    @CacheLookup
    @FindBy(xpath = ("//h6[normalize-space()='Dashboard']"))
    //@FindBy(css = (".oxd-text.oxd-text--h6.oxd-topbar-header-breadcrumb-module"))
    WebElement dashboardMessage;

    @CacheLookup
    @FindBy(xpath = ("//li[1]//a[1]//span[1]"))

    WebElement adminTab;

    public void getTextFromDashboardMessage(String text) {
        verifyThatTextIsDisplayed(dashboardMessage, text);
    }

    public void clickOnAdmin(){
        clickOnElement(adminTab);

    }
}
