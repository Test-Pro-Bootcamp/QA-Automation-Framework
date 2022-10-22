import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;

public class LoginTests {

    @Test
    public static void LoginEmptyEmailPasswordTest() {

        WebDriver driver = new ChromeDriver();
//        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
//
        try {


//            String url = "https://bbb.testpro.io/";
//            driver.get(url);
//            Assert.assertEquals(driver.getCurrentUrl(), url);
//            driver.quit();

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

//            WebElement queueLink = driver.findElement(By.cssSelector("[href=\"#!/queue\"]"));
//            queueLink.click();
//
//            WebElement homeLink = driver.findElement(By.cssSelector("[href=\"#!/home\"]"));
//            homeLink.click();

//            WebElement albums = driver.findElement(By.cssSelector("[href=\"#!/albums\"] "));
//            albums.click();
//
//            Assert.assertEquals(driver.getCurrentUrl(), url);
        } finally {


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
    }
