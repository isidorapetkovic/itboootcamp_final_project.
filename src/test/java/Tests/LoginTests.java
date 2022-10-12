package Tests;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Test;


public class LoginTests extends BaseTest {
    @Test
    public void checkLogin() {
        //Verify that the route /login appears in the url of the page

        homePage.loginButtonOnHomePageWebElement().click();
        String expectedResult = "https://vue-demo.daniel-avellaneda.com/login";
        String actualResult = loginPage.getDriver().getCurrentUrl();
        Assert.assertEquals(actualResult, expectedResult);
    }

    @Test
    public void checksInputTypes() {
        /* Verify that the email input field for the type attribute has the value email
        Verify that the password input field for the type attribute has the value password */

        homePage.loginButtonOnHomePageWebElement().click();
        String expectedResultEmail = "email";
        String actualResultEmail = loginPage.emailOnLoginPageWebElement().getAttribute("type");
        Assert.assertEquals(actualResultEmail, expectedResultEmail);

        homePage.loginButtonOnHomePageWebElement().click();
        String expectedResultPassword = "password";
        String actualResultPassword = loginPage.passwordOnLoginPageWebElement().getAttribute("type");
        Assert.assertEquals(actualResultPassword, expectedResultPassword);
    }

    @Test
    public void displaysErrorsWhenUserDoesNotExist() {
       /* Data: random email and password created using faker library assert:
        Verify that the error contains the message: User does not exist
        Verify that the /login route appears in the url of the page */

        homePage.loginButtonOnHomePageWebElement().click();
        String email = faker.internet().emailAddress();
        String password = faker.internet().password();
        loginPage.login(email, password);
        String expectedResultMessage = "User does not exists";
        String actualResultMessage = loginPage.messageWhenUserDoesNotExistWebElement().getText();
        Assert.assertEquals(actualResultMessage, expectedResultMessage);

        String expectedResultLogin = "https://vue-demo.daniel-avellaneda.com/login";
        String actualResultLogin = loginPage.getDriver().getCurrentUrl();
        Assert.assertEquals(actualResultLogin, expectedResultLogin);
    }

    @Test
    public void displaysErrorsWhenPasswwordIsWrong() {
        /* Data: email: admin@admin.com and arbitrary password assert:
        Verify that the error contains the message: Wrong password
        Verify that the /login route appears in the url of the page */

        homePage.loginButtonOnHomePageWebElement().click();
        loginPage.login("admin@admin.com", "password");
        String expectedResultMessage = "Wrong password";
        String actualResultMessage = loginPage.messageWhenPasswordIsWrongWebElement().getText();
        Assert.assertEquals(actualResultMessage, expectedResultMessage);

        String expectedResultLogin = "https://vue-demo.daniel-avellaneda.com/login";
        String actualResultLogin = loginPage.getDriver().getCurrentUrl();
        Assert.assertEquals(actualResultLogin, expectedResultLogin);
    }

    @Test
    public void Login() {
        /* Podaci:
        email: admin@admin.com
        password: 12345
        asssert: Verify that the /home route appears in the url of the page */

        homePage.loginButtonOnHomePageWebElement().click();
        loginPage.login("admin@admin.com", "12345");
        String expectedResult = "https://vue-demo.daniel-avellaneda.com/home";
        wait.until(ExpectedConditions.urlMatches(expectedResult));
        String actualResult = loginPage.getDriver().getCurrentUrl();
        Assert.assertEquals(actualResult, expectedResult);
    }

    @Test
    public void Logout() {
        /* Assert:
        Verify that the logout button is visible on the page
        Verify that the /login route appears in the url of the page
        Verify that after trying to open the /home route, in the url
        page reports /login route (open with driver.get home page and check
        does it redirect you to login) */

        homePage.loginButtonOnHomePageWebElement().click();
        loginPage.login("admin@admin.com", "12345");
        Boolean expectedResultLogoutButton = true;
        Boolean actualResultLogoutButton = loginPage.logoutButtonOnLoginPageWebElement().isDisplayed();
        Assert.assertEquals(actualResultLogoutButton, expectedResultLogoutButton);

        loginPage.logoutButtonOnLoginPageWebElement().click();
        String expectedResultLogin = "https://vue-demo.daniel-avellaneda.com/login";
        String actualResultLogin = loginPage.getDriver().getCurrentUrl();
        Assert.assertEquals(actualResultLogin, expectedResultLogin);

        driver.get("https://vue-demo.daniel-avellaneda.com/home");
        Assert.assertTrue(driver.getCurrentUrl().contains("login"));
    }
}
