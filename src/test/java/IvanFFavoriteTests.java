import PagesIvaF.*;
import PagesIvaF.AllSongsIvan;
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


public class IvanFFavoriteTests extends BaseTestIvan{
    @Test
    public void checkFavorite() throws InterruptedException{
        LoginPageIvan loginPage = new LoginPageIvan(getDriver());
        HomePageIvan homePageIvan = loginPage.login();
        homePageIvan.favorite();
        System.out.println("Number of favorites         "+(homePageIvan.getNumberfavourite()));

    }


    @Test
    public void checkQueue() throws InterruptedException{
        LoginPageIvan loginPage = new LoginPageIvan(getDriver());
        HomePageIvan homePageIvan = loginPage.login();
        homePageIvan.favorite();
        homePageIvan.playSongFromfav();
        homePageIvan.currentQueue();
    }
    @Test
    public void deleteSongFromFav() throws InterruptedException{
        LoginPageIvan loginPage = new LoginPageIvan(getDriver());
        HomePageIvan homePageIvan = loginPage.login();
        homePageIvan.favorite();
        homePageIvan.deleteSongFromfav();

    }
    @Test
    public void addSongToFavHeart() throws InterruptedException{
        LoginPageIvan loginPage = new LoginPageIvan(getDriver());
        HomePageIvan homePageIvan = loginPage.login();
        AllSongsIvan allSongsIvan = new AllSongsIvan(getDriver());
        int initialNumberOfFav = homePageIvan.getNumberfavourite();
        homePageIvan.clickOnAllSongs();
        allSongsIvan.addToFavoriteHeart();
        int updatedNumberOfFav = homePageIvan.getNumberfavourite();
        System.out.println("Number of favorites before: "+initialNumberOfFav+" New Number Of Favorites:  "+updatedNumberOfFav);

    }
    @Test
    public void downloadAllSongFromFav() throws InterruptedException {
        LoginPageIvan loginPage = new LoginPageIvan(getDriver());
        HomePageIvan homePageIvan = loginPage.login();
        AllSongsIvan allSongsIvan = new AllSongsIvan(getDriver());
        homePageIvan.clickOnAllSongs();
        allSongsIvan.addToFavoriteHeart();
        homePageIvan.favorite();
        homePageIvan.downloadAllSongFromFav();

    }
    @Test
    public void downloadOneSongFromFav() throws InterruptedException {
        LoginPageIvan loginPage = new LoginPageIvan(getDriver());
        HomePageIvan homePageIvan = loginPage.login();
        AllSongsIvan allSongsIvan = new AllSongsIvan(getDriver());
        homePageIvan.clickOnAllSongs();
        allSongsIvan.addToFavoriteHeart();
        homePageIvan.favorite();
        Thread.sleep(2000);
        homePageIvan.contextDownload();
        Thread.sleep(2000);
        Assert.assertTrue(homePageIvan.isSongDownloaded("HoliznaCC0 - Waiting On A Train.mp3"));
    }
    @Test
    public void checkIfFavEmpty() throws InterruptedException {
        LoginPageIvan loginPage = new LoginPageIvan(getDriver());
        HomePageIvan homePageIvan = loginPage.login();
        homePageIvan.favorite();
        Thread.sleep(2000);
        homePageIvan.emptyFavPlay();

    }
    @Test
    public void search() throws InterruptedException {
        LoginPageIvan loginPage = new LoginPageIvan(getDriver());
        HomePageIvan homePageIvan = loginPage.login();
        BasePageIvan basePageIvan = new BasePageIvan(getDriver());
        basePageIvan.putSearchRequest("take      hand");
        Thread.sleep(2000);

    }
    @Test
    public void searchSong() throws InterruptedException {
        LoginPageIvan loginPage = new LoginPageIvan(getDriver());
        HomePageIvan homePageIvan = loginPage.login();
        BasePageIvan basePageIvan = new BasePageIvan(getDriver());
        basePageIvan.putSearchRequest("take      hand");
        Thread.sleep(2000);

    }
    @Test
    public void searchNonExisting() throws InterruptedException {
        LoginPageIvan loginPage = new LoginPageIvan(getDriver());
        HomePageIvan homePageIvan = loginPage.login();
        BasePageIvan basePageIvan = new BasePageIvan(getDriver());
        basePageIvan.putSearchRequest("ivan");
        Thread.sleep(2000);

    }
    @Test
    public void aNewsearch() throws InterruptedException {
        LoginPageIvan loginPage = new LoginPageIvan(getDriver());
        HomePageIvan homePageIvan = loginPage.login();
        BasePageIvan basePageIvan = new BasePageIvan(getDriver());
        basePageIvan.putSearchRequest("take      hand");
        Thread.sleep(2000);

    }


//   Drag and Droop method not working with the Koel App
//    @Test
//    public void dragAndDropSongs() throws InterruptedException {
//        LoginPageIvan loginPage = new LoginPageIvan(getDriver());
//        HomePageIvan homePageIvan = loginPage.login();
//        AllSongsIvan allSongsIvan = new AllSongsIvan(getDriver());
//        homePageIvan.clickOnAllSongs();
//        Thread.sleep(2000);
//        allSongsIvan.dragAndDropFav();
//        Thread.sleep(2000);
//
//
//    }







}
