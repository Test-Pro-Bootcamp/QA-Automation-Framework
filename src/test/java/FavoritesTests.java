import POM.pages.*;
import org.testng.Assert;
import org.testng.annotations.Test;

public class FavoritesTests extends BaseTest{

    @Test
    public void emptyFavorites(){
        HomePage homePage = new LoginPage(driver).signIn("nozishka86@gmail.com","te$t$tudent");
        BasePage basePage = new BasePage(driver).clickFavorites();
        FavoritesPage favoritesPage = new FavoritesPage(driver);

        Assert.assertTrue(favoritesPage.noFavesDisplayed());

    }

    @Test
    public void likeASong(){
        HomePage homePage = new LoginPage(driver).signIn("nozishka86@gmail.com","te$t$tudent")
                                                 .likeSong();
        BasePage basePage = new BasePage(driver).clickFavorites();
        FavoritesPage favoritesPage = new FavoritesPage(driver);
        Assert.assertTrue(favoritesPage.likedSongDisplayed());

        favoritesPage.deleteAllLikedSongs();
        Assert.assertTrue(favoritesPage.noFavesDisplayed());
    }

    @Test
    public void likeASongFromAllSongs(){
        HomePage homePage = new LoginPage(driver).signIn("nozishka86@gmail.com","te$t$tudent");
        BasePage basePage = new BasePage(driver).clickAllSongs();
        AllSongsPage allSongsPage = new AllSongsPage(driver).likeThreeSongs();
        basePage.clickFavorites();
        FavoritesPage favoritesPage = new FavoritesPage(driver);
        Assert.assertTrue(favoritesPage.threeLikedSongs());

        favoritesPage.deleteAllLikedSongs();
        Assert.assertTrue(favoritesPage.noFavesDisplayed());
    }

    @Test
    public void likeASongFromAlbums(){
        HomePage homePage = new LoginPage(driver).signIn("nozishka86@gmail.com","te$t$tudent");
        BasePage basePage = new BasePage(driver).clickAlbums();
        AlbumsPage albumsPage = new AlbumsPage(driver).clickArtist()
                                                      .clickHeartBtnBornKing();
        basePage.clickFavorites();
        FavoritesPage favoritesPage = new FavoritesPage(driver);
        Assert.assertTrue(favoritesPage.isSongBornKingLiked());

        favoritesPage.deleteAllLikedSongs();
        Assert.assertTrue(favoritesPage.noFavesDisplayed());
    }
    @Test
    public void likeASongFromArtists(){
        HomePage homePage = new LoginPage(driver).signIn("nozishka86@gmail.com","te$t$tudent");
        BasePage basePage = new BasePage(driver).clickArtists();
        ArtistsPage artistsPage = new ArtistsPage(driver).clickBoxCatGamesArtist()
                                                         .clickHeartBtnEpic();
        basePage.clickFavorites();
        FavoritesPage favoritesPage = new FavoritesPage(driver);
        Assert.assertTrue(favoritesPage.isSongEpicLiked());

        favoritesPage.deleteAllLikedSongs();
        Assert.assertTrue(favoritesPage.noFavesDisplayed());
    }

    @Test
    public void downloadFaveSong(){
        HomePage homePage = new LoginPage(driver).signIn("nozishka86@gmail.com","te$t$tudent");
        BasePage basePage = new BasePage(driver).clickAlbums();
        AlbumsPage albumsPage = new AlbumsPage(driver).clickArtist().clickHeartBtnBornKing();
        basePage.clickFavorites();
        FavoritesPage favoritesPage = new FavoritesPage(driver).rightClickBornKingHeart();
        Assert.assertTrue(favoritesPage.isDownloadOptionThere());

        favoritesPage.deleteAllLikedSongs();
        Assert.assertTrue(favoritesPage.noFavesDisplayed());
    }
}
