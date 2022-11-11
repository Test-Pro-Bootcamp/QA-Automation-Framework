import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Salma_Homework21 extends Salma_BaseTest {
    @Test
    public void renamePlaylist(){
        //Login
        logIn();
        //Double-click playlist
        doubleClickPlaylist();
        //Rename Playlist
        changePlaylistName();
        //Verify playlist name changed
        verifyPlaylistNameChanged();

    }

    private void verifyPlaylistNameChanged() {
        WebElement playlistLocator = wait.until(ExpectedConditions.visibilityOfElementLocated
                (By.xpath("//a[text()='Edited Salma2']")));
        Assert.assertTrue(playlistLocator.isDisplayed());
    }

    private void changePlaylistName() {
        WebElement textFieldLocator = wait.until(ExpectedConditions.visibilityOfElementLocated
                (By.xpath("//input[@name='name']")));
        textFieldLocator.sendKeys(Keys.COMMAND,"a");
        textFieldLocator.sendKeys(Keys.DELETE);
        textFieldLocator.sendKeys("Edited Salma2");
        textFieldLocator.sendKeys(Keys.ENTER);
    }

    private void doubleClickPlaylist() {
        WebElement playlistLocator = wait.until(ExpectedConditions.visibilityOfElementLocated
                (By.xpath("//a[text()='Salma2']")));
        actions.doubleClick(playlistLocator).perform();
    }
}
