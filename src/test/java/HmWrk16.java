import net.bytebuddy.asm.Advice;
import org.checkerframework.checker.units.qual.K;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import java.time.Duration;

public class HmWrk16 {

    @Test
    public static void createNewPlaylist() {

        By usernameLocator = By.xpath("//*[@type='email']");
        By passwordLocator = By.xpath("//*[@type='password']");
        By loginButton = By.xpath("//*[@type='submit']");
        By avatarIconLocator = By.xpath("//*[@alt = 'Avatar of Student']");
        By NewPlaylistBtn = By.xpath("//i[@title='Create a new playlist']");
        By createNewPlaylist = By.xpath("//*[contains(text(),'New Playlist')]");
        By newPlaylistName = By.xpath("//*[@name='name']");
        By playlistName = By.xpath("//*[contains(text(),'MySongs')]");

        WebDriver driver = new ChromeDriver();
        try {
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
            String url = "https://bbb.testpro.io/";
            driver.get(url);


            driver.findElement(usernameLocator).sendKeys("demo@class.com");
            driver.findElement(passwordLocator).sendKeys("te$t$tudent");
            driver.findElement(loginButton).click();
            driver.findElement(NewPlaylistBtn).click();
            driver.findElement(createNewPlaylist).click();
            driver.findElement(newPlaylistName).sendKeys("MySongs");
            driver.findElement(newPlaylistName).sendKeys(Keys.RETURN);
            Assert.assertTrue(driver.findElement(playlistName).isDisplayed());
        } finally {
            driver.quit();
        }
    }
}

