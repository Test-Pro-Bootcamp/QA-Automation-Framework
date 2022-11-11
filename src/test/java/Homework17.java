import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.devtools.v104.console.model.ConsoleMessage;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.openqa.selenium.WebDriver;

import java.time.Duration;

public class Homework17 extends BaseTest{

    @Test
    public void addSongToPlaylist(){
        //login
        provideEmail("iq14111991@gmail.com");
        providePassword();
        clickSubmitBtn();

        //Add new song to the playlist
        addNewSong();

    }

    private void addNewSong(){
        getAllSongs();

        selectASong();

        addASong();

        addToPlaylist();

        getPlaylistLink();

        // Verify that the song was added to the HW17 Playlist
        verifySongAddedToPlaylist();
    }

    private void getAllSongs() {
        WebElement allSongs = driver.findElement(By.xpath("//*[@id=\"sidebar\"]/section[1]/ul/li[3]/a"));
        allSongs.click();
    }
    
    private void selectASong() {
        WebElement selectASong = driver.findElement(By.xpath("//*[@id=\"songsWrapper\"]/div/div/div[1]/table/tr[19]/td[2]"));
        selectASong.click();
    }
    private void addASong() {
        WebElement addSongBtn = driver.findElement(By.xpath("//button[contains(@title,'Add selected songs to')]"));
        addSongBtn.click();
    }

    private void addToPlaylist() {
        WebElement addToPlaylistHW17 = driver.findElement(By.xpath("//section[@id='songsWrapper']//li[contains(text(),'ITS ALIVE!!!!!')]"));
        addToPlaylistHW17.click();
    }

    private void getPlaylistLink() {
        WebElement playlistHW17Link = driver.findElement(By.xpath("//a[text()='ITS ALIVE!!!!!']"));
        playlistHW17Link.click();
        driver.navigate().refresh();
    }

    private void verifySongAddedToPlaylist() {
        WebElement addedSongToPlaylist = driver.findElement(By.xpath("//*[@id=\"playlistWrapper\"]/div/div/div[1]/table/tr[2]/td[2]"));
        Assert.assertTrue(addedSongToPlaylist.isDisplayed());

        driver.quit();
    }

}