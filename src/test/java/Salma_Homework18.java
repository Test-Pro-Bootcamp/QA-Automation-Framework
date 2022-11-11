import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Salma_Homework18 extends Salma_BaseTest{

    @Test
    public void playSong()  {
        //Login
        provideEmail("salma.ayad.87@gmail.com");
        providePassword("te$t$tudent");
        clickSubmitBtn();
        //Click All songs and double-click a song
        clickAllSongs();
        clickSongAndPlay();
        //DoubleClickSongToPlay();
        //Validate the song is playing
        AssertSongIsPlaying();


    }

    private void AssertSongIsPlaying() {
        WebElement songBarSelector = wait.until(ExpectedConditions.visibilityOfElementLocated
                (By.xpath("//img[@alt='Sound bars']")));
        Assert.assertTrue(songBarSelector.isDisplayed());

    }


//    private void DoubleClickSongToPlay() {
//        WebElement songSelector = driver.findElement(By.xpath("//td[contains(text() , 'Waiting On A Train')]"));
//        actions.doubleClick(songSelector).perform();
//    }

    private void clickSongAndPlay(){
        WebElement songSelector = driver.findElement(By.xpath("//td[contains(text() , 'Waiting On A Train')]"));
        songSelector.click();
        By playButtonSelector = By.cssSelector("[data-testid='play-btn']");
        WebElement playButton =  driver.findElement(playButtonSelector);
        actions.moveToElement(playButton).perform();
        wait.until(ExpectedConditions.elementToBeClickable(playButtonSelector));
        playButton.click();

    }
}