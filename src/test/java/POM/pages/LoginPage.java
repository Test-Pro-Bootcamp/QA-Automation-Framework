
package POM.pages;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoginPage extends BasePage {

    //locators;
    By emailFieldLocator = By.cssSelector("[type='email']");
    By passwordFieldLocator = By.cssSelector("[type='password']");
    By submitButtonLocator = By.cssSelector("[type='submit']");



    public LoginPage(WebDriver givenDriver) {
        super(givenDriver);
    }

    public void clickSubmitBtn() {
        driver.findElement(submitButtonLocator).click();

    }

    public void provideEmail(String email) {
        driver.findElement(emailFieldLocator).sendKeys(email);

    }



   public void providePassword(String password) {
        driver.findElement(passwordFieldLocator).sendKeys(password);

    }
    public void login(){
        provideEmail("kaflimeerim@gmail.com");
        providePassword("te$t$tudent");
        clickSubmitBtn();
    }
}