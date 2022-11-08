package POM;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


import java.time.Duration;

public class BasePage {
    protected WebDriver driver;
    private static int WAIT_SECONDS = 10;
    protected String myEmail = "holostenco.yuliya@gmail.com";
    protected String myPassword = "te$t$tudent";


    public BasePage(WebDriver givenDriver) {
        driver = givenDriver;
        PageFactory.initElements(driver, this);
    }

    public void waitAndActionsClickWebElement(WebElement element) {
        waitForElementToBeClickable(element);
        new Actions(driver).click(element);
    }

    protected void actionsDoubleClickWebElement(WebElement element) {
        waitForElementToBeClickable(element);
        new Actions(driver).doubleClick(element);
    }

    protected void waitAndContextClickWebElement(WebElement element) {
        waitForElementToBeClickable(element);
        new Actions(driver).contextClick(element);
    }

    protected void waitAndInputText(WebElement webElementLocator, String text) {
        waitForVisibilityOfElement(webElementLocator).sendKeys(text);
    }

    protected WebElement waitForElementToBeClickable(WebElement webElementLocator) {
        return new WebDriverWait(driver, Duration.ofSeconds(WAIT_SECONDS)).until(
                ExpectedConditions.elementToBeClickable(webElementLocator));
    }

    protected WebElement waitForVisibilityOfElement(WebElement webElementLocator) {
        return new WebDriverWait(driver, Duration.ofSeconds(WAIT_SECONDS)).until(ExpectedConditions
                .visibilityOf(webElementLocator));
    }

}
