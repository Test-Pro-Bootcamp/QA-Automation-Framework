import POM.pages.HomePage;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Homework21 extends BaseTest{

    By playlistElement = By.xpath("//a[contains(text(), 'Nozima')]");

    @Test
    public void renamePlaylist(){
        HomePage homePage = new HomePage(driver);
        logIn("nozishka86@gmail.com", "te$t$tudent");
        homePage.createPlaylist("Nozima");
        hoverPlaylist();
        rightClickOnPlaylist();
        editPlaylist();
        doubleClickPlaylistName();

        WebElement updatedNotice = driver.findElement(By.xpath("//div//div[contains(text(),'Updated playlist')]"));
        wait.until(ExpectedConditions.visibilityOf(updatedNotice));
        Assert.assertTrue(updatedNotice.isDisplayed());
    }

    public void doubleClickPlaylistName() {
        WebElement playlistName = driver.findElement(By.xpath("//input[@name='name']"));
        actions.doubleClick(playlistName).perform();
        playlistName.sendKeys("Updated Playlist", Keys.ENTER);
    }

    public void editPlaylist() {
        driver.findElement(By.xpath("//li[text()='Edit']")).click();
    }

    public WebElement hoverPlaylist(){
        WebElement playlist = driver.findElement(playlistElement);
        actions.moveToElement(playlist).perform();
        return playlist;
    }
    public void rightClickOnPlaylist() {
        WebElement playlist = driver.findElement(playlistElement);
        actions.contextClick(playlist).perform();
    }
}