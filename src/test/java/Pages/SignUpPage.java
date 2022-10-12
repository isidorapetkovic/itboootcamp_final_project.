package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;


public class SignUpPage extends BasePage {
    private By nameOnSignUpPage = By.id("name");
    private By emailSignUpPage = By.id("email");
    private By passwordSignUpPage = By.id("password");
    private By confirmPassword = By.id("confirmPassword");
    private By signMeUpButton = By.xpath("//*[@id=\"app\"]/div/main/div/div[2]/div/div/div[2]/span/form/div/div[5]/button/span");
    private By messageWhenEmailAlreadyExists = By.xpath("//*[@id=\"app\"]/div[1]/main/div/div[2]/div/div/div[3]/div/div/div/div/div[1]/ul/li");
    private By verifyMessage = By.xpath("//*[@id=\"app\"]/div[4]/div/div/div[1]"); //message appears when succesfully signed

    public SignUpPage(WebDriver driver, WebDriverWait wait) {
        super(driver, wait);
    }

    public WebElement nameSignUpPageWebElement() {
        return getDriver().findElement(nameOnSignUpPage);
    }

    public WebElement emailSignUpPageWebElement() {
        return getDriver().findElement(emailSignUpPage);
    }

    public WebElement passwordSignUpPageWebElement() {
        return getDriver().findElement(passwordSignUpPage);
    }

    public WebElement confirmPasswordWebElement() {
        return getDriver().findElement(confirmPassword);
    }

    public WebElement signMeUpButtonWebElement() {
        return getDriver().findElement(signMeUpButton);
    }

    public WebElement messageWhenEmailAlreadyExistsWebElement() {
        return getDriver().findElement(messageWhenEmailAlreadyExists);}

    public WebElement verifyMessageWebElement() {
        return getDriver().findElement(verifyMessage);
    }

    public void SignUp(String name, String email, String password, String confirmPassword) {
        nameSignUpPageWebElement().sendKeys(name);
        emailSignUpPageWebElement().sendKeys(email);
        passwordSignUpPageWebElement().sendKeys(password);
        confirmPasswordWebElement().sendKeys(confirmPassword);
        signMeUpButtonWebElement().click();
        getDriver().manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
    }
}

