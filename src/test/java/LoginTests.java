
import POM.pages.HomePage;
import POM.pages.LoginPage;
import POM.pages.AllSongPage;
import POM.pages.BasePage;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Test;





public class LoginTests extends BaseTest {

    // @Test(enabled = true, priority = 0)
    // public void LoginEmptyEmailPasswordTest() {


    //     Assert.assertEquals(driver.getCurrentUrl(), url);


    //Test with POM
    @Test(enabled = true, priority = 0)//(priority = 1,dataProvider = "invalidCredentials",dataProviderClass = BaseTest.class)
    public void LoginValidEmailValidPasswordTest() {

        LoginPage loginPage = new LoginPage(driver);
        HomePage homePages = new HomePage(driver);

        loginPage.provideEmail("kaflimeerim@gmail.com");
        loginPage.providePassword("te$t$tudent");
        loginPage.clickSubmitBtn();
        Assert.assertTrue(homePages.getUserAvatar().isDisplayed());

    }
    @Test
    public void Shuffle() throws InterruptedException {
        AllSongPage allSongPage = new AllSongPage(driver);
        LoginPage loginPage = new LoginPage(driver);
        BasePage basePages = new BasePage(driver);

        //step:1 Login;
        loginPage.login();
        //step:2 Click on ALl Songs
        basePages.clickOnAllSongs();
        //step:3 Shuffle all songs
        allSongPage.shuffle();

    }

    @Test
    public void PlaySongFromAllSongs() throws InterruptedException {

        LoginPage loginPage = new LoginPage(driver);
        BasePage basePages = new BasePage(driver);
        AllSongPage allSongPage = new AllSongPage(driver);

        loginPage.login();
        basePages.clickOnAllSongs();
        allSongPage.doubleClickFirstSong();



    }

}

