import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;

public class HmWrk14 {
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
        } finally {

            driver.quit();
        }
    }
}