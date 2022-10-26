
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;

public class Homework17 extends BaseTest {
    String signIn = "nargiza10041@gmail.com";

    @Test
    public void addSongToPlaylist() throws InterruptedException {
        launchBrowser();
        provideEmail(signIn);
        providePassword();
        clickSubmitBtn();
        addNewSong();
        selectSong();
        addToButton();
        addtoMyPlayslist();
        clickOnNargizaPlaylist();
    }

    public void addNewSong() throws InterruptedException {
        WebElement viewAllbutton = driver.findElement(By.xpath("//*[@data-testid ='home-view-all-recently-played-btn']"));
        viewAllbutton.click();
        Thread.sleep(2000);
    }

    public void selectSong() throws InterruptedException {
        WebElement songSelection = driver.findElement(By.xpath("//section[@id='recentlyPlayedWrapper']//table[@class ='items']"));
        songSelection.click();
        Thread.sleep(2000);
    }
    public void addToButton() throws InterruptedException{
        WebElement addingButton = driver.findElement(By.xpath("//button[@class ='btn-add-to']"));
        addingButton.click();
        Thread.sleep(2000);
    }
    public void addtoMyPlayslist() throws InterruptedException {
        WebElement myPlaylistSelect = driver.findElement(By.xpath("//section[@id='recentlyPlayedWrapper']//li[contains(text(),'Nargiza')]"));
        myPlaylistSelect.click();
        Thread.sleep(2000);
    }
    public void clickOnNargizaPlaylist() throws InterruptedException {
        WebElement openPlaylist = driver.findElement(By.xpath("//a[text() ='Nargiza']"));
        openPlaylist.click();
        Thread.sleep(2000);
    }
   }







