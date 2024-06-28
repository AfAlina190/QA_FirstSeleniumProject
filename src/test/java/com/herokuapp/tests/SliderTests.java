package com.herokuapp.tests;

import com.herokuapp.pages.HomePage;
import com.herokuapp.pages.SliderPage;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class SliderTests extends TestBase1{
    @BeforeMethod
    public void precondition(){
        new HomePage(driver).getSliderPage();
    }
    @Test
    public void testSliderFunctionality() {

        new SliderPage(driver)
                .moveSliderToValue(3.5)
                .verifySliderValue(3.5);
    }

    @Test
    public void testMoveSliderWithKeys() {
        new SliderPage(driver)
                .moveSliderWithKeys(3.5)
                .verifySliderValue(3.5);
    }
}
