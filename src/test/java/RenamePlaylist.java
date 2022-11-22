import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Test;

public class RenamePlaylist extends  BaseTest {

    @Test
    public void renamingPlaylist(){
        login();
        doubleClickChoosePlaylist();
        enterNewPlaylistName();
        Assert.assertTrue(doesPlaylistExist());

    }
    public void doubleClickChoosePlaylist() {
        wait.until((ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[contains(text(),'My new song')]"))));
        WebElement webElement = driver.findElement(By.xpath("//a[contains(text(),'My new song')]"));
        actions.doubleClick(webElement).perform();

    }
    public void enterNewPlaylistName() {
        WebElement playListInputField = driver.findElement(By.cssSelector("input[name='name']"));
        playListInputField.sendKeys((Keys.chord(Keys.CONTROL, "a", Keys.BACK_SPACE)));
        playListInputField.sendKeys("Green songs");
        playListInputField.sendKeys(Keys.ENTER);

    }
    private boolean doesPlaylistExist() {
        WebElement playListElement = driver.findElement(By.xpath("//a[contains(text(),'Green songs')]"));
        return playListElement.isDisplayed();


    }


}







