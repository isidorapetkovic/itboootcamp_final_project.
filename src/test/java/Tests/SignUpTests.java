package Tests;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Test;


public class SignUpTests extends BaseTest {
    @Test
    public void visitsTheSignUpPage() {
        //Verify that the /signup route appears in the url of the page

        homePage.signUpButtonOnHomePageWebElement().click();
        String expectedResult = "https://vue-demo.daniel-avellaneda.com/signup";
        String actualResult = signUpPage.getDriver().getCurrentUrl();
        Assert.assertEquals(actualResult, expectedResult);
    }

    @Test
    public void checksInputTypes() {
        /* Assert:
        Verify that the email input field for the type attribute has the value email
        Verify that the password input field for the type attribute has the value password
        Verify that the confirmation password input field for the type attribute has the value password */

        homePage.signUpButtonOnHomePageWebElement().click();
        String expectedResultEmail = "email";
        String actualResultEmail = signUpPage.emailSignUpPageWebElement().getAttribute("type");
        Assert.assertEquals(actualResultEmail, expectedResultEmail);

        homePage.signUpButtonOnHomePageWebElement().click();
        String expectedResultPassword = "password";
        String actualResultPassword = signUpPage.passwordSignUpPageWebElement().getAttribute("type");
        Assert.assertEquals(actualResultPassword, expectedResultPassword);

        homePage.signUpButtonOnHomePageWebElement().click();
        String expectedResultConfirmPassword = "password";
        String actualResultConfirmPassword = signUpPage.confirmPasswordWebElement().getAttribute("type");
        Assert.assertEquals(actualResultConfirmPassword, expectedResultConfirmPassword);
    }

    @Test
    public void displaysErrorsWhenUserAlreadyExists() {
        /* The data:
        name: Test Test
        email: admin@admin.com
        password: 123654
        confirm password: 123654
        Assert:
        Verify that the error contains the message E-mail already exists
        Verify that the /signup route appears in the url of the page */

        homePage.signUpButtonOnHomePageWebElement().click();
        signUpPage.SignUp("Test Test", "admin@admin.com", "123654", "123654");
        String expectedResultEmail = "E-mail already exists";
        String actualResultEmail = signUpPage.messageWhenEmailAlreadyExistsWebElement().getText();
        Assert.assertEquals(actualResultEmail, expectedResultEmail);

        String expectedResultSignUp = "https://vue-demo.daniel-avellaneda.com/signup";
        String actualResultSignUp = signUpPage.getDriver().getCurrentUrl();
        Assert.assertEquals(actualResultSignUp, expectedResultSignUp);
    }

    @Test
    public void SignUpTest() {
        /* Data:
        name: Name and surname of the participant
        email template: name.surname@itbootcamp.rs
        password: 12346
        confirm password: 123456
        Assert:
        Verify that the notification dialog contains the text: IMPORTANT: Verify your account */

        homePage.signUpButtonOnHomePageWebElement().click();
        String email = faker.internet().emailAddress();
        String name = faker.internet().domainName();
        signUpPage.SignUp(name, email, "123456", "123456");
        String expectedResult = "IMPORTANT: Verify your account";
        wait.until(ExpectedConditions.textToBe(By.xpath("//*[@id=\"app\"]/div[4]/div/div/div[1]"), "IMPORTANT: Verify your account"));
        String actualResult = signUpPage.verifyMessageWebElement().getText();
        Assert.assertEquals(actualResult, expectedResult);
    }
}
