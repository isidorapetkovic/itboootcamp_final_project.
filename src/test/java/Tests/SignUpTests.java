package Tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class SignUpTests extends BaseTest{
    @Test
    public void visitsTheSignUpPage() throws InterruptedException {
        loginPage.clickSignUpButton();
        Thread.sleep(5000);  //todo wait
        String expectedResult = "https://vue-demo.daniel-avellaneda.com/signup";
        String actualResult = signUpPage.getDriver().getCurrentUrl();
        Assert.assertEquals(actualResult, expectedResult);
    }

    @Test
    public void checksInputTypes() throws InterruptedException {
        loginPage.clickSignUpButton();
        Thread.sleep(5000);  //todo wait
        String expectedResult1 = "email";
        String actualResult1 = signUpPage.getEmailspdWebElement().getAttribute("type");
        Assert.assertEquals(actualResult1, expectedResult1);

        loginPage.clickSignUpButton();
        Thread.sleep(5000);
        String expectedResult2 = "password";
        String actualResult2 = signUpPage.getPasswordspdWebElement().getAttribute("type");
        Assert.assertEquals(actualResult2, expectedResult2);

        loginPage.clickSignUpButton();
        Thread.sleep(5000);
        String expectedResult3 = "password";
        String actualResult3 = signUpPage.getConfirmPasswordspdWebElement().getAttribute("type");
        Assert.assertEquals(actualResult3, expectedResult3);
    }

    @Test
    public void displaysErrorsWhenUserAlreadyExists () throws InterruptedException {
        loginPage.clickSignUpButton();
        Thread.sleep(5000);  //todo wait
        signUpPage.loginSignup("Test Test","admin@admin.com","123654","123654");
        WebElement actualResult1= driver.findElement(By.xpath("//*[@id=\"app\"]/div[1]/main/div/div[2]/div/div/div[3]/div/div/div/div/div[1]/ul/li"));
        String expectedResult1="E-mail already exists";
        Assert.assertEquals(actualResult1.getText(), expectedResult1);
        String expectedResult2 = "https://vue-demo.daniel-avellaneda.com/signup";
        String actualResult2 = signUpPage.getDriver().getCurrentUrl();
        Assert.assertEquals(actualResult2, expectedResult2);
    }

    @Test
    public void Signup () throws InterruptedException {

    }
}
