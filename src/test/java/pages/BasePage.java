package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class BasePage {
    WebDriver driver;
    WebDriverWait wait;
    Actions actions;

    By avatarLocator = By.cssSelector("img.avatar");

    public BasePage (WebDriver givenDriver){
        driver = givenDriver;
        wait = new WebDriverWait(driver, Duration.ofSeconds(1));
        actions = new Actions(driver);
        PageFactory.initElements(driver,this);
    }

    public boolean isLoggedIn(){
        return driver.findElement(avatarLocator).isDisplayed();
    }

    public FavoritesPage goToFavorite() {
        return new FavoritesPage(driver);
    }
}