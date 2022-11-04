package POM;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class HomePage extends BasePage {
    By infoLocator = By.xpath("//button[@class='about control']");

    public HomePage (WebDriver mainDriverTwo) {
        super(mainDriverTwo);
    }
    public WebElement getInfoAboutKoel(){
        wait.until(ExpectedConditions.visibilityOfElementLocated(infoLocator)).click();
        return null;
    }
}