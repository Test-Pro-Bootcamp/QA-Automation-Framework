package POM.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;


public class LoginPage extends BasePage{
        @FindBy(xpath = "//*[@type='email']")
        WebElement emailField;
        @FindBy(xpath = "//*[@type='password']")
        WebElement passwordField;
        @FindBy(xpath = "//button[@type='submit']")
        WebElement loginBtn;

        public LoginPage(WebDriver givenDriver){
            super(givenDriver);
        }
        public LoginPage provideEmail(String email){
            emailField.sendKeys(email);
            return this;
        }
        public LoginPage providePassword(String password){
           passwordField.sendKeys(password);
           return this;
        }
        public LoginPage clickLoginBtn(){
         loginBtn.click();
         return this;
        }
        public HomePage signIn(String email, String password){
            provideEmail(email)
                    .providePassword(password)
                    .clickLoginBtn();
            return new HomePage(driver);
        }
}
