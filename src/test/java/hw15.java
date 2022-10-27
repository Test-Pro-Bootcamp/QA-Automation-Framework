import org.testng.annotations.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;
import stash.Stashed;

import java.time.Duration;

public class hw15 extends BaseTest{

    @Test
    public static void HW15() throws InterruptedException {
        WebDriver driver = new ChromeDriver();

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        String url = "https://bbb.testpro.io/#!/home";
        driver.get(url);

        WebElement emailField = driver.findElement(By.cssSelector("[type='email']"));
        emailField.click();
        emailField.sendKeys("demo@class.com");

        WebElement passwordField = driver.findElement(By.cssSelector("[type='password']"));
        passwordField.click();
        passwordField.sendKeys("te$t$tudent");

        WebElement submitButton = driver.findElement(By.cssSelector("[type='submit']"));
        submitButton.click();

        WebElement searchField = driver.findElement(By.cssSelector("[type='search']"));
        searchField.click();
        searchField.sendKeys("Pluto");
        // how to validate song pluto

        WebElement isCorrectSong = driver.findElement(By.cssSelector("#searchExcerptsWrapper > div > div > section.songs > ul > article > span.main > span.details"));
        Assert.assertTrue(isCorrectSong.isDisplayed());
        Assert.assertTrue(true, "Pluto");
        Assert.assertEquals(isCorrectSong,"Pluto");

        Thread.sleep(5000);
        driver.quit();


    }
}