import Intern.pages.FavoritePageIntern;
import Intern.pages.HomePageIntern;
import Intern.pages.LoginPageIntern;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.sql.Array;
import java.util.ArrayList;
import java.util.List;


public class FavLIst extends BaseTestIntern {
    @Test(enabled = true)
    public void addingFavoriteSong() {

        LoginPageIntern loginPageIntern = new LoginPageIntern(driver);
        FavoritePageIntern favoritesList= new FavoritePageIntern(driver);
        HomePageIntern homePage = new HomePageIntern(driver);

        //login();
        loginPageIntern.login();
        // first go to all songs
        favoritesList.allSongMenu();
        // add song name
//        List<String> listSongToAdd=new ArrayList<String>();
//

        String song = "Reactor";
       //for (String song:listSongToAdd)

       WebElement el = driver.findElement(By.xpath("//*[@id='songsWrapper']//td[text()='" + song+ "']"));
       el.click();
       actions.contextClick(el).perform();
        WebElement addToBtn = driver.findElement(By.cssSelector(".song-menu .has-sub"));
        addToBtn.click();

        //.song-menu .has-sub .favorite
        WebElement addToFavBtn = driver.findElement(By.cssSelector(".song-menu .has-sub .favorite"));
        addToFavBtn.click();
        ////section[@id='favoritesWrapper']//td[text()='Reactor']
        WebElement favSongInList = driver.findElement(By.xpath("//*[@id='favoritesWrapper']//td[text()='" + song+ "']"));
        favSongInList.isDisplayed();
    }
   @Test(enabled =true)
   public void deleteFavoritesSong() {
       LoginPageIntern loginPageIntern = new LoginPageIntern(driver);
       FavoritePageIntern favoritesList= new FavoritePageIntern(driver);
       //BasePage basePage = new BasePage(driver);
       HomePageIntern homePage = new HomePageIntern(driver);

       //login();
       loginPageIntern.login();
       checkFavoriteList();
       deleteAllSongs();
       Assert.assertEquals(isSongRemoved(),true);
   }
    @Test(enabled = true)
    public void emptySong() {
        LoginPageIntern loginPageIntern = new LoginPageIntern(driver);
        FavoritePageIntern favoritesList= new FavoritePageIntern(driver);
        //BasePage basePage = new BasePage(driver);
        HomePageIntern homePage = new HomePageIntern(driver);
        loginPageIntern.login();
        checkFavoriteList();
        deleteAllSongs();
        Assert.assertEquals(isSongRemoved(),true);
        //noFavorites();

//        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#favoritesWrapper div.text")));
//        WebElement textMessage = driver.findElement(By.cssSelector("#favoritesWrapper div.text"));
//        textMessage.isDisplayed();
        //to check if there is empty

    }


    private void checkFavoriteList() {
        WebElement favList = driver.findElement(By.xpath("//a[@href='#!/favorites']"));
        favList.click();
    }
    @Test(enabled = true)
    public void downloadSong() {
        LoginPageIntern loginPageIntern = new LoginPageIntern(driver);
        HomePageIntern homePage = new HomePageIntern(driver);
        FavoritePageIntern favoritesList= new FavoritePageIntern(driver);
        loginPageIntern.login();
        favoritesList.allSongMenu();
        String songName = "Episode 2";

        WebElement songtoSelect = driver.findElement(By.xpath("//*[@id='songsWrapper']//td[text()='Episode 2']"));
        //WebElement songtoSelect = driver.findElement(By.xpath(songName));
        songtoSelect.click();
        actions.contextClick(songtoSelect).perform();

        WebElement favList = driver.findElement(By.xpath("//li[@class='download']"));
        favList.click();
    }
    private void deleteAllSongs() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//section[@id='favoritesWrapper']//td[@class='title']")));
        WebElement favList = driver.findElement(By.xpath("//section[@id='favoritesWrapper']//td[@class='title']"));
        actions.sendKeys(Keys.chord(Keys.CONTROL, Keys.DELETE));
    }

    private List <WebElement> favSongs(){
        return driver.findElements(By.cssSelector("#favoritesrapper .song-items"));
    }

    public boolean isSongRemoved(){
        return favSongs().size()==0;
    }
    private boolean noFavorites() {
        WebElement textStatusofEmptyList = driver.findElement(By.xpath("//div[contains(text(),'No favorites']"));
        return textStatusofEmptyList.isDisplayed();
    }
}


