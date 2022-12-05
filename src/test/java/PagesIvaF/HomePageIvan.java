package PagesIvaF;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.io.File;
import java.time.Duration;
import java.util.List;

public class HomePageIvan extends BasePageIvan {
    By avatarLocator = By.cssSelector("img.avatar");
    @FindBy(css = "[data-testid='sidebar-create-playlist-btn']")
    WebElement createPlaylistButton;

    @FindBy(css = "[data-testid='playlist-context-menu-create-simple']")
    WebElement newPlaylistOption;

    @FindBy(css = "[name='name']")
    WebElement playlistNameField;
    @FindBy(css = "#playlists  a[href*='favorites']")
    WebElement favorite;
    @FindBy(css = "#sidebar  a[href*='#!/queue']")
    WebElement currentQueue;
    @FindBy(css = "#favoritesWrapper .song-item")
    WebElement songInFav;
    @FindBy(css = "#favoritesWrapper .download ")
    WebElement downloadAllSongsBtm;
    @FindBy(css = "#favoritesWrapper .song-item")
    WebElement firstSongFav;
    @FindBy(css = "#app li.download")
    WebElement contextDownloadBtn;
    @FindBy(xpath = "//section[@id='favoritesWrapper']//i[@data-test='btn-like-liked']")
    WebElement unlikeBtn;
    @FindBy(xpath = "//i[@class='fa fa-frown-o']")
    public
    WebElement emptyListIcon;

    @FindBys(
            @FindBy(css = "#playlists a[href*='playlist']")
    )
    List<WebElement> playlists;
    @FindBys(
            @FindBy(css = "#favoritesWrapper .title")
    )
    List<WebElement> favoritlist;
    @FindBys(
            @FindBy(css = "#favoritesWrapper table.items tr.song-item")
    )
    List<WebElement> queueList;




    public HomePageIvan(WebDriver givenDriver){
        super(givenDriver);

    }
    public WebElement getUserAvatar()
    {
        return driver.findElement(avatarLocator);
    }
    public boolean isUserAvatarDisplayed()
    {
        wait.until(ExpectedConditions.visibilityOfElementLocated(avatarLocator)).isDisplayed();

        return driver.findElement(avatarLocator).isDisplayed();
    }
    public void createPlaylist(String name) throws InterruptedException {
        createPlaylistButton.click();
        newPlaylistOption.click();
        playlistNameField.sendKeys(name);
        playlistNameField.sendKeys(Keys.RETURN);
        new WebDriverWait(driver, Duration.ofSeconds(1)).until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector("[name='name']")));
    }
    public void favorite () throws InterruptedException{
        wait.until(ExpectedConditions.visibilityOf(favorite)).click();

    }
    public void currentQueue () throws InterruptedException{
        wait.until(ExpectedConditions.visibilityOf(currentQueue)).click();

    }
    public void playSongFromfav () throws InterruptedException{
        wait.until(ExpectedConditions.visibilityOf(songInFav));
        actions.doubleClick(songInFav).perform();

    }
    public void deleteSongFromfav() throws InterruptedException{
        songInFav.click();
        Actions action = new Actions(driver);
        action.sendKeys(Keys.DELETE).build().perform();
        }
    public void downloadAllSongFromFav() throws InterruptedException{
        downloadAllSongsBtm.click();
    }
    public void contextDownload() throws InterruptedException{
        actions.contextClick(firstSongFav).perform();
        contextDownloadBtn.click();
    }
    public boolean isSongDownloaded(String songFileName) {
        // point to the location where our song is downloaded
        File fileDirectory = new File("/Users/ivanfedorov/Downloads");

        File[] directoryContents = fileDirectory.listFiles();

//        loops over the directory/folder contents to find song file name
        for (int i = 0; i < directoryContents.length; i++) {
            if (directoryContents[i].getName().equals(songFileName)) {
                directoryContents[i].delete();
                return true;
            }
        }
        return false;
    }


    public int getNumberQueue() {
        return (queueList.size()-1);
    }

    public int getNumberfavourite() {
        return (favoritlist.size()-1);
    }

    public int getNumberOfPlaylist() {
        return playlists.size();
    }
    public void emptyFavPlay() throws InterruptedException{
        int num=favoritlist.size();
        try {
            while (num!=0){
                unlikeBtn.click();}
        } catch (org.openqa.selenium.NoSuchElementException e) {
                Assert.assertTrue(emptyListIcon.isDisplayed());
        }




    }


}
