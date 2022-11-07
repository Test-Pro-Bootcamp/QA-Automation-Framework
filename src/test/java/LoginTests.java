import POM.pages.AllSongsPage;
import POM.pages.BasePage;
import POM.pages.HomePage;
import POM.pages.LoginPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginTests extends BaseTest{

    @Test
    public static void LoginValidEmailPasswordTest () {
        LoginPage loginPage = new LoginPage(driver);
        HomePage homePage = new HomePage(driver);

        loginPage.signIn("nozishka86@gmail.com", "te$t$tudent");

        Assert.assertEquals(driver.getCurrentUrl(), homePage.homepageURL());
    }

    @Test
    public void shuffleSongs(){
        AllSongsPage allSongsPage = new AllSongsPage(driver);
        LoginPage loginPage = new LoginPage(driver);
        BasePage basePage = new BasePage(driver);

        loginPage.signIn("nozishka86@gmail.com", "te$t$tudent");
        basePage.clickAllSongs();
        allSongsPage.clickShuffleBtn();

        Assert.assertTrue(allSongsPage.clearBtnIsDisplayed());
    }

    @Test
    public void playSongFromAllSongsPage(){
        LoginPage loginPage = new LoginPage(driver);
        BasePage basePage = new BasePage(driver);
        AllSongsPage allSongsPage = new AllSongsPage(driver);

        loginPage.signIn("nozishka86@gmail.com","te$t$tudent");
        basePage.clickAllSongs();
        allSongsPage.clickToPlaySong();

        Assert.assertTrue(allSongsPage.songIsPlaying());
    }
}
