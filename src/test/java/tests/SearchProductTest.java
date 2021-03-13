package tests;

import general.BaseTest;
import general.ListenersSpree;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import pages.SearchItemPage;

import java.io.IOException;

@Listeners(ListenersSpree.class)
public class SearchProductTest extends BaseTest {

    @DataProvider(name="searchPhrases")
    public Object[][] searchPhrasesDataProvide(){
        return new Object[][]{{"ruby"}, {"apache"}};
    }

    @Test (dataProvider = "searchPhrases")
    public void searchProduct(String searchPhrases) throws InterruptedException, IOException {
        SearchItemPage searchItemPage = new SearchItemPage(driver);
        searchItemPage.searchProduct(searchPhrases);
        Assert.assertTrue(searchItemPage.areItemsFetchedAreMatchingSearchPhrase(searchPhrases));
        takeScreenshot(driver);
    }


}
