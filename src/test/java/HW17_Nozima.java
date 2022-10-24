import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class HW17_Nozima extends BaseTest {

    @Test
    public static void addSongToPlaylist() throws InterruptedException{

        enterEmail("nozishka86@gmail.com");
        enterPassword("te$t$tudent");
        clickSubmitBtn();
        Thread.sleep(2000);

        clickNewPlaylistBtn();
        clickDropDown();
        enterPlayListName();

        WebElement allSongs = driver.findElement(By.xpath("//a[text()='All Songs']"));
        allSongs.click();
        allSongs.click();
        Thread.sleep(5000);

        WebElement song = driver.findElement(By.xpath("//tr[@class='song-item']//td[contains(text(),'a Beat')]"));
        song.click();

        WebElement addToBtn = driver.findElement(By.xpath("//button[@title='Add selected songs to…']"));
        addToBtn.click();
        Thread.sleep(3000);

        WebElement myPlaylist = driver.findElement(By.xpath("//li[@class='playlist']"));
        myPlaylist.click();
        Thread.sleep(3000);

        WebElement nozimaPlaylist = driver.findElement(By.xpath("//a[contains(text(),'Nozima')]"));
        nozimaPlaylist.click();
        Thread.sleep(3000);

        WebElement addedSong = driver.findElement(By.xpath("//tr[@class='song-item']//td[contains(text(),'a Beat')]"));
        Assert.assertTrue(addedSong.isDisplayed());
        Thread.sleep(3000);
    }

}
