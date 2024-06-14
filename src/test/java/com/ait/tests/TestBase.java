package com.ait.tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.time.Duration;

public class TestBase {
    WebDriver driver;

    //before-setUp
    @BeforeMethod
    public void setUp() {
        driver = new ChromeDriver();

        driver.get("https://demowebshop.tricentis.com/");
        //maximize browser to window size
        driver.manage().window().maximize();
        //wait for all elements on the site to load before start testing
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        }

    @AfterMethod(enabled = false) //- что бы окно не закрывалось
    public void tearDown() {
        driver.quit();//all tabs close browser
    }
}
