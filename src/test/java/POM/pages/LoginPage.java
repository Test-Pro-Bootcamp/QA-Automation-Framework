package POM.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage {
    WebDriver driver;
    public LoginPage(WebDriver driver){
        this.driver = driver;
    }
    By emailFieldLocator = By.xpath("//input[@type='email']");
    By passwordFieldLocator = By.xpath("//input[@type='password']");
    By logIn = By.xpath("//button[@type='submit']");

    public void provideEmail(String email){
        driver.findElement(emailFieldLocator).sendKeys(email);
    }
    public void providePassword(String password) {
        driver.findElement(passwordFieldLocator).sendKeys(password);
    }
    public void clickSubmit() {
        driver.findElement(logIn).click();
    }

    public void login() throws InterruptedException{
        provideEmail("khushbu07@gmail.com");
        providePassword("te$t$tudent");
        clickSubmit();
        Thread.sleep(6000);
    }
}
