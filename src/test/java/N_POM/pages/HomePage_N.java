package N_POM.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class HomePage_N extends BasePage_N {

    By avatarLocator= By.cssSelector("img.avatar");


    public HomePage_N(WebDriver driverSent) {
        super(driverSent);
    }

    public WebElement getUserAvatar(){
            return driver.findElement(avatarLocator);
    }


}

