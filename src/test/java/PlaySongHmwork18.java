import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class PlaySongHmwork18 extends BaseTest{

    @Test

    public void playSong(){
        provideEmail("demo@class.com");
        providePassword("te$t$tudent");
        clickSubmitBtn();
        searchSong();
        clickSongToPlay();
        songIsPlaying();

    }

    private void searchSong() {
        WebElement searchBtn = driver.findElement(By.xpath("[//input[@type='search']"));
        searchBtn.click();
        searchBtn.sendKeys("Pluto");
    }

    private void clickSongToPlay() {
        WebElement clickSong = driver.findElement(By.xpath("[//section[@data-testid='song-excerpts']//span[@class='cover']"));
        clickSong.click();

    }
    private void songIsPlaying() {
        WebElement visualizerAppears = driver.findElement(By.xpath("//img[@alt='Sound bars']"));
        Assert.assertTrue(visualizerAppears.isDisplayed());

    }
}
