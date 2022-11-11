package POM;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class AboutKoelPage extends BasePage {

    public AboutKoelPage(WebDriver mainDriver)  {
        super(mainDriver);
    }
    @FindBy(css = "[type='email']")
    WebElement emailField;
    @FindBy(css = "[type='password']")
    WebElement passwordField;
    @FindBy(css = "[type='submit']")
    WebElement submitButton;

    @FindBy(xpath ="//button[@class = 'about control']")
    WebElement aboutKoelIcon;
    @FindBy(xpath = "//button[text()='Close']")
    WebElement closeKoelInfobutton;


    public AboutKoelPage provideEmail(String email) {
        emailField.sendKeys(email);
        return this;
    }
    public AboutKoelPage providePassword(String password){
        passwordField.sendKeys(password);
        return this;
    }
    public AboutKoelPage clickSubmitBtn() {
        submitButton.click();
        return this;
    }
    public void login() {
        provideEmail("nargiza10041@gmail.com");
        providePassword("te$t$tudent");
        clickSubmitBtn();

    }
    public AboutKoelPage clickButtonInfo() {
        wait.until(ExpectedConditions.visibilityOf(aboutKoelIcon)).click();
        return this;
    }
    public AboutKoelPage clickCloseButton(){
       wait.until(ExpectedConditions.visibilityOf(closeKoelInfobutton)).click();
       return this;
    }
}