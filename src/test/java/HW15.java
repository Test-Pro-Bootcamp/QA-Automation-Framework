import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;

public class HW15 {

//    @Test
//    public static void HW15 () throws InterruptedException {
//        WebDriver driver = new ChromeDriver();
//        try {
//            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
//            String url ="https://bbb.testpro.io/";
//            String registrationURL = "https://bbb.testpro.io/registration.php";
//            driver.get(url);
//            WebElement registrationField = driver.findElement(By.id("hel"));
//            registrationField.click();
//            Thread.sleep(2000);
//            Assert.assertEquals(driver.getCurrentUrl(),registrationURL);
//
//
//
//        }
//        finally {
//            driver.quit();
//
//        }

//    }
    @Test
    public static void HomeWork15 () throws InterruptedException {
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

            WebElement searchArea = driver.findElement(By.cssSelector("[type='search']"));
            searchArea.click();
            searchArea.sendKeys("Pluto");

            WebElement searchResult = driver.findElement(By.cssSelector("#searchExcerptsWrapper > div > div > section.songs > ul > article > span.main > span.details"));
            String a = searchResult.getText();
            if (a.contains("Pluto")){
                Boolean testResult = true;
                Assert.assertTrue(testResult);
            }
        } finally {
            driver.quit();

        }

    }
}
