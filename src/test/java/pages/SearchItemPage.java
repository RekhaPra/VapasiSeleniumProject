package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;

import java.util.List;

public class SearchItemPage extends BasePage {

    @FindBy(id = "keywords")
    private WebElement searchField;

    @FindBy(css = "input[class='btn btn-success']")
    private WebElement searchButton;

    @FindBy(className = "search-results-title")
    private WebElement searchTitle;

    @FindBys(@FindBy(css = "#products"))
    private List<WebElement> searchItems;

    public SearchItemPage(WebDriver driver) {
        super(driver);
    }

    public void searchProduct(String searchPhrase) throws InterruptedException {
        System.out.println("Search item name: " + searchPhrase);
        searchField.clear();
        searchField.sendKeys(searchPhrase);
        searchButton.click();
        waitForElementToLoad(By.cssSelector(".search-results-title"));
       // Thread.sleep(1000);
    }

    public boolean areItemsFetchedAreMatchingSearchPhrase(String searchPhrase) {
        for (WebElement product : searchItems) {
            WebElement productNameElement = product.findElement(By.cssSelector("[itemprop='name']"));
            String productName = productNameElement.getText().trim();
            if ((productName.toLowerCase()).contains((searchPhrase.toLowerCase()))) return true;
        }
        return false;
    }

    public void clearSearchField()
    {
        searchField.clear();
    }



}





