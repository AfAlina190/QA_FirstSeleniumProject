package com.herokuapp.tests;

import com.herokuapp.pages.ExitIntentPage;
import com.herokuapp.pages.HomePage;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class ExitIntentTest  extends TestBase1{


    @BeforeMethod
    public void precondition(){
        new HomePage(driver).getExitIntentPage();
    }

    @Test
    public void exitIntentTest(){
        new ExitIntentPage(driver).moveMouseOut()
                .verifyModalWindowIsDisplayed();
    }

}
