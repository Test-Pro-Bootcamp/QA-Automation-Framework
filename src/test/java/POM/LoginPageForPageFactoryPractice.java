package POM;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPageForPageFactoryPractice extends BasePage {

    @FindBy(xpath = "//input[@type='email']")
    WebElement emailField;
    @FindBy(xpath = "//input[@type='password']")
    WebElement passwordField;
    @FindBy(xpath = "//button[@type='submit']")
    WebElement submitButton;

    public LoginPageForPageFactoryPractice(WebDriver givenDriver) {

        super(givenDriver);
    }
    public void provideEmail(String email) {
        waitAndActionsClickWebElement(emailField);
        emailField.sendKeys(email);

    }
    public void providePassword(String password) {
        waitAndActionsClickWebElement(passwordField);
        passwordField.sendKeys(password);
    }
    public void clickSubmitButton() {
        submitButton.click();
    }
    public void login() {
        provideEmail(myEmail);
        providePassword(myPassword);
        clickSubmitButton();
    }
}
