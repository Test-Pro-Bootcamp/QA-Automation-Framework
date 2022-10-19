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


    @Test
    public static void Homework14Solution () throws InterruptedException {

        WebDriver driver = new ChromeDriver();

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        driver.manage().window().maximize();


        String url = "https://bbb.testpro.io/";
        String registrationURL = "https://bbb.testpro.io/registration.php";
        driver.get(url);


        WebElement registrationLinkElement = driver.findElement(By.id("hel"));
//   WebElement textToGetUsingCssSelector = driver.findElement(By.cssSelector("font[color='#f9f9ff']"));

        Thread.sleep(2000);
        registrationLinkElement.click();
        Thread.sleep(5000);

//        first approach - assert if the current url is equal to your stored (String)  registration page url
        //  Assert.assertEquals(driver.getCurrentUrl(), registrationURL);

//        another approach - Print current url
        String retrievedUrl = driver.getCurrentUrl();
        System.out.println("Our current URL is " +retrievedUrl);

//        another approach - check if the "Register new account" text/line which can be found in the registration page is displayed in the web page
        //  WebElement registerNewAccountHeader = driver.findElement(By.xpath("//h2[contains(text(),'Register new account')]"));
        //     boolean isHeaderPresent = registerNewAccountHeader.isDisplayed();
        //     System.out.println(isHeaderPresent); // returns true if element is displayed

        driver.quit();
    }




}