import POM.BasePage;
import POM.HomePage;
import POM.LoginPage;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

public class CreatePlaylistTestsUsingPOM extends BaseTest {

    @Test
    public void createANewPlaylist(){
       LoginPage loginPage= new LoginPage(driver);
       HomePage homePage=new HomePage(driver);
       BasePage basePage = new BasePage(driver);
       loginPage.login();
       homePage.createNewPlaylist();
       basePage.getConfirmationPopUpText();
       Assert.assertEquals(basePage.getConfirmationPopUpText(),"Created playlist \"Iulia's Playlist.\"");

    }
}
