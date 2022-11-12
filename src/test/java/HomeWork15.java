import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;
import java.time.Duration;

public class HomeWork15 extends BaseTest {
    @Test
    public static void Search() throws InterruptedException {
//        WebDriver driver = new ChromeDriver();
//        String url = "https://bbb.testpro.io/";
//        driver.get(url);
        WebElement EmailField = driver.findElement(By.cssSelector("[type='email']"));
        EmailField.click();
        EmailField.sendKeys("yuliyakis85@gmail.com");
        WebElement PasswordField = driver.findElement(By.cssSelector("[type='password']"));
        PasswordField.click();
        PasswordField.sendKeys("te$t$tudent");

        WebElement SubmitButton = driver.findElement(By.cssSelector("[type='submit']"));
        SubmitButton.click();

        WebElement searchField = driver.findElement(By.cssSelector("[type='search']"));
        searchField.click();
        searchField.sendKeys("Pluto");
        Thread.sleep(2000);
        driver.quit();
    }
}
