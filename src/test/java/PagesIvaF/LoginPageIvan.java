package PagesIvaF;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;


public class LoginPageIvan extends BasePageIvan {
    //Locators
    @FindBy(css = "[type='email']")
    WebElement emailField;
    @FindBy(css = "[type='password']")
    WebElement  passwordField;
    @FindBy(css ="[type='submit']" )
    WebElement submitButtonLocator;
//passing driver from our Login test Page
    public LoginPageIvan(WebDriver givenDriver){
        super(givenDriver);
    }
    public LoginPageIvan clickSubmitBtn(){
        wait.until(ExpectedConditions.visibilityOf(submitButtonLocator));
        submitButtonLocator.click();
        return this;
    }
    public LoginPageIvan provideEmail(String email)  {
        wait.until(ExpectedConditions.visibilityOf(emailField));
        emailField.sendKeys(email);
        return this;

    }
    public LoginPageIvan providePassword(String password){
        wait.until(ExpectedConditions.visibilityOf(passwordField));
        passwordField.sendKeys(password);
        return this;

    }
    public HomePageIvan login(){
        provideEmail("fedorov.ivan@hotmail.com").providePassword("te$t$tudent").clickSubmitBtn();
        return new HomePageIvan(driver);
         }




}
