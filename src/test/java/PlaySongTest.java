import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;


public class PlaySongTest extends BaseTest {

    @Test
    public void PlaySong() throws InterruptedException{
        emailLogin();
        Actions actions = new Actions(driver);
        WebElement allSong = driver.findElement(By.cssSelector("[href='#!/songs']"));
        allSong.click();
        Thread.sleep(2000);
        WebElement locateSong = driver.findElement(By.xpath("//*[@id=\"songsWrapper\"]/div/div/div[1]/table/tr[2]/td[2]"));
        actions.doubleClick(locateSong).perform();
        WebElement confirmSongPlaying = driver.findElement(By.xpath("//*[@id='progressPane']/h3"));
        Assert.assertTrue(confirmSongPlaying.isDisplayed());



    }






}
