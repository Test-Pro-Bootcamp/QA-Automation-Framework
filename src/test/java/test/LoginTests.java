package test;

import PageFactory23.HomePage;
import PageFactory23.LoginPage;
import org.testng.Assert;
import org.testng.annotations.Test;
import test.BaseTest;

public class LoginTests extends BaseTest {

    @Test (enabled = true)
    public void LoginValidEmailPasswordTest () {

        LoginPage loginPage = new LoginPage(getDriver());
        HomePage homePage = new HomePage(getDriver());

        loginPage.provideEmail("dankoyanka@gmail.com");
        loginPage.providePassword("te$t$tudent");
        loginPage.clickSubmitBtn();
        Assert.assertTrue(homePage.isUserAvatarDisplayed());
    }

    @Test (enabled = true)
    public void LoginEmptyPasswordTest() {
        LoginPage loginPage = new LoginPage(getDriver());

        loginPage.provideEmail("dankoyanka@gmail.com");
        loginPage.providePassword("");
        loginPage.clickSubmitBtn();
        Assert.assertTrue(loginPage.isPageOpened());
    }
}

//    @Test
//    public void LoginValidEmailValidPasswordTest () {
//
//        login();
//
//        By avatarIconLocator = By.xpath("//img[contains(@alt,'Avatar of')]");
//        By playlistLocator = By.cssSelector("#playlists h1");
//
//        wait.until(ExpectedConditions.elementToBeClickable(avatarIconLocator));
//        WebElement avatarIcon = driver.findElement(avatarIconLocator);
//        Assert.assertTrue(avatarIcon.isDisplayed());
//        wait.until(ExpectedConditions.elementToBeClickable(playlistLocator));
//        wait.until(ExpectedConditions.textToBePresentInElement(driver.findElement(playlistLocator), "PLAYLISTS"));
//    }




