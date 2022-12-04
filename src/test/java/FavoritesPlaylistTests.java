import POM.pages.BasePage;
import POM.pages.HomePage;
import POM.pages.LoginPage;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;

public class FavoritesPlaylistTests extends BaseTest {
    @Test
    public void FavoritePlaylistSongs(){
        HomePage homePage = new LoginPage(driver).login();
        homePage.addSongToTheFavoritesPlaylist();
        Assert.assertEquals(homePage.getTextAddedSong(),"HoliznaCC0 - Waiting On A Train");
    }


    @Test
    public void EmptyFavoritePlaylist(){
        HomePage homePage = new LoginPage(driver).login();
        homePage.emptyFavoritesPlaylist();
        Assert.assertTrue(homePage.emptyListIcon.isDisplayed());


    }
}
