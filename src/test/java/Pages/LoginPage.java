package Pages;

import Base.BasePage;
import io.qameta.allure.Step;
import io.qameta.allure.testng.AllureTestNg;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;

public class LoginPage extends BasePage {
    public LoginPage(WebDriver driver){
        super(driver);
    }

    //TODO: define locators
    private  final By username_f = By.id("user-name");
    private  final By password_f = By.id("password");
    private final By login_button = By.id("login-button");
    private final By burger_menu= By.xpath("//button[contains(.,\"Open Menu\")]");
    private final By logout_menu =By.id("logout_sidebar_link");
    private final By errorMessage =By.xpath("//h3[contains(.,'Epic sadface: Sorry, this user has been locked out.')]");
    private final By products_title =By.xpath("//span[contains(text(),'Products')]");

    @Step("load the main website")
    public LoginPage load()
    {
        driver.get("https://www.saucedemo.com/");
       return this;
    }
    @Step("login method")
    public LoginPage login(String username, String pass)
    {
        driver.findElement(username_f).sendKeys(username);
        driver.findElement(password_f).sendKeys(pass);
        return this;
    }
    @Step("Click on login button")
    public LoginPage clickOnButton() throws InterruptedException {
        driver.findElement(login_button).click();
        Thread.sleep(1000);
        return this;
    }
    @Step("Logout method")
    public void logout() throws InterruptedException {

        driver.findElement(burger_menu).click();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10)); // 10-second timeout
        WebElement logout_button = wait.until(ExpectedConditions.elementToBeClickable(logout_menu));
        logout_button.click();
        Thread.sleep(500);
    }
    @Step("Error message assertion")
    //TODO: Error message assertion
    public boolean ErrorMessageAssertion()
    {
         return driver.findElement(errorMessage).isDisplayed();
    }
    @Step("Check the user login state assertion")
    //TODO: Check the user login state assertion
    public boolean CheckUserLoginState()
    {
       return driver.findElement(products_title).isDisplayed();
    }
}
