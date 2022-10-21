import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;

public class Homework16 {
    static String user = "salma.ayad.87@gmail.com";
    static String pass = "te$t$tudent";
    static String url = "https://bbb.testpro.io/";
    static WebDriver driver = new ChromeDriver();

    @Test
    public static void createNewPlaylist() throws InterruptedException {
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        //Login to Koel with valid credentials
        Login(user,pass);
        //Clicking Create Playlist Button
        By createPlaylistSelector = By.xpath("//i[@title='Create a new playlist']");
        WebElement createPlaylistButton = driver.findElement(createPlaylistSelector);
        createPlaylistButton.click();
        //Choosing New Playlist form list
        By newPlaylistSelector = By.xpath("//li[@data-testid='playlist-context-menu-create-simple']");
        WebElement newPlaylist = driver.findElement(newPlaylistSelector);
        newPlaylist.click();
        //Typing Playlist name in text field
        By playlistTextSelector = By.xpath("//*[@id='playlists']/form/input");
        WebElement playlistTextField = driver.findElement(playlistTextSelector);
        playlistTextField.sendKeys("Salma's New Playlist");
        playlistTextField.sendKeys(Keys.ENTER);
        Thread.sleep(5000);
        //Asserting that New Playlist is created
        By playlistSectionSelector = By.xpath("//section[@id='playlists']");
        WebElement playlistSection = driver.findElement(playlistSectionSelector);
        Assert.assertTrue(playlistSection.getText().contains("Salma's New Playlist"));
        driver.quit();
    }
    public static void Login(String username, String password){
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get(url);
        //Selectors
        By emailSelector = By.cssSelector("[type='email']");
        By passSelector = By.cssSelector("[type='password']");
        By submitSelector = By.cssSelector("[type='submit']");
        //WebElements
        WebElement emailField = driver.findElement(emailSelector);
        WebElement passwordField = driver.findElement(passSelector);
        WebElement submitButton = driver.findElement(submitSelector);
        //Steps to Log in
        emailField.click();
        emailField.sendKeys(user);
        passwordField.click();
        passwordField.sendKeys(pass);
        submitButton.click();
    }
}
