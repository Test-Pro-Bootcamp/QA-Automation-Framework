import POM.HomePage;
import POM.LoginPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class LoginTests extends BaseTest {
    protected String myEmail = "holostenco.yuliya@gmail.com";
    protected String myPassword = "te$t$tudent";
    private String invalidEmail = "holost@gmail.com";

    @Test
    public void LoginValidEmailValidPasswordTest() {
        LoginPage loginPage = new LoginPage(getDriver());
        HomePage homePage = new HomePage(getDriver());
        loginPage.login();
        Assert.assertTrue(homePage.userAvatarIsDisplayed());
    }
     @Test
    public void LoginInValidEmailPasswordTest() {
        LoginPage loginPage = new LoginPage(getDriver());
        HomePage homePage = new HomePage(getDriver());
        loginPage.provideEmail(invalidEmail);
        loginPage.providePassword(myPassword);
        loginPage.clickSubmitButton();
        Assert.assertEquals(getDriver().getCurrentUrl(), url);
    }

    @Test
    public void LoginEmptyEmailPasswordTest() {
        LoginPage loginPage = new LoginPage(getDriver());
        loginPage.clickSubmitButton();
        Assert.assertEquals(getDriver().getCurrentUrl(), url);
    }
}