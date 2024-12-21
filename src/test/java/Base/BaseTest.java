package Base;

import drivers.DriverFactory;
import io.qameta.allure.Allure;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

public class BaseTest {
    protected WebDriver driver;

    @BeforeMethod
    public void setup()
    {
    driver = new DriverFactory().initialize();
    driver.manage().window().maximize();
    }

    @AfterMethod
    public void shutdown(ITestResult result) throws InterruptedException {
        String testCaseName = result.getMethod().getMethodName();
        File destFile = new File("target" + File.separator + "screenshots" + File.separator + testCaseName + ".png");
        takeScreenShot(String.valueOf(destFile));
        driver.quit();
        Thread.sleep(500);
    }

    public void takeScreenShot(String destFile)
    {
        File file = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        try {
            FileUtils.copyFile(file, new File(destFile));
            InputStream is = new FileInputStream(destFile);
            Allure.addAttachment("screenshot", is);
        } catch (IOException e)
        {
            throw new RuntimeException(e);
        }
    }
}
