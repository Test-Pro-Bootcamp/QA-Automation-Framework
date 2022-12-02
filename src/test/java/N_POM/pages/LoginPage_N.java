package N_POM.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage_N extends BasePage_N {

    //Declaring the drivers
//    WebDriver driver;
//    WebDriverWait wait;

    By emailFieldLocator = By.cssSelector("[type='email']");
    By passwordFieldLocator = By.cssSelector("[type='password']");
    By submitButtonLocator = By.cssSelector("[type='submit']");

    public LoginPage_N(WebDriver givenDriver) {
        super(givenDriver);
    }

        public void clickSubmitButton() {
            driver.findElement(submitButtonLocator).click();
        }

        public void provideEmail(String email){
            driver.findElement(emailFieldLocator).sendKeys(email);
        }

        public void providePassword(String password){
            driver.findElement(passwordFieldLocator).sendKeys(password);
        }

        public void login() {
            provideEmail("demo@class.com");
            providePassword("te$t$tudent");
            clickSubmitButton();
        }

}
