package Pages;

import Base.BasePage;
import Utils.DataFaker;
import io.qameta.allure.Step;
import io.qameta.allure.testng.AllureTestNg;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import java.util.List;

public class CheckoutPage extends BasePage {
    public CheckoutPage(WebDriver driver) {
        super(driver);
    }

    //TODO: define locators
    private final By firstName = By.id("first-name");
    private final By lastName = By.id("last-name");
    private final By zip_code = By.id("postal-code");
    private final By continue_button = By.id("continue");
    private final By finish_button = By.id("finish");
    private final By cancel_button = By.id("cancel");
    private final By ItemPrice = By.className("inventory_item_price");
    private final By totalPriceInWebsite = By.className("summary_subtotal_label");
    private final By completedOrderText = By.xpath("//h2[contains(text(),'Thank you for your order!')]");
    @Step("fill information to checkout")
    //TODO: create method to Checkout
    public CheckoutPage Fill_Info_CheckoutOrder() {
        driver.findElement(firstName).sendKeys(DataFaker.getFirstName());
        driver.findElement(lastName).sendKeys(DataFaker.getLastName());
        driver.findElement(zip_code).sendKeys(DataFaker.getZipCode());
        return this;
    }
    @Step("Click on continue button ")
    public CheckoutPage continue_button()
    {
        driver.findElement(continue_button).click();
        return this;
    }
    @Step("Click on finish button")
    public CheckoutPage finish_button() throws InterruptedException {
        driver.findElement(finish_button).click();
        Thread.sleep(1300);
        return this;
    }

    @Step("canceling order")
    public void cancellingOrder() {
        driver.findElement(cancel_button).click();
    }
    @Step("calculate and check all prices")
    public void calculateAndCheckAllPrices() {
        List<WebElement> All_Price = driver.findElements(ItemPrice);
        double totalPrice = 0;

        for (int i = 0; i < All_Price.size(); i++) {
            String stringValue = All_Price.get(i).getText();
            // Remove the '$' form price
            String textAfter = stringValue.replace("$", "").trim();
            // Convert to string to double and add to total
            double price = Double.parseDouble(textAfter);
            totalPrice += price;
        }
        // Clean the total price from '$' and 'Item total' text
        String text_Total_website = driver.findElement(totalPriceInWebsite).getText();
        String remove_$ = text_Total_website.replace("$", "").replace("Item total:", "").trim();
        double totalWebBeforeTax = Double.parseDouble(remove_$);
        // Assertion
        Assert.assertEquals(totalPrice, totalWebBeforeTax);
            System.out.println("The prices are the same = " + totalPrice + "$");
    }
    @Step("Completed message assertion")
    public void CompletedMessageAssertion()
    {
        Assert.assertTrue(driver.findElement(completedOrderText).isDisplayed());
    }

}
