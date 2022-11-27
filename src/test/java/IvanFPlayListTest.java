import PagesIvaF.HomePageIvan;
import PagesIvaF.LoginPageIvan;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.annotations.TestInstance;
import java.time.Duration;

public class IvanFPlayListTest extends BaseTestIvan{
    @Test
    public void createPlaylist() throws InterruptedException {
        LoginPageIvan loginPage = new LoginPageIvan(getDriver());
        HomePageIvan homePageIvan = loginPage.login();
        int initialNumberOfPlaylists = homePageIvan.getNumberOfPlaylist();
        homePageIvan.createPlaylist("name");
        int updatedNumberOfPlaylists = homePageIvan.getNumberOfPlaylist();
        Assert.assertEquals(updatedNumberOfPlaylists, initialNumberOfPlaylists+1, "Playlist not created");
    }
}
