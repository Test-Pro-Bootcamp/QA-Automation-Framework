import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import POM.pages.LoginPage;

import java.time.Duration;

public class LoginTest {
    WebDriver driver;
    WebDriverWait wait;
    @BeforeTest
    @Parameters({"BaseURL"})
    public void beforeTest(String BaseURL){
        System.out.println("Executing Before Test");
        driver = new ChromeDriver();
        System.out.println("Executing Driver");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(60));
        // wait = new WebDriverWait(driver,Duration.ofSeconds(60))
        driver.get(BaseURL);
    }

    @Test
    public void login() throws InterruptedException{
        LoginPage page = new LoginPage(driver);
        page.login();
    }

    @AfterTest
    public void closeBrowser(){
        driver.quit();
    }
}
