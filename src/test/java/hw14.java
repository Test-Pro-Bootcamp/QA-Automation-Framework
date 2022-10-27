import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class hw14 {
    public static void Homework14() throws InterruptedException {
        WebDriver driver = new ChromeDriver();

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        String url = "https://bbb.testpro.io";
        driver.get(url);

        WebElement registrationBtn = driver.findElement(By.id("hel"));
        registrationBtn.click();

        Thread.sleep(5000);
        driver.quit();

    }
}
