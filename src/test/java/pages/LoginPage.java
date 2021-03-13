package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends BasePage {

    @FindBy(id = "link-to-login")
    WebElement linkToLogin;
    @FindBy(id = "spree_user_email")
    private WebElement userName;
    @FindBy(css = "[type='password']")
    private WebElement password;
    @FindBy(id = "spree_user_remember_me")
    private WebElement rememberMeCheckbox;
    @FindBy(xpath = "//input[@value='Login']")
    private WebElement loginButton;
    @FindBy(xpath = "//*[text()='Logged in successfully']")
    private WebElement loginSuccessMessage;
    @FindBy(css = "input[class='btn btn-success']")
    private WebElement searchButton;
    @FindBy(linkText = "Logout")
    private WebElement logoutButton;
    @FindBy(css = "div[class='alert alert-notice']")
    private WebElement logoutSuccessMessage;

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    public void goForLogin(String email, String pwd) {
        waitForElementToLoad(By.id("link-to-login"));
        linkToLogin.click();
        userName.sendKeys(email);
        password.sendKeys(pwd);
        rememberMeCheckbox.click();
        loginButton.click();
    }

    public void goForLogout() {
        waitForElementToLoad(By.linkText("Logout"));
        logoutButton.click();
    }

    public String getLogoutSuccessMessage() {
        String successMessage = logoutSuccessMessage.getText();
        return successMessage;
    }

    public String getLoginSuccessMessage() {
        String successMessage = loginSuccessMessage.getText();
        return successMessage;
    }
}

