package Tests;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Test;


public class AuthRoutesTests extends BaseTest {
    @Test
    public void forbidsVisitsToHomeUrlIfNotAuthenticated() {
        /*Assert:
        Load the home page when the user is not logged in
        Verify that the route /login appears in the url of the page */

        driver.get("https://vue-demo.daniel-avellaneda.com/home");
        String expectedResult = "https://vue-demo.daniel-avellaneda.com/login";
        wait.until(ExpectedConditions.urlMatches(expectedResult));
        String actualResult = loginPage.getDriver().getCurrentUrl();
        Assert.assertEquals(actualResult, expectedResult);
    }

    @Test
    public void forbidsVisitsToProfileUrlIfNotAuthenticated() {
        /* Assert:
        Load the profile page when the user is not logged in
        Verify that the route /login appears in the url of the page */

        driver.get("https://vue-demo.daniel-avellaneda.com/profile");
        String expectedResult = "https://vue-demo.daniel-avellaneda.com/login";
        wait.until(ExpectedConditions.urlMatches(expectedResult));
        String actualResult = loginPage.getDriver().getCurrentUrl();
        Assert.assertEquals(actualResult, expectedResult);
    }

    @Test
    public void forbidsVisitsToAdminCitiesUrlIfNotAuthenticated() {
        /* Assert:
        Load the admin/cities page when the user is not logged in
        Verify that the route /login appears in the url of the page */

        driver.get("https://vue-demo.daniel-avellaneda.com/admin/cities");
        String expectedResult = "https://vue-demo.daniel-avellaneda.com/login";
        wait.until(ExpectedConditions.urlMatches(expectedResult));
        String actualResult = loginPage.getDriver().getCurrentUrl();
        Assert.assertEquals(actualResult, expectedResult);
    }

    @Test
    public void forbidsVisitsToAdminUsersUrlIfNotAuthenticated() {
         /* Assert:
        Load the admin/users page when the user is not logged in
        Verify that the route /login appears in the url of the page */

        driver.get("https://vue-demo.daniel-avellaneda.com/admin/users");
        String expectedResult = "https://vue-demo.daniel-avellaneda.com/login";
        wait.until(ExpectedConditions.urlMatches(expectedResult));
        String actualResult = loginPage.getDriver().getCurrentUrl();
        Assert.assertEquals(actualResult, expectedResult);
    }
}
