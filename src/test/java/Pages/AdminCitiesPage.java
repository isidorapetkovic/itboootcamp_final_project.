package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;


public class AdminCitiesPage extends BasePage {
    private By logoutButtonOnAdminCitiesPage = By.cssSelector(".btnLogout");
    private By newItemButton = By.cssSelector(".btnNewItem");
    private By editButton = By.id("edit");
    private By deleteButton = By.id("delete");
    private By searchTextPlaceholder = By.id("search");
    private By cityNamePlaceholder = By.id("name");  //Placeholder appears when creating or editing a city
    private By saveButtonModal = By.cssSelector(".btnSave");  //Button appears when creating or editing a city
    private By cityNameField = By.xpath("//*[@id=\"app\"]/div[1]/main/div/div[2]/div/div[1]/div[2]/table/tbody/tr/td[2]"); //part of the table with city names
    private By pageNumber = By.xpath("//*[@id=\"app\"]/div[1]/main/div/div[2]/div/div[1]/div[3]/div[2]");
    private By deleteButtonModal = By.cssSelector(".v-dialog .v-card__actions > button:last-child");
    private By messageAfterDeletingCity = By.xpath("//*[@id=\"app\"]/div[1]/main/div/div[2]/div/div[3]/div/div/div/div/div[1]");
    private By messageWhenCityIsCreated = By.cssSelector(".success .v-snack__content");
    private By messageWhenCityIsEdited = By.xpath("//*[@id='app']/div[1]/main/div/div[2]/div/div[3]/div/div/div/div/div[1]");


    public AdminCitiesPage(WebDriver driver, WebDriverWait wait) {
        super(driver, wait);
    }

    public WebElement logoutButtonWebElement() {
        return getDriver().findElement(logoutButtonOnAdminCitiesPage);
    }

    public WebElement newItemButtonWebElement() {
        return getDriver().findElement(newItemButton);
    }

    public WebElement editButtonWebElement() {
        return getDriver().findElement(editButton);
    }

    public WebElement deleteButtonWebElement() {
        return getDriver().findElement(deleteButton);
    }

    public WebElement searchTextPlaceholderWebElement() {
        return getDriver().findElement(searchTextPlaceholder);
    }

    public WebElement cityNamePlaceholderWebElement() {
        return getDriver().findElement(cityNamePlaceholder);
    }

    public WebElement saveButtonModalWebElement() {
        return getDriver().findElement(saveButtonModal);
    }

    public WebElement cityNameFieldWebElement() {
        return getDriver().findElement(cityNameField);
    }

    public WebElement pageNumberWebElement() {
        return getDriver().findElement(pageNumber);
    }

    public WebElement deleteButtonModalWebElement() {
        return getDriver().findElement(deleteButtonModal);
    }

    public WebElement messageAfterDeletingCityWebElement() {
        return getDriver().findElement(messageAfterDeletingCity);
    }

    public WebElement messageWhenCityIsEditedWebElement() {
        return getDriver().findElement(messageWhenCityIsEdited);
    }

    public WebElement messageWhenCityIsCreatedWebElement() {
        return getDriver().findElement(messageWhenCityIsCreated);
    }


}


