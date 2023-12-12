package com.nopcommerce.demo.pages;

import com.nopcommerce.demo.utility.Utility;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;

public class HomePage extends Utility {

    @CacheLookup
    @FindBy(xpath = "//ul[@class='top-menu notmobile']//a[normalize-space()='Computers']")
    WebElement computers;

    @CacheLookup
    @FindBy(xpath = "//ul[@class='top-menu notmobile']//a[normalize-space()='Electronics'")
    WebElement electronics;

    @CacheLookup
    @FindBy(xpath = "//ul[@class='top-menu notmobile']//a[normalize-space()='Apparel']")
    WebElement apparel;

    @CacheLookup
    @FindBy(xpath = "//ul[@class='top-menu notmobile']//a[normalize-space()='Digital downloads']")
    WebElement digitalDownloads;

    @CacheLookup
    @FindBy(xpath = "//ul[@class='top-menu notmobile']//a[normalize-space()='Books']")
    WebElement books;

    @CacheLookup
    @FindBy(xpath = "//ul[@class='top-menu notmobile']//a[normalize-space()='Jewelry']")
    WebElement jewelry;

    @CacheLookup
    @FindBy(xpath = "//ul[@class='top-menu notmobile']//a[normalize-space()='Gift Cards']")
    WebElement giftCards;

    @CacheLookup
    @FindBy(xpath = "//a[normalize-space()='Log in'")  ////a[normalize-space()='Log in'] or class="ico-login"
    WebElement loginLink;

    @CacheLookup
    @FindBy(xpath = "//a[normalize-space()='Register']") //class="ico-register")
    WebElement register;

    @CacheLookup
    @FindBy(xpath = "//img[@alt='nopCommerce demo store'] - xpath") //class="ico-register")
    WebElement logoText;
    //img[alt='nopCommerce demo store'] -css


    public void clickOnComputers(){
        clickOnElement(computers);
    }

    public void clickOnElectronic() {
        clickOnElement(electronics);
    }

    public void clickOnApparel(){
        clickOnElement(apparel);
    }

    public void clickOnDigitalDownloads(){
        clickOnElement(digitalDownloads);
    }

    public void clickOnBooks(){
        clickOnElement(books);
    }

    public void clickOnJewelry(){
        clickOnElement(jewelry);
    }

    public void clickOnGiftCards(){
        clickOnElement(giftCards);
    }

    public void clickOnLoginLink() {
        clickOnElement(loginLink);
    }

    public void clickOnRegister() {
        clickOnElement(register);
    }

    public String getLogoText() {
        return getTextFromElement(logoText);
    }

    public String getLoginText(){
        return getTextFromElement(loginLink);
    }
}
