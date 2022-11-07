package POM.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

public class LoginPage extends BasePage{

        By emailField = By.xpath("//*[@type='email']");
        By passwordField = By.xpath("//*[@type='password']");
        By loginBtn = By.xpath("//button[@type='submit']");


        public LoginPage(WebDriver givenDriver){
            super(givenDriver);
        }

        public void provideEmail(String email){
            driver.findElement(emailField).sendKeys(email);
        }

        public void providePassword(String password){
            driver.findElement(passwordField).sendKeys(password);
        }

        public void clickLoginBtn(){

            driver.findElement(loginBtn).click();
        }

        public void signIn(String email, String password){
            provideEmail(email);
            providePassword(password);
            clickLoginBtn();
        }

}
