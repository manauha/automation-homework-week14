package com.tutorialsninja.demo.pages;

import com.tutorialsninja.demo.utility.Utility;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;

public class ShoppingCartPage extends Utility {

    @CacheLookup
    @FindBy(xpath = "//div[@id='content']//h1")
    WebElement shoppingCartText;
    @CacheLookup
    @FindBy(xpath = "//div[@class = 'table-responsive']/table/tbody/tr/td[2]/a")
    WebElement productNameText;
    @CacheLookup
    @FindBy(xpath = "//div[@class = 'table-responsive']/table/tbody/tr/td[2]/small[1]")
    WebElement deliveryDateText;
    @CacheLookup
    @FindBy(xpath = "//div[@class = 'table-responsive']/table/tbody/tr/td[3]")
    WebElement modelText;
    @CacheLookup
    @FindBy(xpath = "//div[@class = 'table-responsive']/table/tbody/tr/td[6]")
    WebElement totalText;
    @CacheLookup
    @FindBy(xpath = "//div[@class='input-group btn-block']/input[@type='text']")
    WebElement quantityBox;
    @CacheLookup
    @FindBy(xpath = "//i[@class = 'fa fa-refresh']")
    WebElement refreshButton;
    @CacheLookup
    @FindBy(xpath = "//div[@id='checkout-cart']/div[1]")
    WebElement successMessageRefresh;
    @CacheLookup
    @FindBy(css = "a.btn.btn-primary")
    WebElement checkoutButton;

    @CacheLookup
    @FindBy(xpath = "//div[@id='content']//h1")
    WebElement text;

    @CacheLookup
    @FindBy(xpath = "//div[@class = 'table-responsive']/table/tbody/tr/td[2]/a")
    WebElement productName;

    @CacheLookup
    @FindBy(xpath = "//div[@class = 'table-responsive']/table/tbody/tr/td[3]")
    WebElement model;

    @CacheLookup
    @FindBy(xpath = "//div[@class = 'table-responsive']/table/tbody/tr/td[6]")
    WebElement total;

    public String getShoppingCartMessage(){
        return getTextFromElement(shoppingCartText);
    }

    public String getProductName() {
        return getTextFromElement(productNameText);
    }

    public String getDeliveryDateAppearing(String date){
        return getTextFromElement(deliveryDateText);
    }

    public String getModelText() {
        return getTextFromElement(modelText);
    }

    public String getTotalText() {
        return getTextFromElement(totalText);
    }

    public void clearAndAddQuantity(String quantity) {
        quantityBox.clear();
        sendTextToElement(quantityBox, quantity);
    }

    public void clickOnUpdate() {
        clickOnElement(refreshButton);
    }

    public String getUpdatedSuccessMessageText(String message){
        return getTextFromElement(successMessageRefresh);
    }

    public void clickOnCheckout() {
        clickOnElement(checkoutButton);
    }

    public String verifyProductName() {
        return getTextFromElement(productName);
    }

    public String verifyModel() {
        return getTextFromElement(model);
    }

    public String verifyTotal() {
        return getTextFromElement(total);
    }
    public String verifyShoppingCartText() {
        return getTextFromElement(text);
    }










}
