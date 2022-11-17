
package POM.pages;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;


public class LoginPage extends BasePage {

    //locators;
   // By emailFieldLocator = By.cssSelector("[type='email']");
    @FindBy(css = "[type='email']")
    WebElement emailField;
    //By passwordFieldLocator = By.cssSelector("[type='password']");
    @FindBy(css = "[type='password']")
    WebElement passwordField;
    //By submitButtonLocator = By.cssSelector("[type='submit']");
    @FindBy(css = "[type='submit']")
    WebElement submitButton;



    public LoginPage(WebDriver givenDriver) {

        super(givenDriver);
    }

    public LoginPage clickSubmitBtn() {
       submitButton.click();
       return this;

    }

    public LoginPage provideEmail(String email) {
       emailField.sendKeys(email);
       return this;

    }

    public LoginPage providePassword(String password) {
        passwordField.sendKeys(password);
        return this;

    }
    public HomePage login(){
        provideEmail("kaflimeerim@gmail.com")
                .providePassword("te$t$tudent")
                .clickSubmitBtn();
        return new HomePage(driver);


    }
}