package POM;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import java.time.Duration;

public class LoginPage {
     WebDriver driver;
    WebDriverWait Wait;
    By emailFieldLocator = By.cssSelector("[type='email']");
    By passwordFieldLocator = By.cssSelector("[type='password']");
    By submitButtonLocator = By.cssSelector("[type='submit']");
    By avatarIconLocator = (By.cssSelector("[alt='Avatar of student']"));


    public LoginPage(WebDriver givenDriver) {
        driver = givenDriver;
        Wait = new WebDriverWait(driver, Duration.ofSeconds(20));

    }

//    public void LogIn() {
//        provideEmail("myworld123@gmail.com");
//        providePassword("te$t$tudent");
//        clickSubmitBtn();
//
//    }

    public void clickSubmitBtn() {
        driver.findElement(submitButtonLocator).click();
    }

    public void providePassword(String password) {
        driver.findElement(passwordFieldLocator).sendKeys(password);
    }

    public void provideEmail(String email) {
        driver.findElement(emailFieldLocator).sendKeys(email);

    }

    public void avatarIcon() {

      driver.findElement(avatarIconLocator);
//        Assert.assertTrue(avatarIcon.isDisplayed());
     }
     public void login() {
        provideEmail("myworld123@gmail.com");
        providePassword("te$t$tudent");
        clickSubmitBtn();
     }
//    @Test
//    public void LoginEmptyEmailPasswordTest() throws InterruptedException {
//    }

}