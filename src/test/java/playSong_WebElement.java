import POM.pages.AllSongsPage;
import POM.pages.HomePage;
import POM.pages.LoginPage;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;
//create this class to follow Stan lecture
//Date 11/05/2022 lecture 21-By Stan M (10/31/2022)
public class playSong_WebElement extends BaseTest {

    @Test 
    public void playSongW() throws InterruptedException {
        login();
        //click all songs
        clickAllSongs();
//        //righ click on a song
        getContextMenu();
//        //clickplay
       clickPlayMenuItem();
        //verify that song is playing
        verifyVisualizer();

          //playAsong();
//        WebElement visualizer = driver.findElement(By.xpath("//button[@title='Click for a marvelous visualizer!']"));
//        Assert.assertTrue(visualizer.isDisplayed());
//        WebElement nextBtn = driver.findElement(By.xpath("//i[@data-testid='play-next-btn']"));
//        nextBtn.click();
//        Thread.sleep(2000);
//        WebElement playPauseBtn = driver.findElement(By.xpath("//span[@data-testid='play-btn']"));
//        playPauseBtn.click();
//        By allSongsSelector = By.xpath("//a[@href='#!/songs']");
//        driver.findElement(allSongsSelector).click();

    }

    private void verifyVisualizer() {
        By playBarLocator = By.cssSelector(("[data-testid='sound-bar-play']"));
        WebElement visualizer = driver.findElement(playBarLocator);
        Assert.assertTrue(visualizer.isDisplayed());
    }
    private void clickPlayMenuItem() {
        By playItemLocator = By.cssSelector(".playback");
        wait.until(ExpectedConditions.visibilityOfElementLocated(playItemLocator));
        driver.findElement(playItemLocator).click();
   }

    private void getContextMenu() {
        //.all-songs tr.song-item:nth-child(1)// do right click
        By songLocator = By.cssSelector(".all-songs tr.song-item:nth-child(1)");
        wait.until(ExpectedConditions.visibilityOfElementLocated(songLocator));
        WebElement firstSong = driver.findElement(songLocator);
        actions.contextClick(firstSong).perform();
    }

    private void clickAllSongs() {
        By allSongsSelector = By.xpath("//a[@href='#!/songs']");
        driver.findElement(allSongsSelector).click();
        //wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("header .song-list-controls")));

    }
    public boolean isSongPlaying() {
        WebElement soundBarVisualizer = driver.findElement(By.cssSelector("[data-testid = 'sound-bar-play']"));
        return soundBarVisualizer.isDisplayed();
    }
    @Test 
    void hoverOverPlayButton() {
        login();
        clickAllSongs();
//        WebElement playButton = hoverPlay();
//        Assert.assertTrue(playButton.isDisplayed());
        hoverPlay();
        Assert.assertTrue(hoverPlay().isDisplayed());
        hoverPlay().click();
        Assert.assertTrue(isSongPlaying());
    }

    private WebElement hoverPlay() {
        WebElement play = driver.findElement(By.cssSelector("[data-testid='play-btn']"));
        actions.moveToElement(play).perform();
        return play;
    }
@Test
    public void listOfSongWebElements(){
        //i want to verify that playlist super has 3 songs
          //login
          login();
          //click on playlist 'super'
          choosePlaylistByName("super");
          //count number of songs
          getListofSongs();
          getListofSongs().size();
          //Integer listsize = getListofSongs().size();
          Assert.assertEquals(getListofSongs().size(), 3);
          //verify list of songs is three
           // WebElement listOfSongs = driver.findElement(By.cssSelector("#playlistWrapper td.title"));// only first element
          //Assert.assertEquals(getListOfSongs().size(),3);
  }

    private String getListofSongs() {
        List <WebElement> songList = driver.findElements(By.cssSelector("#playlistWrapper td.title"));
    }

    private void choosePlaylistByName(String name) {
       // By playlistLocator = By.xpath("//a[contains(text(), '" + name + "')]");
        By playlistLocator = By.xpath("//a[contains(text(), '" + name + "')]");
        wait.until(ExpectedConditions.visibilityOfElementLocated(playlistLocator)).click();
    }

}
