package POM.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class BasePage {
    WebDriver driver;
    WebDriverWait wait;
    Actions actions;

    @FindBy(xpath="//li/a[@class='queue']")
    WebElement currentQueueMenuItem;

    By avatarLocator = By.xpath("//img[contains(@alt,'Avatar of')]");
    By soundBarPlayLocator = By.cssSelector("[data-testid = 'sound-bar-play']");
    By allSongsMenuItemLocator = By.xpath("//li/a[@class='songs']");

    public BasePage (WebDriver givenDriver){
        driver = givenDriver;
        wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        actions = new Actions(driver);
        PageFactory.initElements(driver,this);
    }

    public WebElement getUserAvatar(){
        return driver.findElement(avatarLocator);
    }

    public boolean isUserAvatarDisplayed(){
        return driver.findElement(avatarLocator).isDisplayed();
    }

    public boolean isSongPlaying() {
        WebElement soundBarVisualizer = driver.findElement(soundBarPlayLocator);
        return soundBarVisualizer.isDisplayed();
    }

    public AllSongsPage clickOnAllSongs(){
        driver.findElement(allSongsMenuItemLocator).click();
        return new AllSongsPage(driver);
    }

    public CurrentQueuePage navigateToCurrentQueue() {
        this.currentQueueMenuItem.click();
        return new CurrentQueuePage(driver);
    }
}
