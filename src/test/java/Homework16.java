import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;



import java.time.Duration;

public class Homework16 extends BaseTest{

    @Test
    private static void LoginGoodEmailGoodPassword() throws InterruptedException {

        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        By emailFieldSelector = By.xpath("//input[@type='email']");
        By passFieldSelector = By.xpath("//input[@type='password']");
        By submitButtonSelector = By.xpath("//*[@type='submit']");
        By avatarIconSelector = By.xpath("//img[@alt='Avatar of student']");
        By createNewPlaylistButtonSelector = By.xpath("//i[@title='Create a new playlist']");
        By newPlayListBarSelector = By.xpath("//*[contains(text(),'New Playlist')]");
        By newToSaveFieldSelector = By.xpath("//input[@name='name']");
        By resultSelector = By.xpath("//*[@class='active']");

        String loginEmail = "kaflimeerim@gmail.com";
        String loginPass = "te$t$tudent";
        String url = "https://bbb.testpro.io/";
        driver.get(url);
        Assert.assertEquals(driver.getCurrentUrl(), url);
        String  newPlaylistName = "My new songs";

        WebElement emailField = driver.findElement(emailFieldSelector);
        emailField.click();
        emailField.sendKeys(loginEmail);


        WebElement passwordField = driver.findElement(passFieldSelector);
        passwordField.click();
        passwordField.sendKeys(loginPass);

        WebElement submitButton = driver.findElement(submitButtonSelector);
        submitButton.click();

        WebElement avatarIcon = driver.findElement(avatarIconSelector);
        Assert.assertTrue(avatarIcon.isEnabled());
        Thread.sleep(2000);


        WebElement createNewPlaylistButton = driver.findElement(createNewPlaylistButtonSelector);
        createNewPlaylistButton.click();
        Thread.sleep(2000);

        WebElement newPlayListBar = driver.findElement(newPlayListBarSelector);
        newPlayListBar.click();


        WebElement newToSaveField = driver.findElement(newToSaveFieldSelector);
        newToSaveField.sendKeys(newPlaylistName);
        newToSaveField.sendKeys(Keys.ENTER);

        WebElement result = driver.findElement(resultSelector);
        Assert.assertTrue(result.isDisplayed());
        Assert.assertTrue(result.getText().contains("My new songs"));

        Thread.sleep(5000);




            driver.quit();
        }

    }
