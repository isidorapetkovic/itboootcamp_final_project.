package Tests;


import Pages.*;
import com.github.javafaker.Faker;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.html5.WebStorage;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;

import java.time.Duration;

public class BaseTest {
    protected LoginPage loginPage;
    protected HomePage homePage;
    protected SignUpPage signUpPage;
    protected AdminCitiesPage adminCitiesPage;
    protected WebDriver driver;
    protected ProfilePage profilePage;

    protected WebDriverWait wait;
    protected Faker faker;

    @BeforeClass
    public void setup() {
        System.setProperty("webdriver.chrome.driver", "chromedriver");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        loginPage = new LoginPage(driver, wait);
        homePage = new HomePage(driver, wait);
        signUpPage = new SignUpPage(driver, wait);
        adminCitiesPage = new AdminCitiesPage(driver, wait);
        profilePage = new ProfilePage(driver, wait);
        faker = new Faker();
        wait = new WebDriverWait(driver, Duration.ofSeconds(3));
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));

    }

    @BeforeMethod
    public void setupBeforeTest() {
        driver.get("https://vue-demo.daniel-avellaneda.com/");

    }

    @AfterMethod
    public void clearWebStorage() {
        if (driver instanceof WebStorage) {
            WebStorage webStorage = (WebStorage) driver;
            webStorage.getSessionStorage().clear();
            webStorage.getLocalStorage().clear();
        }
    }

    @AfterClass
    public void endOfTest() {
        driver.quit();
    }
}




