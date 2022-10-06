package Tests;


import Pages.HomePage;
import Pages.LoginPage;
import Pages.SignUpPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;

import java.time.Duration;

public class BaseTest  {
    protected LoginPage loginPage;

    protected HomePage homePage;
    protected SignUpPage signUpPage;
    protected WebDriver driver;

    @BeforeClass
    public void setup() {
        System.setProperty("webdriver.chrome.driver", "chromedriver");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        loginPage = new LoginPage(driver);
        homePage = new HomePage(driver);
        signUpPage=new SignUpPage(driver);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
    }

    @BeforeMethod
    public void setupBeforeTest() {
        driver.get("https://vue-demo.daniel-avellaneda.com/");

    }
  //  @AfterClass
   // public void endOfTest(){driver.quit();}




}
