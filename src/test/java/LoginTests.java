import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;

public class LoginTests {

    @Test
    public static void LoginValidEmailValidPasswordTest() {

        // open Chrome browser
        WebDriver driver = new ChromeDriver();
        try {

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

            WebElement avatarIcon = driver.findElement(By.cssSelector("[alt='Avatar of student"));
            Assert.assertTrue(avatarIcon.isDisplayed());
        } finally {

            // Assert.assertEquals(driver.getCurrentUrl(), url);
            //Thread.sleep(5000); // to make program sleep for  5 seconds
            driver.quit(); // to close the driver
        }

    }


    @Test
    public static void LoginInvalidEmailPasswordTest() {

        // open Chrome browser
        WebDriver driver = new ChromeDriver();
        try {
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10)); //wait for 10 second to load before railing the test
            // to open a URL
            String url = "https://bbb.testpro.io/";
            driver.get(url);
            // Locate web element for email field by css locator
            WebElement emailField = driver.findElement(By.cssSelector("[type ='email"));
            emailField.click();// click to element
            emailField.sendKeys("dem@class.com");//typing demo@class.com in email field

            WebElement passwordField = driver.findElement(By.cssSelector("[type ='password"));
            passwordField.click();// click to element
            passwordField.sendKeys("te$t$tudent");

            WebElement submitButton = driver.findElement(By.cssSelector("[type ='submit"));
            submitButton.click();// click to element

            WebElement avatarIcon = driver.findElement(By.cssSelector("[alt='Avatar of student"));
            Assert.assertTrue(avatarIcon.isDisplayed());
        } finally {

            driver.quit(); // to close the driver
        }
    }

    @Test
    public static void LoginValidEmailEmptyPasswordTest() {

        // open Chrome browser
        WebDriver driver = new ChromeDriver();
        try {
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
            passwordField.sendKeys("");

            WebElement submitButton = driver.findElement(By.cssSelector("[type ='submit"));
            submitButton.click();// click to element

            WebElement avatarIcon = driver.findElement(By.cssSelector("[alt='Avatar of student"));
            Assert.assertTrue(avatarIcon.isDisplayed());
        } finally {

            driver.quit(); // to close the driver
        }
    }



}



