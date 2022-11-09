import POM.AllSongsPage;
import POM.LoginPage;
import POM.LoginPageForPageFactoryPractice;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TestsForPlayASongFunction extends BaseTest {

    @Test
    public void playASong(){
        LoginPageForPageFactoryPractice loginPagePageFactory= new LoginPageForPageFactoryPractice(driver);
        loginPagePageFactory.login();
        AllSongsPage allSongs =new AllSongsPage(driver);
        allSongs.search();
        allSongs.playSelectedSong();
        allSongs.playingOfTheSongIsDisplayed();
        Assert.assertTrue(allSongs.playingOfTheSongIsDisplayed());
    }
}
