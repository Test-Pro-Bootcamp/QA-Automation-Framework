import Salma_POM.Pages.*;
import org.testng.Assert;
import org.testng.annotations.Test;


public class Salma_Homework22_AllSongsTests extends Salma_BaseTest{
    @Test
    public void shuffleSongs(){
        LoginPage loginPage = new LoginPage(driver);
        AllSongsPage allSongsPage = new AllSongsPage(driver);
        HomePage homePage = new HomePage(driver);
        BasePage basepage = new BasePage(driver);
        //Step 1:Login
        loginPage.logIn();
        //Step 2:click on All songs
        basepage.clickOnAllSongs();
        //Step 3:Shuffle
        allSongsPage.shuffle();
        //Step 4: Assert first song is playing
        Assert.assertTrue(homePage.isSongPlaying());

    }
    @Test
   public void playASongFromAllSongs(){
        LoginPage loginPage = new LoginPage(driver);
        BasePage basePage = new BasePage(driver);
        HomePage homePage = new HomePage(driver);
        AllSongsPage allSongsPage = new AllSongsPage(driver);

        //Step 1: Login
        loginPage.logIn();
        //Step 2 :Click on All songs
        basePage.clickOnAllSongs();
        //Step 3:Double-click first song
        allSongsPage.doubleClickFirstSong();
        //Step 4: Assert song is playing
        Assert.assertTrue(homePage.isSongPlaying());
   }
   @Test
   public void addSongToFavorites(){
       LoginPage loginPage = new LoginPage(driver);
       BasePage basePage = new BasePage(driver);
       AllSongsPage allSongsPage = new AllSongsPage(driver);
       FavoritesPage favoritesPage = new FavoritesPage(driver);
        //Step 1:Login
       loginPage.logIn();
       //Step 2: click on all songs
       basePage.clickOnAllSongs();
       //Step 3: Choose a song and click Add To Button
       allSongsPage.chooseSongFromAllSongs();
       allSongsPage.clickAddToButton();
       //Step 4: Choose Favorites from drop down menu
       allSongsPage.chooseFavoritesFromMenu();
       //Step 5: Click on favorites
       basePage.clickOnFavorites();
       //Step 6: Verify song is added to favorites
       Assert.assertTrue(favoritesPage.isSongAddedToFavorites());






   }

}
