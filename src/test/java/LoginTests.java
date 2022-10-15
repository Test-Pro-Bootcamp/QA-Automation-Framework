import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginTests {

    @Test
    public static void LoginEmptyEmailPasswordTest () {

        System.setProperty("webdriver.chrome.driver", "C:\\Users\\jimmy\\OneDrive\\Documents\\GitHub\\QA-Automation-Framework\\src\\test\\resources\\chromedriver106.exe");

        if (System.getProperty("os.name").toLowerCase().contains("win")) {
            System.setProperty("webdriver.chrome.driver","chromedriver.exe");
        }

        WebDriver driver = new ChromeDriver();
        String url = "https://bbb.testpro.io/";
        driver.get(url);
        Assert.assertEquals(driver.getCurrentUrl(), url);
//        driver.quit();
    }
}
