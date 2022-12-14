package POM;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends BasePage {
    @FindBy(css="[type='email']")
    WebElement emailField;
    @FindBy(css="[type='password']")
    WebElement passwordField;
    @FindBy(css="[type='submit']")
    WebElement submitButton;

    public LoginPage(WebDriver givenDriver){
        super(givenDriver);
    }

    public LoginPage clickSubmitBtn(){
        submitButton.click();
        return this;
    }

    public LoginPage provideEmail(String email){
        emailField.sendKeys(email);
        return this;
    }

    public LoginPage providePassword(String password){
        passwordField.sendKeys(password);
        return this;
    }

    public HomePage login(){
        provideEmail("dankoyanka@gmail.com")
                .providePassword("te$t$tudent")
                .clickSubmitBtn();
        return new HomePage(driver);
    }
    public boolean isPageOpened() {
        return driver.getCurrentUrl().contains("https://bbb.testpro.io");
    }
}


