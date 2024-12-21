package testcases;

import Base.BaseTest;
import Pages.LoginPage;
import Pages.ProductListPage;
import Utils.usersUtils;
import io.qameta.allure.Description;
import io.qameta.allure.Feature;
import io.qameta.allure.testng.AllureTestNg;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;


@Feature("2- Product List Feature")
public class ProductListTest extends BaseTest {

    @Test(description = "Add one product to cart")
    @Description("user can add product to the cart ")
    public void userCanAddProductToCart() throws InterruptedException {
    LoginPage loginPage = new LoginPage(driver);
    loginPage.load()
            .login(usersUtils.getValid_user(),usersUtils.get_pass())
            .clickOnButton();
    ProductListPage PLP = new ProductListPage(driver);
    PLP.AddProductToCart();
    Thread.sleep(2000);
    }


    @Test(description = "Add all products to cart")
    @Description("user can add all products in the cart")
    public void userCanAddAllProductsToCart() throws InterruptedException {
        LoginPage loginPage = new LoginPage(driver);

        loginPage.load()
                .login(usersUtils.getValid_user(), usersUtils.get_pass())
                .clickOnButton();
        ProductListPage productListPage = new ProductListPage(driver);
        productListPage.AddAllProductsToCart();
    }


    @Test(description = "Remove one product")
    @Description("user can remove one product from the cart")
    public void userCanRemoveItemFromPLP() throws InterruptedException {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.load()
                .login(usersUtils.getValid_user(),usersUtils.get_pass())
                .clickOnButton();
        ProductListPage plp = new ProductListPage(driver);
        plp.AddProductToCart();
        plp.ClickToRemove();
    }

    @Test(description = "Removing all products")
    @Description("verify the functionality of adding all products to the cart and clearing the cart entirely")
    public void userCanRemoveAllItemFromPLP() throws InterruptedException {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.load()
                .login(usersUtils.getValid_user(),usersUtils.get_pass())
                .clickOnButton();
        ProductListPage PLP = new ProductListPage(driver);
        PLP.AddAllProductsToCart()
                .RemoveAllProductsFromPLP();
    }
    @Test(description = "Sorting products option")
    @Description("ensure the sorting option triggers a change in product arrangement")
    public void userCanSortingProducts() throws InterruptedException {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.load()
                .login(usersUtils.getValid_user(),usersUtils.get_pass())
                .clickOnButton();
        ProductListPage PLP = new ProductListPage(driver);
        PLP.SortOptions("low");
        Thread.sleep(3000);
    }
    @Test(description = "verify that the sorting option displays products in the correct order")
    public void TheSortingProductsAreSortingCorrectlyValue() throws InterruptedException {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.load()
                .login(usersUtils.getValid_user(),usersUtils.get_pass())
                .clickOnButton();
        ProductListPage plp = new ProductListPage(driver);
        plp.SortOptions("high").CheckTheSort();
        Thread.sleep(1500);

    }
}