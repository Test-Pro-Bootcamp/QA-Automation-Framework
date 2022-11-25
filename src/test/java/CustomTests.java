import Homework.Homework17;
import Homework.Homework18;
import Homework.Homework19;
import Homework.Homework20;
import POM.FactoryPages.*;
import org.testng.Assert;
import org.testng.annotations.Test;

public class CustomTests extends BaseTest {
    @Test
    public void ShuffleTest() {

        AllSongsPage allSongsPage = new AllSongsPage(driver);
        LoginPage loginPage = new LoginPage(driver);
        HomePage homePage = new HomePage(driver);

        loginPage.login();
        homePage.clickOnAllSongs();
        allSongsPage.shuffleSongs();
    }

    @Test
    public void PlaySong() {
        LoginPage loginPage = new LoginPage(driver);
        HomePage homePage = new HomePage(driver);
        HomePage soundBars = new HomePage(driver);
        AllSongsPage allSongsPage = new AllSongsPage(driver);

        loginPage.login();
        homePage.clickOnAllSongs();
        allSongsPage.doubleClickChosenSong();
        Assert.assertTrue(soundBars.isSongPlaying());
    }

    @Test
    public void ViewAsList() {
        LoginPage loginPage = new LoginPage(driver);
        MyAlbumsPage myAlbumsPage = new MyAlbumsPage(driver);
        MyAlbumsPage thumbnailsEnable = new MyAlbumsPage(driver);
        BasePage basePage = new BasePage(driver);

        loginPage.login();
        basePage.clickOnAlbums();
        myAlbumsPage.changeViewAsList();
        Assert.assertTrue(thumbnailsEnable.isViewChanged());

    }

    @Test
    public void Homework17() {
        LoginPage loginPage = new LoginPage(driver);
        Homework17 homework17 = new Homework17(driver);

        loginPage.login();
        homework17.addNewSong();

    }

    @Test
    public void Homework18() {
        LoginPage loginPage = new LoginPage(driver);
        Homework18 homework18 = new Homework18(driver);

        loginPage.login();
        homework18.playSongFromPlaylist();

    }

    @Test
    public void Homework19() {
        LoginPage loginPage = new LoginPage(driver);
        Homework19 homework19 = new Homework19(driver);

        loginPage.login();
        homework19.deletePL();

    }

    @Test
    public void Homework20() {
        LoginPage loginPage = new LoginPage(driver);
        Homework20 homework20 = new Homework20(driver);

        loginPage.login();
        homework20.playSongFromPlaylist();

    }

}
