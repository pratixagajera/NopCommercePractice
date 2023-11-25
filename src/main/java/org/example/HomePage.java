package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;

public class HomePage extends Utils
{

    /*locators*/
    private By _registerButton = By.xpath("//a[@class = \"ico-register\"]");
    private By _logInButton = By.xpath("//a[@class = \"ico-login\"]");
    private By _productlist = By.xpath("//div[@class = \"prices\"]");


    /*create method to click on register button*/
    public void clickOnRegisterButton()
    {
        clickOnElement(_registerButton);
    }

    /*create method to click on log in button*/
    public void clickOnLogInButton()
    {
        clickOnElement(_logInButton);
    }

    /*create method to get all product price list*/
    public void getAllProductPriceLists()
    {
        List<WebElement> products = driver.findElements(_productlist);
        System.out.println(products.size());
        List<String>productPriceList = new ArrayList<>();
        for (WebElement ele:products)
        {
            productPriceList.add(ele.getText());
            System.out.println(ele.getText());
        }
    }
}
