import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;

//create this class to follow Stan lecture
//Date 11/05/2022 lecture 21-By Stan M (10/31/2022)
public class hw21t extends BaseTest {

    @Test 
    public void renamePlaylist() throws InterruptedException {
        login();
        //check the list you want to change the name
        checkPlaylistToChangeName();
        //double click on it
        //enter the new mane
        enterPlaylistName();
        Assert.assertTrue(doesPlaylistExist());
    }
    private boolean doesPlaylistExist() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[text()='Edited Playlist Name']")));
        WebElement playlistElement = driver.findElement(By.xpath("//a[text()='Edited Playlist Name']"));
        return playlistElement.isDisplayed();
    }

    private void checkPlaylistToChangeName() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"playlists\"]/ul/li[4]")));
        WebElement playlist = driver.findElement(By.xpath("//*[@id=\"playlists\"]/ul/li[4]"));
        actions.doubleClick(playlist).perform();
    }

    private void enterPlaylistName()  throws InterruptedException {

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("input[name='name']")));
        WebElement playlistInputField = driver.findElement(By.cssSelector("input[name='name']"));
        playlistInputField.sendKeys((Keys.chord(Keys.COMMAND, "a", Keys.BACK_SPACE)));

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("input[name='name']")));
        playlistInputField.sendKeys("Edited Playlist Name");
        playlistInputField.sendKeys(Keys.ENTER);

    }
}
