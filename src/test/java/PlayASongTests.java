import POM.BasePage;
import POM.LoginPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;

public class PlayASongTests extends BaseTest {

   private String searchPhrase = "Waiting On A Train";
   private By searchFieldLocator=(By.cssSelector("input[type=search]"));

    @Test
    public void playSong() {
        LoginPage loginPage=new LoginPage(driver);
        loginPage.login();
        BasePage basePage=new BasePage(driver);

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
        emailField.sendKeys(myEmail);

        WebElement passwordField = driver.findElement(By.xpath("//input[@type='password']"));
        passwordField.click();
        passwordField.sendKeys(myPassword);

        WebElement submitBtn = driver.findElement(By.xpath("//button[@type='submit']"));
        submitBtn.click();

        Thread.sleep(3000);
    }

    private void search()  {

    }
}