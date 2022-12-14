package Homework;

import POM.FactoryPages.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;

public class Homework17 extends BasePage {

    public Homework17(WebDriver givenDriver) {
        super(givenDriver);
    }

    public void addNewSong() {
        getAllSongs();

        selectASong();

        addASong();

        addToPlaylist();

        getPlaylistLink();

        // Verify that the song was added to the HW17 Playlist
        verifySongAddedToPlaylist();
    }

    public void getAllSongs() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"sidebar\"]/section[1]/ul/li[3]/a")));
        WebElement allSongs = driver.findElement(By.xpath("//*[@id=\"sidebar\"]/section[1]/ul/li[3]/a"));
        allSongs.click();
    }

    public void selectASong() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"songsWrapper\"]/div/div/div[1]/table/tr[19]/td[2]")));
        WebElement selectASong = driver.findElement(By.xpath("//*[@id=\"songsWrapper\"]/div/div/div[1]/table/tr[19]/td[2]"));
        selectASong.click();
    }

    public void addASong() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[contains(@title,'Add selected songs to')]")));
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

    }

}
