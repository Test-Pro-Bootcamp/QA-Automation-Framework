import org.testng.Assert;
import org.testng.annotations.Test;
import pages.FavoritesPage;
import pages.LoginPage;

public class FavoritesTests extends BaseTest{

    @Test
    public void deleteFavoriteSong() throws InterruptedException {
        String songToDelete = "some name";
        FavoritesPage favoritesPage = new LoginPage(driver)
                .login()
                .goToFavorite()
                .deleteSong(songToDelete);
        Assert.assertTrue(favoritesPage.isSongRemoved(songToDelete), "The song ' "+songToDelete+"' was not deleted");
    }
}