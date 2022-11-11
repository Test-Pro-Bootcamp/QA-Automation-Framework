import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.devtools.v104.console.model.ConsoleMessage;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.openqa.selenium.WebDriver;


import java.time.Duration;

import static org.testng.Assert.assertTrue;

public class Homework18 extends BaseTest {

    @Test
    public void playSong() throws InterruptedException {
        //login
        provideEmail("iq14111991@gmail.com");
        providePassword();
        clickSubmitBtn();

        playSongFromPlaylist();

    }

    private void playSongFromPlaylist() throws InterruptedException {
        openPlaylist();

        selectAndLaunchTheSong();

        verifySongPlaying();
    }

    private void openPlaylist(){

        WebElement openPlaylist = driver.findElement(By.xpath("//*[@id=\"playlists\"]/ul/li[4]/a"));
        openPlaylist.click();

    }

    private void selectAndLaunchTheSong(){
        Actions actions = new Actions(driver);
        WebElement selectAndLaunchTheSong = driver.findElement(By.xpath("//*[@id=\"playlistWrapper\"]/div/div/div[1]/table/tr[3]"));
        actions.contextClick(selectAndLaunchTheSong).perform();
        WebElement hitPlayBtn = driver.findElement(By.xpath("//*[@id=\"app\"]/nav/ul/li[1]"));
        hitPlayBtn.click();
    }

    private void verifySongPlaying() throws InterruptedException {

        WebElement soundBars = driver.findElement(By.xpath("//*[@id=\"mainFooter\"]/div[2]/div[2]/div/button[1]/div/img"));

        Assert.assertEquals(true, soundBars.isDisplayed());
        Thread.sleep(5000);
        tearDownBrowser();

    }
}

