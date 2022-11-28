import POM.pages.BasePage;
import POM.pages.HomePage;
import POM.pages.LoginPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

public class PlaylistTests extends BaseTest {
    @Test
    public void createNewPlaylist(){
        HomePage homePage = new LoginPage(driver).signIn("nozishka86@gmail.com","te$t$tudent");
        int initialNumberOfPlaylists = homePage.getNumberOfPlaylist();
        homePage.createPlaylist("Nozima");
        int updatedNumberOfPlaylists = homePage.getNumberOfPlaylist();
        Assert.assertEquals(updatedNumberOfPlaylists, initialNumberOfPlaylists+1, "Playlist not created");
    }

    @Test
    public void createDuplicatePlaylist(){
        HomePage homePage = new LoginPage(driver).signIn("nozishka86@gmail.com","te$t$tudent");
        int initialNumberOfPlaylists = homePage.getNumberOfPlaylist();
        homePage.createPlaylist("Nozima's Songs");
        homePage.createPlaylist("Nozima's Songs");
        int updatedNumberOfPlaylists = homePage.getNumberOfPlaylist();
        Assert.assertEquals(updatedNumberOfPlaylists, initialNumberOfPlaylists, "Playlist not created");
    }

    @Test
    public void createTwoCharPlaylist(){
        HomePage homePage = new LoginPage(driver).signIn("nozishka86@gmail.com","te$t$tudent");
        int initialNumberOfPlaylists = homePage.getNumberOfPlaylist();
        homePage.createPlaylist("No");
        int updatedNumberOfPlaylists = homePage.getNumberOfPlaylist();
        Assert.assertEquals(updatedNumberOfPlaylists, initialNumberOfPlaylists, "Playlist not created");
    }

    @Test
    public void createThreeCharPlaylist(){
        HomePage homePage = new LoginPage(driver).signIn("nozishka86@gmail.com","te$t$tudent");
        int initialNumberOfPlaylists = homePage.getNumberOfPlaylist();
        homePage.createPlaylist("Noz");
        int updatedNumberOfPlaylists = homePage.getNumberOfPlaylist();
        Assert.assertEquals(updatedNumberOfPlaylists, initialNumberOfPlaylists+1, "Playlist not created");
    }

    @Test
    public void createSevenCharPlaylist(){
        HomePage homePage = new LoginPage(driver).signIn("nozishka86@gmail.com","te$t$tudent");
        int initialNumberOfPlaylists = homePage.getNumberOfPlaylist();
        homePage.createPlaylist("Nozimas");
        int updatedNumberOfPlaylists = homePage.getNumberOfPlaylist();
        Assert.assertEquals(updatedNumberOfPlaylists, initialNumberOfPlaylists+1, "Playlist not created");
    }

    @Test
    public void createTenCharPlaylist(){
        HomePage homePage = new LoginPage(driver).signIn("nozishka86@gmail.com","te$t$tudent");
        int initialNumberOfPlaylists = homePage.getNumberOfPlaylist();
        homePage.createPlaylist("Nozimasong");
        int updatedNumberOfPlaylists = homePage.getNumberOfPlaylist();
        Assert.assertEquals(updatedNumberOfPlaylists, initialNumberOfPlaylists+1, "Playlist not created");
    }

    @Test
    public void createElevenCharPlaylist(){
        HomePage homePage = new LoginPage(driver).signIn("nozishka86@gmail.com","te$t$tudent");
        int initialNumberOfPlaylists = homePage.getNumberOfPlaylist();
        homePage.createPlaylist("Nozimasongs");
        int updatedNumberOfPlaylists = homePage.getNumberOfPlaylist();
        Assert.assertEquals(updatedNumberOfPlaylists, initialNumberOfPlaylists, "Playlist not created");
    }

    @Test
    public void renamePlaylist() {
        HomePage homePage = new LoginPage(driver).signIn("nozishka86@gmail.com", "te$t$tudent");

        homePage.createPlaylist("Dana")
                .hoverOver()
                .rightClickOnPlaylist()
                .editPlaylist()
                .doubleClickPlaylistName();
        WebElement updatedNotice = driver.findElement(By.xpath("//div//div[contains(text(),'Updated Playlist')]"));
        wait.until(ExpectedConditions.visibilityOf(updatedNotice));
        Assert.assertTrue(updatedNotice.isDisplayed());
    }

    @Test
    public void deletePlaylist() {
        HomePage homePage = new LoginPage(driver).signIn("nozishka86@gmail.com", "te$t$tudent");

        homePage.createPlaylist("Nozima")
                .goToMyPlaylist()
                .clickDeleteBtn();
        WebElement successPopUp = driver.findElement(By.xpath("//div[contains(text(),'Deleted')]"));
        wait.until(ExpectedConditions.visibilityOf(successPopUp));
        Assert.assertTrue(successPopUp.isDisplayed());
    }

    @Test
    public void createSmartPlaylist() {
        HomePage homePage = new LoginPage(driver).signIn("nozishka86@gmail.com", "te$t$tudent");

        homePage.createSmartPlaylist();
        WebElement smartPPopUp = driver.findElement(By.xpath("//div[contains(text(),'Smart')]"));
        wait.until(ExpectedConditions.visibilityOf(smartPPopUp));
        Assert.assertTrue(smartPPopUp.isDisplayed());
    }
}


