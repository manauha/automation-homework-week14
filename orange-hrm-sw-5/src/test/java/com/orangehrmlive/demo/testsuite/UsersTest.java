package com.orangehrmlive.demo.testsuite;

import com.orangehrmlive.demo.customlisteners.CustomListeners;
import com.orangehrmlive.demo.pages.*;
import com.orangehrmlive.demo.testbase.BaseTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import resources.testdata.LoginData;
import resources.testdata.TestData;

@Listeners(CustomListeners.class)
public class UsersTest extends BaseTest {

    AddUserPage addUserPage;
    AdminPage adminPage;
    DashboardPage dashboardPage;
    HomePage homePage;
    LoginPage loginPage;
    ViewSystemUsersPage viewSystemUsersPage;

    @BeforeMethod(alwaysRun = true)
    public void itIt() {
        addUserPage = new AddUserPage();
        adminPage = new AdminPage();
        dashboardPage = new DashboardPage();
        homePage = new HomePage();
        loginPage = new LoginPage();
        viewSystemUsersPage = new ViewSystemUsersPage();
    }

    @Test(groups={"sanity", "regression"}, priority = 0, dataProvider = "loginDetails", dataProviderClass = LoginData.class)
    public void adminShouldAddUserSuccessFully(String username, String password) {

        //Login to Application
        homePage.logInToApplication(username, password);

        //click On "Admin" Tab
        dashboardPage.clickOnAdmin();

        //Verify "System Users" Text
        adminPage.verifySystemUsersText("System Users");

        //click On "Add" button
        adminPage.clickOnAddButton();

        //Verify "Add User" Text
        addUserPage.getTextAddUser("Add User");

        //Select User Role "Admin"
        addUserPage.clickOnDropDownList();
        addUserPage.selectUserRoleFromDropDownList("Admin");
        addUserPage.clickOnEmployeeNameOption();

        //enter Employee Name "Ananya Dash"
        addUserPage.enterEmployeeNameToTheField("Lisa Andrews");

        //enter Username
        addUserPage.selectUsernameInToTheUsernameField("LiAndrews");

        //Select status "Disable"
        addUserPage.clickOnDropDownList();
        addUserPage.selectStatusFromDropDownList("Disable");

        //enter password
        addUserPage.enterPasswordInToThePasswordField("Pen&paper2");

        //enter Confirm Password
        addUserPage.enterConfirmPasswordInToTheConfirmPasswordField("Pen&paper2");

        //click On "Save" Button
        addUserPage.clickOnSaveButton();

        //verify message "Successfully Saved"
        addUserPage.getTextForSuccessfullyMessageAfterSavedAddedUser("Successfully Saved");

    }

    @Test(groups={"smoke", "regression"}, priority = 1, dataProvider = "loginDetails", dataProviderClass = LoginData.class)
    public void searchTheUserCreatedAndVerifyIt(String username, String password) {

        //Login to Application
        homePage.logInToApplication(username, password);

        //click On "Admin" Tab
        dashboardPage.clickOnAdmin();

        //Verify "System Users" Text
        adminPage.verifySystemUsersText("System Users");

        //Enter Username
        viewSystemUsersPage.searchWithUsername("Lisa.Andrews");

        //Select User Role
        addUserPage.clickOnDropDownList();
        addUserPage.selectUserRoleFromDropDownList("Admin");

        //Select Status
        viewSystemUsersPage.clickOnSearchWithStatusDropDown();
        addUserPage.selectStatusFromDropDownList("Disable");

        //Click on "Search" Button
        viewSystemUsersPage.clickOnSearchButton();

        //Verify the User should be in Result list.
        viewSystemUsersPage.verifyTheSearchResultList("Lisa.Andrews");

    }

    @Test(groups={"regression"}, priority = 2, dataProvider = "loginDetails", dataProviderClass = LoginData.class)
    public void verifyThatAdminShouldDeleteTheUserSuccessFully(String username, String password) {

        // Login to Application
        homePage.logInToApplication(username, password);

        // click On "Admin" Tab
        dashboardPage.clickOnAdmin();

        // Verify "System Users" Text
        adminPage.verifySystemUsersText("System Users");

        // Enter Username
        viewSystemUsersPage.searchWithUsername("Lisa.Andrews");

        // Select User Role
        addUserPage.clickOnDropDownList();
        addUserPage.selectUserRoleFromDropDownList("Admin");

        // Select Status
        viewSystemUsersPage.clickOnSearchWithStatusDropDown();
        addUserPage.selectStatusFromDropDownList("Disable");

        // Click on "Search" Button
        viewSystemUsersPage.clickOnSearchButton();

        // Verify the User should be in Result list.
        viewSystemUsersPage.verifyTheSearchResultList("Lisa.Andrews");

        // Click on Check box
        viewSystemUsersPage.clickOnCheckBoxRadioButton();

        // Click on Delete Button
        viewSystemUsersPage.clickOnDeleteButton();

        // Popup will display
        viewSystemUsersPage.verifyThePopUpWindowIsDisplayed();

        // Click on Ok Button on Popup
        viewSystemUsersPage.clickOnYesButton();

        // verify message "Successfully Deleted"
        addUserPage.getTextForSuccessfullyMessageAfterSavedAddedUser("Successfully Saved");
    }

    @Test(groups={"regression"}, priority = 4, dataProvider = "DataSet", dataProviderClass = TestData.class)
    public void searchTheUserAndVerifyTheMessageRecordFound(String username, String userRole, String employeeName, String status) {

        //Login to Application
        homePage.logInToApplication("Admin", "admin123");

        //click On "Admin" Tab
        dashboardPage.clickOnAdmin();

        //Verify "System Users" Text
        adminPage.verifySystemUsersText("System Users");

        //Enter Username <username>
        viewSystemUsersPage.searchWithUsername(username);

        //Select User Role <userRole>
        addUserPage.clickOnDropDownList();
        addUserPage.selectUsernameInToTheUsernameField(userRole);

        //Enter EmployeeName <employeeName>
        viewSystemUsersPage.enterEmployeeName(employeeName);

        //Select Status <status>
        viewSystemUsersPage.clickOnSearchWithStatusDropDown();
        addUserPage.selectStatusFromDropDownList(status);

        //Click on "Search" Button verify message "(1) Record Found"
        viewSystemUsersPage.clickOnSearchButton();
        viewSystemUsersPage.verifyNoRecordFoundMessage("No Records Found");

        //Verify username <username>
        viewSystemUsersPage.verifyUsernameLabel(username);

        //Click on Reset Tab
        viewSystemUsersPage.clickOnReSetButton();


//    Data Set
//    username      userRole    employeeName    Status
//    Admin         Admin       Paul Collings   Enable
//    Cassidy.Hope  ESS         Cassidy Hope    Enable
//    Nina.Patel    ESS         Nina Patel      Enable
//    Odis.Adalwin  Admin       Odis Adalwin    Enable


    }
//    @Test
//    public void dryRun(){}
}
