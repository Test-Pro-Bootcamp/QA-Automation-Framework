package POM;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;


public class LoginPage extends BasePage {

    By provideEmailSelector = By.cssSelector("[type='email']");
    By providePasswordSelector = By.cssSelector("[type='password']");
    By clickSubmitSelector = By.cssSelector("[type='submit']");

    public LoginPage(WebDriver mainDriverThree){
    super(mainDriverThree);
}
    public void provideEmail(String email) {
      driver.findElement(provideEmailSelector).sendKeys(email);
    }

    public void providePassword(String password) {
       driver.findElement(providePasswordSelector).sendKeys(password);
    }
    public void clickSubmitBtn() {
        driver.findElement(clickSubmitSelector).click();
    }
    public void login(){
    provideEmail("nargiza10041@gmail.com");
    providePassword("te$t$tudent");
    clickSubmitBtn();

    }

}