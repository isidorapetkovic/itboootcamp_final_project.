package Tests;


import org.testng.Assert;
import org.testng.annotations.Test;


public class LocaleTests extends BaseTest {
    @Test
    public void setLocaleToES() {
        /* Assert: Set language to ES
        Verify that the following text appears in the header of the page: Página de aterrizaje */

        homePage.languageButtonWebElement().click();
        homePage.buttonEspanolWebElement().click();
        String actualResult = homePage.menuWebElement().getText();
        String expectedResult = "Página de aterrizaje";
        Assert.assertEquals(actualResult, expectedResult);
    }

    @Test
    public void setLocaleToEN() {
        /* Assert: Set language to EN
        Verify that the following text appears in the header of the page: Landing */

        homePage.languageButtonWebElement().click();
        homePage.buttonEnglishWebElement().click();
        String actualResult = homePage.menuWebElement().getText();
        String expectedResult = "Landing";
        Assert.assertEquals(actualResult, expectedResult);
    }

    @Test
    public void setLocaleToFr() {
         /* Assert: Set language to FR
         Verify that the following text appears in the header of the page: Page d'atterrissage */

        homePage.languageButtonWebElement().click();
        homePage.buttonFrenchWebElement().click();
        String actualResult = homePage.menuWebElement().getText();
        String expectedResult = "Page d'atterrissage";
        Assert.assertEquals(actualResult, expectedResult);
    }
}
