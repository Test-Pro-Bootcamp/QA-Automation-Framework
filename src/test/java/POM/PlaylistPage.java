package POM;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import java.time.Duration;

public class PlaylistPage extends BasePage{
    public PlaylistPage(WebDriver givenDriver) {
        super(givenDriver);
    }
    public void searchSong(String songTitle) throws InterruptedException{
        WebElement searchField = driver.findElement(By.cssSelector("div#searchForm input[type=search]"));
        searchField.sendKeys(songTitle);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
    }
    public void createPlaylist() throws InterruptedException {
        WebElement createPlaylistIcon = driver.findElement(By.xpath("//i[@title='Create a new playlist']"));
        createPlaylistIcon.click();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
    }
    public String getFirstSongResultText (){
        WebElement firstSongResult = driver.findElement(By.cssSelector(".results .details"));
        return firstSongResult.getText();
    }
    public void selectFirstSongResult() throws InterruptedException {
        WebElement firstSongResult = driver.findElement(By.cssSelector(".results .details"));
        Actions actions = new Actions(driver);
        actions.contextClick(firstSongResult).perform();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
    }
    public String getNotificationText(){
        WebElement notificationText = driver.findElement(By.cssSelector("div.success.show"));
        return notificationText.getText();
    }
    public void enterPlaylistName(String playlistName) throws InterruptedException {
        WebElement newPlaylistOption = driver.findElement(By.xpath("//li[text()=('New Playlist')]"));
        newPlaylistOption.click();
        WebElement newPlaylistNameTextField = driver.findElement(By.xpath
                ("//form[@name='create-simple-playlist-form']/input"));
        newPlaylistNameTextField.sendKeys(playlistName);
        Thread.sleep(2000);
        newPlaylistNameTextField.sendKeys(Keys.ENTER);
        Thread.sleep(2000);
    }
    public void addSongToPlaylist(String playlistName) throws InterruptedException{
        Thread.sleep(4000);
        selectFirstSongResult();
        Actions actions = new Actions(driver);
        WebElement addTo = driver.findElement(By.xpath("//li[contains(text(), 'Add To')]"));
        actions.moveToElement(addTo).perform();
        Thread.sleep(2000);
        WebElement playlistNameElement = driver.findElement(By.xpath("//ul[@class='menu submenu menu-add-to']" +
                "/li[contains(text(),'"+playlistName+"')]"));
        playlistNameElement.click();
        Thread.sleep(2000);
    }
}
