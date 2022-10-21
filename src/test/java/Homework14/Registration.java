package Homework14;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;

public class Registration{
    @Test
    public static void registrationNavigation() {

        WebDriver driver = new ChromeDriver();
        try {
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
            String url = "https://bbb.testpro.io/";
            driver.get(url);

            WebElement regLink = driver.findElement(By.cssSelector("[type='sumbit']"));
            regLink.click();

            WebElement avatarIcon = driver.findElement(By.cssSelector("[alt = 'Avatar of student']"));
            Assert.assertTrue(avatarIcon.isDisplayed());
        }
        finally{
            driver.quit();
        }
    }
        }
