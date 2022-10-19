import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;

public class PasswordReset {
    @Test
    public static void changePassword() throws InterruptedException {
        WebDriver driverThree = new ChromeDriver();
        try {
            driverThree.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
            String url = "https://bbb.testpro.io/";
            driverThree.get(url);
            WebElement loggedIn = driverThree.findElement(By.cssSelector("[type='email']"));
            loggedIn.click();
            loggedIn.sendKeys("nargiza10041@gmail.com");
            WebElement insertPassword = driverThree.findElement(By.cssSelector("[type='password']"));
            insertPassword.click();
            insertPassword.sendKeys("te$t$tudent");
            WebElement submitButtonTwo = driverThree.findElement(By.cssSelector("[type='submit']"));
            submitButtonTwo.click();
            WebElement searchButton = driverThree.findElement(By.cssSelector("[type ='search']"));
            searchButton.click();
            searchButton.sendKeys("Pluto");

        }
             finally {
                Thread.sleep(30000);

            }
        }

    }
