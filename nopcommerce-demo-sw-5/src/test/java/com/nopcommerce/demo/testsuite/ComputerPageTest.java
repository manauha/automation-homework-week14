package com.nopcommerce.demo.testsuite;

import com.nopcommerce.demo.customlisteners.CustomListeners;
import com.nopcommerce.demo.pages.BuildYourOwnComputerPage;
import com.nopcommerce.demo.pages.ComputerPage;
import com.nopcommerce.demo.pages.DesktopsPage;
import com.nopcommerce.demo.pages.HomePage;
import com.nopcommerce.demo.testbase.BaseTest;
import org.testng.Assert;
import org.testng.ITestNGListener;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import resources.testdata.TestData;

@Listeners({ITestNGListener.class, CustomListeners.class})
public class ComputerPageTest extends BaseTest {

    HomePage homePage;
    ComputerPage computerPage;
    DesktopsPage desktopsPage;
    BuildYourOwnComputerPage buildYourOwnComputerPage;

    @BeforeMethod(alwaysRun = true)
    public void itIt() {
        homePage = new HomePage();
        computerPage = new ComputerPage();
        desktopsPage = new DesktopsPage();
        buildYourOwnComputerPage = new BuildYourOwnComputerPage();
    }

    @Test(groups = {"sanity", "regression"}, priority = 0)
    public void verifyUserShouldNavigateToComputerPageSuccessfully() {

        //Click on Computer tab
        homePage.clickOnComputers();

        //Verify "Computer" text
        String expected = "Computers";
        String actual = computerPage.verifyComputerText();
        System.out.println(actual);
        Assert.assertEquals(actual, expected, "Error Message");

    }

    @Test(groups = {"smoke", "regression"}, priority = 1)
    public void verifyUserShouldNavigateToDesktopsPageSuccessfully() {

        //Click on Computer tab
        homePage.clickOnComputers();

        //Click on Desktops link
        computerPage.clickOnDesktops();

        //Verify "Desktops" text
        String expected = "Desktops";
        String actual = desktopsPage.verifyDesktopsText();
        Assert.assertEquals(actual, expected, "No Desktops Text");
    }

    @Test(dataProvider = "dataSet", dataProviderClass = TestData.class, groups = {"regression"} , priority = 2)
    public void verifyThatUserShouldBuildYouOwnComputerAndAddThemToCartSuccessfully(String processor, String ram, String hdd, String os, String software) {

        // Click on Computer tab
        homePage.clickOnComputers();

        // Click on Desktops link
        computerPage.clickOnDesktops();

        // Click on product name "Build your own computer"
        desktopsPage.clickOnBuildYourOwnComputer();

        // Select processor "processor"
        buildYourOwnComputerPage.selectProcessor(processor);

        // Select RAM "ram"
        buildYourOwnComputerPage.selectRAM(ram);

        // Select HDD "hdd"
        buildYourOwnComputerPage.selectHDD(hdd);

        // Select OS "os"
        buildYourOwnComputerPage.selectOS(os);

        // Select Software "software"
        buildYourOwnComputerPage.selectSoftware(software);

        // Click on "ADD TO CART" Button
        buildYourOwnComputerPage.clickOnAddToCartLink();

        // Verify message "The product has been added to your shopping cart
        String expectedText = "The product has been added to your shopping cart";
        String actualText = buildYourOwnComputerPage.getMessageText();
        Assert.assertEquals(actualText, expectedText, "Text not displayed");
    }
}

//DATA SET
//| processor                                         | ram           | hdd               | os | software           |                             |
//| 2.2 GHz Intel Pentium Dual-Core E2200             | 2 GB          | 320 GB            | Vista Home [+$50.00]    | Microsoft Office [+$50.00]  |
//| 2.5 GHz Intel Pentium Dual-Core E2200 [+$15.00]   | 4GB [+$20.00] | 400 GB [+$100.00] | Vista Premium [+$60.00] | Acrobat Reader [+$10.00]    |
//| 2.5 GHz Intel Pentium Dual-Core E2200 [+$15.00]   | 8GB [+$60.00] | 320 GB            | Vista Home [+$50.00]    | Total Commander [+$5.00]    |


