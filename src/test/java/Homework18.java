import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.awt.*;

public class Homework18 extends BaseTest {

    @Test
    public void playSong() throws InterruptedException {

        provideEmail();
        providePassword();
        clickSubmitBtn();
        playASong();

        WebElement visualizer = driver.findElement(By.xpath("//button[@title='Click for a marvelous visualizer!']"));
        Assert.assertTrue(visualizer.isDisplayed());
    }

    private void playASong() throws InterruptedException {

       WebElement nextBtn = driver.findElement(By.xpath("//i[@data-testid='play-next-btn']"));
       nextBtn.click();
       Thread.sleep(3000);
       WebElement playPauseBtn = driver.findElement(By.xpath("//span[@data-testid='play-btn']"));
       playPauseBtn.click();
    }

}
