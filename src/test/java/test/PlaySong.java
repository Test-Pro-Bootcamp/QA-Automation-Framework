package test;

import PageFactory23.AllSongsPage;
import PageFactory23.BasePage;
import PageFactory23.HomePage;
import PageFactory23.LoginPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class PlaySong extends BaseTest {

    @Test (enabled = false)
    public void playSong() {

        LoginPage loginPage = new LoginPage(driver);
        AllSongsPage songsPage = new AllSongsPage(driver);
        BasePage homePage = new HomePage(driver);

        loginPage.login();
        homePage.clickOnAllSongs();
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
