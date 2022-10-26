import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.openqa.selenium.interactions.Actions;

public class HOMEWORK_18 extends BaseTest {
    String signIn = "nargiza10041@gmail.com";

    @Test
    public void playSong() throws InterruptedException {
        launchBrowser();
        provideEmail(signIn);
        providePassword();
        clickSubmitBtn();
        clickOnNargizaPlaylist();
        clickOnSong();
        rightClickSong();

    }

    public void clickOnNargizaPlaylist() throws InterruptedException {
        WebElement openPlaylist = driver.findElement(By.xpath("//a[text() ='Nargiza']"));
        openPlaylist.click();
        Thread.sleep(2000);
    }
    public void clickOnSong() throws InterruptedException{
        Actions actions = new Actions(driver);
        WebElement getSong = driver.findElement(By.xpath("//section[@id='playlistWrapper']//td[contains(text(),'Pluto')]"));
        actions.contextClick(getSong).perform();
        Thread.sleep(2000);
    }
    private void rightClickSong() {
        WebElement menuSong = driver.findElement(By.xpath("//li[@class = 'playback']"));
        menuSong.click();
    }

}
