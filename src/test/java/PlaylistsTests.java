import Salma_POM.Pages.HomePage;
import Salma_POM.Pages.LoginPage;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class PlaylistsTests extends Salma_BaseTest {

    @Test
    public void createNewPlaylist() {
        LoginPage loginPage = new LoginPage(driver);
        HomePage homePage = loginPage.logIn();
        homePage.clickPlusBtn();
        homePage.clickNewPlaylist();
        homePage.enterNewPlaylistName();
        Assert.assertTrue(homePage.isNewPlaylistPopUp());
        Assert.assertTrue(homePage.isNewPlaylistAdded());
    }
    @Test
    public void createDuplicatePlaylist(){
        LoginPage loginPage = new LoginPage(driver);
        HomePage homePage = loginPage.logIn();
        homePage.clickPlusBtn();
        homePage.clickNewPlaylist();
        homePage.enterNewPlaylistName();
        //Enter the same playlist name(duplicate)
        homePage.clickPlusBtn();
        homePage.clickNewPlaylist();
        homePage.enterNewPlaylistName();
        //The duplicate playlist should not be created
        Assert.assertFalse(homePage.isNewPlaylistPopUp());
    }
    @Test
    public void createNewShortPlaylist(){
        LoginPage loginPage = new LoginPage(driver);
        HomePage homePage = loginPage.logIn();
        homePage.clickPlusBtn();
        homePage.clickNewPlaylist();
        //Enter playlist name with 2 characters
        homePage.enterShortNewPlaylistName();
        Assert.assertFalse(homePage.isNewPlaylistPopUp());
    }
    @Test
    public void createNewLongPlaylist(){
        LoginPage loginPage = new LoginPage(driver);
        HomePage homePage = loginPage.logIn();
        homePage.clickPlusBtn();
        homePage.clickNewPlaylist();
        //Enter playlist name with 2 characters
        homePage.enterLongNewPlaylistName();
        Assert.assertFalse(homePage.isNewPlaylistPopUp());
    }

}
