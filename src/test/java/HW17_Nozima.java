import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class HW17_Nozima extends BaseTest {

    @Test
    public void addSongToPlaylist(){
        logIn("nozishka86@gmail.com","te$t$tudent");
        createPlaylist();


        WebElement allSongs = driver.findElement(By.xpath("//a[text()='All Songs']"));
        allSongs.click();
        allSongs.click();

        WebElement song = driver.findElement(By.xpath("//tr[@class='song-item']//td[contains(text(),'a Beat')]"));
        song.click();

        WebElement addToBtn = driver.findElement(By.xpath("//button[@title='Add selected songs to…']"));
        addToBtn.click();

        WebElement myPlaylist = driver.findElement(By.xpath("//li[@class='playlist']"));
        myPlaylist.click();

        WebElement nozimaPlaylist = driver.findElement(By.xpath("//a[contains(text(),'Nozima')]"));
        nozimaPlaylist.click();

        WebElement addedSong = driver.findElement(By.xpath("//tr[@class='song-item']//td[contains(text(),'a Beat')]"));
        Assert.assertTrue(addedSong.isDisplayed());
    }

}
