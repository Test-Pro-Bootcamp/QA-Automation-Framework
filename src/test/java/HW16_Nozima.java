import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.List;
import java.util.Set;

public class HW16_Nozima {

        @BeforeSuite
        public static void chromeConfigs() {
            // This is for Windows users
            if (System.getProperty("os.name").toLowerCase().contains("win")) {
                System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
            }
        }
        @Test
    public static void createNewPlaylist() throws InterruptedException{
            String urlLanding = "https://bbb.testpro.io/";
            String email = "nozishka86@gmail.com";
            String password = "te$t$tudent";
            String newPlaylistName = "Nozima's Songs";

            WebDriver driver = new ChromeDriver();
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(7));
            driver.get(urlLanding);

            WebElement emailField = driver.findElement(By.xpath("//*[@type='email']"));
            WebElement passwordField = driver.findElement(By.xpath("//*[@type='password']"));
            WebElement loginButton = driver.findElement(By.xpath("//button[@type='submit']"));

            emailField.sendKeys(email);
            Thread.sleep(1000);
            passwordField.click();
            passwordField.sendKeys(password);
            Thread.sleep(1000);
            loginButton.click();

            Assert.assertEquals(driver.getCurrentUrl(), urlLanding);

            WebElement newPButton = driver.findElement(By.cssSelector("[class='fa fa-plus-circle create']"));
            newPButton.click();
            Thread.sleep(3000);
            WebElement dropDownOption = driver.findElement(By.xpath("//li[contains(text(), 'New Playlist')]"));
            dropDownOption.click();
            Thread.sleep(3000);

            WebElement playNameField = driver.findElement(By.xpath("//*[@name = 'name']"));
            playNameField.sendKeys(newPlaylistName);
            Thread.sleep(3000);
            playNameField.sendKeys(Keys.RETURN);
            Thread.sleep(3000);

            WebElement listCreated = driver.findElement(By.xpath("//a[contains(text(), 'Nozima')]"));
            Assert.assertTrue(listCreated.isDisplayed());

            driver.quit();

    }
}