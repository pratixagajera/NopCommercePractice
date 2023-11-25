package org.example;

import org.openqa.selenium.By;
import org.testng.Assert;

public class RegisterResultPage extends Utils
{
    /*Locators*/
    private By _continueButton = By.xpath("//a[@class = \"button-1 register-continue-button\"]");
    private By _confirmationMessage = By.className("result");


    /*create method to verify confirmation email for registration*/
    public void verifyUserRegisteredSuccessfully()
    {
        /*wait until continue button is clickable*/
        waitForClickAble(_continueButton, 10);
        /*get text from element for confirmation result*/
        String registrationMessage = getTextFromElement(_confirmationMessage);
        System.out.println(registrationMessage);
        /*assert point*/
        Assert.assertEquals(registrationMessage, "Your registration completed", "Your registration is not completed");
    }
}
