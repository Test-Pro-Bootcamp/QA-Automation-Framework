package POM;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;


public class LoginPage extends BasePage {

    @FindBy(css = "[type='email']")
    WebElement emailField;
    @FindBy(css = "[type='password']")
    WebElement passwordField;
    @FindBy(css = "[type='submit']")
    WebElement submitButton;
    public LoginPage(WebDriver mainDriver) {
    super(mainDriver);
}
    public LoginPage provideEmail(String email) {
      emailField.sendKeys(email);
      return this;
    }
    public LoginPage providePassword(String password) {
      passwordField.sendKeys(password);
        return this;
    }
    public LoginPage clickSubmitBtn() {
       submitButton.click();
        return this;
    }
    public HomePage login(){
             provideEmail("nargiza10041@gmail.com")
            .providePassword("te$t$tudent")
            .clickSubmitBtn();
        return new HomePage(driver);
    }
}