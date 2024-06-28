package com.herokuapp.tests;

import com.herokuapp.pages.HomePage;
import com.herokuapp.pages.JsAlertsWidowsPage;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class JsAlertsTests extends TestBase1{
    @BeforeMethod
    public void precondition() {
        new HomePage(driver).getJSAlertsPage();
    }

    @Test
     public void alertTest() {
        new JsAlertsWidowsPage(driver)
                .simpleAlert()
                .verifyResult("You successfully clicked an alert");
    }

    @Test
    public void confirmTest() {
        new JsAlertsWidowsPage(driver)
                .selectResult("Cancel")
                .verifyResult("Cancel");
    }

    @Test
    public void sendMessageToPromptTest(){
        new JsAlertsWidowsPage(driver)
                .sendMessageToPrompt("Hello!")
                .verifyResult("Hello!");
    }

}
