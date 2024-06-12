package Homework.hw_2;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class HomeWorkTest {
    WebDriver driver;

    //before-setUp
    @BeforeMethod
    public void setUp() {
        driver = new ChromeDriver();
        driver.get("https://demowebshop.tricentis.com/");// without history
    }

    //tests
    @Test
    public void openGoogle() {
        System.out.println("The site is opened!");
    }


    //after-tearDown (закрываем браузер)
    @AfterMethod
    public void tearDown() {
        driver.quit();//all tabs close browser

    }
//    =============SECOND HW===============

    @Test
    public void findElementByCssSelector() {
        //tag name -> tag
        //WebElement element = driver.findElement(By.tagName("h1"));
        driver.findElement(By.cssSelector("h1"));

        driver.findElement(By.cssSelector("h2"));

        driver.findElement(By.cssSelector("a"));

        driver.findElement(By.cssSelector("button"));

        //id -> #id
        //driver.findElement(By.id("city"));
        driver.findElement(By.cssSelector("#webchatgpt-snackbar"));

        driver.findElement(By.cssSelector("#USE_CHAT_GPT_AI_ROOT_Context_Menu"));

        driver.findElement(By.cssSelector("#USE_CHAT_GPT_AI_ROOT_Minimize_Container"));

        driver.findElement(By.cssSelector("#USE_CHAT_GPT_AI_ROOT"));

        driver.findElement(By.cssSelector("#0"));

        driver.findElement(By.cssSelector("#1"));

        //class -> class
        //WebElement phone =  driver.findElement(By.className("telephone"));
        driver.findElement(By.cssSelector(".navigation-link"));

        driver.findElement(By.cssSelector(".logo"));

        driver.findElement(By.cssSelector(".search-card"));

        driver.findElement(By.cssSelector(".search-container"));

        driver.findElement(By.cssSelector(".close"));


        //[attr='value']
        WebElement cssSelector = driver.findElement(By.cssSelector("[ng-reflect-name='city']"));
        System.out.println(cssSelector.getAttribute("type"));
       


    }

}
