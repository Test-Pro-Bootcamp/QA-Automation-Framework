package Salma_POM.Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class HomePage extends BasePage{

//Declaring Locators
    //By avatarLocator = By.cssSelector("img.avatar");
    //By soundBarLocator = By.xpath("//img[@alt='Sound bars']");
    //Locators with Page Factory
    @FindBy(css="img.avatar")
    WebElement avatarImage;
    @FindBy(xpath = "//img[@alt='Sound bars']")
    WebElement soundBar;
    //Constructor method
    public HomePage(WebDriver givenDriver) {
       super(givenDriver);
    }

    //Getting user avatar
    public WebElement getUserAvatar(){
       // return driver.findElement(avatarLocator);
        return avatarImage;
    }
    //Method to verify user avatar is displayed
    public boolean isUserAvatarDisplayed(){
        //return driver.findElement(avatarLocator).isDisplayed();
        //We don't need driver.findElement when we use page factory
        return avatarImage.isDisplayed();
    }

    public boolean isSongPlaying(){
//        WebElement songBarVisualizer = wait.until(ExpectedConditions.visibilityOfElementLocated(soundBarLocator));
//         return songBarVisualizer.isDisplayed();
        return wait.until(ExpectedConditions.visibilityOf(soundBar)).isDisplayed();

    }
}
