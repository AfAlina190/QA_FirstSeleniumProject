package com.herokuapp.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

import java.util.ArrayList;
import java.util.List;

public class MultipleWindowsPage extends BasePage1{
    public MultipleWindowsPage(WebDriver driver) {

        super(driver);
    }
    @FindBy(css = ".example>a")
    WebElement openWindowLink;


    public MultipleWindowsPage switchToNewWindow(int index) {
        click(openWindowLink);

        List<String> tabs = new ArrayList<>(driver.getWindowHandles());
        driver.switchTo().window(tabs.get(index));
        return this;
    }

    @FindBy(xpath = "//h3[.='New window']")
    WebElement newWindowTitle;
    public MultipleWindowsPage verifyNewWindowTitle(String title) {
        Assert.assertTrue(shouldHaveText(newWindowTitle,title,10));
        return this;
    }
}
