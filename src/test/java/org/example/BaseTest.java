package org.example;

import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class BaseTest extends BrowserManager
{
    //    before method to open browser
    @BeforeMethod
    public void setUp()
    {
        openBrowser();
    }

    //    after method to close browser
    @AfterMethod
    public void tearDown(ITestResult result)
    {

        if (!(result.isSuccess()))
        {
            captureScreenshots(result.getName());
        }
        closeBrowser();
    }
}
