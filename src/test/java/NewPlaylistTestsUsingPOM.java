import POM.BasePage;
import POM.HomePage;
import POM.LoginPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class NewPlaylistTestsUsingPOM extends BaseTest {
    private String notificationMessage = "Created playlist \"Iulia's Playlist.\"";

    @Test
    public void createANewPlaylist() {
        LoginPage loginPage = new LoginPage(driver);
        HomePage homePage = new HomePage(driver);
        BasePage basePage = new BasePage(driver);
        loginPage.login();
        homePage.createNewPlaylist();
        homePage.enterNewPlaylistName();
        homePage.getConfirmationPopUpText();
        Assert.assertEquals(homePage.getConfirmationPopUpText(), notificationMessage);

    }
}
