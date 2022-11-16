
package POM.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class BasePage{
    WebDriver driver;
    WebDriverWait wait;
    Actions actions;

    //Locator;
    By allSongsMenuItemLocator = By.cssSelector("li a.songs");


    public BasePage(WebDriver givenDriver) {
        driver = givenDriver;
        wait = new WebDriverWait(driver, Duration.ofSeconds(50));
    }
    public void clickOnAllSongs() throws InterruptedException {
        driver.findElement(allSongsMenuItemLocator).click();
        Thread.sleep(2000);
    }
}




