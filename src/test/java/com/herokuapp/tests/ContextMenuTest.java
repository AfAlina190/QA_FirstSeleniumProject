package com.herokuapp.tests;

import com.herokuapp.pages.ContextMenuPage;
import com.herokuapp.pages.HomePage;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class ContextMenuTest extends TestBase1{

    @BeforeMethod
    public void precondition(){
        new HomePage(driver).getContextMenuPage();
    }

    @Test
    public void contextMenuTest(){
        new ContextMenuPage(driver)
                .rightClickOnTheElement();
//                .verifyIsAlertPresent();

    }
}
