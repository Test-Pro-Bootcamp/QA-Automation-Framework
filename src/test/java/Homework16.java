import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;

public class Homework16 extends BaseTest{
    private String user = "salma.ayad.87@gmail.com";
    private String pass = "te$t$tudent";

    @Test
    public void createNewPlaylist() throws InterruptedException {
        //Login to Koel with valid credentials
        Login(user,pass);
        //Clicking Create Playlist Button
        By createPlayListSelector = By.xpath("//i[@title='Create a new playlist']");
        WebElement createPlayListButton = driver.findElement(createPlayListSelector);
        createPlayListButton.click();
        //Choosing New Playlist from list
        By newPlayListSelector = By.xpath("//li[@data-testid='playlist-context-menu-create-simple']");
        WebElement newPlayList = driver.findElement(newPlayListSelector);
        newPlayList.click();
        //Typing Playlist name in text field
        By playListTextSelector = By.xpath("//*[@id='playlists']/form/input");
        WebElement playListTextField = driver.findElement(playListTextSelector);
        playListTextField.sendKeys("Salma New Playlist");
        playListTextField.sendKeys(Keys.ENTER);
        Thread.sleep(5000);
        //Asserting that New Playlist is created
        By playListSectionSelector = By.xpath("//section[@id='playlists']");
        WebElement playListSection = driver.findElement(playListSectionSelector);
        Assert.assertTrue(playListSection.getText().contains("Salma New Playlist"));
    }
    public void Login(String username, String password){
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
