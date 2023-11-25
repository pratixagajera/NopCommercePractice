package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

public class RegisterPage extends Utils
{

    /*create object*/
    LoadProp loadProp = new LoadProp();


    /*Locators*/
    private By _clickOnRadioButton= By.xpath("//input[@id = \"gender-male\"]");
    private By _firstName = By.id("FirstName");
    private By _typeLastName = By.id("LastName");
    private By _dateOfBirth = By.name("DateOfBirthDay");
    private By _monthOfBirth = By.name("DateOfBirthMonth");
    private By _yearOfBirth = By.name("DateOfBirthYear");
    private By _Email = By.id("Email");
    private By _companyName = By.id("Company");
    private By _password = By.name("Password");
    private By _confirmPassword = By.id("ConfirmPassword");
    private By _registerButton = By.name("register-button");

    /*variable declare for email*/
    String typeEmail = loadProp.getProperty("email")+timeStamp()+"@gmail.com";


    //    create method to verify user is on register page
    public void verifyUserIsOnRegisterPage()
    {
        Assert.assertTrue(driver.getCurrentUrl().contains("register"));
    }


    /*create method for registration*/
    public void enterDetailsForRegisteration()
    {
        /*click on register button*/
        clickOnElement(_clickOnRadioButton);
        /*type first name field*/
        typeText(_firstName, loadProp.getProperty("firstName"));
        /*type last name field*/
        typeText(_typeLastName, loadProp.getProperty("lastName"));
        /*select date of birth from drop down*/
        Select selectDay = new Select(driver.findElement(_dateOfBirth));
        selectDay.selectByVisibleText("10");
        /*select date of month from drop down*/
        Select selectMonth = new Select(driver.findElement(_monthOfBirth));
        selectMonth.selectByIndex(9);
        /*select year of birth from drop down*/
        Select selectYear = new Select(driver.findElement(_yearOfBirth));
        selectYear.selectByValue("1999");
        /*type email field*/
        typeText(_Email, typeEmail);
        /*type company name field*/
        typeText(_companyName, loadProp.getProperty("companyName"));
        /*type password*/
        typeText(_password, loadProp.getProperty("password"));
        /*type confirmation password*/
        typeText(_confirmPassword,loadProp.getProperty("confirmPassword"));
        /*click on register button*/
        clickOnElement(_registerButton);
    }
}
