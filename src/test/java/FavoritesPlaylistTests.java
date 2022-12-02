import POM.pages.BasePage;
import POM.pages.HomePage;
import POM.pages.LoginPage;
import org.testng.annotations.Test;

public class FavoritesPlaylistTests extends BaseTest {
    @Test
    public void FavoritePlaylistSavedSongs(){
        HomePage homePage = new LoginPage(driver).login();
        BasePage basePage = new BasePage(driver);
        HomePage.clickAllSongs();





    }

}
