package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;

import java.util.List;

public class HomePage extends BasePage {

    @FindBy(css = ".alert.alert-info")
    WebElement cartEmptyMessage;
    @FindBy(css = ".glyphicon.glyphicon-minus-sign")
    WebElement deleteProductFromCartButton;
    @FindBy(css = "#keywords")
    WebElement searchKeyword;
    @FindBy(css = "#quantity")
    WebElement quantity;
    @FindBy(css = "#add-to-cart-button")
    WebElement addToCartButton;
    @FindBy(css = "#checkout-link")
    WebElement checkOutLinkButton;
    @FindBy(css = "#summary-order-total")
    WebElement summaryOrderTotal;
    @FindBy(id = "link-to-login")
    private WebElement loginButton;
    @FindBy(linkText = "Logout")
    private WebElement logoutButton;
    @FindBy(linkText = "My Account")
    private WebElement myAccountButton;
    @FindBy(css = "a[class='list-group-item active']")
    private WebElement bagsHeader;
    @FindBy(xpath = "//input[@id='Price_Range_$15.00_-_$18.00']")
    private WebElement priceTag;
    @FindBy(css = "input[class='btn btn-primary']")
    private WebElement filterSearchButton;
    @FindBys(@FindBy(css = "span[class='price selling lead']"))
    private List<WebElement> bagsProducts;
    @FindBy(css = "input[class='btn btn-success']")
    private WebElement searchButton;

    public HomePage(WebDriver driver) {
        super(driver);
    }

    public void open() {
        driver.get("https://spree-vapasi.herokuapp.com/");
    }

    // public void loginFromHomePage() {
    //    loginButton.click();
    // }

    // public void logOutFromHomePage() {
    //   logoutButton.click();
    // }

    public void selectCategory(String categorySearchText) {
        WebElement categoryName = driver.findElement(By.linkText(categorySearchText));
        categoryName.click();
        By activeCategory = By.cssSelector(".list-group-item.active");
        waitForElementToLoad(activeCategory);
    }

    public void filterUsingPriceRange(String priceRange) {
        //
        //WebElement priceRangeCriteria= driver.findElement(By.xpath("//div[@class='navigation']/ul/li/input[@value='"+priceRange+"']"));
        priceTag.click();
        filterSearchButton.click();
    }

    public boolean areAllProductsDisplayedInPriceRange(String priceRange) {

        String subStringLowerEnd = priceRange.substring(1, 6);//$15.00
        String subStringUpperEnd = priceRange.substring(10, 15);
        double lowerEndNumber = Double.parseDouble(subStringLowerEnd);
        double upperEndNumber = Double.parseDouble(subStringUpperEnd);

        for (int i = 0; i < bagsProducts.size(); i++) {
            String s = bagsProducts.get(i).getAttribute("content");
            //System.out.println(s);
            double d = Double.parseDouble(s);
            //System.out.println(d);
            if (!(d >= lowerEndNumber || d <= upperEndNumber)) {
                return false;
            }

        }
        return true;
    }

    public boolean isCartEmpty(String expectedCartEmptyMessage) {
        String actualCartEmptyMessage = cartEmptyMessage.getText();
        if (!(actualCartEmptyMessage.equals(expectedCartEmptyMessage))) {
            return false;
        }
        return true;
    }

    public void removeProductFromCart(String productName) {
        deleteProductFromCartButton.click();

    }

    public void addProductToCart(String productName, String numberOfTimesToAddTheProduct) {
        waitForElementToLoad(By.cssSelector("#keywords"));
        searchKeyword.sendKeys(productName);
        searchButton.click();
        driver.findElement(By.cssSelector("img[alt='" + productName + "']")).click();
        quantity.clear();
        quantity.sendKeys(numberOfTimesToAddTheProduct);
        addToCartButton.click();

    }

    public void searchProductAndAddToCart(String productName) {
        waitForElementToLoad(By.cssSelector("#keywords"));
        searchKeyword.sendKeys(productName);
        searchButton.click();
        driver.findElement(By.cssSelector("img[alt='" + productName + "']")).click();
        addToCartButton.click();
        checkOutLinkButton.click();
    }

    public boolean isOrderSummaryTotalCorrect(String expectedOrderTotal) {
        String actualSummaryTotal = summaryOrderTotal.getText();
        if (!(actualSummaryTotal.equals(expectedOrderTotal))) {
            return false;
        }
        return true;
    }
}


