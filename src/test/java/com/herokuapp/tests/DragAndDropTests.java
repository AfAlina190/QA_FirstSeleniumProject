package com.herokuapp.tests;

import com.herokuapp.pages.DragAndDropPage;
import com.herokuapp.pages.HomePage;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class DragAndDropTests extends TestBase1{

    @BeforeMethod
    public void precondition(){
        new HomePage(driver).getDragAndDropPage();
    }

    @Test
    public void dragAndDropTest() {
        new DragAndDropPage(driver).dragAndDropAction().verifyTextInBothShapes();
    }

    @Test
    public void dragAndDropTest1() {
        new DragAndDropPage(driver).dragAndDropAction().verifyTextInOneShape("B");
    }

    @Test
    public void dragAndDropByTest() {
        new DragAndDropPage(driver).dragAndDropByAction(0,0).verifyTextInBothShapes();
    }


}
