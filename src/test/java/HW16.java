import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;

public class HW16 {

    @Test
    public static void createNewPlaylist() throws InterruptedException {
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        String url = "https://bbb.testpro.io/";
        String serachingPageUrl = "https://bbb.testpro.io/#!/playlist/";
        driver.get(url);

        WebElement emailField = driver.findElement(By.cssSelector("[type='email']"));
        emailField.click();
        emailField.sendKeys("iq14111991@gmail.com");

        WebElement passwordField = driver.findElement(By.cssSelector("[type='password']"));
        passwordField.click();
        passwordField.sendKeys("te$t$tudent");

        WebElement submitButton = driver.findElement(By.cssSelector("[type='submit']"));
        submitButton.click();

        WebElement createNewPlayListsButton = driver.findElement(new By.ByXPath("//*[@id=\"playlists\"]/h1/i"));
        Thread.sleep(2000);
        createNewPlayListsButton.click();

        WebElement createNewPlayLists = driver.findElement(new By.ByXPath("//*[@id=\"playlists\"]/nav/ul/li[1]"));
        createNewPlayLists.click();
        WebElement createNewPlayListsKeyField = driver.findElement(new By.ByXPath("//*[@id=\"playlists\"]/form/input"));
        createNewPlayListsKeyField.click();
        createNewPlayListsKeyField.sendKeys("ITS ALIVE!!!!!");
        createNewPlayListsKeyField.submit();

        WebElement newPlaylist = driver.findElement(By.xpath("//a[contains(text(), 'ITS ALIVE!!!!!')]"));
        Assert.assertTrue(newPlaylist.isDisplayed());

        Thread.sleep(3000);

        driver.quit();

    }
}
