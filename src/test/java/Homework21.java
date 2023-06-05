import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.annotations.Test;

public class Homework21 extends BaseTest {

    @Test
    public void renamePlaylist() throws InterruptedException {
        //Login to webapp
        navigateToPage();
        provideEmail("khushbu07@gmail.com");
        providePassword("te$t$tudent");
        clickSubmit();
        selectPlaylist();
        contextClickPlayList();
        enterPlaylistName();
    }

     String playlistName = "Playlist1";

   private void selectPlaylist() throws InterruptedException{
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".playlist:nth-child(3)"))).click();
        Thread.sleep(3000);
    }

   private void contextClickPlayList() throws InterruptedException {
        wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector(".playlist:nth-child(3)")));
        WebElement rightClickPlaylist = driver.findElement(By.cssSelector(".playlist:nth-child(3)"));
        Actions action = new Actions(driver);
        action.contextClick(rightClickPlaylist).perform();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("li[data-testid^='playlist-context-menu-edit']"))).click();
       Thread.sleep(3000);
    }
    private void enterPlaylistName() throws InterruptedException {
        WebElement playlistInputField = driver.findElement(By.cssSelector("input[name='name']"));
        playlistInputField.sendKeys(Keys.CONTROL, "a");
        Thread.sleep(3000);
        playlistInputField.sendKeys(playlistName);
        Thread.sleep(3000);
        playlistInputField.sendKeys(Keys.ENTER);
        Thread.sleep(3000);
    }
}
