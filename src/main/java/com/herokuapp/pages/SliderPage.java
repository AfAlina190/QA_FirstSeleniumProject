package com.herokuapp.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static org.openqa.selenium.devtools.v85.debugger.Debugger.pause;

public class SliderPage extends BasePage1{
    public SliderPage(WebDriver driver) {
        super(driver);
    }
    @FindBy(xpath = "//div[@class='sliderContainer']/input")
    WebElement sliderContainer;

    @FindBy(xpath = "//div[@class='sliderContainer']/span[@id='range']")
    WebElement sliderValue;

    public SliderPage moveSliderToValue(double v) {
        Actions actions = new Actions(driver);
        double min = 0.0;
        double max = 5.0;
        int width = sliderContainer.getSize().getWidth();
        int xOffset = (int) ((v - min) / (max - min) * width - width / 2);


        actions.dragAndDropBy(sliderContainer, xOffset, 0).perform();
        pause(1000);

        return this;
    }

    public SliderPage moveSliderWithKeys(double v) {
        sliderContainer.click();
        double currentValue = Double.parseDouble(sliderValue.getText());
        double step = 0.5;
        while (currentValue != v) {
            if (currentValue < v) {
                sliderContainer.sendKeys(Keys.ARROW_RIGHT);
            } else {
                sliderContainer.sendKeys(Keys.ARROW_LEFT);
            }
            currentValue = Double.parseDouble(sliderValue.getText());
        }


        return this;
    }

    public SliderPage verifySliderValue(double v) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.textToBe(By.id("range"), String.valueOf(v)));
        assert sliderValue.getText().equals(String.valueOf(v)) : "Slider value is incorrect";

        return this;
    }
}
