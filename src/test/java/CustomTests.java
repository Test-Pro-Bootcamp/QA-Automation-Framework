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
        AllSongsPage allSongsPage = new AllSongsPage(getDriver());
        LoginPage loginPage = new LoginPage(getDriver());
        HomePage homePage = new HomePage(getDriver());

        loginPage.login();
        homePage.clickOnAllSongs();
        allSongsPage.shuffleSongs();
    }

    @Test
    public void PlaySong() {

        LoginPage loginPage = new LoginPage(getDriver());
        HomePage homePage = new HomePage(getDriver());
        HomePage soundBars = new HomePage(getDriver());
        AllSongsPage allSongsPage = new AllSongsPage(getDriver());

        loginPage.login();
        homePage.clickOnAllSongs();
        allSongsPage.doubleClickChosenSong();
        Assert.assertTrue(soundBars.isSongPlaying());
    }

    @Test
    public void ViewAsList() {

        LoginPage loginPage = new LoginPage(getDriver());
        MyAlbumsPage myAlbumsPage = new MyAlbumsPage(getDriver());
        MyAlbumsPage thumbnailsEnable = new MyAlbumsPage(getDriver());
        BasePage basePage = new BasePage(getDriver());

        loginPage.login();
        basePage.clickOnAlbums();
        myAlbumsPage.changeViewAsList();
        Assert.assertTrue(thumbnailsEnable.isViewChanged());

    }

    @Test
    public void Homework17() {
        LoginPage loginPage = new LoginPage(getDriver());
        Homework17 homework17 = new Homework17(getDriver());

        loginPage.login();
        homework17.addNewSong();

    }

    @Test
    public void Homework18() {

        LoginPage loginPage = new LoginPage(getDriver());
        Homework18 homework18 = new Homework18(getDriver());

        loginPage.login();
        homework18.playSongFromPlaylist();

    }

    @Test
    public void Homework19() {

        LoginPage loginPage = new LoginPage(getDriver());
        Homework19 homework19 = new Homework19(getDriver());

        loginPage.login();
        homework19.deletePL();

    }

    @Test
    public void Homework20() {

        LoginPage loginPage = new LoginPage(getDriver());
        Homework20 homework20 = new Homework20(getDriver());

        loginPage.login();
        homework20.playSongFromPlaylist();

    }

}
