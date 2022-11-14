package t.pages;

import POM.pages.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HomePage_t extends BasePage_t {

    WebDriver driver;
    WebDriverWait wait;
    //Locators
    By avatarLocator = By.cssSelector("img.avatar");
    //public HomePage_t(WebDriver sentDriver) {
       // super(sentDriver);
    //}
    public HomePage_t(WebDriver sentDriver) {
       // driver = sentDriver;
        super(sentDriver);
    }
//    public WebElement getUserAvatar() {
//        return driver.findElement(avatarLocator);
//    }
//    public boolean isUserAvatarDisplayed() {
//        return driver.findElement(avatarLocator).isDisplayed();
//    }

}
