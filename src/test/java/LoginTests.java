import POM.pages.*;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginTests extends BaseTest{
    
    @Test
    public static void LoginValidEmailPasswordTest () {
        LoginPage loginPage = new LoginPage(driver);
        HomePage homePage = loginPage.signIn("","");

        loginPage.signIn("nozishka86@gmail.com", "te$t$tudent");

        Assert.assertEquals(driver.getCurrentUrl(), homePage.homepageURL());
    }

    @Test
    public void shuffleSongs(){
        AllSongsPage allSongsPage = new AllSongsPage(driver);
        LoginPage loginPage = new LoginPage(driver);

        loginPage.signIn("nozishka86@gmail.com", "te$t$tudent").clickAllSongs();
        allSongsPage.clickShuffleBtn();

        Assert.assertTrue(allSongsPage.clearBtnIsDisplayed());
    }

    @Test
    public void playSongFromAllSongsPage(){
        LoginPage loginPage = new LoginPage(driver);
        AllSongsPage allSongsPage = new AllSongsPage(driver);

        loginPage.signIn("nozishka86@gmail.com", "te$t$tudent").clickAllSongs();
        allSongsPage.clickToPlaySong();

        Assert.assertTrue(allSongsPage.songIsPlaying());
    }


   @Test
    public void likePlutoSong(){
        LoginPage loginPage = new LoginPage(driver);
        AlbumsPage albumsPage = new AlbumsPage(driver);

        loginPage.signIn("nozishka86@gmail.com", "te$t$tudent").clickAlbums();
        albumsPage.clickArtist().clickHeartBtnPluto();
        Assert.assertTrue(albumsPage.isSongPlutoLiked());
    }
}
