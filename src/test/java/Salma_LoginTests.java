import Salma_POM.Pages.HomePage;
import Salma_POM.Pages.LoginPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;

public class Salma_LoginTests extends Salma_BaseTest{


    @Test(priority = 0)
    public void LoginEmptyEmailPasswordTest () {

        Assert.assertEquals(getDriver().getCurrentUrl(), url);
    }

    @Test(priority = 1)
    public void LoginValidEmailValidPasswordTest () {
//Testing with POM(Page Object Model)
        LoginPage loginPage = new LoginPage(getDriver());
        HomePage homepage = new HomePage(getDriver());
        loginPage.logIn();
        Assert.assertTrue(homepage.isUserAvatarDisplayed());


    }

    @Test(priority = 2, dataProvider = "invalidCredentials", dataProviderClass = Salma_BaseTest.class)
    public void LoginInvalidEmailPasswordTest (String email, String password) throws InterruptedException {
        provideEmail(email);
        providePassword(password);
        clickSubmitBtn();

        // Vd
        Thread.sleep(2000);
        Assert.assertEquals(getDriver().getCurrentUrl(), url);

    }

    @Test(enabled = false)
    public void LoginValidEmailEmptyPasswordTest () {
        WebDriver driver;
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        String url = "https://bbb.testpro.io/";
        driver.get(url);

        WebElement emailField = driver.findElement(By.cssSelector("[type='email']"));
        emailField.click();
        emailField.sendKeys("demo@class.com");

        WebElement passwordField = driver.findElement(By.cssSelector("[type='password']"));
        passwordField.click();

        Assert.assertEquals(driver.getCurrentUrl(), url);
        driver.quit();
    }


}