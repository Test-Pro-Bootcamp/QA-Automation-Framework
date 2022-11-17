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
        BasePage basePage = new BasePage(driver);

        loginPage.login();
        basePage.clickOnAllSongs();
        allSongsPage.shuffleSongs();
    }
    @Test
    public void DoubleClickASong(){

        AllSongsPage allSongsPage = new AllSongsPage(driver);
        LoginPage loginPage = new LoginPage(driver);
        BasePage soundBars = new HomePage(driver);
        BasePage basePage = new BasePage(driver);

        loginPage.login();
        basePage.clickOnAllSongs();
        allSongsPage.choseASong();
        allSongsPage.doubleClickChosenSong();
        Assert.assertTrue(soundBars.isSongPlaying());

    }
    @Test
    public void ViewAsList(){

        MyAlbumsPage myAlbumsPage = new MyAlbumsPage(driver);
        LoginPage loginPage = new LoginPage(driver);
        MyAlbumsPage thumbnails = new MyAlbumsPage(driver);
        BasePage basePage = new BasePage(driver);

        loginPage.login();
        basePage.clickOnAlbums();
        myAlbumsPage.changeViewAsList();
        Assert.assertTrue(thumbnails.isViewChanged());

    }


}