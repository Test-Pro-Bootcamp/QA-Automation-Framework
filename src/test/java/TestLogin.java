import PagesIvaF.AllSongsIvan;
import PagesIvaF.BasePageIvan;
import PagesIvaF.HomePageIvan;
import PagesIvaF.LoginPageIvan;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;

public class TestLogin extends BaseTestIvan{
    @Test(enabled = true)
    public void LoginWithValidEmailPasswordTest(){
        LoginPageIvan loginPage = new LoginPageIvan(getDriver());
        HomePageIvan homePageIvan = loginPage.login();
        Assert.assertTrue(homePageIvan.isUserAvatarDisplayed());

    }
    @Test(enabled = true)
    public void Shuffle(){
        LoginPageIvan loginPageIvan = new LoginPageIvan(getDriver());
        HomePageIvan homePageIvan = loginPageIvan.login();
        AllSongsIvan allSongsIvan= new AllSongsIvan(getDriver());
        homePageIvan.clickOnAllSongs();
        getDriver().manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        allSongsIvan.shuffle();
        Assert.assertTrue((homePageIvan.isSongPlaying()));
    }
    @Test(enabled = false)
    public void PlayASongFromAllSongs() throws Exception{
        LoginPageIvan loginPageIvan = new LoginPageIvan(getDriver());
        HomePageIvan homePageIvan = loginPageIvan.login();
        homePageIvan.clickOnAllSongs().doubleClickFirstSong();
        Assert.assertTrue(homePageIvan.isSongPlaying());


    }
    @Test(enabled = false)
    public void playFromContest(){
        LoginPageIvan loginPage = new LoginPageIvan(getDriver());
        HomePageIvan homePageIvan = loginPage.login();
        homePageIvan.clickOnAllSongs().contextClickFirstSong().playFromContextMenu();
        Assert.assertTrue(homePageIvan.isSongPlaying());
    }

    @Test
    public void loginTest(){
        LoginPageIvan loginPage = new LoginPageIvan(driver);
        loginPage.login();


    }


}
