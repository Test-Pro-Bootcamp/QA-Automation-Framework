import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import java.time.Duration;
import org.testng.Assert;
import org.testng.annotations.Test;


public class Homework17 extends BaseTest{
    String songTitle="Reactor";
    String playlistName = "Yana Playlist";
    String NewSongAddedPopup = "Added 1 song into";


    @Test
    public void addSongToPlaylist() throws InterruptedException {

    login("dankoyanka@gmail.com", "te$t$tudent");
    searchSong(songTitle);

    addSongToPlaylist(playlistName);
    Assert.assertTrue(getNotificationText().contains(NewSongAddedPopup));



}


}