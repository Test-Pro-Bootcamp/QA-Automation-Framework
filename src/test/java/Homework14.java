import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;

public class Homework14 {

    //Create a test case registrationNavigation() using @Test annotation
    @Test
    public static void registrationNavigation () throws InterruptedException {

        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        //Using Selenium, Navigate to "https://bbb.testpro.io/"
        String url = "https://bbb.testpro.io/";
        String registrationURL = "https://bbb.testpro.io/registration.php";
        driver.get(url);
        WebElement registration = driver.findElement(By.id("hel"));
        registration.click();

        Assert.assertEquals(driver.getCurrentUrl(), registrationURL);
        driver.quit();
    }

}
