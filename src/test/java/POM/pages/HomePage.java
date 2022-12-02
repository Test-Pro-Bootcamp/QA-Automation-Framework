package POM.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage extends POM.pages.BasePage {

    @FindBy(xpath = "//a[@class='songs active']")
    WebElement allSongsList;
    public HomePage(WebDriver sentDriver) {super(sentDriver);}

    public void clickAllSongs() {
        allSongsList.click();

    }
}
