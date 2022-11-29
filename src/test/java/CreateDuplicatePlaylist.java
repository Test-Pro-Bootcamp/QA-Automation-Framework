import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class CreateDuplicatePlaylist extends BaseTest {

    private final String newPlayList = "Happy Holidays";
    @Test
    public void createTheSameNamePlaylist() {
        login();
        clickCreatePlaylistBtn();
        clickNewPlaylistOption();
        sendKeysPlaylistNewNameField();
        getContextMenu();

        Assert.assertNotEquals(getNewUserNamePlayList(newPlayList), newPlayList);
    }

    private String getNewUserNamePlayList(String newUserNamePlayList) {

        List<WebElement> elementName = driver.findElements(By.xpath("//li[@class='playlist playlist']"));
        String resultNamePlayList = "Default Name";
        for (WebElement elements : elementName) {
            String userNamePlayList = elements.getAttribute("innerText");
            if (userNamePlayList.equals(newUserNamePlayList)) {
                resultNamePlayList = newUserNamePlayList;
            }
        }
        return resultNamePlayList;
    }


    private void getContextMenu() {
        driver.findElement(By.cssSelector("[name='name']")).sendKeys(" ", Keys.ENTER);

    }

    private void sendKeysPlaylistNewNameField() {
        WebElement playlistNameFiled = driver.findElement(By.cssSelector("[name='name']"));
        highlightElement(playlistNameFiled);
        playlistNameFiled.sendKeys(newPlayList);

    }

    private void clickNewPlaylistOption() {
        WebElement newPlaylistOption = driver.findElement(
                By.cssSelector("[data-testid='playlist-context-menu-create-simple']"));
        highlightElement(newPlaylistOption);
        newPlaylistOption.click();
    }

    private void clickCreatePlaylistBtn() {
        WebElement createPlaylistBtn = driver.findElement(By.cssSelector("[data-testid='sidebar-create-playlist-btn']"));
        highlightElement(createPlaylistBtn);
        createPlaylistBtn.click();
    }
}