package test;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import java.time.Duration;

public class CreatePlaylist extends BaseTest {
    String playlistName = "Best Hits";

    @Test
    public void createPlaylist() throws InterruptedException {
        WebElement createPlaylistIcon = driver.findElement(By.xpath("//i[@title='Create a new playlist']"));
        createPlaylistIcon.click();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }
    public void enterPlaylistName(String playlistName) throws InterruptedException {
        WebElement newPlaylistOption = driver.findElement(By.xpath("//li[text()=('New Playlist')]"));
        newPlaylistOption.click();
        WebElement newPlaylistNameTextField = driver.findElement(By.xpath
                ("//form[@name='create-simple-playlist-form']/input"));
        newPlaylistNameTextField.sendKeys(playlistName);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        newPlaylistNameTextField.sendKeys(Keys.ENTER);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

        WebElement playlistCreatedNotification = driver.findElement(By.xpath("//div[contains(text(),'Created playlist')]"));
        Assert.assertTrue(playlistCreatedNotification.isDisplayed());
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

    }
}
