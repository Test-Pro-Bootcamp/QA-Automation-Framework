import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.net.URL;
import java.time.Duration;

public class RegistrationTest {

    @Test
    public static void firstRegistration() throws InterruptedException {
        WebDriver driverTwo = new ChromeDriver();
        try
        {
        driverTwo.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        String url = "https://bbb.testpro.io/";
        driverTwo.get(url);
        WebElement registrationButton = driverTwo.findElement(By.id("hel"));
        registrationButton.click();
        WebElement newEmail = driverTwo.findElement(By.id("email"));
        newEmail.click();
        newEmail.sendKeys("nargiza10041@gmail.com");
        WebElement registrationButtonTwo = driverTwo.findElement(By.cssSelector("[type='submit']"));
        registrationButtonTwo.click();
        }

        finally {
            Thread.sleep(10000);
            driverTwo.quit();
        }
        }

    }
