package com.herokuapp.pages;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

import java.util.List;

public class AddRemoveElementsPage extends BasePage1{
    public AddRemoveElementsPage(WebDriver driver) {

        super(driver);
    }

    public AddRemoveElementsPage addElements() {

        new Actions(driver).sendKeys(Keys.TAB,Keys.TAB,Keys.ENTER).perform();
        return this;
    }

    @FindBy(css = ".added-manually")
    WebElement deleteButton;


    public AddRemoveElementsPage verifyAddElements() {
        Assert.assertTrue(isElementVisible(deleteButton));
        return this;
    }

    public AddRemoveElementsPage removeElements() {
        addElements();
        pause(1000);
        new Actions(driver).sendKeys(Keys.TAB,Keys.ENTER).perform();
        return this;
    }

    @FindBy(css = ".added-manually")
    List<WebElement> deleteButton1;

    @FindBy(id = "elements")
    WebElement elementsContainer;

    public AddRemoveElementsPage verifyRemoveElements() {
        Assert.assertTrue(isElementPresent(deleteButton1));
        return this;
    }
    public boolean isElementInvisible(WebElement element) {
        int height = element.getSize().getHeight();
        if (height == 0) {
            return true;
        } else {
            return false;
        }
    }
}
