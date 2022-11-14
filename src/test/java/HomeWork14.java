import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class HomeWork14 {
    @Test
    public static void registrationNavigation() throws InterruptedException {
        WebDriver driver = new ChromeDriver();
        String url = "https://bbb.testpro.io/";
        String expectedRegistrationUrl = "https://bbb.testpro.io/registration.php";
        driver.get(url);
        WebElement registrationButton = driver.findElement(By.id("hel"));
        registrationButton.click();
        Assert.assertEquals(driver.getCurrentUrl(),
                          expectedRegistrationUrl);
        driver.quit();
    }

}
