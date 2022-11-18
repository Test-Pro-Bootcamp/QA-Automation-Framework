package Factory.pages;

import POM.pages.BasePage;
import POM.pages.HomePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPageF extends BasePageF{

    // Declaring the locators
    //By emailFieldLocator = By.cssSelector("[type='email']");
    @FindBy(css="[type='email']")
    WebElement emailField;
    //By passwordFieldLocator = By.cssSelector("[type='password']");
    @FindBy(css="[type='password']")
    WebElement passwordField;
    //By submitButtonLocator = By.cssSelector("[type='submit']");
    @FindBy(css="[type='submit']")
    WebElement submitButton;

    //passing the driver from our LoginTests page
    public LoginPageF(WebDriver givenDriver){
        super(givenDriver);
    }

    public LoginPageF clickSubmitBtn(){
        submitButton.click();
        return this;
    }

    public LoginPageF provideEmail(String email){
        emailField.sendKeys(email);
        return this;
    }

    public LoginPageF providePassword(String password){
        passwordField.sendKeys(password);
        return this;
    }

//    public POM.pages.HomePage login(){
//        provideEmail("demo@class.com")
//                .providePassword("te$t$tudent")
//                .clickSubmitBtn();
//        return new HomePage(driver);
//    }
    public Factory.pages.HomePageF login(){
        provideEmail("demo@class.com")
                .providePassword("te$t$tudent")
                .clickSubmitBtn();
        return new HomePageF(driver);
    }



}
