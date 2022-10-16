import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;

public class LoginTests {

    @Test
    public static void LoginEmptyEmailPasswordTest () throws InterruptedException {

        System.setProperty("webdriver.chrome.driver", "C:\\Users\\jimmy\\OneDrive\\Documents\\GitHub\\QA-Automation-Framework\\src\\test\\resources\\chromedriver106.exe");

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
}
