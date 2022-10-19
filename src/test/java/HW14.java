import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;

public class HW14 {

    @Test
    public static void HW14 () throws InterruptedException {
        WebDriver driver = new ChromeDriver();
        try {
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
            String url ="https://bbb.testpro.io/";
            String registrationURL = "https://bbb.testpro.io/registration.php";
            driver.get(url);
            WebElement registrationField = driver.findElement(By.id("hel"));
            registrationField.click();
            Thread.sleep(2000);
            Assert.assertEquals(driver.getCurrentUrl(),registrationURL);



        }
        finally {
                driver.quit();

        }

    }


}
