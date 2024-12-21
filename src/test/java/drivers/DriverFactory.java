package drivers;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class DriverFactory {
    protected WebDriver driver;
    public  WebDriver initialize()
    {
        String browser = System.setProperty("browser", "CHROME");
        if(browser== null) {
            browser = "CHROME";
        }
        switch(browser.toUpperCase())
        {
            case "CHROME":
                WebDriverManager.chromedriver().setup();
                driver =new ChromeDriver();
                break;
            case "FIREFOX":
                WebDriverManager.firefoxdriver().setup();
                driver =new FirefoxDriver();
                break;
            case "EDGE":
                WebDriverManager.edgedriver().setup();
                driver =new EdgeDriver();
                break;
            default: throw new RuntimeException("this browser is not supported");
        }
        return driver;

    }

}
