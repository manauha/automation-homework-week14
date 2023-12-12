package com.tutorialsninja.demo.testsuite;

import com.tutorialsninja.demo.customlisteners.CustomListeners;
import com.tutorialsninja.demo.pages.ComponentsPage;
import com.tutorialsninja.demo.pages.DesktopPage;
import com.tutorialsninja.demo.pages.HomePage;
import com.tutorialsninja.demo.pages.LaptopsAndNoteBookPage;
import com.tutorialsninja.demo.testbase.BaseTest;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

@Listeners(CustomListeners.class)
public class TopMenuTest extends BaseTest {

    HomePage homePage;
    DesktopPage desktopPage;
    LaptopsAndNoteBookPage laptopsAndNoteBookPage;
    ComponentsPage componentsPage;

    @BeforeMethod
    public void inIt() {
        homePage = new HomePage();
        desktopPage = new DesktopPage();
        laptopsAndNoteBookPage = new LaptopsAndNoteBookPage();
        componentsPage = new ComponentsPage();
    }

    @Test(groups = {"sanity","regression"}, priority = 0)
    public void verifyUserShouldNavigateToDesktopsPageSuccessfully() {

        //1.1 Mouse hover on “Desktops” Tab and click
        homePage.mouseHoverAndClickOnDesktop();

        //1.2 call selectMenu method and pass the menu = “Show All Desktops”
        homePage.selectMenu("Desktops");

        //1.3 Verify the text ‘Desktops’
        String expectedDesktop = "Desktops";
        String actualDesktop = desktopPage.getDesktopText();
        Assert.assertEquals(actualDesktop, expectedDesktop, "No Desktop Text");
    }

    @Test(groups = {"smoke", "regression"}, priority = 1)
    public void verifyUserShouldNavigateToLaptopsAndNotebooksPageSuccessfully() {

        // 2.1 Mouse hover on “Laptops & Notebooks” Tab and click
        homePage.mouseHoverAndClickOnLaptopsAndNotebooks();

        // 2.2 call selectMenu method and pass the menu = “Show All Laptops & Notebooks”
        homePage.selectMenu("Laptops & Notebooks");

        //2.3 Verify the text ‘Laptops & Notebooks’
        String expectedLaptopsAndNotebooks = "Laptops & Notebooks";
        String actualLaptopsAndNotebooks = laptopsAndNoteBookPage.getLaptopAndNoteBookText();
        Assert.assertEquals(actualLaptopsAndNotebooks, expectedLaptopsAndNotebooks, "Incorrect Text Displayed");

    }

    @Test(groups = {"regression"}, priority = 2)
    public void verifyUserShouldNavigateToComponentsPageSuccessfully() {

        // 3.1 Mouse hover on “Components” Tab and click
        homePage.mouseHoverAndClickOnComponents();

        //3.2 call selectMenu method and pass the menu = “Show All Components”
        homePage.selectMenu("Components");

        //3.3 Verify the text ‘Components’
        String expectedComponents = "Components";
        String actualComponents = componentsPage.getComponentsText();
        Assert.assertEquals(actualComponents, expectedComponents, "Incorrect Text Displayed");

    }

//    @Test
//    public void dryRun(){}
}