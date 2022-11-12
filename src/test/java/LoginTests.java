import POM.HomePage;
import POM.LoginPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class  LoginTests extends BaseTest1 {
   private String invalidEmail="holost@gmail.com";
   private By avatarLocator=By.xpath("//*[contains(@alt,'Avatar of')]");

   @Test
    public void LoginValidEmailValidPasswordTest(){
        LoginPage loginPage = new LoginPage(driver);
        HomePage homePage= new HomePage(driver);
        loginPage.login();
        WebElement avatarIcon= driver.findElement(avatarLocator);
        Assert.assertTrue(avatarIcon.isDisplayed());
    }

    @Test
    public void LoginInValidEmailPasswordTest(){
        LoginPage loginPage = new LoginPage(driver);
        HomePage homePage= new HomePage(driver);
        loginPage.provideEmail(invalidEmail);
        loginPage.providePassword(myPassword);
        loginPage.clickSubmitButton();
        Assert.assertEquals(driver.getCurrentUrl(), url);
    }
    @Test
    public void LoginEmptyEmailPasswordTest(){
        LoginPage loginPage = new LoginPage(driver);
        loginPage.clickSubmitButton();
        Assert.assertEquals(driver.getCurrentUrl(), url);
    }
}