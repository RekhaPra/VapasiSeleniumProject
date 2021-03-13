package tests;

import general.BaseTest;
import general.ListenersSpree;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import pages.LoginPage;

import java.io.IOException;

@Listeners(ListenersSpree.class)
public class LoginAndLogoutTest extends BaseTest {

    String email = "rekhi.ibt@gmail.com";
    String password = "thana*123";

    @Test(priority = 1)
    public void Login() throws IOException {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.goForLogin(email, password);
        String message = loginPage.getLoginSuccessMessage();
        Assert.assertEquals(message, "Logged in successfully");
        takeScreenshot(driver);

    }

    @Test(priority = 2)
    public void Logout() throws IOException {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.goForLogout();
        String message = loginPage.getLogoutSuccessMessage();
        Assert.assertEquals(message, "Signed out successfully.");
        takeScreenshot(driver);
    }

}
