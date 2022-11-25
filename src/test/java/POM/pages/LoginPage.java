package POM.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoginPage extends BasePage{

    By emailFieldLocator = By.cssSelector("[type='email']");
    By passwordFieldLocator = By.cssSelector("[type='password']");
    By submitButtonSelector = By.cssSelector("[type='submit']");

    public LoginPage(WebDriver givenDriver) {
        super  (givenDriver);
    }

    public void clickSubmitBtn(){
        driver.findElement(submitButtonSelector).click();
    }

    public void provideEmail(String email){
        driver.findElement(emailFieldLocator).sendKeys(email);
    }
    public void providePassword(String password){
        driver.findElement(passwordFieldLocator).sendKeys(password);
    }
    public WebElement getUserAvatar(){
        return driver.findElement(avatarLocator);
    }

    public boolean isUserAvatarDisplayed(){
        return driver.findElement(avatarLocator).isDisplayed();
    }
    public void login() {
        driver.manage().window().maximize();
        provideEmail("iq14111991@gmail.com");
        providePassword("te$t$tudent");

        clickSubmitBtn();
    }
}
