package com.herokuapp.tests;

import com.herokuapp.pages.HomePage;
import com.herokuapp.pages.HoverPage;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class HoverTest extends TestBase1{
    @BeforeMethod
    public void precondition() {
        new HomePage(driver).getHoversPage();

    }
    @Test
    public void hoverTest(){
        new HoverPage(driver).selectInfoUser();

    }
}
