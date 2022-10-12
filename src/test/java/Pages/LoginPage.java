package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;


public class LoginPage extends BasePage {
    private By emailOnLoginPage = By.id("email");
    private By passwordOnLoginPage = By.id("password");
    private By loginButtonOnLoginPage = By.xpath("//*[@id=\"app\"]/div[1]/main/div/div[2]/div/div/div[3]/span/form/div/div[3]/button/span");
    private By logoutButtonOnLoginPage = By.xpath("//*[@id=\"app\"]/div[1]/div/header/div/div[3]/button[2]/span");
    private By messageWhenUserDoesNotExist = By.xpath("//*[@id=\"app\"]/div[1]/main/div/div[2]/div/div/div[4]/div/div/div/div/div[1]/ul/li");
    private By messageWhenPasswordIsWrong = By.xpath("//*[@id=\"app\"]/div[1]/main/div/div[2]/div/div/div[4]/div/div/div/div/div[1]/ul/li");

    public LoginPage(WebDriver driver, WebDriverWait wait) {
        super(driver, wait);
    }

    public WebElement emailOnLoginPageWebElement() {
        return getDriver().findElement(emailOnLoginPage);
    }

    public WebElement passwordOnLoginPageWebElement() {
        return getDriver().findElement(passwordOnLoginPage);
    }

    public WebElement loginButtonOnLoginPageWebElement() {
        return getDriver().findElement(loginButtonOnLoginPage);
    }

    public WebElement logoutButtonOnLoginPageWebElement() {
        return getDriver().findElement(logoutButtonOnLoginPage);
    }

    public WebElement messageWhenUserDoesNotExistWebElement() {
        return getDriver().findElement(messageWhenUserDoesNotExist);
    }

    public WebElement messageWhenPasswordIsWrongWebElement() {
        return getDriver().findElement(messageWhenPasswordIsWrong);
    }

    public void login(String email, String password) {
        emailOnLoginPageWebElement().sendKeys(email);
        passwordOnLoginPageWebElement().sendKeys(password);
        loginButtonOnLoginPageWebElement().click();
        getDriver().manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

    }

    public void loginWithValidCredentials() {
        login("admin@admin.com", "12345");
    }

}
