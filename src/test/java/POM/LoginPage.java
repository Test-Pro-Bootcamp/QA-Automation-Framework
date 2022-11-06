package POM;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoginPage extends  basePage{
    WebDriver driver;
    WebDriverWait wait;

    //By emailFieldLocator = By.xpath("//input[@type='email']");
    @FindBy(xpath="//input[@type='email']")
    WebElement emailField;
   // By passwordFieldLocator = By.xpath("//input[@type='password']");
    @FindBy(xpath="//input[@type='password']")
    WebElement passwordField;
    By submitButtonLocator = By.xpath("//button[@type='submit']");


    public LoginPage(WebDriver givenDriver) {
        //passing the driver from our loginTests
        super(givenDriver);
    }

    public LoginPage clickSubmitButton() {
        driver.findElement(submitButtonLocator).click();
        return this;

    }

    public LoginPage provideEmail(String email) {
        emailField.click();
     emailField.sendKeys(email);
     return this;
    }

    public LoginPage providePassword(String Password) {
       passwordField.click();
       passwordField.sendKeys(Password);
       return this;

    }

    public LoginPage login(){

        provideEmail("holostenco.yuliya@gmail.com")
                .providePassword("te$t$tudent")
                .clickSubmitButton();
        return this;
    }
}
