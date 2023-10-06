import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;

public class SongPlay extends BaseTest{

    @Test
    public void songPlay(){
        login();
        //click all songs
        clickAllSongs();
        //right click on a song
        getContextMenu();
        //click play
        clickPlayMenuItem();
        //verify that song is playing
        verifyVisualizer();



    }

    private void verifyVisualizer() {
        By playBarLocator = By.cssSelector("[data-testid = \"sound-bar-play\"]");
        WebElement visualizer = driver.findElement(playBarLocator);
        Assert.assertTrue(visualizer.isDisplayed());
    }

    private void clickPlayMenuItem() {
        By playItemLocator = By.cssSelector(".playback");
        wait.until(ExpectedConditions.visibilityOfElementLocated(playItemLocator));
        driver.findElement(playItemLocator).click();
    }

    private void getContextMenu() {
        By songLocator = By.cssSelector(".all-songs tr.song-item:nth-child(1)");
        wait.until(ExpectedConditions.visibilityOfElementLocated(songLocator));
        WebElement firstSong = driver.findElement(songLocator);
        actions.contextClick(firstSong).perform();
    }

    private void clickAllSongs() {
        By allSongsSelector = By.cssSelector(".menu .songs");
        driver.findElement(allSongsSelector).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("header .song-list-controls")));
    }

    @Test
    void hoverOverPlayButton() {
        login();
        clickAllSongs();
        hoverPlay();
        Assert.assertTrue(hoverPlay().isDisplayed());

    }

    private WebElement hoverPlay() {
        WebElement play = driver.findElement(By.cssSelector("[data-testid='play-btn']"));
        actions.moveToElement(play).perform();
        return driver.findElement(By.cssSelector("[data-testid='play-btn']"));
    }

    @Test
    public void listOfSongWebElements(){
        login();
        choosePlaylistByName("Super");
        getListOfSongs();
        Assert.assertEquals(getListOfSongs().size(),8);
    }

    private List getListOfSongs() {
        return driver.findElements(By.cssSelector("#playlistWrapper td.title"));
    }

    private void choosePlaylistByName(String name) {
        By playlistLocator = By.xpath("//a[contains(text(), '" + name + "')]");
        wait.until(ExpectedConditions.visibilityOfElementLocated(playlistLocator)).click();
        //WebElement playlistName = driver.findElement(By.cssSelector());
    }

    @Test
    public void renamePlaylist(){
        login();
        doubleClickChoosePlaylist();
        enterPlaylistName();
        Assert.assertTrue(doesPlaylistExist());
        
    }

    private boolean doesPlaylistExist() {
    }

    private void enterPlaylistName() {
        
    }

    private void doubleClickChoosePlaylist() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("section[id='playlists'] li:nth-child(5))"))
        WebElement element = driver.findElement(By.cssSelector("section[id='playlists'] li:nth-child(5)"));
        actions.doubleClick(element).perform();
    }

}
