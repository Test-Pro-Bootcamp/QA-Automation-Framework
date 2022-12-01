package POM.FactoryPages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends BasePage {

    @FindBy(css = "[type = 'email']")
    WebElement emailField;
    @FindBy(css = "[type = 'password']")
    WebElement passwordField;
    @FindBy(css = "[type = 'submit']")
    WebElement submitBtn;

    public LoginPage(WebDriver givenDriver) {
        super(givenDriver);
    }

    public boolean submitBtnIsDisplayed(){

        return submitBtn.isDisplayed();
    }

    public LoginPage clickSubmitBtn() {

        submitBtn.click();
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

    public void login() {
        driver.manage().window().maximize();
        provideEmail("iq14111991@gmail.com")
                .providePassword("te$t$tudent")
                .clickSubmitBtn();
    }
}
