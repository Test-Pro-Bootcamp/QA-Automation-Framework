import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;

public class Hw14 {
    @Test
    public static void Homework14Solution () throws InterruptedException {

        String url = "https://bbb.testpro.io/";
        String registrationURL = "https://bbb.testpro.io/registration.php";


        WebDriver driver = new ChromeDriver();

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get(url);
        driver.manage().window().maximize();

        WebElement registrationLinkElement = driver.findElement(By.id("hel"));

        Thread.sleep(2000);
        registrationLinkElement.click();
        Thread.sleep(7000);


        Assert.assertEquals(driver.getCurrentUrl(), registrationURL);
        driver.quit();
    }

    }
