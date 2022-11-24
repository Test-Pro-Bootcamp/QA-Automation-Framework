import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

public class CreateNewPlaylist extends BaseTest{
    @Test
    public void createNewPlaylist(){
        login();
        clickCreatePlaylistBtn();
        clickNewPlaylistOption();
        sendKeysPlaylistNewNameField();

    }

    private void sendKeysPlaylistNewNameField() {
        WebElement playlistNameFiled = driver.findElement(By.cssSelector("[name='name']"));
        playlistNameFiled.sendKeys("Happy Holidays");
        playlistNameFiled.sendKeys(Keys.ENTER);
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
