package com.herokuapp.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

import java.util.List;

public class HoverPage extends BasePage1{
    public HoverPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(tagName = "h5")
    WebElement infUser;
    @FindBy(className = "figure")
    List<WebElement> figures;

    public HoverPage selectInfoUser() {
        Actions actions = new Actions(driver);
        for (WebElement figure : figures) {
            actions.moveToElement(figure).perform();
            pause(1000);
            verifyInfoUser();
        }
        return this;
    }

    public HoverPage verifyInfoUser() {
        Assert.assertTrue(isElementVisible(infUser));
        return this;
    }
}
