package Salma_POM.Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class HomePage extends BasePage{

//Declaring Locators
    By avatarLocator = By.cssSelector("img.avatar");
    By soundBarLocator = By.xpath("//img[@alt='Sound bars']");
    //Constructor method
    public HomePage(WebDriver givenDriver) {
       super(givenDriver);
    }

    //Getting user avatar
    public WebElement getUserAvatar(){
        return driver.findElement(avatarLocator);
    }
    //Method to verify user avatar is displayed
    public boolean isUserAvatarDisplayed(){
        return driver.findElement(avatarLocator).isDisplayed();
    }

    public boolean isSongPlaying(){
        WebElement songBarVisualizer = wait.until(ExpectedConditions.visibilityOfElementLocated(soundBarLocator));
         return songBarVisualizer.isDisplayed();
    }
}
