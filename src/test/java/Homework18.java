import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Homework18 extends BaseTest{
    @Test
    public void playSong() throws InterruptedException{
        //Login to webapp
        navigateToPage();
        provideEmail("khushbu07@gmail.com");
        providePassword("te$t$tudent");
        clickSubmit();

        Thread.sleep(2000);
        playASong();

        WebElement songIsPlaying = driver.findElement(By.xpath("//div[@data-testid='sound-bar-play']"));
        Assert.assertTrue(songIsPlaying.isDisplayed());
    }

    private void playASong() throws InterruptedException{

        WebElement nextButton = driver.findElement(By.xpath("//i[@data-testid='play-next-btn']"));
        nextButton.click();
        Thread.sleep(2000);
        WebElement buttonPlaySong = driver.findElement(By.xpath("//span[@data-testid='play-btn']/i"));
        buttonPlaySong.click();
    }
}
