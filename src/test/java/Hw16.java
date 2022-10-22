import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;

public class Hw16 {
    
    @Test
    public static void creatingNewPlaylist() throws InterruptedException {


        String url = "https://bbb.testpro.io/";
        String email = "holostenco.yuliya@gmail.com";
        String password = "te$t$tudent";
        String myPlaylistName = "Iulia's Playlist";

        WebDriver driver = new ChromeDriver();

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get(url);
        driver.manage().window().maximize();

        WebElement emailField = driver.findElement(By.xpath("//input[@type='email']"));
        emailField.click();
        emailField.sendKeys(email);

        WebElement passwordField = driver.findElement(By.xpath("//input[@type='password']"));
        passwordField.click();
        passwordField.sendKeys(password);

        WebElement submitButton = driver.findElement(By.xpath("//button[@type='submit']"));
        submitButton.click();

        WebElement createANewPlaylistElement = driver.findElement(By.xpath("//*[@title='Create a new playlist']"));
        createANewPlaylistElement.click();

        Thread.sleep(2000);

        WebElement newPlaylistLink = driver.findElement(By.xpath("//*[contains(text(),\"New Playlist\")]"));
        newPlaylistLink.click();

        WebElement newPlaylistNameField = driver.findElement(By.xpath("//*[contains(@placeholder, 'to save')]"));
        newPlaylistNameField.click();
        newPlaylistNameField.sendKeys(myPlaylistName + "\n");
        Thread.sleep(3000);

        WebElement newPlaylist = driver.findElement(By.xpath("//*[contains(@href, '#!/playlist/24574')]"));
        Assert.assertTrue(newPlaylist.isDisplayed());
        driver.quit();


    }
}
