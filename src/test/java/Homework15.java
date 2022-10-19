import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;


public class Homework15 {
    @Test
    public static void Homework15solution() throws InterruptedException {
        WebDriver driver = new ChromeDriver();
        try {
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
            String url = "https://bbb.testpro.io/";
            driver.get(url);

            WebElement emailField = driver.findElement(By.cssSelector("[type='email']"));
            emailField.click();
            emailField.sendKeys("salma.ayad.87@gmail.com");

            WebElement passwordField = driver.findElement(By.cssSelector("[type='password']"));
            passwordField.click();
            passwordField.sendKeys("te$t$tudent");

            WebElement submitButton = driver.findElement(By.cssSelector("[type='submit']"));
            submitButton.click();


            WebElement searchField = driver.findElement(By.cssSelector("[name='q']"));
            searchField.click();
            searchField.sendKeys("Pluto");
            Thread.sleep(5000);
           //Validating the song matches results
            WebElement searchWrapper = driver.findElement(By.id("searchExcerptsWrapper"));
            searchWrapper.getText();
            System.out.println(searchWrapper.getText().contains("Pluto"));
        } finally {

            driver.quit();
        }
    }
}
