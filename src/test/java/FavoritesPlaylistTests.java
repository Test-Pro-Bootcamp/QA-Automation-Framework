import POM.pages.BasePage;
import POM.pages.HomePage;
import POM.pages.LoginPage;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

public class FavoritesPlaylistTests extends BaseTest {
    @Test
    public void FavoritePlaylistSongs(){
        HomePage homePage = new LoginPage(driver).login();
//      HomePage.addSongToTheFavoritesPlaylist();
        homePage.addSongToTheFavoritesPlaylist();








    }

}
