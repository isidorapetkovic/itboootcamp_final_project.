package Tests;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class AdminCitiesTests extends BaseTest {
    String nameOfTheCity = "";
    String edit = "";

    @BeforeClass
    public void setupBeforeAdminCitiesTests() {
        nameOfTheCity = super.faker.address().cityName();
        edit = nameOfTheCity + "-edited";
    }

    @BeforeMethod
    public void setupBeforeTest() {
        super.setupBeforeTest();
        homePage.loginButtonOnHomePageWebElement().click();
        loginPage.loginWithValidCredentials();
        homePage.clickAdminButtonAndNavigateToCities();
    }

    @Test
    public void visitsTheAdminCitiesPageAndListCities() {
        /* Data:
        admin email: admin@admin.com
        admin password: 12345
        assert:
        Verify that the /admin/cities route appears in the url of the page
        Verify the existence of the logout button */

        String expectedResultAdminCities = "https://vue-demo.daniel-avellaneda.com/admin/cities";
        String actualResultAdminCities = adminCitiesPage.getDriver().getCurrentUrl();
        Assert.assertEquals(actualResultAdminCities, expectedResultAdminCities);

        Boolean expectedResultLogoutButton = true;
        Boolean actualResultLogoutButton = adminCitiesPage.logoutButtonWebElement().isDisplayed();
        Assert.assertEquals(actualResultLogoutButton, expectedResultLogoutButton);
    }

    @Test
    public void createNewCity() throws InterruptedException {
        /* Data: random city created using the Faker library
        assert:
        Verify that the message contains text: Saved successfully */

        adminCitiesPage.newItemButtonWebElement().click();
        adminCitiesPage.cityNamePlaceholderWebElement().sendKeys(nameOfTheCity);
        adminCitiesPage.saveButtonModalWebElement().click();
        Thread.sleep(3000); //did not work with waits
        String expectedResult = "Saved successfully";
        String actualResult = adminCitiesPage.messageWhenCityIsCreatedWebElement().getText();
        Assert.assertTrue(actualResult.contains(expectedResult));

    }

    @Test(dependsOnMethods = {"createNewCity"})
    public void editCity() {
        /* Data:Edit city created in test #2 to the same name  + - edited
        (example: Belgrade –edited)
        assert:
        Verify that the message contains text: Saved successfully */

        adminCitiesPage.searchTextPlaceholderWebElement().click();
        adminCitiesPage.searchTextPlaceholderWebElement().sendKeys(nameOfTheCity);
        adminCitiesPage.editButtonWebElement().click();
        adminCitiesPage.cityNamePlaceholderWebElement().sendKeys("-edited");
        adminCitiesPage.saveButtonModalWebElement().click();
        wait.until(ExpectedConditions.textToBe(By.xpath("//*[@id='app']/div[1]/main/div/div[2]/div/div[3]/div/div/div/div/div[1]"), "Saved successfully\nCLOSE"));

        String expectedResult = "Saved successfully";
        String actualResult = adminCitiesPage.messageWhenCityIsEditedWebElement().getText();
        Assert.assertTrue((actualResult.contains(expectedResult)));
    }

    @Test(dependsOnMethods = {"createNewCity", "editCity"})
    public void searchCity() {
        /* Data: edited city created in test #3
        assert:
        Verify that in Name column in the first row contains the text from the search */

        adminCitiesPage.searchTextPlaceholderWebElement().click();
        adminCitiesPage.searchTextPlaceholderWebElement().sendKeys(edit);
        wait.until(ExpectedConditions.numberOfElementsToBe(By.xpath("//*[@id=\"app\"]/div[1]/main/div/div[2]/div/div[1]/div[2]/table/tbody/tr"), 1));
        String actualResultColumnNumber = adminCitiesPage.pageNumberWebElement().getText();
        String expectedResultColumnNumber = "1 - 1 of 1";
        Assert.assertEquals(actualResultColumnNumber, expectedResultColumnNumber);

        String actualResultEditedCity = adminCitiesPage.cityNameFieldWebElement().getText();
        String expectedResultEditedCity = edit;
        Assert.assertEquals(actualResultEditedCity, expectedResultEditedCity);
    }

    @Test(dependsOnMethods = {"createNewCity", "editCity", "searchCity"})
    public void deleteCity() {
        /* Data: edited city from test #3
         assert:
         Enter the name of the city before editing in the search field
         Wait until the number of rows in the table is 1
         Verify that there is text from the search in the Name column of the first row
         Click on the Delete button from the first row
         Wait for the delete dialog to appear
         Click on the Delete button from the dialog
         Wait for the message display popup to be visible
         Verify that the message contains text Deleted successfully */

        adminCitiesPage.searchTextPlaceholderWebElement().click();
        adminCitiesPage.searchTextPlaceholderWebElement().sendKeys(nameOfTheCity);
        wait.until(ExpectedConditions.numberOfElementsToBe(By.xpath("//*[@id=\"app\"]/div[1]/main/div/div[2]/div/div[1]/div[2]/table/tbody/tr"), 1));
        String actualResultColumnNumber = adminCitiesPage.pageNumberWebElement().getText();
        String expectedResultColumnNumber = "1 - 1 of 1";
        Assert.assertEquals(actualResultColumnNumber, expectedResultColumnNumber);

        String actualResultEditedCity = adminCitiesPage.cityNameFieldWebElement().getText();
        String expectedResultEditedCity = edit;
        Assert.assertEquals(actualResultEditedCity, expectedResultEditedCity);

        adminCitiesPage.deleteButtonWebElement().click();
        wait.until(ExpectedConditions.attributeContains(adminCitiesPage.deleteButtonModalWebElement(), "type", "button"));
        adminCitiesPage.deleteButtonModalWebElement().click();
        wait.until(ExpectedConditions.textToBe(By.xpath("//*[@id=\"app\"]/div[1]/main/div/div[2]/div/div[3]/div/div/div/div/div[1]"), "Deleted successfully\nCLOSE"));
        String actualResultMessage = adminCitiesPage.messageAfterDeletingCityWebElement().getText();
        String expectedResultMessage = "Deleted successfully";
        Assert.assertTrue(actualResultMessage.contains(expectedResultMessage));

    }
}


