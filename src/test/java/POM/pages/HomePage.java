package POM.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HomePage extends BasePage {

    By avatarIconLocator = By.xpath("//img[contains(@alt,'Avatar of')]");


    public HomePage(WebDriver givenDriver) {
        super(givenDriver);

    }

    public WebElement getUserAvatar() {
        return driver.findElement(avatarIconLocator);

    }

    public boolean isUserAvatarDisplayed() {
        return driver.findElement(avatarIconLocator).isDisplayed();

    }

}