import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class HomeWork18 extends BaseTest{
    @Test
    public void PlaySong(){
        provideEmail("yuliyakis85@gmail.com");
        providePassword("te$t$tudent");
        clickSubmitBtn();
        playASong();
        ValidateSongIsPLaying();

    }

    private void playASong() {
        WebElement playBtn = driver. findElement(By.xpath(" //i[@data-testid='play-next-btn']"));
        playBtn.click();

        WebElement playPauseBtn = driver. findElement(By.xpath(" //span[@data-testid='play-btn']"));
        playPauseBtn.click();

    }
    private void ValidateSongIsPLaying() {
        WebElement visualizer = driver. findElement(By.xpath("//img[@alt='Sound bars']"));
        Assert.assertTrue(visualizer.isDisplayed());
    }
}
