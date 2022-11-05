package Salma_POM.Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class LoginPage extends BasePage{

    //locators
    By passwordFieldLocator = By.cssSelector("[type='password']");
    By emailFieldLocator = By.cssSelector("[type='email']");
    By submitButtonLocator = By.cssSelector("[type='submit']");

    //Constructor Method(passing the driver from LoginTests page)
    public LoginPage(WebDriver givenDriver) {
        super(givenDriver);
    }

    public void clickSubmitBtn() {
        WebElement submitButton = driver.findElement(submitButtonLocator);
        submitButton.click();
    }

    public void provideEmail(String email) {
        WebElement emailField = driver.findElement(emailFieldLocator);
        emailField.click();
        emailField.sendKeys(email);
    }

    public void providePassword(String password) {
        WebElement passwordField = driver.findElement(passwordFieldLocator);
        passwordField.click();
        passwordField.sendKeys(password);
    }
    public void logIn(){
        provideEmail("salma.ayad.87@gmail.com");
        providePassword("te$t$tudent");
        clickSubmitBtn();
    }
}
