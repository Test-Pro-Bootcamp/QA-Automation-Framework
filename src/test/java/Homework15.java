import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;

public class Homework15 {

    @Test
    public static void search () throws InterruptedException {

        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        String url = "https://bbb.testpro.io/";
        driver.get(url);

        WebElement email = driver.findElement(By.cssSelector("[type='email']"));
        email.click();
        email.sendKeys("khushbu@gmail.com");
        Thread.sleep(1000);

        WebElement password = driver.findElement(By.cssSelector("[type='password']"));
        password.click();
        password.sendKeys("te$t$tudent");
        Thread.sleep(1000);

        WebElement login = driver.findElement(By.cssSelector("[type='submit']"));
        login.click();

        WebElement search = driver.findElement(By.cssSelector("[type='search']"));
        search.click();
        search.sendKeys("pluto");
        Thread.sleep(1000);

        Assert.assertTrue(search.isDisplayed());
        Thread.sleep(3000);

       driver.quit();
    }

}
