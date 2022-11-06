package POM;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


import java.time.Duration;

public class BasePage {
    WebDriver driver;
    WebDriverWait wait;
    Actions actions;
    By allSongsMenuItemLocator = By.cssSelector("li a.songs");

    public BasePage(WebDriver givenDriver) {

        driver = givenDriver;
        wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        actions = new Actions(driver);
    }

    public void clickOnAllSongs() {
        driver.findElement(allSongsMenuItemLocator).click();
    }

    protected WebElement waitForElementToBeClickable(WebElement webElementLocator) {
        return new WebDriverWait(driver, Duration.ofSeconds(10)).until(
                ExpectedConditions.elementToBeClickable(webElementLocator));
    }

    protected WebElement waitForVisibilityOfElement(WebElement webElementLocator) {
        return new WebDriverWait(driver, Duration.ofSeconds(10)).until(ExpectedConditions
                .visibilityOf(webElementLocator));
    }

    public String getConfirmationPopUpText() {
        WebElement notificationMessage = driver.findElement(By.cssSelector("div.success.show"));
        waitForVisibilityOfElement(notificationMessage);
        return driver.findElement(By.cssSelector("div.success.show")).getText();
    }
}
