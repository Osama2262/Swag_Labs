package testcases;

import Base.BaseTest;
import Pages.CartPage;
import Pages.LoginPage;
import Pages.ProductListPage;
import Utils.usersUtils;
import io.qameta.allure.Description;
import io.qameta.allure.Feature;
import org.testng.Assert;
import org.testng.annotations.Test;


@Feature("3- Cart Feature")
public class TC003_CartTest extends BaseTest {

    @Test(description = "Remove product from cart")
    @Description("user can remove product from cart")
    public void userCanRemoveProductFromCart() throws InterruptedException {

        LoginPage loginPage =new LoginPage(driver);
        loginPage.load().login(usersUtils.getValid_user(),usersUtils.get_pass())
                .clickOnButton();
        ProductListPage plp =new ProductListPage(driver);
        plp.AddProductToCart()
                .ClickOnCartICon()
                .RemoveFormCart();
    }

    @Test(description = "Finishing Order")
    @Description("user can finish his order successfully")
    public void userCanFinishHisOrder() throws InterruptedException {
        LoginPage loginPage =new LoginPage(driver);
        loginPage.load()
                .login(usersUtils.getValid_user(),usersUtils.get_pass())
                .clickOnButton();
        ProductListPage plp =new ProductListPage(driver);
        plp.AddProductToCart()
                .ClickOnCartICon()
                .ClickOnCheckOut_button()
                .Fill_Info_CheckoutOrder()
                .continue_button()
                .finish_button()
                .CompletedMessageAssertion();
    }
    @Test(description = "Canceling order from CheckoutPage")
    @Description("user can cancel his order from CheckoutPage")
    public void userCanCancelOrderInCheckoutPage() throws InterruptedException {
        LoginPage loginPage =new LoginPage(driver);
        loginPage.load()
                .login(usersUtils.getValid_user(),usersUtils.get_pass())
                .clickOnButton();
        ProductListPage plp =new ProductListPage(driver);
        plp.AddProductToCart()
                .ClickOnCartICon()
                .ClickOnCheckOut_button()
                .Fill_Info_CheckoutOrder()
                .continue_button()
                .cancellingOrder();
        Assert.assertTrue(loginPage.CheckUserLoginState());
    }
    @Test(description = " Calculate the product price")
    @Description("The website display the correct total price for all products")
    public void theWebsiteCalculateCorrectPrice() throws InterruptedException {
        CartPage cartPage = new CartPage(driver);
        LoginPage loginPage =new LoginPage(driver);
        loginPage.load()
                .login(usersUtils.getValid_user(),usersUtils.get_pass())
                .clickOnButton();
        ProductListPage plp =new ProductListPage(driver);
       plp.AddAllProductsToCart();
       cartPage.ClickOnCartICon()
               .ClickOnCheckOut_button()
               .Fill_Info_CheckoutOrder()
               .continue_button()
               .calculateAndCheckAllPrices();

    }
    @Test(description ="Functional continue shopping ")
    @Description("user can go back to the PLP and continue adding products to the cart by clicking on the 'continue shopping' button")
    public void userCanContinuesAddingProductFromCartPage() throws InterruptedException {
        LoginPage loginPage =new LoginPage(driver);
        loginPage.load().login(usersUtils.getValid_user(),usersUtils.get_pass())
                .clickOnButton();
        ProductListPage plp =new ProductListPage(driver);
        plp.AddProductToCart()
                .ClickOnCartICon()
                .ContinueShopping()
                .AddOneMoreItem();
    }

}
