package PageFactory23;


import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginTest extends BaseTest {


    @Test (enabled=true, priority = 1)
    public void LoginValidEmailValidPasswordTest () {

        login();

        By avatarIconLocator = By.xpath("//img[contains(@alt,'Avatar of')]");
        By playlistLocator = By.cssSelector("#playlists h1");

        wait.until(ExpectedConditions.elementToBeClickable(avatarIconLocator));
        WebElement avatarIcon = driver.findElement(avatarIconLocator);
        Assert.assertTrue(avatarIcon.isDisplayed());
        wait.until(ExpectedConditions.elementToBeClickable(playlistLocator));
        wait.until(ExpectedConditions.textToBePresentInElement(driver.findElement(playlistLocator), "PLAYLISTS"));
    }

    @Test
    public void LoginValidEmailPasswordTest () {
        LoginPage1 loginPage = new LoginPage1(driver);
        HomePage1 homePage = new HomePage1(driver);

        loginPage.provideEmail("dankoyanka@gmail.com");
        loginPage.providePassword("te$t$tudent");
        loginPage.clickSubmitBtn();
        Assert.assertTrue(homePage.isUserAvatarDisplayed());

    }
}
