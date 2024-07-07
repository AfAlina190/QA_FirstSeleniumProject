package com.herokuapp.pages;

import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.BeforeMethod;

import java.io.File;
import java.net.HttpURLConnection;
import java.net.URL;
import java.time.Duration;
import java.util.List;
import java.util.NoSuchElementException;

public abstract class  BasePage1 {
    WebDriver driver;

    JavascriptExecutor js;

    Logger logger = LoggerFactory.getLogger(BasePage1.class);

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

    public boolean isElementPresent(List<WebElement> element) {
        return element.size() > 0;
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

    public void verifyLinks(String linkUrl) {

        try {
            URL url = new URL(linkUrl);
//        create URL connection and get response code
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setConnectTimeout(5000);
            connection.connect();

            if(connection.getResponseCode() >= 400){
                logger.info(linkUrl + "-" + connection.getResponseMessage() + " link is broken");

            }else{
                logger.info(linkUrl + " - " + connection.getResponseMessage());
            }
        } catch (Exception e) {
            logger.info(linkUrl + "-" + e.getMessage() + " - Error occurred");
        }
    }
    public boolean checkImage(WebElement image) {
        return (Boolean)((JavascriptExecutor)driver)
                .executeScript("return (typeof arguments[0].naturalWidth != undefined && arguments[0].naturalWidth>0);",image);
    }

    public void clickWithRectangle(WebElement element, int x, int y){
        Rectangle rectangle = element.getRect();
        int offSetX = rectangle.getWidth() / x;
        int offSetY = rectangle.getHeight() / y;

        Actions actions = new Actions(driver);
        actions.moveToElement(element).perform();
        actions.moveByOffset(-offSetX,-offSetY).click().perform();

    }

    public boolean isFileDownloaded(String path, String name) {
        File dir = new File(path);
        File[] dirContents = dir.listFiles();

        for (int i = 0; i < dirContents.length; i++) {
            if (dirContents[i].getName().equals(name)) {
                return true;
            }
        }
        return false;
    }
}
