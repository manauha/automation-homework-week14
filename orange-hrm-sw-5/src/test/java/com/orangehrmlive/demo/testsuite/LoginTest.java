package com.orangehrmlive.demo.testsuite;

import com.orangehrmlive.demo.customlisteners.CustomListeners;
import com.orangehrmlive.demo.pages.*;
import com.orangehrmlive.demo.testbase.BaseTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import resources.testdata.LoginData;

@Listeners(CustomListeners.class)
public class LoginTest extends BaseTest {

    AddUserPage addUserPage;
    AdminPage adminPage;
    DashboardPage dashboardPage;
    HomePage homePage;
    LoginPage loginPage;
    ViewSystemUsersPage viewSystemUsersPage;

    @BeforeMethod(alwaysRun = true)
    public void itIt(){
        addUserPage = new AddUserPage();
        adminPage = new AdminPage();
        dashboardPage = new DashboardPage();
        homePage = new HomePage();
        loginPage = new LoginPage();
        viewSystemUsersPage = new ViewSystemUsersPage();

    }
    @Test(groups={"sanity", "regression"}, priority = 0, dataProvider = "loginDetails", dataProviderClass = LoginData.class)
    public void verifyUserShouldLoginSuccessFully(String username, String password) {

        //Enter username //Enter password //Click on Login Button
        homePage.logInToApplication(username,password);

        //Verify "WelCome" Message -Dashboard
        adminPage.getLoginPageDashboardText("Dashboard");

    }

    @Test(groups={"smoke", "regression"},priority = 1, dataProvider = "loginDetails", dataProviderClass = LoginData.class)
    public void verifyThatTheLogoDisplayOnHomePage(String username, String password) {

        //Login To The application
        homePage.logInToApplication(username,password);

        //Verify Logo is Displayed
        adminPage.verifyLogoIsDisplayed();
    }

    @Test(groups={"regression"}, priority = 2, dataProvider = "loginDetails", dataProviderClass = LoginData.class)
    public void verifyUserShouldLogOutSuccessFully(String username, String password) {

        //Login To The application
        homePage.logInToApplication(username,password);

        //Click on User Profile logo
        adminPage.clickOnUserProfileLogo();

        //Mouse hover on "Logout" and click
        adminPage.mouseHoverAndClickOnLogoutButton();

        //Verify the text "Login Panel" is displayed
        homePage.verifyLoginPanelText("Login");

    }

    @Test(groups={"regression"}, priority = 3, dataProvider = "loginDetails1", dataProviderClass = LoginData.class)
    public void verifyErrorMessageWithInvalidCredentials(String username, String password, String errorMessage) {

        //Enter username <username>  //Enter password <password> // Click on Login Button
        homePage.logInToApplication(username,password);

        //Verify Error message <errorMessage>
        String expected = errorMessage;
        String actual = homePage.getInvalidInputMessage();
        System.out.println(actual);


        //Test Data:
        //username                password        errorMessage
        //                                        Required
        //test123 @gmail.com                      Required
        //                        test123         Required
        //test123 @gmail.com      test123         Invalid credentials
    }
}
