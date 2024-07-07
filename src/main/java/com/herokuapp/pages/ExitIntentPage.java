package com.herokuapp.pages;

import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

import java.awt.*;

public class ExitIntentPage extends BasePage1{
    public ExitIntentPage(WebDriver driver) {
        super(driver);
    }

    public ExitIntentPage moveMouseOut() {
        //        get window size
        Dimension dimension = driver.manage().window().getSize();
        int x = dimension.getWidth() / 2;
        int y = dimension.getHeight() / 2;

        Robot robot;
        try {
            robot = new Robot();
        } catch (AWTException e) {
            throw new RuntimeException(e);
        }

        robot.mouseMove(x, -y);
        pause(1000);

        return this;
    }

    @FindBy(css = ".modal")
    WebElement modal;

    public ExitIntentPage verifyModalWindowIsDisplayed() {
        Assert.assertTrue(isElementVisible(modal));
        return this;
    }
}
