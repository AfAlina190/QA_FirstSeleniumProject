package com.herokuapp.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

import java.util.List;

public class NestedFramesPage extends BasePage1{
    public NestedFramesPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(css = "frame")
    List<WebElement> frames;

    @FindBy(name = "frame-top")
    WebElement frameTop;

    @FindBy(name = "frame-bottom")
    WebElement frameBottom;

    @FindBy(name = "frame-left")
    WebElement frameLeft;

    @FindBy(name = "frame-middle")
    WebElement frameMiddle;

    @FindBy(name = "frame-right")
    WebElement frameRight;

    @FindBy(css = "body")
    WebElement body;

    public NestedFramesPage handleNestedFrames() {

        System.out.println("Number of frames on the page is " + frames.size());

        driver.switchTo().frame(frameTop);

        System.out.println("Number of frame-top children is " + frames.size());
        driver.switchTo().frame(frameMiddle);

        System.out.println("Frame is " + body.getText());

        driver.switchTo().parentFrame();

        System.out.println("Number of frame-top children is " + frames.size());

        driver.switchTo().defaultContent();

        driver.switchTo().frame(frameBottom);
        driver.switchTo().defaultContent();
        driver.switchTo().frame(frameTop);
        System.out.println("Number of frame-top children is " + frames.size());

        driver.switchTo().frame(2);
        System.out.println("Frame is " + body.getText());
        driver.switchTo().defaultContent();
        driver.switchTo().frame(1);
        System.out.println("Frame is " + body.getText());

        return this;
    }

    public NestedFramesPage switchToBottomFrame() {
        driver.switchTo().frame(frameBottom);
        return this;
    }

    public NestedFramesPage verifyText(String text) {
        Assert.assertTrue(body.getText().contains(text));
        return this;
    }

    public NestedFramesPage switchToLeftFrame() {
        driver.switchTo().frame(frameTop).switchTo().frame(frameLeft);
        return this;
    }

    public NestedFramesPage switchToRightFrame() {
        driver.switchTo().frame(frameTop).switchTo().frame(2);
        return this;
    }
}
