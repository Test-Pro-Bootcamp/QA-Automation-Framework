package t.pages;

import POM.pages.BasePage;
import POM.pages.HomePage;
import POM.pages.LoginPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class LoginPage_t  {
    WebDriver driver;
    String url;
    WebDriverWait wait;
    //locators
    By submitButtonLocator = By.cssSelector("[type='submit']");
    By emailField = By.cssSelector("[type='email']");
    By passwordField = By.cssSelector("[type='password']");

     //passing the driver from our LoginTests page
    public LoginPage_t(WebDriver givenDriver) {
        driver = givenDriver;
        wait = new WebDriverWait(driver, Duration.ofSeconds(5));
    }

    public LoginPage_t clickSubmitBtn() {
        driver.findElement(submitButtonLocator).click();
        return this;
    }
    public LoginPage_t provideEmail(String email) {
        driver.findElement(emailField).sendKeys(email);
        return this;
    }

    public LoginPage_t providePassword( String password) {
        driver.findElement(passwordField).sendKeys(password);
        return this;
    }

    public HomePage_t login(){
        provideEmail("demo@class.com")
                .providePassword("te$t$tudent")
                .clickSubmitBtn();
        return new HomePage_t(driver);
    }
//    public void login() {
//        provideEmail("demo@class.com");
//        providePassword("te$t$tudent");
//        clickSubmitBtn();
//    }



}
