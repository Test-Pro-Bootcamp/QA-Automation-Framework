import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;

public class HmWrk15 {
    @Test
    public void search(){
        WebDriver driver = new ChromeDriver();
        try {
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

            String url = "https://bbb.testpro.io/";
            driver.get(url);

            WebElement emailField = driver.findElement(By.cssSelector("[type='email']"));
            emailField.click();
            emailField.sendKeys("demo@class.com");

            WebElement passwordField = driver.findElement(By.cssSelector("[type='password']"));
            passwordField.click();
            passwordField.sendKeys("te$t$tudent");

            WebElement loginBtn = driver.findElement(By.cssSelector("[type='submit']"));
            loginBtn.click();

            WebElement searchBtn = driver.findElement(By.cssSelector("[type='search']"));
            searchBtn.click();
            searchBtn.sendKeys("Pluto");

            WebElement viewAllBtn = driver.findElement(By.cssSelector("[data-test = 'view-all-songs-btn']"));
            Assert.assertTrue(viewAllBtn.isDisplayed());
        }
        finally {
            driver.quit();
        }
    }
}
