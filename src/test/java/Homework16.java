import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import java.time.Duration;

public class Homework16 {
    @Test(enabled = false)
    public static void createNewPlaylist() throws InterruptedException {

        ChromeDriver driver=new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("https://qa.koel.app/");

        WebElement emailField = driver.findElement(By.xpath("//*[@type='email']"));
        emailField.sendKeys("khushbu07@gmail.com");

        WebElement passwordField = driver.findElement(By.xpath("//*[@type='password']"));
        passwordField.sendKeys("te$t$tudent");

        WebElement submitButton=driver.findElement(By.xpath("//*[@type='submit']"));
        submitButton.click();
        Thread.sleep(60000);

        WebElement createPlaylist = driver.findElement(By.xpath("//*[@id='playlists']/h1/i"));
        createPlaylist.click();
        Thread.sleep(60000);

        WebElement addPlaylist = driver.findElement(By.xpath("//*[@id='playlists']/nav/ul/li[1]"));
        addPlaylist.click();
        Thread.sleep(5000);

        WebElement playlistField = driver.findElement(By.xpath("//*[@id='playlists']/form/input"));
        playlistField.sendKeys("Playlist12");
        playlistField.sendKeys(Keys.ENTER);
        Thread.sleep(30000);

        WebElement verifyPlaylist = driver.findElement(By.xpath("//*[@id='playlists']//ul//li//a[text()[contains(.,\"Playlist12\")]]"));
        verifyPlaylist.click();
        Thread.sleep(30000);

    }
}