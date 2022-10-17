import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginTests {

    @Test
    public static void LoginEmptyEmailPasswordTest ()  throws InterruptedException{
        WebDriver driver = new ChromeDriver();
        String url = "https://bbb.testpro.io/";
        driver.get(url);

        WebElement emailElement = driver.findElement(By.cssSelector("[type='email']"));
        emailElement.click();
        emailElement.sendKeys("nargiza104@gmail.com");

        WebElement passwordElement = driver.findElement(By.cssSelector("[type='password']"));
        passwordElement.click();
        passwordElement.sendKeys("te$t$tudent");

        WebElement submitButton = driver.findElement(By.cssSelector("[type='submit']"));
        submitButton.click();

        Thread.sleep(5000);
        driver.quit();
    }
}
