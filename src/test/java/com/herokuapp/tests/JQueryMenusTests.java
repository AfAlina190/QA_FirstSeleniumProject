package com.herokuapp.tests;

import com.herokuapp.pages.HomePage;
import com.herokuapp.pages.JQueryUIMenusPage;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class JQueryMenusTests extends TestBase1{

    HomePage home;
    JQueryUIMenusPage jQuery;
    String path = "C:/Users/afali/Downloads";

    @BeforeMethod
    public void precondition(){
        home = new HomePage(driver);
        jQuery = new JQueryUIMenusPage(driver);
        home.getJQueryUIMenusPage();
    }

    @Test
    public void backToJqueryUITest(){
        jQuery.selectBackToJQuery()
                .verifyText("is many things, but one thing");
    }

    @Test
    public void jQueryUIMenusPdfTest() {
        jQuery.hoverEnabled()
                .hoverDownloads()
                .clickPdf()
                .checkFileDownloaded(path,"menu.pdf");
    }

    @Test
    public void jQueryUIMenusCsvTest() {
        jQuery.hoverEnabled()
                .hoverDownloads()
                .clickCsv()
                .checkFileDownloaded(path,"menu.csv");
    }

    @Test
    public void jQueryUIMenusExcelTest() {
        jQuery.hoverEnabled()
                .hoverDownloads()
                .clickExcel()
                .checkFileDownloaded(path,"menu.xls");
    }

    @AfterMethod
    public void postCondition() {
        jQuery.removeDownloadedFile(path,"menu");
    }

}
