package com.herokuapp.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

public class JsAlertsWidowsPage extends BasePage1{
    public JsAlertsWidowsPage(WebDriver driver) {
        super(driver);
    }
    @FindBy(css = "li:nth-child(1)>button")
    WebElement simpleAlertButton;

    public JsAlertsWidowsPage simpleAlert() {
        click(simpleAlertButton);
        driver.switchTo().alert().accept();
        return this;
    }

    @FindBy(css = "#result")
    WebElement result;
    public JsAlertsWidowsPage verifyResult(String text){
         if (text !=null){
             Assert.assertTrue(result.getText().contains(text));
         }return this;
    }

    @FindBy(css = "li:nth-child(2)>button")
    WebElement confirmButton;
    public JsAlertsWidowsPage selectResult(String text) {
        click(confirmButton);
        if (text != null && text.equalsIgnoreCase("OK")){
            driver.switchTo().alert().accept();
        }else if (text != null && text.equalsIgnoreCase("Cancel")){
            driver.switchTo().alert().dismiss();
        }return this;
    }

    @FindBy(css = "li:nth-child(3)>button")
    WebElement promptButton;
    public JsAlertsWidowsPage sendMessageToPrompt(String message) {
        click(promptButton);

        if (message != null){
            driver.switchTo().alert().sendKeys(message);
            driver.switchTo().alert().accept();
        }else {
            driver.switchTo().alert().dismiss();
        }
        return this;
    }
}
