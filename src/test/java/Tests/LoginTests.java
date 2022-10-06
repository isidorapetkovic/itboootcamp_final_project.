package Tests;

import com.github.javafaker.Faker;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import javax.swing.*;
import java.awt.event.ActionEvent;


public class LoginTests extends BaseTest{
    @Test
    public void checkLogin() throws InterruptedException {
        homePage.clickLoginButton();
        String expectedResult = "https://vue-demo.daniel-avellaneda.com/login";
        Thread.sleep(5000); //todo wait
        String actualResult = loginPage.getDriver().getCurrentUrl();
        Assert.assertEquals(actualResult, expectedResult);
    }

    @Test
    public void checksInputTypes () throws InterruptedException {
        homePage.clickLoginButton();
        Thread.sleep(5000);
        String expectedResult1 = "email";
        String actualResult1 = loginPage.getEmailFieldWebElement().getAttribute("type");
        Assert.assertEquals(actualResult1, expectedResult1);

        homePage.clickLoginButton();
        Thread.sleep(5000);
      String expectedResult2 = "password";
      String actualResult2 = loginPage.getPasswordFieldWebElement().getAttribute("type");
      Assert.assertEquals(actualResult2, expectedResult2);
   }

    @Test
    public void displaysErrorsWhenUserDoesNotExist() throws InterruptedException {
        //faker.internet().emailAddress()
        homePage.clickLoginButton();
        Thread.sleep(3000);
        Faker faker = new Faker();
        String email=faker.internet().emailAddress();
        String password=faker.internet().password();
        loginPage.login(email,password);
        String expectedResult1 = "User does not exists";
         WebElement actualResult1 = driver.findElement(By.xpath("//*[@id=\"app\"]/div[1]/main/div/div[2]/div/div/div[4]/div/div/div/div/div[1]/ul/li"));
        Assert.assertEquals(actualResult1.getText(), expectedResult1);
        //driver.getPageSource().contains("User does not exists").;
        String expectedResult2 = "https://vue-demo.daniel-avellaneda.com/login";
        String actualResult2 = loginPage.getDriver().getCurrentUrl();
        Assert.assertEquals(actualResult2, expectedResult2);
    }

    @Test
    public void displaysErrorsWhenPasswwordIsWrong() throws InterruptedException {
        homePage.clickLoginButton();
        Thread.sleep(3000);
        loginPage.login("admin@admin.com","password");
        String expectedResult1 = "Wrong password";
        WebElement actualResult1 = driver.findElement(By.xpath("//*[@id=\"app\"]/div[1]/main/div/div[2]/div/div/div[4]/div/div/div/div/div[1]/ul/li"));
        Assert.assertEquals(actualResult1.getText(), expectedResult1);
        String expectedResult2 = "https://vue-demo.daniel-avellaneda.com/login";
        String actualResult2 = loginPage.getDriver().getCurrentUrl();
        Assert.assertEquals(actualResult2, expectedResult2);
   }

    @Test
    public void Login() throws InterruptedException {
        homePage.clickLoginButton();
        Thread.sleep(3000);
        loginPage.login("admin@admin.com","12345");
        String expectedResult = "https://vue-demo.daniel-avellaneda.com/home";
        String actualResult = loginPage.getDriver().getCurrentUrl();
        Assert.assertEquals(actualResult, expectedResult);
    }

    @Test (dependsOnMethods = {"Login"})
    public void Logout() throws InterruptedException {
        WebElement logoutButton= driver.findElement(By.xpath("//*[@id=\"app\"]/div[1]/div/header/div/div[3]/button[2]/span"));
        Boolean expectedResult1= true;
        Boolean actualResult1 = logoutButton.isDisplayed();
        Assert.assertEquals(actualResult1, expectedResult1);
        logoutButton.click();
        Thread.sleep(3000);
        String expectedResult2 = "https://vue-demo.daniel-avellaneda.com/login";
        String actualResult2 = loginPage.getDriver().getCurrentUrl();
        Assert.assertEquals(actualResult2, expectedResult2);
        driver.get("https://vue-demo.daniel-avellaneda.com/home");
        String expectedResult3 = "https://vue-demo.daniel-avellaneda.com/login";
        Assert.assertTrue(driver.getCurrentUrl().contains("login"));
 }
}
