package com.tutorialsninja.demo.testsuite;

import com.tutorialsninja.demo.customlisteners.CustomListeners;
import com.tutorialsninja.demo.pages.DesktopPage;
import com.tutorialsninja.demo.pages.HomePage;
import com.tutorialsninja.demo.pages.ProductPage;
import com.tutorialsninja.demo.pages.ShoppingCartPage;
import com.tutorialsninja.demo.testbase.BaseTest;
import org.testng.Assert;
import org.testng.ITestNGListener;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import resources.testdata.TestData;

@Listeners({ITestNGListener.class, CustomListeners.class})
public class DesktopsTest extends BaseTest {

    HomePage homePage;
    DesktopPage desktopPage;
    ProductPage productPage;
    ShoppingCartPage shoppingCartPage;

    @BeforeMethod(alwaysRun = true)
    public void inIt() {
        homePage = new HomePage();
        desktopPage = new DesktopPage();
        productPage = new ProductPage();
        shoppingCartPage = new ShoppingCartPage();
    }


    @Test(groups = {"sanity", "regression"}, priority = 0)
    public void verifyProductArrangeInAlphabeticalOrder() {

        //1.1 Mouse hover on Desktops Tab. and click
        homePage.mouseHoverAndClickOnDesktop();

        //1.2 Click on “Show All Desktops”
        homePage.selectMenu("Desktops");

        //1.3 Select Sort By position "Name: Z to A"
        desktopPage.clickOnSortByPosition();
        desktopPage.selectSortByZToA("Name (Z - A)");

        //1.4 Verify the Product will arrange in Descending order.
        Assert.assertEquals(desktopPage.afterSorting(), desktopPage.beforeSorting(), "Not sorted in descending order");

    }

    @Test(groups = {"smoke", "regression"},priority = 1,dataProvider = "ProductData", dataProviderClass = TestData.class)
    public void verifyProductAddedToShoppingCartSuccessFully(String product, String qty, String successMessage, String productName, String model, String total) {

        //2.1 Mouse hover on Currency Dropdown and click
        homePage.mouseHoverOnCurrencyDropdownAndClick();
        //homePage.selectGBP();

        //2.2 Mouse hover on £Pound Sterling and click
        homePage.mouseHoverOnPoundSterlingAndClick();

        //2.3 Mouse hover on Desktops Tab.
        homePage.mouseHoverOnDesktopsTab();

        //2.4 Click on “Show All Desktops”
        homePage.clickOnShowAllDesktops();

        //2.5 Select Sort By position "Name: A to Z"
        desktopPage.clickOnSortByPosition();
        desktopPage.selectSortByAToZ("Name (A - Z)");

        //2.6 Select product <product>
        desktopPage.selectProduct(product);

        //2.7 Enter Qty <qty> using Select class.
        productPage.enterQty(qty);

        //2.8 Click on “Add to Cart” button
        productPage.clickOnAddToCartButton();

        //2.9 Verify the Message <successMessage>
        System.out.println(productPage.verifySuccessMessageToAddInCart());

        //2.10 Click on link “shopping cart” display into success message
        productPage.clickOnShoppingCart1();

        //2.11 Verify the text "Shopping Cart"
        System.out.println(shoppingCartPage.verifyShoppingCartText());

        //2.12 Verify the Product name <productName>
        System.out.println(shoppingCartPage.verifyProductName());

        //2.13 Verify the Model <model>
        System.out.println(shoppingCartPage.verifyModel());

        //2.14 Verify the Total <total>
        System.out.println(shoppingCartPage.verifyTotal());

//  DATA SET
//| product       | qty | successMessage                                               | productName  | model      | total     |
//| HTC Touch HD  | 1   | Success: You have added HTC Touch HD to your shopping cart!  | HTC Touch HD | Product 1  | £74.73    |
//| iPhone        | 2   | Success: You have added iPhone to your shopping cart!        | iPhone       | product 11 | £150.92   |
//| Palm Treo Pro | 3   | Success: You have added Palm Treo Pro to your shopping cart! | Palm Treo Pro| Product 2  | £1,242.11 |
    }

}
