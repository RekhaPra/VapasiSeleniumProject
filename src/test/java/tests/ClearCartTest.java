package tests;

import general.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.LoginPage;

import java.io.IOException;

public class ClearCartTest extends BaseTest {
    String email = "rekhi.ibt@gmail.com";
    String password = "thana*123";

    @Test
    public void clearCart() throws IOException {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.goForLogin(email, password);
        HomePage homePage = new HomePage(driver);
        homePage.addProductToCart("Ruby on Rails Mug", "3");
        homePage.removeProductFromCart("Ruby on Rails Mug");
        takeScreenshot(driver);
        Assert.assertTrue(homePage.isCartEmpty("Your cart is empty"), "Passed- Cart is empty.");
    }
}
