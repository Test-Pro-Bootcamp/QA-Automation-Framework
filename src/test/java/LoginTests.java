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

            WebElement submitButton = driver.findElement(By.cssSelector("[type='submit']"));
            submitButton.click();

            WebElement avatarIcon = driver.findElement(By.cssSelector("[alt = 'Avatar of student']"));
            Assert.assertTrue(avatarIcon.isDisplayed());
        }
            finally {
            driver.quit();
        }
    }

    @Test
    public static void LoginInValidEmailPasswordTest() {

        WebDriver driver = new ChromeDriver();
        try {
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

            String url = "https://bbb.testpro.io/";
            driver.get(url);

            WebElement emailField = driver.findElement(By.cssSelector("[type='email']"));
            emailField.click();
            emailField.sendKeys("dem@class.com");

            WebElement passwordField = driver.findElement(By.cssSelector("[type='password']"));
            passwordField.click();
            passwordField.sendKeys("te$t$tudent");

            WebElement submitButton = driver.findElement(By.cssSelector("[type='submit']"));
            submitButton.click();

            WebElement avatarIcon = driver.findElement(By.cssSelector("[alt = 'Avatar of student']"));
            Assert.assertTrue(avatarIcon.isDisplayed());
        }
        finally {
            driver.quit();
        }
    }

    @Test
    public static void LoginValidEmailEmptyPasswordTest() {

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
            passwordField.sendKeys("");

            WebElement submitButton = driver.findElement(By.cssSelector("[type='submit']"));
            submitButton.click();

            WebElement avatarIcon = driver.findElement(By.cssSelector("[alt = 'Avatar of student']"));
            Assert.assertTrue(avatarIcon.isDisplayed());
        }
        finally {
            driver.quit();
        }
    }
    @Test
    public static void LoginEmptyPasswordTest() {

        WebDriver driver = new ChromeDriver();
        try {
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

            String url = "https://bbb.testpro.io/";
            driver.get(url);

            WebElement searchBar = driver.findElement(By.cssSelector("[type='search']"));
            searchBar.click();
            searchBar.sendKeys("Dark Days");


            WebElement avatarIcon = driver.findElement(By.cssSelector("[alt = 'Avatar of student']"));
            Assert.assertTrue(avatarIcon.isDisplayed());
        } finally {
            driver.quit();
        }
    }

    public static class Registration{
        @Test
        public static void registrationNavigation() {

            WebDriver driver = new ChromeDriver();
            try {
                driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
                String url = "https://bbb.testpro.io/";
                driver.get(url);

                WebElement regLink = driver.findElement(By.id("hel"));
                regLink.click();

                WebElement regbutton = driver.findElement(By.cssSelector("[type='submit']"));
                Assert.assertTrue(regbutton.isDisplayed());
            }
            finally{
                driver.quit();
            }
        }
            }

    @Test
    public static void search() throws InterruptedException {

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

            WebElement submitButton = driver.findElement(By.cssSelector("[type='submit']"));
            submitButton.click();

            WebElement searchButton = driver.findElement(By.cssSelector("[type='search']"));
            searchButton .click();
            searchButton.sendKeys("Pluto");

            WebElement avatarIcon = driver.findElement(By.cssSelector("[data-test='view-all-songs-btn']"));
            Assert.assertTrue(avatarIcon.isDisplayed());
        }
        finally {
            Thread.sleep(5000);
            driver.quit();
        }
    }
}
