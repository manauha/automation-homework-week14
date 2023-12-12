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
public class MyAccountsTest extends BaseTest {
    HomePage homePage;
    RegisterPage registerPage;
    AccountCreationPage accountCreationPage;
    AccountPage accountPage;
    LoginPage loginPage;
    LogoutPage logoutPage;

    @BeforeMethod(alwaysRun = true)
    public void inIt() {
        homePage = new HomePage();
        registerPage = new RegisterPage();
        accountCreationPage = new AccountCreationPage();
        accountPage = new AccountPage();
        loginPage = new LoginPage();
        logoutPage = new LogoutPage();
    }

    @Test(groups = {"sanity", "regression"}, priority = 0)
    public void verifyUserShouldNavigateToRegisterPageSuccessfully() {

        //1.1 Click on My Account Link.
        homePage.clickOnMyAccount();

        //1.2 Call the method “selectMyAccountOptions” method and pass the parameter “Register”
        homePage.selectMyAccountOptions("Register");

        //1.3 Verify the text “Register Account”.
        String expectedRegisterAccountText = "Register Account";
        String actualRegisterAccountText = registerPage.getRegisterAccountText();
        Assert.assertEquals(actualRegisterAccountText, expectedRegisterAccountText, "Error");

    }

    @Test(groups = {"smoke", "regression"}, priority = 1)
    public void verifyUserShouldNavigateToLoginPageSuccessfully() {

        //2.1 Click on My Account Link.
        homePage.clickOnMyAccount();

        //2.2 Call the method “selectMyAccountOptions” method and pass the parameter “Login”
        homePage.selectMyAccountOptions("Login");

        //2.3 Verify the text “Returning Customer”.
        String expectedReturningCustomerText = "Returning Customer";
        String actualReturningCustomerText = accountPage.getReturningCustomerText();
        Assert.assertEquals(actualReturningCustomerText, expectedReturningCustomerText, "Error Message");

    }


    @Test(groups = {"regression"}, priority = 2)
    public void verifyThatUserRegisterAccountSuccessfully() {

        //3.1 Click on My Account Link.
        homePage.clickOnMyAccount();

        //3.2 Call the method “selectMyAccountOptions” method and pass the parameter “Register”
        homePage.selectMyAccountOptions("Register");

        //3.3 Enter First Name
        registerPage.enterFirstName("Neil");

        //3.4 Enter Last Name
        registerPage.enterLastName("Cooper");

        //3.5 Enter Email
        registerPage.enterEmail("ncooper108@test.com");

        //3.6 Enter Telephone
        registerPage.enterTelephone("0123 4567 8901");

        //3.7 Enter Password
        registerPage.enterPassword("Pen2Paper");

        //3.8 Enter Password Confirm
        registerPage.enterConfirmPassword("Pen2paper");

        //3.9 Select Subscribe Yes radio button
        registerPage.clickOnSubscribeToNewsletter();

        //3.10 Click on Privacy Policy check box
        registerPage.clickOnPrivacyPolicy();

        //3.11 Click on Continue button
        registerPage.clickOnContinueAfterPrivacyButton();

        //3.12 Verify the message “Your Account Has Been Created!”
        String expectedAccountCreatedText = "Your Account Has Been Created!";
        String actualAccountCreatedText = accountCreationPage.getAccountCreationMessage();
        Assert.assertEquals(actualAccountCreatedText, expectedAccountCreatedText, "Error Message");

        //3.13 Click on Continue button
        accountCreationPage.clickOnContinueAfterAccountCreation();

        // 3.14 Click on My Account Link.
        accountPage.clickOnMyAccountLink();

        //3.15 Call the method “selectMyAccountOptions” method and pass the parameter “Logout”
        accountPage.selectMyAccountOption("Logout");

        //3.16 Verify the text “Account Logout”
        String expectedLogoutText = "Account Logout";
        String actualLogoutText = logoutPage.getLogoutMessage();
        Assert.assertEquals(actualLogoutText, expectedLogoutText, "Error");

        //3.17 Click on Continue button
        accountPage.clickOnContinueAfterLogout();
    }


    @Test(groups = "regression", priority = 4)
    public void verifyThatUserShouldLoginAndLogoutSuccessfully() {

        //4.1 Click on My Account Link.
        homePage.clickOnMyAccount();

        //4.2 Call the method “selectMyAccountOptions” method and pass the parameter “Login”
        homePage.selectMyAccountOptions("Login");

        //4.3 Enter Email address
        loginPage.enterEmail("ncooper108@test.com");

        //4.4 Enter Last Name

        //4.5 Enter Password
        loginPage.enterPassword("Pen2paper");

        //4.6 Click on Login button
        loginPage.clickOnLogin();

        //4.7 Verify text “My Account”
        String expectedMyAccountText = "My Account";
        String actualMyAccountText = accountPage.getMyAccountText();
        Assert.assertEquals(actualMyAccountText, expectedMyAccountText, "Error");

        //4.8 Click on My Account Link.
        accountPage.clickOnMyAccountLink();

        //4.9 Call the method “selectMyAccountOptions” method and pass the parameter “Logout”
        homePage.selectMyAccountOptions("Logout");

        //4.10 Verify the text “Account Logout”
        String expectedAccountLogoutText = "Account Logout";
        String actualAccountLogoutText = logoutPage.getLogoutMessage();

        //4.11 Click on Continue button
        logoutPage.clickOnLogoutContinueButton();

    }
}
