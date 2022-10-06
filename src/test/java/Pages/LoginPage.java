package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebElement;

public class LoginPage extends BasePage{


    private By emailField = By.id("email");
    private By passwordField = By.id("password");

    private By loginButton2=By.xpath("//*[@id=\"app\"]/div[1]/main/div/div[2]/div/div/div[3]/span/form/div/div[3]/button/span");
    private By signUp= By.xpath("//*[@id=\"app\"]/div/div/header/div/div[3]/a[4]");

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    public By getLoginButton() {
        return loginButton2;
    }

    public By getEmailField() {
        return emailField;
    }
    public WebElement getEmailFieldWebElement () {
        return getDriver().findElement(emailField);
    }

    public By getPasswordField() {
        return passwordField;
    }

    public WebElement getPasswordFieldWebElement () {
        return getDriver().findElement(passwordField);
    }

    public By getLoginButton2() {
        return loginButton2;
    }

    public By getSignUp() {
        return signUp;
    }

    public void login (String email, String password) throws InterruptedException {
        WebElement emailField= getDriver().findElement(getEmailField());
        emailField.sendKeys(email);
        WebElement passwordField= getDriver().findElement(getPasswordField());
        passwordField.sendKeys(password);
        WebElement loginButton2= getDriver().findElement(getLoginButton2());
        loginButton2.click();
        Thread.sleep(5000);

    }

    public void clickSignUpButton() {
        WebElement signUp=getDriver().findElement(getSignUp());
        signUp.click();
    }
}
