import POM.FactoryPages.HomePage;
import POM.FactoryPages.LoginPage;
import org.testng.Assert;
import org.testng.annotations.Test;


public class LoginTests extends BaseTest {

    @Test
    public void LoginValidEmailPasswordTest() {
        LoginPage loginPage = new LoginPage(getDriver());
        HomePage homePage = new HomePage(getDriver());

        loginPage.login();

        Assert.assertTrue(homePage.isUserAvatarDisplayed());

    }

    @Test
    public void LoginEmptyPasswordTest() {
        LoginPage loginPage = new LoginPage(getDriver());
        HomePage homePage = new HomePage(getDriver());

        loginPage.provideEmail("iq14111991@gmail.com");
        loginPage.providePassword("");
        loginPage.clickSubmitBtn();
        Assert.assertTrue(loginPage.submitBtnIsDisplayed());

    }
}