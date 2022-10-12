package Tests;

import org.testng.Assert;
import org.testng.annotations.Test;


public class ProfileTests extends BaseTest {
    @Test
    public void editsProfile() throws InterruptedException {
        /* Data: random data using the faker library
        Assert:
        Verify that the following message is displayed : Profile saved successfuly
        Verify that each input now for the value attribute has the value entered in the form */

        homePage.loginButtonOnHomePageWebElement().click();
        loginPage.login("admin@admin.com", "12345");
        homePage.profileButtonOnHomePageWebElement().click();
        String name = faker.internet().domainName();
        String phone = faker.number().digits(10);
        String city = faker.address().cityName();
        String country = faker.address().country();
        String twitter = "https://" + faker.internet().domainName();
        String gitHub = "https://" + faker.internet().domainName();
        profilePage.createProfile(name, phone, city, country, twitter, gitHub);
        profilePage.saveButtonOnProfilePageWebElement().click();
        String actualResult = profilePage.snackBarMessageWebElement().getText();
        String expectedResult = "Profile saved successfuly";
        Assert.assertTrue((actualResult.contains(expectedResult)));
    }
}
