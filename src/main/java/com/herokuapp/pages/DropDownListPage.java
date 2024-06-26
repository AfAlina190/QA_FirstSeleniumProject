package com.herokuapp.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

public class DropDownListPage extends BasePage1{
    public DropDownListPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(id = "dropdown")
    WebElement dropdown;

    public DropDownListPage selectOption(int index) {

        Select select = new Select(dropdown);
        select.selectByIndex(index);
        return this;
    }

    @FindBy(css = "option:nth-child(2)")
    WebElement option;
    public DropDownListPage verifyText() {
        Assert.assertTrue(shouldHaveText(option, "1", 5));
        return this;
    }
}
