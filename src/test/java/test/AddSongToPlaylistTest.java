package test;

import POM.PlaylistPage;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

import java.time.Duration;

public class AddSongToPlaylistTest extends BaseTest {
    @Test
    public static void addSong() {
        PlaylistPage playlistPage = new PlaylistPage();

        playlistPage.searchSong();
        playlistPage.createPlaylist();
        playlistPage.getFirstSongResultText();
        playlistPage.selectFirstSongResult();
        playlistPage. getNotificationText();
        playlistPage.enterPlaylistName();

    }
//    public void selectFirstSongResult() throws InterruptedException {
//        WebElement firstSongResult = driver.findElement(By.cssSelector(".results .details"));
//        Actions actions = new Actions(driver);
//        actions.contextClick(firstSongResult).perform();
//        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
//    }
//    public String getNotificationText(){
//        WebElement notificationText = driver.findElement(By.cssSelector("div.success.show"));
//        return notificationText.getText();
//    }
//    public void enterPlaylistName(String playlistName) throws InterruptedException {
//        WebElement newPlaylistOption = driver.findElement(By.xpath("//li[text()=('New Playlist')]"));
//        newPlaylistOption.click();
//        WebElement newPlaylistNameTextField = driver.findElement(By.xpath
//                ("//form[@name='create-simple-playlist-form']/input"));
//        newPlaylistNameTextField.sendKeys(playlistName);
//        Thread.sleep(2000);
//        newPlaylistNameTextField.sendKeys(Keys.ENTER);
//        Thread.sleep(2000);
//    }
//    public void addSongToPlaylist(String playlistName) throws InterruptedException{
//        Thread.sleep(4000);
//        selectFirstSongResult();
//        Actions actions = new Actions(driver);
//        WebElement addTo = driver.findElement(By.xpath("//li[contains(text(), 'Add To')]"));
//        actions.moveToElement(addTo).perform();
//        Thread.sleep(2000);
//        WebElement playlistNameElement = driver.findElement(By.xpath("//ul[@class='menu submenu menu-add-to']" +
//                "/li[contains(text(),'"+playlistName+"')]"));
//        playlistNameElement.click();
//        Thread.sleep(2000);
//    }
}