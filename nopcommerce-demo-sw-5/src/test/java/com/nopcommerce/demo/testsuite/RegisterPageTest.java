package com.nopcommerce.demo.testsuite;

import com.nopcommerce.demo.customlisteners.CustomListeners;
import com.nopcommerce.demo.pages.HomePage;
import com.nopcommerce.demo.pages.RegisterPage;
import com.nopcommerce.demo.testbase.BaseTest;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

@Listeners(CustomListeners.class)
public class RegisterPageTest extends BaseTest {

    HomePage homePage;
    RegisterPage registerPage;

    @BeforeMethod(alwaysRun = true)
    public void inIt() {
        homePage = new HomePage();
        registerPage = new RegisterPage();
    }

    @Test(groups = {"sanity","regression"}, priority = 0)
    public void verifyUserShouldNavigateToRegisterPageSuccessfully() {

        //Click on Register Link
        homePage.clickOnRegister();

        //Verify "Register" text
        String expectedText = "Register";
        String actualText = registerPage.verifyRegisterText();
        Assert.assertEquals(actualText, expectedText, "Error Text");

    }

    @Test(groups = {"smoke","regression"}, priority = 1)
    public void verifyThatFirstNameLastNameEmailPasswordAndConfirmPasswordFieldsAreMandatory() throws InterruptedException {

        //Click on Register Link
        homePage.clickOnRegister();

        //Click on "REGISTER" button
        registerPage.clickOnRegisterButton();

        //Verify the error message "First name is required."
        String expectedMessage = "First name is required.";
        String actualMessage = registerPage.verifyFirstNameErrorText();
        System.out.println(actualMessage);
        Assert.assertEquals(actualMessage, expectedMessage, "Error Text");

        //Verify the error message "Last name is required."
        String expectedMessage1 = "Last name is required.";
        String actualMessage1 = registerPage.verifyLastNameErrorText();
        System.out.println(actualMessage1);
        Assert.assertEquals(actualMessage1, expectedMessage1, "Error Text");

        //Verify the error message "Email is required."
        String expectedMessage2 = "Email is required.";
        String actualMessage2 = registerPage.verifyEmailErrorText();
        System.out.println(actualMessage2);
        Assert.assertEquals(actualMessage2, expectedMessage2, "Error Text");

        //Verify the error message "Password is required."
        String expectedMessage3 = "Password is required.";
        String actualMessage3 = registerPage.verifyPasswordErrorText();
        Assert.assertEquals(actualMessage3, expectedMessage3, "Error Text");

        //Verify the error message "Password is required."
        String expectedMessage4 = "Password is required.";
        String actualMessage4 = registerPage.verifyConfirmPasswordErrorText();
        Assert.assertEquals(actualMessage4, expectedMessage4, "Error Text");

    }

    @Test(groups = {"regression"}, priority = 2)
    public void verifyThatUserShouldCreateAccountSuccessfully() {

        //Click on Register Link
        homePage.clickOnRegister();

        //Select gender "Female"
        registerPage.clickOnGenderFemale();

        //Enter firstname
        registerPage.enterFirstName("Neil");

        //Enter lastname
        registerPage.enterLastName("Cooper");

        //Select day
        registerPage.selectDayOfBirthDay("9");

        //Select month
        registerPage.selectMonthOfBirthDay("May");
        //Select year
        registerPage.selectYearOfBirthDay("1989");

        //Enter email
        registerPage.enterEmail("ncooper108@test.com");

        //Enter password
        registerPage.enterPassword("Pen2paper");

        //Enter Confirm Password
        registerPage.enterConfirmPassword("Pen2paper");

        //Click on "REGISTER" button
        registerPage.clickOnRegisterButton();

        //Verify message "Your registration completed"
        String expectedMessage = "Your registration completed";
        String actualMessage = registerPage.verifyRegistrationCompletedMessage();
        Assert.assertEquals(actualMessage, expectedMessage, "Incomplete Registration");

    }
}