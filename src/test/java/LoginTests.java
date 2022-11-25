import POM.pages.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;


public class LoginTests extends BaseTest {

    @Test
    public void LoginValidEmailPasswordTest () {
        LoginPage loginPage = new LoginPage(driver);
        HomePage homePage = new HomePage(driver);
        loginPage.login();

        Assert.assertTrue(homePage.getUserAvatar().isDisplayed());
    }
    @Test
    public void ShufleTest(){

        AllSongsPage allSongsPage = new AllSongsPage(driver);
        LoginPage loginPage = new LoginPage(driver);

        loginPage.login();
        allSongsPage.clickOnAllSongs();
        allSongsPage.shuffleSongs();
    }
    @Test
    public void DoubleClickASong(){

        AllSongsPage allSongsPage = new AllSongsPage(driver);
        LoginPage loginPage = new LoginPage(driver);
        AllSongsPage soundBars = new AllSongsPage(driver);

        loginPage.login();
        allSongsPage.clickOnAllSongs();
        allSongsPage.choseASong();
        allSongsPage.doubleClickChosenSong();
        Assert.assertTrue(soundBars.isSongPlaying());

    }
    @Test
    public void ViewAsList(){

        MyAlbumsPage myAlbumsPage = new MyAlbumsPage(driver);
        LoginPage loginPage = new LoginPage(driver);
        MyAlbumsPage thumbnails = new MyAlbumsPage(driver);
        AllSongsPage allSongsPage = new AllSongsPage(driver);

        loginPage.login();
        allSongsPage.clickOnAlbums();
        myAlbumsPage.changeViewAsList();
        Assert.assertTrue(thumbnails.isViewChanged());

    }


}