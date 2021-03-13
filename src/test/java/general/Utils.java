package general;

import com.google.common.io.Files;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import java.io.File;
import java.io.IOException;
import java.util.Date;

public class Utils {

    String CHROME_KEY = "webdriver.chrome.driver";
    String CHROME_VALUE = "/Users/rekhag/Desktop/chromedriver";
    String TEST_URL = "https://spree-vapasi.herokuapp.com";

    public void takeScreenshot(WebDriver driver) throws IOException {
        Date d = new Date();
        TakesScreenshot ts = (TakesScreenshot) driver;
        File srcFile = ts.getScreenshotAs(OutputType.FILE);
        File destFile = new
                File("/Users/rekhag/IdeaProjects/spreeproject/src/main/java/screenshots/" + d +
                "_screenshot.png");
        Files.copy(srcFile,destFile);
    }
}
