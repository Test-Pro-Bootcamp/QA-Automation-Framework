import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Homework17 extends BaseTest{
    @Test
   public void addSongToPlaylist() throws InterruptedException{
        provideEmail("salma.ayad.87@gmail.com");
        providePassword();
        clickSubmitBtn();
        clickAllSongs();

        WebElement chooseSong = driver.findElement(By.xpath("//td[text()='Mid-Air Machine - If It_s All I Do']"));
        chooseSong.click();
        WebElement addToBtn = driver. findElement(By.cssSelector("button.btn-add-to"));
        addToBtn.click();
        Thread.sleep(3000);

        WebElement playlistToAddSong = driver.findElement(By.xpath("//li[@class='favorites']"));
        playlistToAddSong.click();
        Thread.sleep(2000);
       WebElement PlayList = driver.findElement(By.cssSelector("li.playlist.favorites"));
       PlayList.click();

       WebElement confirmSongIsAdded = driver.findElement(By.cssSelector("#favoritesWrapper > div"));
       Assert.assertTrue(confirmSongIsAdded.getText().contains("Mid-Air Machine"));
    }


    private void clickAllSongs() {
        WebElement clickAllSongsBtn = driver.findElement(By.xpath("//a[@class='songs']"));
        clickAllSongsBtn.click();




    
