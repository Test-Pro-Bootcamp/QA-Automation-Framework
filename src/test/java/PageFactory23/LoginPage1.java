package PageFactory23;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage1 extends BasePage1 {
    @FindBy(css="[type='email']")
    WebElement emailField;
    @FindBy(css="[type='password']")
    WebElement passwordField;
    @FindBy(css="[type='submit']")
    WebElement submitButton;

    public LoginPage1(WebDriver givenDriver){
        super(givenDriver);
    }

    public LoginPage1 clickSubmitBtn(){
        submitButton.click();
        return this;
    }

    public LoginPage1 provideEmail(String email){
        emailField.sendKeys(email);
        return this;
    }

    public LoginPage1 providePassword(String password){
        passwordField.sendKeys(password);
        return this;
    }

    public HomePage1 login(){
        provideEmail("dankoyanka@gmail.com")
                .providePassword("te$t$tudent")
                .clickSubmitBtn();
        return new HomePage1(driver);
    }


    public boolean isPageOpened() {
        return driver.getCurrentUrl().contains("https://bbb.testpro.io");
    }
}


