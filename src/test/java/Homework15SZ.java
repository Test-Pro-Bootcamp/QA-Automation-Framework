import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;


//        Create a new file Homework15.java file with @Test annotation in IntelliJ IDEA
//        Create a test case search() using @Test annotation
//        Navigate to "https://bbb.testpro.io/"
//        Log in with your credentials
//        Search for the song "Pluto" (use CSS locators to locate the elements)
//        Validate that there is a song matched in a search results
//        Create a new branch and commit your changes
//        Push your code to a remote repository
//        Create a pull request
//        Copy and paste the link of the pull request (or your branch) to the field below, so we can check your homework
public class Homework15SZ {
    @Test
    public static void Searchsong() throws InterruptedException {

        // open Chrome browser
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10)); //wait for 10 second to load before railing the test
        // to open a URL
        String url = "https://bbb.testpro.io/";
        driver.get(url);
        // Locate web element for email field by css locator
        WebElement emailField = driver.findElement(By.cssSelector("[type ='email"));
        emailField.click();// click to element
        emailField.sendKeys("demo@class.com");//typing demo@class.com in email field

        WebElement passwordField = driver.findElement(By.cssSelector("[type ='password"));
        passwordField.click();// click to element
        passwordField.sendKeys("te$t$tudent");



        WebElement submitButton = driver.findElement(By.cssSelector("[type ='submit"));
        submitButton.click();// click to element

//        WebElement avatarIcon = driver.findElement(By.cssSelector("[alt='Avatar of student"));
//        Assert.assertTrue(avatarIcon.isDisplayed());

        WebElement search = driver.findElement(By.cssSelector("[name='q']"));
        search.click();
        search.sendKeys("pluto");


        Thread.sleep(2000);
        driver.quit(); // to close the driver

    }
}
