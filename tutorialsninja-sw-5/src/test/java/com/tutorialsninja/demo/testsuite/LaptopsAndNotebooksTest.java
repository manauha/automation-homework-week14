package com.tutorialsninja.demo.testsuite;

import com.tutorialsninja.demo.customlisteners.CustomListeners;
import com.tutorialsninja.demo.pages.*;
import com.tutorialsninja.demo.testbase.BaseTest;
import org.testng.Assert;
import org.testng.ITestNGListener;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

@Listeners({ITestNGListener.class, CustomListeners.class})
public class LaptopsAndNotebooksTest extends BaseTest {

    HomePage homePage;
    LaptopsAndNoteBookPage laptopsAndNoteBookPage;
    MacBookPage macBookpage;
    ShoppingCartPage shoppingCartPage;
    CheckoutPage checkoutPage;

    @BeforeMethod(alwaysRun = true)
    public void itIt() {
        homePage = new HomePage();
        laptopsAndNoteBookPage = new LaptopsAndNoteBookPage();
        macBookpage = new MacBookPage();
        shoppingCartPage = new ShoppingCartPage();
        checkoutPage = new CheckoutPage();

    }

    @Test(groups = {"sanity", "regression"}, priority = 0)
    public void verifyProductsPriceDisplayHighToLowSuccessfully() {

        //1.1 Mouse hover on Laptops & Notebooks Tab.and click
        homePage.mouseHoverAndClickOnLaptopsAndNotebooks();

        //1.2 Click on “Show All Laptops & Notebooks”
        homePage.selectMenu("Laptops & Notebooks");

        //1.3 Select Sort By "Price (High > Low)"
        laptopsAndNoteBookPage.selectPriceHighToLow("Price (High > Low)");

        //1.4 Verify the Product price will arrange in High to Low order.
        Assert.assertEquals(laptopsAndNoteBookPage.afterSorting(), laptopsAndNoteBookPage.beforeSorting(), "products not sorted by Price High to Low");
    }

    @Test(groups = {"smoke", "regression"}, priority = 1)
    public void verifyThatUserPlaceOrderSuccessfully() {

        //2.1 Mouse hover on Laptops & Notebooks Tab and click
        homePage.mouseHoverAndClickOnLaptopsAndNotebooks();

        //2.2 Click on “Show All Laptops & Notebooks”
        homePage.selectMenu("Laptops & Notebooks");

        //2.3 Select Sort By "Price (High > Low)"
        laptopsAndNoteBookPage.selectPriceHighToLow("Price (High > Low)");

        //2.4 Select Product “MacBook”
        laptopsAndNoteBookPage.clickOnMacbook();

        //2.5 Verify the text “MacBook”
        Assert.assertEquals(macBookpage.getTextFromMacBook(), "MacBook", "MacBook Product not display");

        //2.6 Click on ‘Add To Cart’ button
        macBookpage.clickOnAddToCart();

        // 2.7 Verify the message “Success: You have added MacBook to your shopping cart!”
        Assert.assertTrue(macBookpage.isSuccessMessageAppearing(), "Message Doesn't Appear");

        //2.8 Click on link “shopping cart” display into success message
        macBookpage.clickOnShoppingCart();

        //2.9 Verify the text "Shopping Cart"
        //Assert.assertTrue(shoppingCartPage.isShoppingCartAppearing(), "Shopping Cart Doesn't Appear");

        //2.10 Verify the Product name "MacBook"
        Assert.assertEquals(shoppingCartPage.getProductName(), "MacBook", "Product Name Doesn't appear");

        //2.11 Change Quantity "2"
        shoppingCartPage.clearAndAddQuantity("2");

        //2.12 Click on “Update” Tab
        shoppingCartPage.clickOnUpdate();

        // 2.13 Verify the message “Success: You have modified your shopping cart!”
       // Assert.assertEquals(shoppingCartPage.isSuccessMessageAppearing("Success: You have modified your shopping cart!"), "Cart not modified");

        //2.14 Verify the Total £737.45
        Assert.assertEquals(shoppingCartPage.getTotalText(), "$1,204.00", "Total not matched");

        //2.15 Click on “Checkout” button
        shoppingCartPage.clickOnCheckout();

        //2.16 Verify the text “Checkout”
        Assert.assertEquals(checkoutPage.getCheckoutText(), "Checkout", "Checkout not displayed");

        //2.17 Verify the Text “New Customer”
        Assert.assertEquals(checkoutPage.getNewCustomerText(), "New Customer", "New Customer not displayed");

        //2.18 Click on “Guest Checkout” radio button
        checkoutPage.clickOnGuestCheckoutRadioButton();

        //2.19 Click on “Continue” tab
        checkoutPage.clickOnContinueButton();

        //2.20 Fill the mandatory fields
        checkoutPage.enterBillingDetailsFirstName("Neil");
        checkoutPage.enterBillingDetailsLastName("Cooper");
        checkoutPage.enterBillingDetailsEmail("n" + getRandomString(7) + "c@gmail.com");
        checkoutPage.enterBillingDetailsTelephone("07898762345");
        checkoutPage.enterBillingDetailsAddress("45 Barr Road");
        checkoutPage.enterBillingDetailsCity("Bath");
        checkoutPage.enterBillingDetailsPostcode("BA1 2AB");
        checkoutPage.enterBillingDetailsCountry("United Kingdom");
        checkoutPage.enterBillingDetailsRegionOrState("Aberdeen");


        //2.21 Click on “Continue” Button
        checkoutPage.clickOnContinueBillingButton();

        //2.22 Add Comments About your order into text area
        checkoutPage.enterComment("Gift Wrapped");

        //2.23 Check the Terms & Conditions check box
        checkoutPage.clickOnContinueCommentButton();

        //2.24 Click on “Continue” button 2.25 Verify the message “Warning: Payment method required!”
        Assert.assertTrue(checkoutPage.isPaymentWarningAppearing(), "Payment Warning not displayed");
    }
}
