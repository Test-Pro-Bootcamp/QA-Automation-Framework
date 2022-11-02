import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;


//Create a new file Homework15.java file with @Test annotation in IntelliJ IDEA
//        Create a test case search() using @Test annotation
//        Navigate to "https://bbb.testpro.io/"
//        Log in with your credentials
//        Search for the song "Pluto" (use CSS locators to locate the elements)
//        Validate that there is a song matched in a search results
//        Create a new branch and commit your changes
//        Push your code to a remote repository
//        Create a pull request
//        Copy and paste the link of the pull request (or your branch) to the field below, so we can check your homework
public class HW15 {
    public static void main(String[] args) {

    }

    @Test
    public static void search() throws InterruptedException {
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        String url = "https://bbb.testpro.io/";
        String serachingPageUrl = "https://bbb.testpro.io/#!/search";
        driver.get(url);

        WebElement emailField = driver.findElement(By.cssSelector("[type='email']"));
        emailField.click();
        emailField.sendKeys("iq14111991@gmail.com");

        WebElement passwordField = driver.findElement(By.cssSelector("[type='password']"));
        passwordField.click();
        passwordField.sendKeys("te$t$tudent");

        WebElement submitButton = driver.findElement(By.cssSelector("[type='submit']"));
        submitButton.click();

        WebElement searchField = driver.findElement(By.cssSelector("[type='search']"));
        searchField.click();
        searchField.sendKeys("Pluto");
        Assert.assertEquals(driver.getCurrentUrl(), serachingPageUrl);
        Thread.sleep(3000);

        driver.quit();

    }
}

