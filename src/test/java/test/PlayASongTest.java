package test;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;

public class PlayASongTest extends BaseTest{

    @Test
    public void PlayASongTest() throws InterruptedException {

    WebElement nextBtn = driver.findElement(By.xpath("//i[@data-testid='play-next-btn']"));
        nextBtn.click();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));


    WebElement playPauseBtn = driver.findElement(By.xpath("//span[@data-testid='play-btn']"));
        playPauseBtn.click();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

    WebElement visualizer = driver.findElement(By.xpath
            ("//button[@title='Click for a marvelous visualizer!']"));
        Assert.assertTrue(visualizer.isDisplayed());
}

}
