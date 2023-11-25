package org.example;

import org.testng.annotations.Test;

public class TestSuite extends BaseTest
{

    /*object created for homepage*/
    HomePage homePage = new HomePage();
    /*objected created for register page*/
    RegisterPage registerPage = new RegisterPage();
    /*objected created for registerResult page*/
    RegisterResultPage registerResultPage = new RegisterResultPage();


    @Test
    public void verifyUserShouldAbleToRegisterSuccessfully()
    {
//        click on register button
        homePage.clickOnRegisterButton();
//        verify user is on register page
        registerPage.verifyUserIsOnRegisterPage();
//        enter registration detail
        registerPage.enterDetailsForRegisteration();
//        verify user registered successfully
        registerResultPage.verifyUserRegisteredSuccessfully();

    }

    @Test
    public void verifyUserShouldPrintPriceList()
    {
        homePage.getAllProductPriceLists();
    }
}
