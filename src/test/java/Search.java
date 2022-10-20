import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;

public class Search {


    @Test
    public void SongSearch() throws InterruptedException {

        String url = "https://bbb.testpro.io/";
        WebDriver driver = new ChromeDriver();

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get(url);
        driver.manage().window().maximize();

        String email = "dankoyanka@gmail.com";
        String password = "te$t$tudent";

        WebElement emailAddressField = driver.findElement(By.cssSelector("input[type='email']"));
        WebElement passwordField = driver.findElement(By.cssSelector("input[type='password']"));
        WebElement loginButton = driver.findElement(By.cssSelector("button[type='submit']"));

        emailAddressField.sendKeys(email);
        Thread.sleep(2000);
        passwordField.sendKeys(password);
        Thread.sleep(2000);
        loginButton.click();

        WebElement searchField = driver.findElement(By.cssSelector("input[type=search]"));
        searchField.sendKeys("F");
        Thread.sleep(3000);
        searchField.clear();
        searchField.sendKeys("Pluto");
        Thread.sleep(3000);

        WebElement SearchResult = driver.findElement(By.cssSelector("div.main-scroll-wrap div.results section.songs ul:nth-child(2) article:nth-child(1) span.main > span.details"));
        System.out.println(SearchResult.getText());

        Assert.assertTrue(SearchResult.isDisplayed());
        Thread.sleep(5000);

        driver.quit();
    }
}


