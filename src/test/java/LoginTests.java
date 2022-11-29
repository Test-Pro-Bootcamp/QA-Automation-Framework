import POM.FactoryPages.HomePage;
import POM.FactoryPages.LoginPage;
import org.testng.Assert;
import org.testng.annotations.Test;


public class LoginTests extends BaseTest {

    @Test
    public void LoginValidEmailPasswordTest() {
        LoginPage loginPage = new LoginPage(driver);
        HomePage homePage = new HomePage(driver);
        loginPage.login();

        Assert.assertTrue(homePage.getUserAvatar().isDisplayed());

    }
}