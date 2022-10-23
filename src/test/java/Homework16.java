import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;
import java.time.Duration;

public class Homework16 {
    @Test
    public void NewPlaylist() throws InterruptedException {

        String url = "https://bbb.testpro.io/";
        WebDriver driver = new ChromeDriver();

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get(url);
        driver.manage().window().maximize();

        String email = "dankoyanka@gmail.com";
        String password = "te$t$tudent";

        WebElement emailAddressField = driver.findElement(By.xpath("//input[@type='email']"));
        WebElement passwordField = driver.findElement(By.xpath("//input[@type='password']"));
        WebElement loginButton = driver.findElement(By.xpath("//button[@type='submit']"));

        emailAddressField.sendKeys(email);

        passwordField.sendKeys(password);

        loginButton.click();

        WebElement createPlaylistIcon = driver.findElement(By.xpath("//i[@title='Create a new playlist']"));
        createPlaylistIcon.click();
        Thread.sleep(3000);

        WebElement newPlaylistOption = driver.findElement(By.xpath("//li[@data-testid='playlist-context-menu-create-simple']"));
        newPlaylistOption.click();
        Thread.sleep(3000);

        WebElement newPlaylistNameTextField = driver.findElement(By.xpath("//input[@placeholder='↵ to save']"));
        String newPlaylistNameToEnter = "House playlist";
        newPlaylistNameTextField.sendKeys(newPlaylistNameToEnter);
        newPlaylistNameTextField.sendKeys(Keys.ENTER);

        WebElement playlistCreatedNotification = driver.findElement(By.xpath("//div[contains(text(),'Created playlist')]"));
        Assert.assertTrue(playlistCreatedNotification.isDisplayed());
        Thread.sleep(3000);

        driver.quit();





    }


}
