package tests;

import general.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.LoginPage;
import pages.SearchItemPage;

public class AddToCartAndValidateOrderAmountTest extends BaseTest {
    String email = "rekhi.ibt@gmail.com";
    String password = "thana*123";

    @Test
    public void addToCartAndValidateOrderAmount() throws InterruptedException {

        LoginPage loginPage = new LoginPage(driver);
        loginPage.goForLogin(email, password);
        HomePage homePage = new HomePage(driver);
        homePage.searchProductAndAddToCart("Ruby on Rails Mug");
        Assert.assertTrue(homePage.isOrderSummaryTotalCorrect("$13.99"));
    }

}
