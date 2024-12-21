package Pages;

import Base.BasePage;
import io.qameta.allure.Step;
import io.qameta.allure.testng.AllureTestNg;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Listeners;

public class CartPage extends BasePage {
    public CartPage(WebDriver driver) {
        super(driver);
    }
    //TODO: define locators
    By continueShop_button = By.id("continue-shopping");
    By checkOut_button = By.id("checkout");
    By Remove_button = By.xpath("//button[contains(.,'Remove')]");
    By Cart_icon = By.id("shopping_cart_container");

    @Step("Click on Cart icon")
    public CartPage ClickOnCartICon()
    {
        driver.findElement(Cart_icon).click();
        return this;
    }
    @Step("Click on Checkout button")
    public CheckoutPage ClickOnCheckOut_button()
    {
        driver.findElement(checkOut_button).click();
        return new CheckoutPage(driver);
    }
    @Step("Remove item form cart")
    public void RemoveFormCart() throws InterruptedException {
        Thread.sleep(1000);
        driver.findElement(Remove_button).click();
    }
    @Step("Continue Shopping after entering the cartPage")
    public ProductListPage ContinueShopping() throws InterruptedException {
        driver.findElement(continueShop_button).click();
        Thread.sleep(1300);
        return new ProductListPage(driver);
    }


}

