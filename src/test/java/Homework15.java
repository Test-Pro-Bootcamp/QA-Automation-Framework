import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;

public class Homework15 {


    @Test
    public static void search() throws InterruptedException {
        
        
        
        String url = "https://bbb.testpro.io/";


        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get(url);

        WebElement emailField = driver.findElement(By.cssSelector("[type='email']"));
        emailField.click();
        emailField.sendKeys("kaflimeerim@gmail.com");

        WebElement passwordField = driver.findElement(By.cssSelector("[type='password']"));
        passwordField.click();
        passwordField.sendKeys("te$t$tudent");

        WebElement submitButton = driver.findElement(By.cssSelector("[type='submit']"));
        submitButton.click();

        WebElement avatarElement = driver.findElement(By.cssSelector("[alt='Avatar of student']"));
        Assert.assertTrue(avatarElement.isDisplayed());
        Thread.sleep(4000);

        WebElement searchArea = driver.findElement(By.cssSelector("[type='search']"));
        searchArea.click();
        searchArea.sendKeys("Pluto");


        Thread.sleep(2000);
        driver.quit();







        
        
        
        


    }
}