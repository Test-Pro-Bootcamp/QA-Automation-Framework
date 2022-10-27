import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;

public class PlayASongTests extends BaseTest {

    String email = "holostenco.yuliya@gmail.com";
    String searchPhrase = "Waiting On A Train";

    @Test
    public void playSong() throws InterruptedException {

        login();
        search();
        playSelectedSong();
        validatePlayOfTheSong();


    }

    private void validatePlayOfTheSong() {
        WebElement imgOfAPlayingSong = driver.findElement(By.xpath("//img[@alt='Sound bars']"));
        Assert.assertTrue(imgOfAPlayingSong.isDisplayed());
    }

    private void playSelectedSong() {
        Actions actions = new Actions(driver);
        WebElement selectedSong = driver.findElement(By.xpath("//ul/article[1]/span[2]/span[1]"));
        actions.contextClick(selectedSong).perform();

        WebElement playBtn = driver.findElement(By.xpath("//span[text()='Play']"));
        playBtn.click();


    }

    public void login() throws InterruptedException {
        WebElement emailField = driver.findElement(By.xpath("//input[@type='email']"));
        emailField.click();
        emailField.sendKeys(email);

        WebElement passwordField = driver.findElement(By.xpath("//input[@type='password']"));
        passwordField.click();
        passwordField.sendKeys("te$t$tudent");

        WebElement submitBtn = driver.findElement(By.xpath("//button[@type='submit']"));
        submitBtn.click();

        Thread.sleep(3000);
    }

    private void search() throws InterruptedException {
        WebElement searchField = driver.findElement(By.cssSelector("input[type=search]"));
        Thread.sleep(3000);

        searchField.sendKeys(searchPhrase);
        Thread.sleep(2000);
    }
}