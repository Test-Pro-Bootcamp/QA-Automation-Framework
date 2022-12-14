package test;

import POM.AllSongsPage;
import POM.BasePage;
import POM.HomePage;
import POM.LoginPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class PlaySongTest extends BaseTest {

    @Test (enabled = true)
    public void playSong() {

        LoginPage loginPage = new LoginPage(driver);
        AllSongsPage songsPage = new AllSongsPage(driver);
        BasePage homePage = new HomePage(driver);

        loginPage.login();
        songsPage.clickOnAllSongs();
        songsPage.contextClickFirstSong();
        songsPage.playFromContextMenu();
        Assert.assertTrue(songsPage.isSongPlaying());
    }

    @Test (enabled = false)
    void hoverOverPlayButton() {
        LoginPage loginPage = new LoginPage(getDriver());
        AllSongsPage allSongsPage = new AllSongsPage(getDriver());

        loginPage.login();
        allSongsPage.chooseAllSongsList();
        allSongsPage.hoverPlay();
        Assert.assertTrue(allSongsPage.hoverPlay().isDisplayed());
        allSongsPage.hoverPlay().click();
        Assert.assertTrue(allSongsPage.isSongPlaying());
    }
}
