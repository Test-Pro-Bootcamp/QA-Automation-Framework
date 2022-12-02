package N_POM.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage_Pfactory_N extends BasePage_N {

  //  By emailFieldLocator = By.cssSelector("[type='email']");
    @FindBy(css= "[type='email']")
            WebElement emailField;
   // By passwordFieldLocator = By.cssSelector("[type='password']");
    @FindBy(css="[type='password']")
            WebElement passwordField;
//    By submitButtonLocator = By.cssSelector("[type='submit']");
    @FindBy(css="[type='submit']")
    WebElement submitButton;

    public LoginPage_Pfactory_N(WebDriver givenDriver) {
        super(givenDriver);
    }

        public LoginPage_Pfactory_N clickSubmitButton() {
            submitButton.click();
            return this;
        }

        public LoginPage_Pfactory_N provideEmail(String email){
            emailField.sendKeys(email);
            return this;
        }

        public LoginPage_Pfactory_N providePassword(String password){
             passwordField.sendKeys(password);
             return this;
        }

        public HomePage_N login() {
            provideEmail("demo@class.com")
                    .providePassword("te$t$tudent")
                    .clickSubmitButton();
            return new HomePage_N(driver);
        }

}
