package PagesIvaF;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HomePageIvan extends BasePageIvan {
    By avatarLocator = By.cssSelector("img.avatar");


    public HomePageIvan(WebDriver givenDriver){
        super(givenDriver);

    }
    public WebElement getUserAvatar()
    {
        return driver.findElement(avatarLocator);
    }
    public boolean isUserAvatarDisplayed()
    {
        wait.until(ExpectedConditions.visibilityOfElementLocated(avatarLocator)).isDisplayed();

        return driver.findElement(avatarLocator).isDisplayed();
    }

}
