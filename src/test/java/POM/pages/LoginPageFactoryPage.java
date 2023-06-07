package POM.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPageFactoryPage {
    WebDriver driver;
    public LoginPageFactoryPage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//input[@type='email']")
    WebElement emailFieldLocator;

    @FindBy(xpath = "//input[@type='password']")
    WebElement passwordFieldLocator;

    @FindBy(xpath = "//button[@type='submit']")
    WebElement logIn;

    public LoginPageFactoryPage provideEmail(String email){
        emailFieldLocator.sendKeys(email);
        return this;
    }
    public LoginPageFactoryPage providePassword(String password) {
        passwordFieldLocator.sendKeys(password);
        return this;
    }
    public LoginPageFactoryPage clickSubmit() {
        logIn.click();
        return this;
    }

  /*  public void loginPageFactory() throws InterruptedException{
        provideEmail("khushbu07@gmail.com");
        providePassword("te$t$tudent");
        clickSubmit();
        Thread.sleep(6000);
    }*/
}
