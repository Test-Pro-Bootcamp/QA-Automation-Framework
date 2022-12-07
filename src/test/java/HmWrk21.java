import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Test;

public class HmWrk21 extends BaseTest {
    @Test
    public void renamePlaylist()  {
        logIn();
        doubleclickplaylist();
        enterNewPlaylistName();
        Assert.assertTrue(doesPlaylistExsit());
    }
    private boolean doesPlaylistExsit() {
        WebElement playlistDisplayed = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[contains(text(),'Car Music')]")));
        return playlistDisplayed.isDisplayed();
    }
    private void enterNewPlaylistName() {
        WebElement inputNewName = driver.findElement(By.xpath("//input[@name='name']"));
        inputNewName.sendKeys((Keys.chord(Keys.CONTROL, "a", Keys.BACK_SPACE)));
        inputNewName.sendKeys("Car Music");
        inputNewName.sendKeys(Keys.ENTER);
    }
    private void doubleclickplaylist() {
        WebElement doubleClickPlaylistName = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[contains(text(),'SuperPlus')]")));
        actions.doubleClick(doubleClickPlaylistName).perform();
    }
}

