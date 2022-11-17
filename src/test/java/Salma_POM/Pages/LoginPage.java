package Salma_POM.Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class LoginPage extends BasePage{

    //Locators
    //By passwordFieldLocator = By.cssSelector("[type='password']");
    //By emailFieldLocator = By.cssSelector("[type='email']");
    //By submitButtonLocator = By.cssSelector("[type='submit']");

    //Locators Using Page Factory
    //To use Page factory you have to initialize it in BasePage
   @FindBy(css="[type='password']")
    WebElement passwordField;
   @FindBy(css="[type='email']")
    WebElement emailField;
   @FindBy(css="[type='submit']")
    WebElement submitButton;




    //Constructor Method(passing the driver from LoginTests page)
    public LoginPage(WebDriver givenDriver) {
        super(givenDriver);
        PageFactory.initElements(driver,this);
    }

    public LoginPage clickSubmitBtn() {
//        WebElement submitButton = driver.findElement(submitButtonLocator);
//        submitButton.click();
        //With Page Factory
        submitButton.click();
        return this;
        //Instead of public void, we can use public LoginPage as return Object(fluent interface)

    }

    public LoginPage provideEmail(String email) {
//        WebElement emailField = driver.findElement(emailFieldLocator).click();
//        emailField.sendKeys(email);
        //Using Page Factory
        emailField.click();
        emailField.sendKeys(email);
        return this;
        //Instead of public void, we can use public LoginPage as return Object

    }

    public LoginPage providePassword(String password) {
//        WebElement passwordField = driver.findElement(passwordFieldLocator).click();
//        passwordField.sendKeys(password);
        //With Page Factory
        passwordField.click();
        passwordField.sendKeys(password);
        return this;
        //Instead of public void, we can use public LoginPage as return Object
    }
    public HomePage logIn(){
        provideEmail("salma.ayad.87@gmail.com")
                .providePassword("te$t$tudent")
                .clickSubmitBtn();
        return new HomePage(driver);
        //Now we can use "." after each method and put them in one line since we used LoginPage
        //as return
        //Instead of public void,We can use HomePage as return object, so after logIn method is done, we will
        //return a new instance of Homepage Object
        //So instead of creating a new instance of homepage in the test, we are creating it here
    }
}
