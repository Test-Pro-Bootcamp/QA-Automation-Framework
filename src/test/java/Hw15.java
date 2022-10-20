import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;

public class Hw15 {
    @Test
    public static void Search() throws InterruptedException {
        String url = "https://bbb.testpro.io/";
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get(url);
        driver.manage().window().maximize();

        WebElement emailField = driver.findElement(By.cssSelector("[type='email']"));
        emailField.click();
        emailField.sendKeys("holostenco.yuliya@gmail.com");

        WebElement passwordField = driver.findElement(By.cssSelector("[type='password']"));
        passwordField.click();
        passwordField.sendKeys("te$t$tudent");

        WebElement loginButton = driver.findElement(By.xpath("//*[text() = 'Log In']"));
        loginButton.click();

        WebElement searchField = driver.findElement(By.cssSelector("[type='search']"));
        searchField.click();
        searchField.sendKeys("Pluto");

        WebElement song = driver.findElement(By.cssSelector("[class='songs']>ul>article>span:nth-child(2)"));
        Assert.assertTrue(song.isDisplayed());

        Thread.sleep(3000);
        driver.quit();
    }


}
