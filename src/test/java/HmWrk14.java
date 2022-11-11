import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;

public class HmWrk14 {
    @Test
    public  void registrationNavigation() throws InterruptedException {

        WebDriver driver = new ChromeDriver();
        try {
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
            String url = "https://bbb.testpro.io/";
            String regUrl = "https://bbb.testpro.io/registration.php";
            driver.get(url);

            WebElement regLink = driver.findElement(By.id("hel"));
            regLink.click();

            Assert.assertEquals(driver.getCurrentUrl(), regUrl);
            System.out.println("Redirected to " + driver.getCurrentUrl());
        } finally {

            driver.quit();
        }
    }
}