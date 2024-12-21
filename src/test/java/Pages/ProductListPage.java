package Pages;

import Base.BasePage;

import io.qameta.allure.Step;
import io.qameta.allure.testng.AllureTestNg;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ProductListPage extends BasePage {
    public ProductListPage(WebDriver driver) {
        super(driver);
    }

    String Saved_option;
    //TODO: define locators
    private final By sortBy = By.cssSelector("[data-test=\"product-sort-container\"]");
    private final By products_list = By.xpath("//button[contains(.,'Add to cart')]");
    private final By first_product = By.xpath("//div[@class=\"inventory_item\"][1]//button[contains(.,'Add to cart')]");
    private final By AnotherItem = By.xpath("//div[@class=\"inventory_item\"][2]//button[contains(.,'Add to cart')]");
    private final By Remove_button = By.xpath("//button[contains(.,'Remove')]");
    private final By ItemPrice = By.className("inventory_item_price");
    private final By inventoryItemName = By.className("inventory_item_name");
    @Step("Add product to cart")
    public CartPage AddProductToCart() throws InterruptedException {
        driver.findElement(first_product).click();
        Thread.sleep(1500);
        return new CartPage(driver);

    }
    @Step("Add more one product")
    public void AddOneMoreItem() throws InterruptedException {
        driver.findElement(AnotherItem).click();
        Thread.sleep(1500);
    }
    @Step("Add all products to cart")
    public ProductListPage AddAllProductsToCart() throws InterruptedException {
        List<WebElement> AllProducts = driver.findElements(products_list);
        int i = AllProducts.size();
        while (i != 0) {
            --i;
            AllProducts.get(i).click();
            Thread.sleep(1000);
        }
        return this;
    }

    @Step("Remove all products from ProductListPage")
    public void RemoveAllProductsFromPLP() throws InterruptedException {
        List<WebElement> AllProducts = driver.findElements(Remove_button);
        int i = AllProducts.size();
        while (i != 0) {
            --i;
            AllProducts.get(i).click();
            Thread.sleep(400);
        }
    }

    @Step("Click on Remove button")
    public void ClickToRemove() throws InterruptedException {
        driver.findElement(Remove_button).click();
        Thread.sleep(1000);
    }

    @Step("Sorting option")
    public ProductListPage SortOptions(String how) {
        Saved_option = how;
        WebElement dropdown = driver.findElement(sortBy);
        Select select = new Select(dropdown);
        switch (how) {
            case "az":
                select.selectByVisibleText("Name (A to Z)");
                break;
            case "za":
                select.selectByVisibleText("Name (Z to A)");
                break;
            case "low":
                select.selectByVisibleText("Price (low to high)");
                break;
            case "high":
                select.selectByVisibleText("Price (high to low)");
                break;
            default:
                throw new RuntimeException(" please enter valid value ");
        }
        return this;
    }
    @Step("Check the sorting option")
    public void CheckTheSort() {
        switch (Saved_option) {
            case "low":
                List<WebElement> All_Price = driver.findElements(ItemPrice);
                for (int i = 0; i < All_Price.size()-1; i++) {

                    String text1 = All_Price.get(i).getText();
                    String text1After = text1.replace("$","").trim(); // Remove "$" and trim spaces
                    double currentPrice = Double.parseDouble(text1After);//convert string value to double
                    String text2 = All_Price.get(i + 1).getText();
                    String text2After = text2.replace("$","").trim(); // Remove "$" and trim spaces
                    double theNextPrice = Double.parseDouble(text2After);//convert string value to double
                    if (currentPrice > theNextPrice) {
                        throw new RuntimeException("The sort is not correct");
                    }
                    theNextPrice = 9999;
                }
                break;
            case "high":
                All_Price = driver.findElements(ItemPrice);
                for (int i = 0; i < All_Price.size()-1; i++) {
                    String text1 = All_Price.get(i).getText();
                    String text1After = text1.replace("$","").trim(); // Remove "$" and trim spaces
                    double currentPrice = Double.parseDouble(text1After);//convert string value to double
                    String text2 = All_Price.get(i + 1).getText();
                    String text2After = text2.replace("$","").trim(); // Remove "$" and trim spaces
                    double theNextPrice = Double.parseDouble(text2After);//convert string value to double
                    if (currentPrice < theNextPrice) {
                        throw new RuntimeException("The sort is not correct");
                    }
                    theNextPrice = 0;
                }
                break;
            case "za":
                List<WebElement> productElements = driver.findElements(inventoryItemName);

                // Extract product names into a list
                List<String> productNames = new ArrayList<>();
                for (WebElement product : productElements) {
                    productNames.add(product.getText().trim()); // Get text and trim spaces
                }

                // Create a copy of the list and sort it alphabetically
                List<String> sortedProductNames = new ArrayList<>(productNames);
                Collections.sort(sortedProductNames);

                // Compare the original list with the sorted list
                if (productNames.equals(sortedProductNames)) {
                    System.out.println("Products are sorted alphabetically from A to Z.");
                } else {
                    System.out.println("Products are NOT sorted alphabetically.");
                }
                break;
            case "az":
                productElements = driver.findElements(inventoryItemName);
                // Extract product names into a list
                productNames = new ArrayList<>();
                for (WebElement product : productElements) {
                    productNames.add(product.getText().trim()); // Get text and trim spaces
                }

                // Create a copy of the list and sort it in descending order (Z to A)
                sortedProductNames = new ArrayList<>(productNames);
                sortedProductNames.sort(Collections.reverseOrder());

                // Compare the original list with the sorted list
                if (productNames.equals(sortedProductNames)) {
                    System.out.println("Products are sorted alphabetically from Z to A.");
                } else {
                    System.out.println("Products are NOT sorted alphabetically from Z to A.");
                }
                break;
        }
    }

}
