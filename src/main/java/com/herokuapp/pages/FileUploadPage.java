package com.herokuapp.pages;

import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

import java.awt.*;
import java.awt.event.InputEvent;
import java.awt.event.KeyEvent;

public class FileUploadPage extends BasePage1{
    public FileUploadPage(WebDriver driver) {

        super(driver);
    }

    @FindBy(id = "file-upload")
    WebElement fileUpload;

    @FindBy(id = "file-submit")
    WebElement fileSubmit;

    public FileUploadPage uploadWithRobot() {

        clickWithRectangle(fileUpload, 16, 2);

        Robot robot;
        try {
            robot = new Robot();
        } catch (AWTException e) {
            throw new RuntimeException(e);
        }


        Dimension dimension = driver.manage().window().getSize();
        System.out.println("Dimension x and y: " + dimension.getWidth() + " *** " + dimension.getHeight());


        int x = dimension.getWidth()/ 2 + 400;
        int y = dimension.getHeight()/ 4 + 10;

        robot.mouseMove(x, y);
        pause(1000);
        //        click left mouse button
        robot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
        pause(1000);
        //        release left mouse button
        robot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
        //        press ENTER key
        robot.keyPress(KeyEvent.VK_ENTER);
        pause(1000);

        return this;
    }

    public FileUploadPage pressSubmitBtn() {
        click(fileSubmit);
        return this;
    }

    @FindBy(css = "h3")
    WebElement message;
    public FileUploadPage verifyMessage(String text) {
        Assert.assertTrue(shouldHaveText(message, text, 5));
        return this;
    }
}
