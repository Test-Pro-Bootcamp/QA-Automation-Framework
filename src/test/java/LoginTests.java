import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;

public class LoginTests {

    @Test
    public static void LoginEmptyEmailPasswordTest() throws InterruptedException {

        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        String url = "https://bbb.testpro.io/";
        driver.get(url);
        Thread.sleep(5000);
        driver.quit();
    }

    @Test
    public static void LoginValidEmailValidPasswordTest() throws InterruptedException {

        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        String url = "https://bbb.testpro.io/";
        driver.get(url);

        WebElement emailField = driver.findElement(By.cssSelector("[type = 'email']"));
        emailField.click();
        emailField.sendKeys("demo@class.com");

        WebElement passwordField = driver.findElement(By.cssSelector("[type = 'password']"));
        passwordField.click();
        passwordField.sendKeys("te$t$tudent");

       WebElement submit = driver.findElement(By.cssSelector("[type = 'submit']"));
       submit.click();

       WebElement avatar = driver.findElement(By.cssSelector("[alt = 'Avatar of student']"));
        Assert.assertTrue(avatar.isDisplayed());

        Thread.sleep(5000);
        driver.quit();
    }

    @Test
    public static void LoginInvalidEmailValidPasswordTest() throws InterruptedException {


        WebDriver driver = new ChromeDriver();
        try {
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

            String url = "https://bbb.testpro.io/";
            driver.get(url);

            WebElement emailField = driver.findElement(By.cssSelector("[type = 'email']"));
            emailField.click();
            emailField.sendKeys("dem@class.com");

            WebElement passwordField = driver.findElement(By.cssSelector("[type = 'password']"));
            passwordField.click();
            passwordField.sendKeys("te$t$tudent");

            WebElement submit = driver.findElement(By.cssSelector("[type = 'submit']"));
            submit.click();

            WebElement avatar = driver.findElement(By.cssSelector("[alt = 'Avatar of student']"));
            Assert.assertTrue(avatar.isDisplayed());

            Thread.sleep(5000);
        }
        finally{
            driver.quit();
        }

    }



}