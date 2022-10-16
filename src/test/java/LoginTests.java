import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;

public class LoginTests {

    @Test
    public static void LoginEmptyEmailPasswordTest () throws InterruptedException {

        // This is for Windows users
        if (System.getProperty("os.name").toLowerCase().contains("win")) {
            System.setProperty("webdriver.chrome.driver","chromedriver.exe");
        }

        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        String url = "https://bbb.testpro.io/";
        driver.get(url);

        Thread.sleep(5000);
        driver.quit();
    }

    @Test
    public static void ValidateRegistrationPage() throws InterruptedException {

        if (System.getProperty("os.name").toLowerCase().contains("win")) {
            System.setProperty("webdriver.chrome.driver","chromedriver.exe");
        }

        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        String url = "https://bbb.testpro.io/";
        driver.get(url);

        WebElement registrationLink = driver.findElement(By.id("hel"));
        WebElement email = driver.findElement(By.cssSelector("[type = 'email']"));
        WebElement password = driver.findElement(By.cssSelector("[type = 'password']"));

//        email.click();
//        email.sendKeys("laborde.chaanyah@gmail.com");
//        password.click();
//        password.sendKeys("te$t$tudent");
        registrationLink.click();

        Thread.sleep(5000);
        driver.quit();

    }

}
