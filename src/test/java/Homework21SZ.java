import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Test;



import java.security.Key;

    public class Homework21SZ extends BaseTest{
        @Test
        public void renamePlaylist() throws InterruptedException {
            login();
            // doubleclick on a playlist
            doubleClickChoosePlaylist();
            // Enter new playlist name
            enterPlaylistName();
            // assert that the new playlistname exists
            Assert.assertTrue(doesPlaylistExist());
        }

        private void doubleClickChoosePlaylist() {
            wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("//*[@id='playlists']/ul/li[3]/a")));
            WebElement element =driver.findElement(By.xpath("//*[@id='playlists']/ul/li[3]/a"));
            actions.doubleClick(element).perform();

        }
        private boolean doesPlaylistExist() {
            WebElement playlistElement =driver.findElement(By.xpath("//a[text()='Edited Playlist Name']"));
            return playlistElement.isDisplayed();

        }

        private void enterPlaylistName() throws InterruptedException{
            WebElement playlistInputField = driver.findElement(By.cssSelector("input[name='name']"));
            playlistInputField.sendKeys(Keys.chord(Keys.COMMAND, "a", Keys.BACK_SPACE));
            Thread.sleep(3000);
            playlistInputField.sendKeys("Edited Playlist Name");
            playlistInputField.sendKeys(Keys.ENTER);

        }



    }



