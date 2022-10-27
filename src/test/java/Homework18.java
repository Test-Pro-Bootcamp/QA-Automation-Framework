import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Homework18 extends BaseTest{
   @Test
     public void playSong() throws InterruptedException {
       //Login
       provideEmail("salma.ayad.87@gmail.com");
       providePassword();
       clickSubmitBtn();
       //Click All songs and double-click a song
       clickAllSongs();
       DoubleClickSongToPlay();
       //Validate the song is playing
       WebElement songBarSelector = driver.findElement(By.xpath("//img[@alt='Sound bars']"));
       Assert.assertTrue(songBarSelector.isDisplayed());
   }


    private void DoubleClickSongToPlay() {
        Actions actions = new Actions(driver);
        WebElement songSelector = driver.findElement(By.xpath("//td[contains(text() , 'Waiting On A Train')]"));
        actions.doubleClick(songSelector).perform();
    }
}
