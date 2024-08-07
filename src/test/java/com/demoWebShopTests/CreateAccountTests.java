package com.demoWebShopTests;

import com.demoWebShop.data.UserData;
import com.demoWebShop.models.User;
import com.demoWebShop.utils.DataProviders;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class CreateAccountTests extends TestBase{
    @BeforeMethod
    public void ensurePrecondition(){
        if(!app.getUser().isLoginLinkPresent()){
            app.getUser().clickOnLogOutLink();
        }
    }

    @Test(enabled = false)
    public void createAccountPositiveTest(){

        logger.info("Create account with data: " + UserData.FIRST_NAME + " " + UserData.LAST_NAME + " " + UserData.EMAIL + " " + UserData.PASSWORD);

        app.getUser().clickOnRegisterLink();
        app.getUser().fillRegisterForm(new User()
                .setFirstName(UserData.FIRST_NAME)
                .setLastName(UserData.LAST_NAME)
                .setEmail(UserData.EMAIL)
                .setPassword(UserData.PASSWORD));
        app.getUser().clickOnRegisterButton();

        Assert.assertTrue(app.getUser().isLogOutLinkPresent());
    }

    @Test
    public void createExistedAccountNegativeTest(){
        logger.info("Existed account data: " + UserData.FIRST_NAME + " " + UserData.LAST_NAME + " " + UserData.EMAIL + " " + UserData.PASSWORD);
        app.getUser().clickOnRegisterLink();
        app.getUser().fillRegisterForm(new User()
                .setFirstName(UserData.FIRST_NAME)
                .setLastName(UserData.LAST_NAME)
                .setEmail(UserData.EMAIL)
                .setPassword(UserData.PASSWORD));
        app.getUser().clickOnRegisterButton();

        Assert.assertTrue(app.getUser().isErrorEmailAlreadyExistsPresent());
    }



    @Test(dataProvider = "createAccountWithCsv", dataProviderClass = DataProviders.class)
    public void createAccountPositiveTestFromDataProviderWithCsv(User user){

        app.getUser().clickOnRegisterLink();
        app.getUser().fillRegisterForm(user);
        app.getUser().clickOnRegisterButton();

        Assert.assertTrue(app.getUser().isLogOutLinkPresent());
    }

}
