package POM;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class HomePage extends BasePage {
//    By infoLocator = By.xpath("//button[@class='about control']");

    @FindBy(css = "a.view-profile")
    WebElement profileIcon;

    public HomePage (WebDriver mainDriverTwo) {
        super(mainDriverTwo);
    }
    public boolean isProfileIconPresent(){
       wait.until(ExpectedConditions.visibilityOf(profileIcon));
        return profileIcon.isDisplayed();
    }
}