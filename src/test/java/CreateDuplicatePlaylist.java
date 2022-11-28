import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class CreateDuplicatePlaylist extends BaseTest {
    @Test
    public void createTheSameNamePlaylist(){
        login();
        clickCreatePlaylistBtn();
        clickNewPlaylistOption();
        sendKeysPlaylistNewNameField();
        getContextMenu();
        clickCreatePlaylistBtn();
        clickNewPlaylistOption();
        sendKeysPlaylistNewNameField2();
        getContextMenu();
        WebElement newPlaylist = driver.findElement(By.xpath("//a[text()='Happy Holidays']"));
        WebElement newPlaylist2 = driver.findElement(By.xpath("//a[text()='Happy Holidays']"));
        Assert.assertNotEquals(newPlaylist,newPlaylist2);
    }

    private void sendKeysPlaylistNewNameField2() {
        WebElement PlaylistNameField2 = driver.findElement(By.cssSelector("[name='name']"));
        PlaylistNameField2.sendKeys("Happy Holidays");
    }

    private void getContextMenu() {
        driver.findElement(By.cssSelector("[name='name']")).sendKeys(" ", Keys.ENTER);

    }

    private void sendKeysPlaylistNewNameField() {
        WebElement playlistNameFiled = driver.findElement(By.cssSelector("[name='name']"));
        playlistNameFiled.sendKeys("Happy Holidays");

    }

    private void clickNewPlaylistOption() {
        WebElement newPlaylistOption = driver.findElement(By.cssSelector("[data-testid='playlist-context-menu-create-simple']"));
        newPlaylistOption.click();
    }

    private void clickCreatePlaylistBtn() {
        WebElement createPlaylistBtn = driver.findElement(By.cssSelector("[data-testid='sidebar-create-playlist-btn']"));
        createPlaylistBtn.click();
    }

}
