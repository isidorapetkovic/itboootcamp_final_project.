package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SignUpPage extends BasePage{
    private By nameFieldsp= By.id("name");
    private By emailsp=By.id("email");
    private By passwordsp=By.id("password");
    private By confirmPasswordsp = By.id("confirmPassword");
    private By signMeUpBtn = By.xpath("//*[@id=\"app\"]/div/main/div/div[2]/div/div/div[2]/span/form/div/div[5]/button/span");
    //*[@id="app"]/div/main/div/div[2]/div/div/div[2]/span/form/div/div[1]/span/div/div]
    public SignUpPage (WebDriver driver) {
        super(driver);
    }

    public By getNameFieldsp() {
        return nameFieldsp;
    }
   public By getEmailsp() {
        return emailsp;
    }
    public WebElement getEmailspdWebElement () {
        return getDriver().findElement(emailsp);
    }

    public By getPasswordsp() {
        return passwordsp;
    }
    public WebElement getPasswordspdWebElement () {
        return getDriver().findElement(passwordsp);
    }


    public By getConfirmPasswordsp() {
        return confirmPasswordsp;
    }
    public WebElement getConfirmPasswordspdWebElement () {
        return getDriver().findElement(confirmPasswordsp);
    }

    public WebElement getSignMeUpBtn() {
        return getDriver().findElement(signMeUpBtn);
    }
  public void loginSignup(String name, String email,String password, String confirmPassword) {
        WebElement nameFieldsp= getDriver().findElement(getNameFieldsp());
        nameFieldsp.sendKeys(name);
        WebElement emailsp= getDriver().findElement(getEmailsp());
        emailsp.sendKeys(email);
        WebElement passwordsp= getDriver().findElement(getPasswordsp());
        passwordsp.sendKeys(password);
        WebElement confirmPasswordsp= getDriver().findElement(getConfirmPasswordsp());
        confirmPasswordsp.sendKeys(confirmPassword);
        WebElement signUpBtn=getSignMeUpBtn();
        signUpBtn.click();

    }


}

