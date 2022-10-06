package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class HomePage extends BasePage{
    private By loginButton = By.xpath("//*[@id=\"app\"]/div/div/header/div/div[3]/a[3]");

    public HomePage(WebDriver driver) {
        super(driver);

    }

    public By getLoginButton() {
        return loginButton;
    }

    public void setLoginButton(By loginButton) {
        this.loginButton = loginButton;
    }

    public void clickLoginButton() {
        WebElement loginButton= getDriver().findElement(getLoginButton());
        loginButton.click();
    }
}
