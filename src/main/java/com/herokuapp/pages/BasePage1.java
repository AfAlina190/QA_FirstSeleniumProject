package com.herokuapp.pages;

import org.openqa.selenium.Alert;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeMethod;

import java.time.Duration;
import java.util.NoSuchElementException;

public abstract class  BasePage1 {
    WebDriver driver;

    JavascriptExecutor js;

    public BasePage1(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver,this);
        js = (JavascriptExecutor) driver;
    }

    public void click(WebElement element) {
        element.click();
    }
    public void clickWithJS(WebElement element, int x, int y) {
        js.executeScript("window.scrollBy(arguments[0], arguments[1]);", x, y);
        click(element);
    }

    public void typeWithJS(WebElement element, String text, int x, int y) {
        if (text != null) {
            clickWithJS(element, x, y);
            element.clear();
            element.sendKeys(text);
        }
    }

    public void pause(int milliseconds) {
        try {
            Thread.sleep(milliseconds);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }


    public void type(WebElement element, String text) {
        if (text != null) {
            click(element);
            element.clear();
            element.sendKeys(text);
        }
    }

    public boolean shouldHaveText(WebElement element, String text, int time) {

        return new WebDriverWait(driver, Duration.ofSeconds(time))
                .until(ExpectedConditions.textToBePresentInElement(element, text));
    }
    public boolean isElementVisible(WebElement el) {
        try {
            el.isDisplayed();
            return true;
        }catch (NoSuchElementException ex) {
            ex.getMessage();
            return false;
        }
    }
    public boolean isAlertPresent() {
        Alert alert = new WebDriverWait(driver, Duration.ofSeconds(20))
                .until(ExpectedConditions.alertIsPresent());
        if(alert == null){
            return false;
        }else{
            driver.switchTo().alert();
            alert.accept();
            return true;
        }
    }
}
