package POMtests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class HomePageTest extends BaseTest {

    By userAvatarIcon = By.cssSelector("img.avatar");

    public HomePageTest(WebDriver givenDriver) {
        super(givenDriver);
    }

    public WebElement getUserAvatar () {
        return findElement(userAvatarIcon);
    }
}


