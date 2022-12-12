package Intern.pages;

import POM.pages.AllSongsPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class BasePageIntern {
    WebDriver driver;
    WebDriverWait wait;
    Actions actions;

    By avatarLocator = By.cssSelector("img.avatar");
    By soundBarPlayLocator = By.cssSelector("[data-testid = 'sound-bar-play']");
    //location at All song pages
    By allSongsMenuItemLocator = By.cssSelector("li a.songs");
    //locator at favorites Page
    By gotoFavorites = By.xpath("//a[@href='#!/favorites']");

    By songToBeSelectFromAllSongs = By.cssSelector("#songsWrapper .selected");

    By addButton = By.cssSelector((".btn-add-to"));

    By favoritesBtn = By.xpath("//*[@id='songsWrapper']//li[@class='favorites']");
//
    By favSonginFavList = By.xpath("//section[@id='playlistWrapper']//tr[@class='song-item']//td[@class='title']");

    By nosSongOnFavList = By.cssSelector("#favoritesWrapper div.text");
    //private WebDriver ;

    public BasePageIntern(WebDriver givenDriver){
        driver = givenDriver;
        wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        actions = new Actions(driver);
        PageFactory.initElements(driver,this);
    }

    public WebElement getUserAvatar(){
        return driver.findElement(avatarLocator);
    }

    public boolean isUserAvatarDisplayed(){
        return driver.findElement(avatarLocator).isDisplayed();
    }

    public FavoritePageIntern allSongMenu(){
        driver.findElement(allSongsMenuItemLocator).click();
        return new FavoritePageIntern(driver);
    }

//    public void addSongtoFavorites() {
//        driver.findElement(addButton).click();
//        driver.findElement(favoritesBtn).click();
//
//    }
//    public void getSongLocator() {
//       driver.findElement(songToBeSelectFromAllSongs);
//        return this;
//    }
//    public String getSongText() {
//        driver.findElement(songToBeSelectFromAllSongs).getText();
//        return this;
//    }
//
//    public String checkSongInFavList() {
//        driver.findElement(favSonginFavList).getText();
//        return this;
//    }
}

