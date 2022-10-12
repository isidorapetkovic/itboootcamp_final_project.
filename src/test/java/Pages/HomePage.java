package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;


public class HomePage extends BasePage {
    private By loginButtonOnHomePage = By.xpath("//*[@id=\"app\"]/div/div/header/div/div[3]/a[3]");
    private By signUpButtonOnHomePage = By.xpath("//*[@id=\"app\"]/div/div/header/div/div[3]/a[4]");
    private By adminButtonOnHomePage = By.cssSelector(".btnAdmin");
    private By languageButton = By.className("btnLocaleActivation");
    private By buttonEnglish = By.cssSelector(".btnEN");  //buttonEnglish displays after clicking languageButton
    private By buttonEspanol = By.cssSelector(".btnES");  //buttonEspanol displays after clicking languageButton
    private By buttonFrench = By.cssSelector(".btnFR");  //buttonFrench displays after clicking languageButton
    private By messageAfterChoosingLanguage = By.xpath("//*[@id=\"app\"]/div[1]/main/div/div[2]/div/div[1]/div[1]/h1");
    private By profileButtonOnHomePage = By.xpath("//*[@id=\"app\"]/div[1]/div/header/div/div[3]/a[3]/span");
    private By cities = By.cssSelector(".btnAdminCities"); //button cities displays after clicking adminButton


    public HomePage(WebDriver driver, WebDriverWait wait) {
        super(driver, wait);
    }

    public WebElement loginButtonOnHomePageWebElement() {
        return getDriver().findElement(loginButtonOnHomePage);
    }

    public WebElement signUpButtonOnHomePageWebElement() {
        return getDriver().findElement(signUpButtonOnHomePage);
    }

    public WebElement adminButtonOnHomePageWebElement() {
        return getDriver().findElement(adminButtonOnHomePage);
    }

    public WebElement languageButtonWebElement() {
        return getDriver().findElement(languageButton);
    }

    public WebElement buttonEnglishWebElement() {
        return getDriver().findElement(buttonEnglish);
    }

    public WebElement buttonEspanolWebElement() {
        return getDriver().findElement(buttonEspanol);
    }

    public WebElement buttonFrenchWebElement() {
        return getDriver().findElement(buttonFrench);
    }

    public WebElement menuWebElement() {
        return getDriver().findElement(messageAfterChoosingLanguage);
    }

    public WebElement profileButtonOnHomePageWebElement() {
        return getDriver().findElement(profileButtonOnHomePage);
    }

    public WebElement citiesButtonWebElement() {
        return getDriver().findElement(cities);
    }

    public void clickAdminButtonAndNavigateToCities() {
        adminButtonOnHomePageWebElement().click();
        citiesButtonWebElement().click();
        getDriver().manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
    }

}

