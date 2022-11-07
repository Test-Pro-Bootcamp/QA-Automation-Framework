package POM;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


import java.time.Duration;

public class BasePage {
   protected WebDriver driver;
    WebDriverWait wait;
    Actions actions;
    private By allSongsMenuItemLocator = By.cssSelector("li a.songs");
    private By popUpMessageLocator = By.cssSelector("div.success.show");
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
        WebElement notificationMessage = driver.findElement(popUpMessageLocator);
        waitForVisibilityOfElement(notificationMessage);
        return driver.findElement(popUpMessageLocator).getText();
    }
}
