package com.ait.tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import java.util.List;

public class FindElementsTests extends TestBase {

    @Test
    public void findElementsByTagName(){


        //find element by tag

        WebElement element = driver.findElement(By.tagName("h1"));
        System.out.println(element.getText());

        WebElement element1 = driver.findElement(By.tagName("a"));
        System.out.println(element1.getText());

        //find elements by tag
        List<WebElement> elements = driver.findElements(By.tagName("a"));
        System.out.println(elements.size());

    }

    @Test
    public void findElementByLocator(){

        //by id

        driver.findElement(By.id("city"));

        //by class name
       WebElement phone =  driver.findElement(By.className("telephone"));
        System.out.println(phone.getText());

        //link text
        WebElement linkText = driver.findElement(By.linkText("Let the car work"));
        System.out.println(linkText.getText());




    }

    @Test
    public void findElementByCssSelector(){
        //tag name -> tag
        //WebElement element = driver.findElement(By.tagName("h1"));
        driver.findElement(By.cssSelector("h1"));

        //id -> #id
        //driver.findElement(By.id("city"));
        driver.findElement(By.cssSelector("#city"));

        //class -> class
        //WebElement phone =  driver.findElement(By.className("telephone"));
        driver.findElement(By.cssSelector(".telephone"));

        //[attr='value']
        WebElement cssSelector =  driver.findElement(By.cssSelector("[ng-reflect-name='city']"));
        System.out.println(cssSelector.getAttribute("type"));


        // ========================== LESSON 3 ===============================

        //contains -> * [ng-reflect-router-link*='car']
        WebElement elementContains =  driver.findElement(By.cssSelector("[ng-reflect-router-link*='car']"));
        System.out.println(elementContains.getText());

        //start-> ^
        driver.findElement(By.cssSelector("[ng-reflect-router-link^='let']"));

        //ent on -> $
        driver.findElement(By.cssSelector("[ng-reflect-router-link$='work']"));



    }

    @Test
    public void findElementByXpath(){
        // //*[@attr='value']

        //tag name -> //tag
        // driver.findElement(By.cssSelector("h1"));
        driver.findElement(By.xpath("//h1"));

        //==  id -> //*[id='value']  ==
        //driver.findElement(By.cssSelector("#city"));
        driver.findElement(By.xpath("//input[@id='city']"));

        //class -> //*[@class='value']
        //WebElement phone =  driver.findElement(By.className("telephone"));
        driver.findElement(By.xpath("//*[@class='telephone']"));

        //text = //tag[text()='text']
        ////h2[text()='Type your data and hit Yalla!']
        driver.findElement(By.xpath("//h2[text()='Type your data and hit Yalla!']"));
        driver.findElement(By.xpath("//h2[.='Type your data and hit Yalla!']"));

        //contains -> //tag[contains(.,'Text)]
        driver.findElement(By.xpath("//h2[contains(.,'Yalla!')]"));

        //contains value -> //tag[contains(@attr,'partialValue')]
        driver.findElement(By.xpath("//input[contains(@class,'target')]"));

        //start  -> //tag[starts-with(@attr,'startOfValue')]
        driver.findElement(By.xpath("//input[starts-with(@class,'ng-untouched')]"));


    }

    @Test
    public void findElementByXpath2(){
        //parent

        driver.findElement(By.xpath("//h1/parent::*"));//move up
        driver.findElement(By.xpath("//h1/.."));
        driver.findElement(By.xpath("//h1/parent::div"));

        //ancestor
        driver.findElement(By.xpath("//h1/ancestor::*"));//all
        driver.findElement(By.xpath("//h1/ancestor::div"));//two options
        driver.findElement(By.xpath("//h1/ancestor::div[2]"));// one option

        //following-sibling
        driver.findElement(By.xpath("//h1/following-sibling::*"));//all
        driver.findElement(By.xpath("//h1/following-sibling::form"));//one option


        //preceding-sibling
        driver.findElement(By.xpath("//h2/preceding-sibling::*"));//one option

    }


}

// !! css  двигаться вверх по дереву не может в отдличии от xpath
//css = div>span --> xpath = //div/span - это непосредственно дочерний эжлемент
//css = div span --> xpath = //div//span

//parent
//child
//ancestor
//descendant




















