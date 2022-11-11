import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Salma_Homework20 extends Salma_BaseTest{
    @Test
    public void deletePlaylist() {
        logIn();
        clickOnPlaylist();
        clickOnDeletePlaylist();
        assertPlaylistIsDeleted();

    }

    private void assertPlaylistIsDeleted() {
        //Assert Delete Popup shows
        WebElement playlistDeletedPopup = wait.until(ExpectedConditions.visibilityOfElementLocated
                (By.xpath("//div[@class='success show']")));
        Assert.assertTrue(playlistDeletedPopup.getText().contains("Deleted playlist"));
        //Assert the playlist is no more listed in the playlists
        Assert.assertTrue(wait.until(ExpectedConditions.invisibilityOfElementLocated
                (By.xpath("//a[text()='Salma']"))));
    }

    private void clickOnDeletePlaylist() {
        WebElement deletePlaylist = wait.until(ExpectedConditions.visibilityOfElementLocated
                (By.xpath("//button[@title='Delete this playlist']")));
        deletePlaylist.click();
    }

    private void clickOnPlaylist() {
        WebElement playlistLocator = wait.until(ExpectedConditions.visibilityOfElementLocated
                (By.xpath("//a[text()='Salma']")));
        playlistLocator.click();
    }
}