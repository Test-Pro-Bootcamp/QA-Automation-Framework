
package POM.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class BasePage{
     WebDriver driver;
    WebDriverWait wait;
    Actions actions;


    //Locator;
    By avatarIconLocator = By.xpath("//img[contains(@alt,'Avatar of')]");


     By allSongsMenuItemLocator = By.cssSelector("li a.songs");

    By soundBarPlayLocator = By.cssSelector("[data-testid='sound-bar-play']");


    public BasePage(WebDriver givenDriver) {
        driver = givenDriver;
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        actions = new Actions(driver);
        PageFactory.initElements(driver,this);
    }
    public WebElement getUserAvatar() {
        return driver.findElement(avatarIconLocator);

    }

    public boolean isUserAvatarDisplayed()  {
        return driver.findElement(avatarIconLocator).isDisplayed();

    }
    public boolean isSongPlaying(){
        WebElement soundBarVisualizer = driver.findElement(soundBarPlayLocator);
        return soundBarVisualizer.isDisplayed();
    }

        public  AllSongPage clickOnAllSongs()  {
        driver.findElement(allSongsMenuItemLocator).click();
        return new AllSongPage(driver);

    }
}




