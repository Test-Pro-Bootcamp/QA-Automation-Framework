import org.openqa.selenium.By; Homework#18
import org.openqa.selenium.WebDriver;

 main
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

 Homework#18
import java.awt.*;


 main
public class Homework18 extends BaseTest {

    @Test
    public void playSong() throws InterruptedExceptio
    Homework#18

        provideEmail();
        providePassword();
        clickSubmitBtn();
       provideEmail("demo@class.com");
        providePassword("te$t$tudent");
        clickSubmitBtn();

 main
        playASong();

        WebElement visualizer = driver.findElement(By.xpath("//button[@title='Click for a marvelous visualizer!']"));
        Assert.assertTrue(visualizer.isDisplayed());
    }

    private void playASong() throws InterruptedException {

 Homework#18
       WebElement nextBtn = driver.findElement(By.xpath("//i[@data-testid='play-next-btn']"));
       nextBtn.click();
       Thread.sleep(3000);
       WebElement playPauseBtn = driver.findElement(By.xpath("//span[@data-testid='play-btn']"));
       playPauseBtn.click();
    }


        WebElement nextBtn = driver.findElement(By.xpath("//i[@data-testid='play-next-btn']"));
        nextBtn.click();
        Thread.sleep(2000);
        WebElement playPauseBtn = driver.findElement(By.xpath("//span[@data-testid='play-btn']"));
        playPauseBtn.click();

    }


 main
}
