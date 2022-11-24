package Homework;

import POM.pages.BasePage;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.devtools.v104.console.model.ConsoleMessage;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.openqa.selenium.WebDriver;

import java.time.Duration;

public class Homework17 extends BasePage {

    public Homework17(WebDriver givenDriver) {
        super(givenDriver);
    }

    public void addNewSong(){
        getAllSongs();

        selectASong();

        addASong();

        addToPlaylist();

        getPlaylistLink();

        // Verify that the song was added to the HW17 Playlist
        verifySongAddedToPlaylist();
    }

    public void getAllSongs() {
        WebElement allSongs = driver.findElement(By.xpath("//*[@id=\"sidebar\"]/section[1]/ul/li[3]/a"));
        allSongs.click();
    }

    public void selectASong() {
        WebElement selectASong = driver.findElement(By.xpath("//*[@id=\"songsWrapper\"]/div/div/div[1]/table/tr[19]/td[2]"));
        selectASong.click();
    }
    public void addASong() {
        WebElement addSongBtn = driver.findElement(By.xpath("//button[contains(@title,'Add selected songs to')]"));
        addSongBtn.click();
    }

    public void addToPlaylist() {
        WebElement addToPlaylistHW17 = driver.findElement(By.xpath("//section[@id='songsWrapper']//li[contains(text(),'ITS ALIVE!!!!!')]"));
        addToPlaylistHW17.click();
    }

    public void getPlaylistLink() {
        WebElement playlistHW17Link = driver.findElement(By.xpath("//a[text()='ITS ALIVE!!!!!']"));
        playlistHW17Link.click();
        driver.navigate().refresh();
    }

    public void verifySongAddedToPlaylist() {
        WebElement addedSongToPlaylist = driver.findElement(By.xpath("//*[@id=\"playlistWrapper\"]/div/div/div[1]/table/tr[2]/td[2]"));
        Assert.assertTrue(addedSongToPlaylist.isDisplayed());

        driver.quit();
    }

}
