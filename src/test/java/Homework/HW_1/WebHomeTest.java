package Homework.HW_1;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class WebHomeTest {
    WebDriver driver;

    //before-setUp
    @BeforeMethod
    public void setUp(){
        driver = new ChromeDriver();
        driver.get("https://demowebshop.tricentis.com/");// without history
    }

    //tests
    @Test
    public void openGoogle(){
        System.out.println("The site is opened!");
    }


    //after-tearDown (закрываем браузер)
    @AfterMethod
    public void tearDown(){
        driver.quit();//all tabs close browser
//
    }

}


