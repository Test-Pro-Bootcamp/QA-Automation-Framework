package POM.FactoryPages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class MyAlbumsPage extends BasePage {

    @FindBy(xpath = "//*[@id=\"albumsWrapper\"]/header/span/label[2]")
    WebElement changeViewAsListsLocator;
    @FindBy(xpath = "//*[@id=\"albumsWrapper\"]/header/span/label[1]")
    WebElement thumbnails;

    public MyAlbumsPage(WebDriver givenDriver) {
        super(givenDriver);
    }

    public void changeViewAsList() {
        changeViewAsListsLocator.click();
    }

    public boolean isViewChanged() {
        return thumbnails.isDisplayed();
    }


}


