package stepDefinition;

import io.cucumber.java.After;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import java.time.Duration;

public class Homework17StepDefinition {

    WebDriver driver;
    WebDriverWait wait;

    @Given("I am login in")
    public void iAmLoginIn() {
        System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
        driver = new ChromeDriver();
        driver.get("https://bbb.testpro.io");
        driver.manage().window().maximize();

        WebElement emailField = driver.findElement(By.cssSelector("[type = 'email']"));
        emailField.sendKeys("iq14111991@gmail.com");

        WebElement passwordField = driver.findElement(By.cssSelector("[type = 'password']"));
        passwordField.sendKeys("te$t$tudent");

        WebElement submitBtn = driver.findElement(By.cssSelector("[type = 'submit']"));
        submitBtn.click();

    }

    @And("I open all songs page")
    public void iOpenAllSongsPage() {
//        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"sidebar\"]/section[1]/ul/li[3]/a")));
        //*[@id="sidebar"]/section[1]/ul/li[3]/a
        WebElement allSongs = driver.findElement(By.xpath("//*[@id=\"sidebar\"]/section[1]/ul/li[3]/a"));
        allSongs.click();
    }

    @When("I click to chosen song")
    public void iClickToChosenSong() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"songsWrapper\"]/div/div/div[1]/table/tr[19]/td[2]")));
        WebElement selectASong = driver.findElement(By.xpath("//*[@id=\"songsWrapper\"]/div/div/div[1]/table/tr[19]/td[2]"));
        selectASong.click();
    }

    @And("I add chosen song to playlist")
    public void iAddChosenSongToPlaylist() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[contains(@title,'Add selected songs to')]")));
        WebElement addSongBtn = driver.findElement(By.xpath("//button[contains(@title,'Add selected songs to')]"));
        addSongBtn.click();
        WebElement addToPlaylistHW17 = driver.findElement(By.xpath("//section[@id='songsWrapper']//li[contains(text(),'ITS ALIVE!!!!!')]"));
        addToPlaylistHW17.click();
    }

    @Then("I make the check")
    public void iMakeTheCheck() {
        WebElement playlistHW17Link = driver.findElement(By.xpath("//a[text()='ITS ALIVE!!!!!']"));
        playlistHW17Link.click();
        driver.navigate().refresh();
        WebElement addedSongToPlaylist = driver.findElement(By.xpath("//*[@id=\"playlistWrapper\"]/div/div/div[1]/table/tr[2]/td[2]"));
        Assert.assertTrue(addedSongToPlaylist.isDisplayed());
    }
//    @After
//    public void closeBrowser() {
//        driver.quit();
//    }
}
