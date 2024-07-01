package com.herokuapp.tests;

import com.herokuapp.pages.DropDownListPage;
import com.herokuapp.pages.HomePage;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class DropDownListTests extends TestBase1{

    @BeforeMethod
    public void precondition(){
        new HomePage(driver).getDropdownListPage();
    }

    @Test
    public void dropdownListTest(){
        new DropDownListPage(driver).selectOption(1)
                .verifyText();
    }

}
