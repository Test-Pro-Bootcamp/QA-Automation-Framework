import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Test;

public class PlaySong extends BaseTest {


    @Test
    public void playSong(){
        login();
        chooseAllSongs();
        contextClickFirstSong();
        choosePlay();
        Assert.assertTrue(isSongPlaying());
    }


    private void chooseAllSongs() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("li a.songs"))).click();
    }

    private void contextClickFirstSong() {

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".all-songs tr.song-item:nth-child(1)")));
        WebElement firstSong = driver.findElement(By.cssSelector(".all-songs tr.song-item:nth-child(1)"));
        actions.contextClick(firstSong).perform();
    }

    private void choosePlay() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".playback"))).click();

    }
    public boolean isSongPlaying(){
        WebElement soundBarVisualizer = driver.findElement(By.cssSelector("[data-testid= 'sound-bar-play'"));
        return soundBarVisualizer.isDisplayed();
    }


     @Test
  void hoverOverPlayButton() throws InterruptedException {

        login();
        chooseAllSongs();
        hoverPlay();
        Assert.assertTrue(hoverPlay().isDisplayed());
        hoverPlay().click();
        Assert.assertTrue(isSongPlaying());
        Thread.sleep(5000);

    }

    private WebElement hoverPlay() {

        WebElement play = driver.findElement(By.cssSelector("[data-testid='play-btn']"));
        actions.moveToElement(play).perform();
        return play;




    }

}



