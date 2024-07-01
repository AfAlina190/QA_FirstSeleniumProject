package com.herokuapp.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

public class ContextMenuPage extends BasePage1{
    public ContextMenuPage(WebDriver driver) {

        super(driver);
    }

    @FindBy(id = "hot-spot")
    WebElement hotSpot;

    public Object rightClickOnTheElement() {
        new Actions(driver).contextClick(hotSpot).perform();
        return this;
    }

    public ContextMenuPage verifyIsAlertPresent(){
        Assert.assertTrue(isAlertPresent());
        return this;
    }
}
