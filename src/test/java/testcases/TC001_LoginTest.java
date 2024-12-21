package testcases;

import Base.BaseTest;
import Pages.LoginPage;
import Utils.usersUtils;
import io.qameta.allure.Description;
import io.qameta.allure.Feature;
import org.testng.Assert;
import org.testng.annotations.Test;

@Feature("1- Login Feature")
public class TC001_LoginTest extends BaseTest {
    @Test(description = "user login with valid conditions")
    @Description("user can login with valid email and password")
    public void userCanLoginWithValidConditions() throws InterruptedException {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.load()
                .login(usersUtils.getValid_user()
                        ,usersUtils.get_pass())
                .clickOnButton();
        Assert.assertTrue(loginPage.CheckUserLoginState());
    }
    @Test(description = "user can't login with locked Account")
    @Description("user can't login with locked Account")
    public void LoginWithLockedOutUser() throws InterruptedException {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.load()
                .login(usersUtils.getLocked_out_user()
                        , usersUtils.get_pass())
                .clickOnButton();
        Assert.assertTrue(loginPage.ErrorMessageAssertion());

    }

    @Test(description = "user login with Problem Account")
    @Description("user facing the same image into all product when he login with ProblemAccount")
    public void LoginWithProblemUser() throws InterruptedException {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.load().
                login(usersUtils.getProblem_user()
                        , usersUtils.get_pass())
                .clickOnButton();
        Thread.sleep(1200);


    }
    @Test(description = "user can log out from account ")
    @Description("user can log out form his account successfully")
    public void userCanLogoutFromAccount() throws InterruptedException {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.load().login(usersUtils.getValid_user(),usersUtils.get_pass())
                .clickOnButton()
                .logout();
    }
}
