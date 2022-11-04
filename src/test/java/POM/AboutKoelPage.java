package POM;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class AboutKoelPage extends BasePage {

    public AboutKoelPage(WebDriver mainFour) {
        super(mainFour);
    }

    By provideEmailSelector = By.cssSelector("[type='email']");
    By providePasswordSelector = By.cssSelector("[type='password']");
    By clickSubmitSelector = By.cssSelector("[type='submit']");
    By aboutButtonLocator = By.xpath("//button[@class='about control']");
    By closeInfoLocator = By.xpath("//button[text()='Close']");

    public void provideEmail(String email) {
        driver.findElement(provideEmailSelector).sendKeys(email);
    }

    public void providePassword(String password) {
        driver.findElement(providePasswordSelector).sendKeys(password);
    }

    public void clickSubmitBtn() {
        driver.findElement(clickSubmitSelector).click();
    }

    public void login() {
        provideEmail("nargiza10041@gmail.com");
        providePassword("te$t$tudent");
        clickSubmitBtn();

    }
    public void clickButtonInfo(){
        wait.until(ExpectedConditions.visibilityOfElementLocated(aboutButtonLocator)).click();
    }
    public void clickCloseButton(){
        wait.until(ExpectedConditions.visibilityOfElementLocated(closeInfoLocator)).click();
    }
}