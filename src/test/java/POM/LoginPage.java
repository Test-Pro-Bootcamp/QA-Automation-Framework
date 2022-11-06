package POM;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoginPage extends BasePage {

    @FindBy(xpath = "//input[@type='email']")
    WebElement emailField;
    @FindBy(xpath = "//input[@type='password']")
    WebElement passwordField;
    @FindBy(xpath="//button[@type='submit']")
    WebElement submitButton;

    public LoginPage(WebDriver givenDriver) {
        super(givenDriver);
    }
    public void provideEmail(String email) {
        emailField.click();
        emailField.sendKeys(email);
    }
    public void providePassword(String password) {
        passwordField.click();
        passwordField.sendKeys(password);
    }
    public void clickSubmitButton() {
        submitButton.click();
    }
    public void login() {
        provideEmail("holostenco.yuliya@gmail.com");
        providePassword("te$t$tudent");
        clickSubmitButton();
    }
}
