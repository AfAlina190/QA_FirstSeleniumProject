package com.herokuapp.tests;

import com.herokuapp.pages.HomePage;
import com.herokuapp.pages.MultipleWindowsPage;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class MultipleWindowsTests extends TestBase1{

    @BeforeMethod
    public void precondition(){
        new HomePage(driver)
                .getMultipleWindowsPage();
    }

    @Test
    public void handleNewTabTest(){
        new MultipleWindowsPage(driver)
                .switchToNewWindow(1)
                .verifyNewWindowTitle("New Window");

    }

}
