package POM;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoginPage extends BasePage {
    By emailFieldLocator = By.xpath("//input[@type='email']");
    By passwordFieldLocator = By.xpath("//input[@type='password']");
    By submitButtonLocator = By.xpath("//button[@type='submit']");

    public LoginPage(WebDriver givenDriver) {
        super(givenDriver);
    }

    public void provideEmail(String myEmail) {
        WebElement emailField = driver.findElement(emailFieldLocator);
        waitForElementToBeClickable(emailField).click();
        emailField.sendKeys(myEmail);
    }

    public void providePassword(String password) {
        WebElement passwordFiled = driver.findElement(passwordFieldLocator);
        waitForElementToBeClickable(passwordFiled).click();
        passwordFiled.sendKeys(password);
    }

    public void clickSubmitButton() {
        WebElement submitButton = driver.findElement(submitButtonLocator);
        waitForVisibilityOfElement(submitButton).click();
    }

    public void login() {
        provideEmail("holostenco.yuliya@gmail.com");
        providePassword("te$t$tudent");
        clickSubmitButton();
    }
}
