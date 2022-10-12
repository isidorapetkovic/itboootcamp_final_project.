package Pages;


import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;


public class ProfilePage extends BasePage {
    private By nameOnProfilePage = By.id("name");
    private By phone = By.id("phone");
    private By cityOnProfilePage = By.id("city");
    private By countryOnProfilePage = By.id("country");
    private By twitterOnProfilePage = By.id("urlTwitter");
    private By gitHub = By.id("urlGitHub");
    private By saveButtonOnProfilePage = By.cssSelector(".btnSave");
    private By snackBarMessage = By.xpath("//*[@id=\"app\"]/div[1]/main/div/div[2]/div/div/div[4]/div/div/div/div/div[1]"); //appears after clicking saveButtonOnProfilePage

    public ProfilePage(WebDriver driver, WebDriverWait wait) {
        super(driver, wait);
    }

    public WebElement nameOnProfilePageWebElement() {
        return getDriver().findElement(nameOnProfilePage);
    }

    public WebElement phoneWebElement() {
        return getDriver().findElement(phone);
    }

    public WebElement cityOnProfilePageWebElement() {
        return getDriver().findElement(cityOnProfilePage);
    }

    public WebElement countryOnProfilePageWebElement() {
        return getDriver().findElement(countryOnProfilePage);
    }

    public WebElement twitterOnProfilePageWebElement() {
        return getDriver().findElement(twitterOnProfilePage);
    }

    public WebElement gitHubWebElement() {
        return getDriver().findElement(gitHub);
    }

    public WebElement saveButtonOnProfilePageWebElement() {
        return getDriver().findElement(saveButtonOnProfilePage);
    }

    public WebElement snackBarMessageWebElement() {
        return getDriver().findElement(snackBarMessage);
    }


    public void createProfile(String name, String phone, String country, String city, String twitter, String gitHub) throws InterruptedException {

        nameOnProfilePageWebElement().sendKeys(Keys.COMMAND + "A", Keys.DELETE);
        Thread.sleep(1000);
        nameOnProfilePageWebElement().sendKeys(name);

        phoneWebElement().sendKeys(Keys.COMMAND + "A", Keys.DELETE);
        Thread.sleep(1000);
        phoneWebElement().sendKeys(phone);

        cityOnProfilePageWebElement().sendKeys(Keys.COMMAND + "A", Keys.DELETE);
        Thread.sleep(1000);
        cityOnProfilePageWebElement().sendKeys(city);

        countryOnProfilePageWebElement().sendKeys(Keys.COMMAND + "A", Keys.DELETE);
        Thread.sleep(1000);
        countryOnProfilePageWebElement().sendKeys(country);

        twitterOnProfilePageWebElement().sendKeys(Keys.COMMAND + "A", Keys.DELETE, twitter);
        Thread.sleep(1000);
        twitterOnProfilePageWebElement().sendKeys(twitter);

        gitHubWebElement().sendKeys(Keys.COMMAND + "A", Keys.DELETE, gitHub);
        Thread.sleep(1000);
        gitHubWebElement().sendKeys(gitHub);
        Thread.sleep(2000);
    }
}

