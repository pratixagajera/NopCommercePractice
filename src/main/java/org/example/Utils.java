package org.example;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.Duration;

public class Utils extends BasePage
{
    //    timeStamp method
    public static String timeStamp()
    {
        String timeStamp = new SimpleDateFormat("yyyyMMddHHmmss").format(new java.util.Date());
        return timeStamp;
    }

    //    reusable method created for click on element
    public static void clickOnElement(By by)
    {
        driver.findElement(by).click();
    }

    /*method created for wait for clickable*/
    public static void waitForClickAble(By by,int time)
    {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(time));
        wait.until(ExpectedConditions.elementToBeClickable(by));
    }

    /*method created for type text*/
    public static void typeText(By by, String text)
    {
        driver.findElement(by).sendKeys(text);
    }

    /*method created to get text from element*/
    public static String getTextFromElement(By by)
    {
        return driver.findElement(by).getText();
    }

    /*create method to capture screenshots*/
    public static void captureScreenshots(String screenShotName)
    {
        try {
            TakesScreenshot ts = (TakesScreenshot) driver;
            File source = ts.getScreenshotAs(OutputType.FILE);
            FileUtils.copyFile(source, new File("ScrrenshotsTS\\" +screenShotName +timeStamp()+ ".png"));
            System.out.println("Screenshot taken");
        }catch (IOException e)
        {
            System.out.println("Exception while taking screenshot" +e.getMessage());
        }
    }
}
