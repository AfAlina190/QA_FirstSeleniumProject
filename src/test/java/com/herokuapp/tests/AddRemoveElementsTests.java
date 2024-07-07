package com.herokuapp.tests;

import com.herokuapp.pages.AddRemoveElementsPage;
import com.herokuapp.pages.HomePage;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class AddRemoveElementsTests extends TestBase1{
    HomePage home;
    AddRemoveElementsPage addRemove;


    @BeforeMethod
    public void precondition() {

        home = new HomePage(driver);
        addRemove = new AddRemoveElementsPage(driver);
        home.getAddRemoveElements();
    }

    @Test
    public void addElementsTest() {
        addRemove.addElements()
                .verifyAddElements();
    }

    @Test(expectedExceptions = AssertionError.class)
    public void removeElementsTest() {
        addRemove.removeElements()
                .verifyRemoveElements();
    }
}
