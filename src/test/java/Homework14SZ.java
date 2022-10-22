import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;


public class Homework14SZ {
    @Test
    public static void registrationNavigationTest() throws InterruptedException {

        WebDriver driver = new ChromeDriver();


        String url = "https://bbb.testpro.io/";
        String registrationURL = "https://bbb.testpro.io/registration.php";
<<<<<<< Updated upstream

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get(url);
        driver.manage().window().maximize();

       WebElement registrationLink = driver.findElement(By.id("hel")) ;
       registrationLink.click();
       Thread.sleep(2000);


        Assert.assertEquals(driver.getCurrentUrl(), registrationURL);
        Thread.sleep(3000);
=======
        driver.get(url);
        driver.get(registrationURL);

       WebElement registrationLink = driver.findElement(By.id("hel")) ;
       registrationLink.click();


        Assert.assertEquals(driver.getCurrentUrl(), url);
        Assert.assertEquals(driver.getCurrentUrl(), registrationURL);
>>>>>>> Stashed changes
        driver.quit();

    }

}
    //    Using Selenium, Navigate to "https://bbb.testpro.io/"
//    Click Registration link
//    Validate that you are redirected to Registration page
//    Create a new branch and commit your changes
//    Push your code to a remote repository
//    Create a pull request
//    Copy and paste the link of the pull request (or your branch) to the field below, so we can check your homework


