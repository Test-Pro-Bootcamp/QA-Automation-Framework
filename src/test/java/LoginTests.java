import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.TreeMap;

public class LoginTests {


    @Test
    public static void LoginEmptyEmailPasswordTest () {

        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));}

//    @Test
//    public static void LoginInalidEmailValidPasswordTest () {
//        WebDriver driver = new ChromeDriver();
//        try {
//            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
//
//            String url = "https://bbb.testpro.io/";
//            driver.get(url);
//            WebElement emailField = driver.findElement(By.cssSelector("[type='email']"));
//            emailField.click();
//            emailField.sendKeys("dem@class.com");
//            WebElement passwordField = driver.findElement(By.cssSelector("[type='password']"));
//            passwordField.click();
//            passwordField.sendKeys("te$t$tudent");
//            WebElement submitButton = driver.findElement(By.cssSelector("[type='submit']"));
//            submitButton.click();
//            WebElement avatarElement = driver.findElement(By.cssSelector("[alt='Avatar of student']"));
//            Assert.assertTrue(avatarElement.isDisplayed());
//            }
//        finally {
//            driver.quit();
//        }
//
//    }

  /*  @Test
    public static void LoginEmptyEmailPasswordTest () throws InterruptedException {
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
            WebElement avatarElement = driver.findElement(By.cssSelector("[alt='Avatar of student']"));
            Assert.assertTrue(avatarElement.isDisplayed());
            Thread.sleep(4000);
            WebElement queueLink = driver.findElement(By.cssSelector("[href=\"#!/queue\"]"));
            queueLink.click();
            Thread.sleep(4000);
            WebElement queueContainer = driver.findElement(By.id("queueWrapper"));
            Assert.assertTrue(queueContainer.isDisplayed());

            WebElement homeLink = driver.findElement(By.linkText("Home"));
            homeLink.click();
            Thread.sleep(2000);



        }
        finally {
            driver.quit();
        }
>>>>>>> Stashed changes

        String url = "https://bbb.testpro.io/";
        driver.get(url);
        Assert.assertEquals(driver.getCurrentUrl(), url);
        driver.quit();
    }
//    @Test
//    public static void SwitchToSongMenu () throws InterruptedException {
//
//        WebDriver driver = new ChromeDriver();
//        try {
//            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
//            String url = "https://bbb.testpro.io/";
//            driver.get(url);
//            By emailSelector = By.cssSelector("[type='email']");
//            WebElement emailField = driver.findElement(emailSelector);
//            WebElement passwordField = driver.findElement(By.cssSelector("[type='password']"));
//            WebElement submitButton = driver.findElement(By.cssSelector("[type='submit']"));
//            By avatarSelector = By.cssSelector("[alt='Avatar of student']");
//            By songMenuSelector =   By.className("songs");
//            By allButtonSelector = By.className("btn-shuffle-all");
//
//
//
//            emailField.click();
//            emailField.sendKeys("demo@class.com");
//            passwordField.click();
//            passwordField.sendKeys("te$t$tudent");
//            submitButton.click();
//            Assert.assertTrue(driver.findElement(avatarSelector).isDisplayed());
//           // WebElement songMenu = driver.findElement(songMenuSelector);
//            driver.findElement(songMenuSelector).click();
//            Assert.assertTrue(driver.findElement(allButtonSelector).isDisplayed());
//            Thread.sleep(2000);
//        }
//        finally {
//            driver.quit();
//        }
//
//    }
//
//    @Test
//    public static void SearchSong () throws InterruptedException {
//
//        WebDriver driver = new ChromeDriver();
//        try {
//            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
//            String url = "https://bbb.testpro.io/";
//            driver.get(url);
//            By emailSelector = By.cssSelector("[type='email']");
//            WebElement emailField = driver.findElement(emailSelector);
//            WebElement passwordField = driver.findElement(By.cssSelector("[type='password']"));
//            WebElement submitButton = driver.findElement(By.cssSelector("[type='submit']"));
//            By avatarSelector = By.cssSelector("[alt='Avatar of student']");
//            By searchBarSelector =   By.cssSelector("[type='search']");
//            By allButtonSelector = By.className("btn-shuffle-all");
//
//
//
//            emailField.click();
//            emailField.sendKeys("demo@class.com");
//            passwordField.click();
//            passwordField.sendKeys("te$t$tudent");
//            submitButton.click();
//            Assert.assertTrue(driver.findElement(avatarSelector).isDisplayed());
//            // WebElement songMenu = driver.findElement(songMenuSelector);
//            driver.findElement(searchBarSelector).click();
//            driver.findElement(searchBarSelector).sendKeys("Veggie");
//           // Assert.assertTrue(driver.findElement().isDisplayed());
//            Thread.sleep(5000);
//        }
//        finally {
//            driver.quit();
//        }
//
//    }
*/
}
