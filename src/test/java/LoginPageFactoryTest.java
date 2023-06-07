import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import POM.pages.LoginPageFactoryPage;

import java.time.Duration;

public class LoginPageFactoryTest {
    WebDriver driver;
    WebDriverWait wait;
    @BeforeTest
    @Parameters({"BaseURL"})
    public void beforeTest(String BaseURL){
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(60));
        wait = new WebDriverWait(driver,Duration.ofSeconds(60));
        driver.get(BaseURL);
    }

    @Test
    public void loginPageFactory() throws InterruptedException{
        LoginPageFactoryPage page = new LoginPageFactoryPage(driver);
        page.provideEmail("khushbu07@gmail.com").providePassword("te$t$tudent").clickSubmit();
        Thread.sleep(6000);
    }

    @AfterTest
    public void closeBrowser(){
        driver.quit();
    }
}
