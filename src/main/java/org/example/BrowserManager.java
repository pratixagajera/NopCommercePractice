package org.example;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.time.Duration;

public class BrowserManager extends Utils
{
    /*create object*/
    LoadProp loadProp = new LoadProp();
    String browserName = loadProp.getProperty("browser");


    //    create method to open browser for testing
    public void openBrowser()
    {
//        conditional statement if-else used to use different browser
        if (browserName.equalsIgnoreCase("Chrome"))  /*for chrome browser*/
        {
            System.setProperty("webdriver.chrome.driver", "src/test/resources/drivers/chromedriver.exe");
            driver = new ChromeDriver();
        }else if (browserName.equalsIgnoreCase("Firefox"))  /*for firefox browser*/
        {
            System.setProperty("webdriver.gecko.driver", "src/test/resources/drivers/geckodriver.exe");
            driver = new FirefoxDriver();
        }else if (browserName.equalsIgnoreCase("Edge"))  /*for edge browser*/
        {
            System.setProperty("webdriver.edge.driver", "src/test/resources/drivers/msedgedriver.exe");
            driver = new EdgeDriver();
        }else
        {
            System.out.println("Your browser name is wrong or does not match :" +browserName );
        }

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
        driver.manage().window().maximize();
        driver.get("https://demo.nopcommerce.com/");
    }


    //    create method to close browser
    public void closeBrowser()
    {

        driver.quit();
    }
}
